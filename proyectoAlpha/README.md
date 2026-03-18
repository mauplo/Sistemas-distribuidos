# Proyecto Alpha - Whack A Mole Recurrente

## 0) Evaluación experimental de desempeño
Para el entregable de la evaluación se  incluyó el reporte en el mismo github:

**[Reporte_Pegale_al_monstruo.pdf](Reporte_Pegale_al_monstruo.pdf)**

## 1) Contenido de cada archivo en `src/`

### `src/ServidorMonstruos.java`
Implementa el servidor principal del juego.

Funciones:
- Inicializa el productor JMS hacia el tópico `PegaleAlMonstruo` (ActiveMQ).
- Publica eventos de juego en el tópico: `INICIO`, `MONSTRUO:<casilla>` y `GANADOR:<jugador>`.
- Abre dos escuchadores TCP usando ServerSockets:
- `EscuchadorLogin` en el puerto `33000` para registrar jugadores.
- `EscuchadorGolpes` en el puerto `36900` para recibir golpes acertados.
- Mantiene el marcador en memoria (`ConcurrentHashMap<String, Integer>`), persistente para cada partida.
- Controla el ciclo del juego:
- Cada 2 segundos publica un monstruo en una casilla aleatoria (1-9).
- Acepta solo el primer golpe valido por monstruo.
- Cuando un jugador llega a `SCORE_TO_WIN = 5`, anuncia ganador, pausa, reinicia puntajes y comienza nueva partida.

### `src/EscuchadorLogin.java`
Escuchador TCP para login/registro.

Funciones:
- Levanta un `ServerSocket` en el puerto configurado (`LOGIN_PORT = 33000`).
- Crea un hilo `LoginConnection` por conexion entrante.
- Lee `playerName` usando `DataInputStream.readUTF()`.
- Llama a `server.registerPlayer(playerName)` para que el servidor registre al jugador.
- Responde al cliente con metadatos de conexion:
- `OK|TOPIC=...|LOGIN_PORT=...|HIT_PORT=...`.

### `src/EscuchadorGolpes.java`
Escuchador TCP para golpes.

Funciones:
- Levanta un `ServerSocket` en `HIT_PORT = 36900`.
- Crea un hilo `HitConnection` por conexion.
- Mantiene una conexion persistente por cliente y procesa multiples golpes (bucle `while(true)`).
- Por cada golpe recibido (`playerName`), invoca `server.tryHit(playerName)`.
- Responde ACK textual al cliente:
- `HIT_OK` si el golpe conto.
- `HIT_REJECTED` si no conto (sin monstruo activo, pausa, etc.).

### `src/JugadorMonstruo.java`
Cliente de juego con interfaz Swing para un jugador.

Funciones:
- Pide nombre por dialogo y realiza login TCP al servidor.
- Abre y reutiliza un socket TCP de golpes para reducir overhead por clic.
- Se suscribe por JMS al topic `PegaleAlMonstruo` para recibir estado del juego.
- Renderiza tablero 3x3 con `JCheckBox`.
- Interpreta mensajes del servidor:
- `MONSTRUO:<casilla>`: activa casilla objetivo temporalmente.
- `GANADOR:<jugador>`: muestra ganador y limpia tablero.
- `INICIO`: reinicia estado visual.
- Considera golpe valido cuando el usuario desmarca la casilla activa antes de timeout local (3 s), luego envia golpe por TCP.

### `src/Estresador.java`
Cliente de carga para pruebas de estres y medicion de latencia.

Funciones:
- Ejecuta 10 configuraciones de concurrencia: `N = 50, 100, ..., 500`.
- Para cada `N`, corre `R = 10` repeticiones.
- En cada repeticion lanza `N` hilos de conexion (login) y, para los que conectaron, `N` hilos de primer golpe.
- Mide por jugador:
- Exito de conexión (`0/1`).
- Tiempo de conexión (ms).
- Tiempo al primer golpe (ms).
- Calcula metricas agregadas por configuración:
- `% exito conexion`.
- `media` y `desviacion estandar` de tiempo de conexión.
- `media` y `desviacion estandar` de tiempo de primer golpe.
- Exporta CSV en `metricas_estres.csv`.

### `src/Launcher.java`
Lanzador local de multiples clientes `JugadorMonstruo`.

Funciones:
- Abre varias instancias de jugador en la misma JVM (segun `NUM_JUGADORES`).
- Introduce un retardo corto entre lanzamientos (`DELAY_ENTRE_JUGADORES_MS`) para evitar que los diálogos se encimen.
- Facilita pruebas manuales multijugador en una sola máquina.

## 2) Logica del programa (servidor, jugador y estresador)

### Flujo general de arquitectura
El sistema usa dos canales en paralelo:
- JMS (pub/sub por topic): difusion de eventos de juego a todos los jugadores.
- TCP punto a punto: operaciones de control y accion (`login` y `golpe`).

Esto separa Funciones:
- El estado visible del juego se distribuye eficientemente por topic.
- Las acciones que requieren validacion inmediata (golpes) llegan directo al servidor por TCP.

### Logica del servidor (`ServidorMonstruos`)
1. Inicializa productor JMS y escuchadores TCP (`LOGIN_PORT`, `HIT_PORT`).
2. Publica `INICIO` al arrancar.
3. En ciclo continuo:
- Si `gamePaused` esta activo (hubo ganador), espera 4 s, reinicia puntuaciones y publica `INICIO`.
- Si no hay pausa, genera casilla aleatoria 1-9, marca `monsterActive = true`, publica `MONSTRUO:<casilla>`, espera 2 s y desactiva el monstruo (`monsterActive = false`).
4. Al recibir un golpe por `tryHit(playerName)`:
- Rechaza si no hay monstruo activo o el juego esta en pausa.
- Acepta solo el primer golpe valido del monstruo actual (al aceptar, desactiva `monsterActive`).
- Suma punto al jugador.
- Si alcanza 5 puntos, publica `GANADOR:<jugador>` y activa pausa de fin de ronda.

### Logica del jugador (`JugadorMonstruo`)
1. Solicita nombre y hace login TCP.
2. Abre socket persistente de golpes (`HIT_PORT`).
3. Construye UI Swing 3x3 y escucha mensajes JMS en segundo plano.
4. Cuando llega `MONSTRUO:<casilla>`:
- Marca esa casilla como activa.
- Habilita ventana temporal para golpear.
- Arranca timer local de 3 s para limpiar si nadie pega.
5. Golpe:
- El jugador "golpea" al desmarcar la casilla activa.
- Si sigue disponible, envia su nombre por TCP y espera ACK (`HIT_OK` o `HIT_REJECTED`).
6. Cuando llega `GANADOR:<jugador>`, muestra aviso y reinicia vista para nueva ronda.

### Logica del estresador (`Estresador`)
1. Define dos estructuras principales:
- `double[][][] mediciones = new double[N][3][R]` (se crea por cada configuracion `N`).
- `double[][] metricas = new double[len(N_VALUES)][6]` (global para el resultado final).
2. En `mediciones[N][3][R]`, la segunda dimension de tamano `3` representa:
- indice `0`: exito de conexion (`1.0` o `0.0`).
- indice `1`: tiempo de conexion en ms.
- indice `2`: tiempo de primer golpe en ms.
3. Para cada repeticion `r` (de `0` a `R-1`), primero llena `mediciones` en dos fases:
- Fase A: lanza `N` hilos para login concurrente y guarda exito/latencia en `mediciones[jugador][0][r]` y `mediciones[jugador][1][r]`.
- Fase B: solo para jugadores con conexion exitosa, lanza hilos de golpe y guarda el tiempo en `mediciones[jugador][2][r]`.
4. Al terminar las `R` repeticiones de ese `N`, recorre `mediciones` para calcular estadisticos agregados y los coloca en una fila de `metricas` con 6 columnas:
- `[0]` = `N`.
- `[1]` = porcentaje de exito de conexion.
- `[2]` = media de tiempo de conexion.
- `[3]` = desviacion estandar de tiempo de conexion.
- `[4]` = media de tiempo de primer golpe.
- `[5]` = desviacion estandar de tiempo de primer golpe.
5. Repite ese proceso para cada valor en `N_VALUES`, por lo que `metricas` termina con `len(N_VALUES)` filas (una por nivel de carga).
6. Finalmente, `exportarMetricasCsv(...)` exporta `metricas` a `metricas_estres.csv`, escribiendo encabezado y luego una fila por cada configuracion `N`.

## 3) Instrucciones breves de ejecucion

### Requisitos previos
- Java 17+ (o version compatible con tus librerias).
- Broker ActiveMQ levantado en el endpoint por defecto (`tcp://localhost:61616`, usado por `ActiveMQConnection.DEFAULT_BROKER_URL`).

### Compilar
Desde la raiz del proyecto, compila las clases:

```bash
javac -d out src/*.java
```

Nota: si compilas por consola, asegurate de incluir en `-cp` los JAR de ActiveMQ/JMS cuando aplique en tu entorno.

### Modo interactivo
1. Inicia el servidor:

```bash
java -cp out ServidorMonstruos
```

2. Opcion A: abrir un jugador individual:

```bash
java -cp out JugadorMonstruo
```

3. Opcion B: abrir varios jugadores con launcher:

```bash
java -cp out Launcher
```

Opcional:
- Puedes ajustar cuántos jugadores deseas abrir con `NUM_JUGADORES`.

### Modo estresamiento (metricas)
1. Con el servidor en ejecucion, corre:

```bash
java -cp out Estresador
```

2. Al terminar, revisa el archivo generado:
- `metricas_estres.csv`

Opcional:
- Puedes ajustar carga y repeticiones en `src/Estresador.java` modificando `N_VALUES` y `R`.
