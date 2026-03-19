# Modelos de Comunicación Indirecta

**Curso:** Sistemas Distribuidos  
**Profesor:** Dr. J. Octavio Gutiérrez García  
**Contacto:** octavio.gutierrez@itam.mx

---

## Tabla de Contenidos

1. [Comunicación Indirecta](#1-comunicación-indirecta)
2. [Desacoplamiento Espacial y Temporal](#2-desacoplamiento-espacial-y-temporal)
3. [Memoria Distribuida Compartida](#3-comunicación-a-través-de-memoria-distribuida-compartida)
4. [Comunicación Grupal](#4-comunicación-grupal)
5. [Comunicación Publicación-Inscripción](#5-comunicación-publicación-inscripción)
6. [Colas de Mensajes](#6-colas-de-mensajes)
7. [Java Message Service (JMS)](#7-java-message-service-jms)
8. [JMS con ActiveMQ](#8-jms-usando-activemq)
9. [Prácticas de Laboratorio](#9-prácticas-de-laboratorio)

---

## 1. Comunicación Indirecta

La **comunicación indirecta** es la comunicación entre entidades en un sistema distribuido a través de un intermediario, **sin acoplamiento directo** entre emisores y receptores.

### Características principales

- Soporta patrones de comunicación **uno a uno** (_one-to-one_) y **uno a muchos** (_one-to-many_).
- Facilita la adaptación a cambios en el sistema.
- Introduce retrasos adicionales respecto a la comunicación directa, lo cual es una contrapartida aceptada a cambio de mayor flexibilidad.

### ¿Por qué usar comunicación indirecta?

Se usa especialmente en **sistemas distribuidos donde se anticipan cambios**, como:

- **Ambientes altamente volátiles**, por ejemplo, entornos móviles donde los dispositivos entran y salen constantemente de la red.
- **Diseminación de eventos** donde los usuarios pueden cambiar o son desconocidos de antemano.

---

## 2. Desacoplamiento Espacial y Temporal

La comunicación indirecta introduce dos tipos fundamentales de desacoplamiento:

### 2.1 Desacoplamiento Espacial

> El emisor **no necesita conocer** al receptor, y viceversa.

Esto proporciona:
- Mayor libertad para tratar cambios en el sistema.
- Los participantes se pueden **reemplazar, actualizar, replicar o migrar** sin afectar a los demás.

**Ejemplo:** Un componente que publica eventos no necesita saber cuántos ni cuáles componentes están leyendo esos eventos. Pueden agregarse o removerse suscriptores sin que el publicador lo note.

### 2.2 Desacoplamiento Temporal

> Los participantes pueden tener **líneas de existencia independientes**.

Esto significa que:
- El emisor puede enviar un mensaje **incluso si el receptor no está activo** en ese momento.
- El receptor puede leer el mensaje **cuando se reactive**, sin necesidad de que el emisor siga disponible.

Este desacoplamiento es especialmente útil en ambientes con conectividad intermitente o procesos con ciclos de vida distintos.

---

## 3. Comunicación a través de Memoria Distribuida Compartida

La **Memoria Distribuida Compartida (DSM, por sus siglas en inglés)** es una abstracción utilizada para el intercambio de datos entre equipos que **no comparten memoria física**.

### Características

- Los datos almacenados se consideran **persistentes**.
- **No hay paso explícito de mensajes** entre procesos; en cambio, los procesos leen y escriben en un espacio de memoria lógicamente compartido.
- La memoria distribuida se presenta como si fuera parte del **espacio de direcciones del proceso**.

### Diagrama: Memoria Distribuida Compartida (Página 6)

```
     ┌─────────────────────────────────────────┐
     │       Memoria compartida distribuida    │  ← rectángulo azul
     └──────────┬──────────────┬───────────────┘
                ▲              ▲              ▲
                │              │              │
     ┌──────────────────────────────────────────┐
     │                   RED                    │  ← rectángulo blanco
     └──────────┬──────────────┬───────────────┘
                │              │              │
                ▼              ▼              ▼
          [Computadora]  [Computadora]  [Computadora]  ← con ícono de pantalla
           Memoria         Memoria        Memoria
            Física          Física         Física
```

> **"La memoria distribuida se muestra como espacio de direcciones del proceso"** ← nota explicativa en el diagrama original

**Descripción literal del diagrama (Imagen 1):** En la parte superior hay un rectángulo azul con el texto "Memoria compartida distribuida". Debajo, un rectángulo blanco con el texto "RED" actúa de intermediario. En la parte inferior se muestran tres íconos de computadora de escritorio con pantalla (cada uno representando un nodo físico), etiquetados los tres como "Memoria Física". Flechas bidireccionales conectan la RED con cada nodo y también suben de la RED hacia la Memoria compartida distribuida. A la derecha del diagrama hay un recuadro estilo bocadillo con una flecha azul que señala al tercer nodo, con la leyenda: _"La memoria distribuida se muestra como espacio de direcciones del proceso"_.

**Interpretación:** Cada nodo (computadora) posee su propia memoria física local independiente. A través de la RED, se construye una capa de abstracción —la Memoria Compartida Distribuida— que hace que cada proceso vea esa memoria remota como si fuera su propio espacio de direcciones local. El programador escribe y lee como si accediera a memoria local, mientras la infraestructura gestiona de forma transparente la coherencia y propagación de los datos entre nodos.

---

## 4. Comunicación Grupal

La **comunicación grupal** es un mecanismo donde un mensaje se manda a un grupo y se difunde a **todos sus miembros**.

### Características

- El emisor **no conoce** a los receptores individuales.
- Los miembros pueden **unirse y abandonar** un grupo dinámicamente.
- Es una abstracción de nivel superior sobre el **multicast** de red.

### Aplicaciones fundamentales

La comunicación grupal es base para:

- **Diseminación fiable de información** a muchos clientes (por ejemplo, notificaciones de precios de acciones a múltiples agentes de bolsa).
- **Aplicaciones colaborativas**, para que todos los usuarios tengan la misma vista del sistema (coherencia de estado compartido).
- **Tolerancia a fallos**: mantiene coherente la información replicada entre réplicas del servicio.
- **Sistemas de monitorización**: envío de métricas y alertas a múltiples receptores simultáneamente.

### 4.1 Tipos de Grupos

### Diagrama: Grupos Cerrados vs. Grupos Abiertos (Página 9)

```
  GRUPO CERRADO                        GRUPO ABIERTO
  ┌─────────────────────┐              ┌──────────────────────┐
  │  ○                  │              │  ○ ──────────► ○     │
  │  ▲  ↖               │              │  ▲             │     │
  │  │    ○ (se envía   │              │  │             ▼     │
  │  │    ↙  a sí mismo)│              │  ○ ◄────────── ○     │
  │  ○ ←───             │              │        ▲             │
  └─────────────────────┘              └────────┼─────────────┘
                                               │ (acepta)
        ╳  ← rechazado                         │
        ○  (proceso externo)             ○ ────┘ (proceso externo
                                                 puede enviar)
```

**Descripción literal del diagrama (Imagen 2):** El diagrama muestra dos grandes círculos anaranjados que representan grupos de procesos. En el **grupo cerrado** (izquierda), hay tres nodos (círculos blancos pequeños) dentro del grupo con flechas negras que van entre ellos; uno de los nodos incluso tiene una flecha curva que se apunta a sí mismo (autoenvío). Debajo del grupo cerrado hay un nodo externo con una **X** en gris sobre él, indicando que su comunicación está bloqueada. En el **grupo abierto** (derecha), hay cuatro nodos internos conectados con flechas negras entre sí, además de flechas grises que parten de un nodo externo ubicado debajo del grupo y apuntan hacia los nodos internos, y algunas flechas grises salen también del interior hacia ese nodo externo, mostrando comunicación bidireccional con el exterior.

**Interpretación:** En un **grupo cerrado**, la comunicación está restringida exclusivamente a los miembros del grupo; cualquier proceso externo es bloqueado. En un **grupo abierto**, los procesos externos pueden enviar mensajes a los miembros del grupo, e incluso recibir mensajes del grupo, lo que permite mayor interoperabilidad pero reduce el control de acceso.

#### Grupos con y sin sobrelapamiento

- **Sin sobrelapamiento:** Un proceso pertenece a un solo grupo a la vez.
- **Con sobrelapamiento:** Un proceso puede pertenecer a múltiples grupos simultáneamente.

### 4.2 Fiabilidad en Multicast

La fiabilidad en la comunicación grupal se define mediante **tres propiedades fundamentales**:

| Propiedad | Definición |
|-----------|-----------|
| **Integridad** | El mensaje que se recibe es **exactamente el mismo** que se envió (sin corrupción ni alteración). |
| **Validez** | Los mensajes enviados se entregan **en algún momento** (eventualmente llegarán). |
| **Acuerdo** | Si el mensaje se entrega a **un proceso**, se entrega a **todos** los procesos del grupo. |

El _Acuerdo_ es la propiedad más exigente: garantiza que no haya entregas parciales donde algunos miembros reciban el mensaje y otros no.

### 4.3 Ordenamiento de Mensajes

La entrega de mensajes en grupos puede seguir diferentes órdenes. A continuación se describen los tres modelos principales.

#### Ordenamiento Total (Página 12)

El diagrama utiliza tres ejes verticales de tiempo para los procesos P1, P2 y P3. Los mensajes se representan con dos tipos de marcadores: círculos (envío) y cuadros (recepción/entrega). Hay tres familias de mensajes: T (círculos grandes anaranjados/negros), F (cuadros dorados/negros) y C (cuadros dorados/negros, más abajo).

```
Tiempo
  │    T1●                                     ●T2     ← mensajes T
  │      ○────────────────────●────────────────○
  │      ●                                     ●
  │   F1 ●  ┌─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─┐  (resaltado rojo)
  │   F2 ●  │ ■─────────────────■──────────────■F3│
  │      ○  │  ■                ■                  │
  │      ■  └─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─┘
  │   C1 ●──────────────────────────────────────■
  │   C2 ●──────────■───────────■───────────────●C3
  │      ■          ■           ■               ■
  ▼      P1         P2          P3
```

**Descripción literal (Imagen 3):** El diagrama muestra tres líneas de tiempo verticales para los procesos P1, P2 y P3, con el tiempo fluyendo hacia abajo. Hay tres familias de mensajes: T (círculos grandes), F (cuadros) y C (cuadros, más abajo). Un **rectángulo de borde rojo discontinuo** encuadra la zona superior del diagrama (mensajes T1 y T2), señalando visualmente cuál es el subconjunto que ilustra el ordenamiento total. Las líneas diagonales conectan el punto de emisión (círculo/punto lleno en el proceso origen) con los puntos de recepción (cuadros) en los procesos destino.

**Interpretación:** La zona resaltada en rojo indica que en el **ordenamiento total**, todos los procesos (P1, P2, P3) reciben los mensajes en exactamente el mismo orden global. Sin importar de qué fuente provengan o cuándo sean emitidos, la capa de comunicación garantiza que la secuencia de entrega sea idéntica en todos los nodos. Es la garantía más fuerte de ordenamiento.

#### Ordenamiento FIFO (Página 13)

Misma estructura de diagrama con tres procesos y tres familias de mensajes T, F y C.

```
Tiempo
  │    T1●                                     ●T2
  │      ○────────────────────●────────────────○
  │      ●                                     ●
  │   F1 ●──────────────────────────────────────■   ┐
  │   F2 ●──────────■─────────■────────────────■F3  │ (resaltado rojo)
  │      ○          ■         ■                      ┘
  │   C1 ●──────────────────────────────────────■
  │   C2 ●──────────■─────────■───────────────●C3
  │      ■          ■         ■               ■
  ▼      P1         P2        P3
```

**Descripción literal (Imagen 4):** Idéntica estructura de tres procesos con mensajes T, F y C. Ahora el **rectángulo de borde rojo discontinuo** se desplaza a la zona media del diagrama, encuadrando exclusivamente los mensajes F1, F2 y F3. Los mensajes T quedan fuera del recuadro (en la parte superior) y los mensajes C también (en la parte inferior).

**Interpretación:** El recuadro rojo señala que la propiedad garantizada en este modelo es el **ordenamiento FIFO**: los mensajes enviados por **la misma fuente** se entregan en el orden en que fueron emitidos. Si P1 emite F1 y luego F2, todos los receptores recibirán F1 antes que F2. Sin embargo, no hay garantía sobre el orden relativo entre mensajes de fuentes distintas (por ejemplo, F1 podría llegar antes o después de T2 en distintos procesos).

#### Ordenamiento Causal (Página 14)

Misma estructura de diagrama con tres procesos y tres familias de mensajes T, F y C.

```
Tiempo
  │    T1●                                     ●T2
  │      ○────────────────────●────────────────○
  │      ●                                     ●
  │   F1 ●──────────────────────────────────────■
  │   F2 ●──────────■─────────■────────────────■F3
  │      ○          ■         ■
  │   C1 ●──────────────────────────────────────■  ┐
  │   C2 ●──────────■─────────■───────────────●C3  │ (resaltado rojo)
  │      ■          ■         ■               ■    ┘
  ▼      P1         P2        P3
```

**Descripción literal (Imagen 5):** Misma estructura de tres procesos con las tres familias de mensajes. En esta variante, el **rectángulo de borde rojo discontinuo** se desplaza a la zona inferior del diagrama, encuadrando únicamente los mensajes C1, C2 y C3. Los mensajes T y F quedan fuera del recuadro en las zonas superior y media respectivamente.

**Interpretación:** El recuadro rojo señala el **ordenamiento causal**: si un mensaje C2 fue generado como consecuencia de haber recibido C1 (existe una relación _happens-before_ entre ellos), entonces cualquier proceso que reciba C2 habrá recibido C1 con anterioridad. Es una generalización de FIFO que captura dependencias causales entre mensajes de **distintas fuentes**, no solo del mismo emisor. Es más fuerte que FIFO pero menos restrictivo que el ordenamiento total.

### Diagrama: Manejo de Membresía al Grupo (Página 15)

```
                           Expansión de la dirección del grupo
  ○ ──(Enviar a grupo)──►  ┌──────────────────────────────────┐
  (proceso externo)        │          ○  (miembro)            │
  "Multienvío"             │        ↗ ↘                       │
                           │      ○     ○  (miembro)──Salir ─────────►┐
                           │                                  │        │
                           │         ○  (miembro)──Fallo ─────────────► Gestión de
                           │                                  │        │ miembros
                           │  ◄── Entrar ── ○ (proceso nuevo) │        │ del grupo
                           └──────────────────────────────────┘        │
                                       Grupo de procesos        ◄──────┘
```

**Descripción literal (Imagen 6):** El diagrama muestra un gran **óvalo anaranjado** etiquetado "Grupo de procesos" con tres círculos blancos en su interior (los miembros actuales), conectados entre sí con flechas negras. A la izquierda, un círculo blanco externo tiene dos flechas negras que apuntan hacia los miembros del grupo, etiquetadas en azul: "Enviar a grupo", "Expansión de la dirección del grupo" y "Multienvío". Desde dos de los nodos interiores parten flechas discontinuas horizontales hacia la derecha, etiquetadas "Salir" y "Fallo" en negro, que convergen en el texto **"Gestión de miembros del grupo"** en azul (fuera del óvalo, a la derecha). En la parte inferior del óvalo, una flecha discontinua entra desde un círculo externo etiquetada "Entrar". Las flechas de eventos de membresía (Salir, Fallo, Entrar) están dibujadas en **rojo**, distinguiéndolas visualmente de las flechas de comunicación normales.

**Interpretación:** El diagrama representa los cuatro mecanismos del ciclo de vida de la membresía grupal: (1) **Expansión de la dirección del grupo**: cuando un proceso externo envía a la dirección del grupo, el sistema traduce esa dirección en las direcciones individuales de todos los miembros actuales (multicast); (2) **Detector de fallos**: si un miembro falla, el evento "Fallo" es detectado; (3) **Notificación de miembros**: tanto los eventos de Salir como de Fallo y Entrar son reportados al servicio de Gestión de miembros del grupo, quien notifica a todos los restantes; (4) **Entrar**: un proceso externo puede solicitar unirse al grupo dinámicamente.

### 4.5 JGroups: Toolkit para Multicast Fiable

**JGroups** es una biblioteca Java que proporciona comunicación multicast fiable. Implementa los mecanismos descritos anteriormente (fiabilidad, ordenamiento, membresía) para que los desarrolladores puedan construir aplicaciones de comunicación grupal sin implementar estos protocolos desde cero.

---

## 5. Comunicación Publicación-Inscripción

El modelo **publicación-inscripción** (_publish-subscribe_) es un paradigma de comunicación indirecta ampliamente usado en sistemas distribuidos.

### Principio de funcionamiento

- Los **editores** (_publishers_) publican eventos estructurados a un servicio central.
- Los **suscriptores** (_subscribers_) expresan interés en tipos particulares de eventos.
- El **servicio de publicación-inscripción** casa (_matches_) las suscripciones con los eventos publicados y asegura el envío correcto de notificaciones.
- Un evento se envía a **todos los suscriptores** que hayan expresado interés en ese tipo de evento.

### Diagrama: Sistema de Agentes de Bolsa con Pub/Sub (Página 19)

```
         Fuente                                    Fuente
         externa                                   externa
            │                                         │
   ┌────────────────────┐                   ┌────────────────────┐
   │   Agente de Bolsa  │                   │   Agente de Bolsa  │
   │  ┌──────┐ ┌──────┐ │◄──Notificación────│ ┌──────┐  ┌──────┐│
   │  │Agente│ │Agente│ │◄──Notificación    │ │Agente│  │Agente││
   │  └──────┘ └──────┘ │                   │ └──────┘  └──────┘│
   └────────────────────┘                   └────────────────────┘
           ▲                [Proveedor de info]          ▲
           │               (centro, distribuye)          │
           └──────Notificación─────────────Notificación──┘
   ┌────────────────────┐                   ┌────────────────────┐
   │   Agente de Bolsa  │                   │   Agente de Bolsa  │
   │  ┌──────┐ ┌──────┐ │◄──Notificación────│ ┌──────┐  ┌──────┐│
   │  │Agente│ │Agente│ │◄──Notificación    │ │Agente│  │Agente││
   │  └──────┘ └──────┘ │                   │ └──────┘  └──────┘│
   └────────────────────┘                   └────────────────────┘
                              [Proveedor de
                               información 2]
                              Fuente externa
```

**Descripción literal (Imagen 7):** El diagrama muestra dos **Proveedores de información** en el centro (uno arriba y uno abajo), cada uno alimentado por una "Fuente externa" con una flecha que entra desde arriba o desde abajo. Alrededor de los proveedores, en las cuatro esquinas, hay cuatro recuadros marrón oscuro etiquetados "Agente de Bolsa", cada uno conteniendo un círculo grande blanco con dos íconos de tarjetas de base de datos (representando subagentes) con flechas entre ellos. Desde los proveedores parten múltiples flechas etiquetadas "Notificación" en negro que se cruzan y llegan a los distintos Agentes de Bolsa, mostrando que cada proveedor puede enviar notificaciones a múltiples agentes simultáneamente.

**Interpretación:** Este diagrama ilustra el patrón publicación-inscripción aplicado a un sistema financiero distribuido. Los **proveedores de información** son los publicadores: reciben datos del mercado de fuentes externas y distribuyen notificaciones a múltiples destinos. Los **Agentes de Bolsa** son los suscriptores: contienen subagentes que procesan las notificaciones recibidas. El sistema puede escalar con múltiples proveedores y múltiples agentes simultáneos, todos desacoplados entre sí. Las flechas cruzadas ilustran que cada proveedor puede notificar a varios agentes y que los agentes pueden recibir notificaciones de varios proveedores.

### 5.1 Propiedades del Modelo Publicación-Inscripción

#### Heterogeneidad

> Facilita que componentes variados (de distintos lenguajes, plataformas o versiones) **trabajen juntos** por medio de interfaces de recepción de eventos.

Los componentes no necesitan compartir tecnología ni conocerse mutuamente; solo deben entender el formato de los eventos.

#### Asincronía

> Las notificaciones se envían **asíncronamente** a los suscriptores, evitando el acoplamiento temporal.

El publicador no espera respuesta del suscriptor. Esto significa que el publicador puede seguir produciendo eventos a su propio ritmo, independientemente de cuánto tarden los suscriptores en procesarlos.

### Diagrama: Operaciones del Sistema Publicar/Suscribir (Páginas 22 y 25)

```
  [editor] ──Publicar(e1)─────────────────────────────────────────────►
                               ┌─────────────────────┐  Suscribir(f1)◄─── [suscriptor]
  [editor] ──Publicar(e2)─────►│                     │──Notificar(e2)───► [suscriptor]
                               │ Sistema             │
  [editor] ──Anunciar(f1)─────►│ publicar/suscribir  │──Notificar(e1)───► [suscriptor]
                               └─────────────────────┘
```

**Descripción literal (Imágenes 8 y 9):** El diagrama muestra tres **óvalos amarillos** a la izquierda, todos etiquetados "editor". Cada óvalo tiene una flecha que apunta hacia la derecha con su etiqueta de operación: el primero con `Publicar(e1)`, el segundo con `Publicar(e2)`, y el tercero con `Anunciar(f1)`. Todas convergen en un **rectángulo azul marino** central etiquetado "Sistema publicar/suscribir". Del lado derecho del rectángulo central salen flechas hacia tres **óvalos rojos** etiquetados "suscriptor": el primero con la operación `Suscribir(f1)` (flecha que entra al sistema, no sale), el segundo recibe `Notificar(e2)` y el tercero recibe `Notificar(e1)`. Las imágenes 8 y 9 muestran el mismo diagrama en dos diapositivas consecutivas del curso, siendo prácticamente idénticas.

**Interpretación:** El diagrama muestra el flujo completo de las cinco operaciones del modelo pub/sub. Los **editores** pueden realizar dos tipos de operaciones: `Publicar(evento)` para enviar un evento concreto, o `Anunciar(filtro)` para declarar qué tipos de eventos publicarán en el futuro (útil para optimización del sistema). Los **suscriptores** realizan `Suscribir(filtro)` para registrar su interés. El **sistema central** hace el casamiento (_matching_) entre los filtros de suscripción y los eventos publicados, y ejecuta `Notificar(evento)` enviando la notificación solo a los suscriptores cuyo filtro coincide.

### 5.3 Esquemas del Filtro

Los filtros determinan qué eventos recibe cada suscriptor. Existen cuatro esquemas principales:

#### Basados en Canales

- Los eventos se publican en un **canal nombrado**.
- Los suscriptores se suscriben a un canal específico.
- Simple pero rígido: no permite filtrar por contenido dentro del canal.

#### Basados en Asunto o Tema (Topic-Based)

- El **tema** (_topic_) es uno de los campos del evento.
- La suscripción se define con respecto a este campo.

```java
// Ejemplo en JADE (Java Agent DEvelopment Framework)
MessageTemplate mt = MessageTemplate.MatchTopic(Topic);
ACLMessage msg = receive(mt);
```

#### Basados en Contenido

- La suscripción es una **condición lógica** o _query_ sobre los valores de los atributos del evento.
- Permite filtros muy expresivos y precisos.

```java
// Ejemplo: recibir mensajes INFORM del agente "myAgent"
MessageTemplate mt = MessageTemplate.and(
    MessageTemplate.MatchPerformative(ACLMessage.INFORM),
    MessageTemplate.MatchSender(new AID("myAgent", AID.ISLOCALNAME))
);
ACLMessage msg = receive(mt);
```

#### Basados en Tipos

- La suscripción define **tipos de eventos** compatibles con un tipo o subtipo del filtro (orientado a objetos).
- Se integran elegantemente en **lenguajes de programación orientados a objetos**, aprovechando la jerarquía de herencia.

### Diagrama: Pub/Sub Distribuido — Red de Brokers (Páginas 26 y 28)

```
Publishers          Broker network (óvalo anaranjado)    Subscribers
                   ┌────────────────────────────────┐
   [P1] ──────────►│   ○─────────○                  ├──────► [S1]
                   │   │         │                  │
   [P2] ──────────►│   ○────○────○                  ├──────► [S2]
                   │        │                       │
   [P3] ──────────►│        ○                       ├──────► [S3]
                   └────────────────────────────────┘
```

**Descripción literal (Imagen 10):** El diagrama muestra, a la izquierda, tres recuadros cuadrados etiquetados `P1`, `P2` y `P3` (Publishers). A la derecha, tres recuadros cuadrados etiquetados `S1`, `S2` y `S3` (Subscribers). En el centro hay un gran **óvalo anaranjado** etiquetado "Broker network", que contiene cinco círculos blancos (brokers individuales) interconectados entre sí con líneas, formando una topología de malla no uniforme. Los publicadores tienen líneas que entran al óvalo por la izquierda, y los suscriptores tienen líneas que salen por la derecha.

**Interpretación:** Este diagrama representa la arquitectura **distribuida** del sistema pub/sub. En lugar de un único broker central, existe una **red de brokers** que cooperan entre sí mediante protocolos de enrutamiento de eventos. Los publicadores (P1, P2, P3) se conectan al broker más cercano o disponible; los eventos se propagan internamente por la red de brokers hasta alcanzar los brokers a los que están conectados los suscriptores (S1, S2, S3). Esta arquitectura elimina el punto único de fallo y permite escalar horizontalmente añadiendo más brokers a la red.

| Aspecto | Centralizado | Distribuido (red de brokers) |
|---------|-------------|-------------|
| **Simplicidad** | Alta | Baja |
| **Escalabilidad** | Limitada | Alta |
| **Tolerancia a fallos** | Baja (punto único de fallo) | Alta |
| **Latencia** | Variable | Generalmente menor |

---

## 6. Colas de Mensajes

Las **colas de mensajes** (_message queues_) son la abstracción fundamental que sustenta la comunicación indirecta en muchos sistemas distribuidos.

### ¿Para qué se usan?

- **Integración de aplicaciones** heterogéneas (diferentes lenguajes, plataformas, versiones).
- Base para **sistemas de procesamiento de transacciones**.
- Proporcionan **desacoplamiento espacial y temporal** entre emisores y receptores.

### 6.1 Modelo de Programación

El modelo es simple e intuitivo:

- Los **emisores** mandan mensajes **a la cola**.
- Los **receptores** leen mensajes **de la cola**.

### Diagrama: Sistema Cola de Mensajes (Página 30)

```
                    ┌─────────────────────────────────────────────┐
                    │         Sistema Cola de Mensajes            │
[productores]─Enviar►  ■──■──■  (Cola 1)           ◄──Recibir── [consumidor]
                    │                                             │
[productores]─Enviar►     ■     (Cola 2)           ◄──Consultar─[consumidor]
                    │                                             │
[productores]─Enviar►  ■──■     (Cola 3)           ◄──Notificar─[consumidor]
                    └─────────────────────────────────────────────┘
```

**Descripción literal (Imagen 11):** El diagrama muestra un gran rectángulo anaranjado etiquetado "Sistema Cola de Mensajes". A la izquierda hay tres óvalos amarillos etiquetados "productores", cada uno con una flecha etiquetada "Enviar" apuntando al interior del rectángulo. Dentro del rectángulo se ven tres filas horizontales (colas) con rectángulos pequeños grises que representan mensajes encolados. A la derecha del rectángulo hay tres óvalos rojos etiquetados "consumidor", con flechas etiquetadas "Recibir", "Consultar" y "Notificar" apuntando desde el sistema hacia cada consumidor.

**Interpretación:** El diagrama muestra los tres estilos de recepción de mensajes de una cola. El consumidor superior usa **Recibir** (bloqueante: espera hasta que llegue un mensaje). El consumidor del medio usa **Consultar** (_polling_ no bloqueante: verifica si hay mensajes y continúa si no los hay). El consumidor inferior usa **Notificar** (asíncrono por callback: el sistema avisa cuando llega un mensaje). Los productores siempre envían de la misma forma: depositan mensajes en la cola sin importar el estado del consumidor.

### 6.2 Estilos de Recepción

| Estilo | Descripción |
|--------|-------------|
| **Recepción bloqueante** | El receptor espera (bloqueado) hasta que llegue un mensaje en la cola. |
| **Recepción no bloqueante** | El receptor verifica si hay mensajes y continúa si no los hay (polling). |
| **Notificación (callback)** | Se dispara un evento cuando llega un mensaje; el receptor no necesita consultar activamente. |

### 6.3 Características de los Mensajes

- Las colas tienen **orden FIFO** o **por prioridades** para la entrega.
- Se puede **seleccionar un mensaje** por sus características (filtrado selectivo).
- Cada mensaje tiene:
  - **Destino:** a qué cola o receptor va dirigido.
  - **Metadatos:** información auxiliar (prioridad, timestamp, tipo, etc.).
  - **Cuerpo:** el contenido del mensaje propiamente dicho.

### 6.4 Persistencia y Fiabilidad

- Los mensajes son **persistentes**: se almacenan indefinidamente hasta que son leídos.
- Se **garantiza la entrega fiable**, aunque no se garantiza el momento exacto de entrega.
- Los mensajes sobreviven a reinicios del sistema (durabilidad).

### 6.5 Funcionalidades Adicionales

#### Mensajes Transaccionales

Los mensajes pueden formar parte de una **transacción**:
- O se realizan **todas** las acciones (envío + procesamiento) o **ninguna**.
- Si una parte falla, toda la operación se revierte (_rollback_).
- Esencial para sistemas financieros y de alta integridad.

#### Transformación de Mensajes

- Se pueden realizar **transformaciones al llegar a la cola**.
- Permite adaptar el formato de la información entre sistemas con distintas representaciones de datos.
- Ejemplo: convertir XML a JSON, o adaptar versiones de un protocolo.

### 6.6 Implementaciones Comerciales y Open Source

| Producto | Proveedor |
|---------|----------|
| **JMS** (_Java Message Service_) | Estándar Java (API, no implementación) |
| **IBM WebSphere MQ** | IBM |
| **MSMQ** (_Microsoft Message Queuing_) | Microsoft |
| **Oracle Streams Advanced Queuing** | Oracle |
| **ActiveMQ** | Apache (open source) |

#### Diagrama: IBM WebSphere MQ (Página 31)

**Descripción literal (Imagen 12):** La imagen muestra una gran flecha horizontal morada con el texto **"WebSphere MQ, Version 7.0"**. Sobre la flecha hay cuatro íconos de personas sentadas con laptop, cada uno asociado a uno de los cuatro tipos de interfaz que WebSphere MQ soporta: **Web 2.0**, **Java Message Service (JMS)**, **Multi-Language Message Service** y **MQ Interface**. Debajo de la flecha hay un recuadro que muestra el modelo **Publish/Subscribe**: a la izquierda hay íconos de documentos (mensajes publicados) y a la derecha grupos de círculos (suscriptores), con flechas punteadas indicando la distribución del mensaje a múltiples suscriptores.

**Interpretación:** WebSphere MQ de IBM es una solución empresarial de colas de mensajes que soporta múltiples interfaces de programación (Web 2.0, JMS, lenguajes múltiples e interfaz nativa MQ), permitiendo que aplicaciones heterogéneas se integren. También implementa el modelo publicación-inscripción, donde un mensaje publicado puede llegar a múltiples suscriptores simultáneamente.

#### Diagrama: Microsoft MSMQ (Página 32)

**Descripción literal (Imagen 13):** El diagrama muestra dos bloques principales. El bloque superior, etiquetado **"AppFabric/MSMQ Server"**, contiene dos componentes conectados: un **HttpReceiver** (recibe mensajes HTTP desde "la nube") y un **MsmqTransmitter** (transmite los mensajes al destino). Del MsmqTransmitter bajan cuatro flechas hacia cuatro colas verticales etiquetadas "MSMQ" cada una, conectadas mediante "Net.msmq binding". El bloque inferior, etiquetado **"BizTalk Server"**, recibe los mensajes de las colas MSMQ a través de un componente "Net.msmq receive location" y los procesa en **BizTalk** (representado como un servidor de base de datos).

**Interpretación:** El diagrama ilustra una arquitectura de integración empresarial con Microsoft MSMQ. Los mensajes HTTP llegan al servidor AppFabric, donde el HttpReceiver los captura y el MsmqTransmitter los distribuye a múltiples colas MSMQ. BizTalk Server consume esas colas para procesamiento de flujos de trabajo empresariales. MSMQ actúa como el intermediario de mensajería que desacopla la recepción HTTP del procesamiento BizTalk.

#### Diagrama: Oracle Streams Advanced Queuing (Página 33)

**Descripción literal (Imagen 14):** El diagrama se titula **"Advanced Queuing, an Enabling Technology"**. Muestra una base de datos Oracle a la izquierda con su cola de Advanced Queuing, conectada a dos aplicaciones (arriba y abajo). A la derecha de una barrera vertical etiquetada **"MACHINE BOUNDARY"** (frontera de máquina) hay dos instancias más de bases de datos Oracle, cada una también con Advanced Queuing y sus aplicaciones respectivas. Las flechas rojas que cruzan la barrera están etiquetadas: **"Propagate JMS Text message"** (hacia la base Oracle superior derecha) y **"Propagate business event message"** (hacia la base Oracle inferior derecha).

**Interpretación:** Oracle Advanced Queuing permite que aplicaciones conectadas a una base de datos Oracle intercambien mensajes de forma asíncrona. Lo más destacado del diagrama es la capacidad de **propagación entre máquinas**: los mensajes se pueden transferir automáticamente de una cola Oracle en un servidor a colas Oracle en otros servidores, cruzando fronteras de máquina. Se pueden propagar tanto mensajes JMS de texto estándar como eventos de negocio propietarios de Oracle.

#### Diagrama: Cola de Mensajes — Estructura básica (Página 37)

**Descripción literal (Imagen 15):** El diagrama muestra una estructura lineal simple. A la izquierda hay un rectángulo rojo etiquetado **"Sender"** (emisor). A la derecha un rectángulo cyan/azul etiquetado **"Receiver"** (receptor). Entre ellos hay un rectángulo gris más grande etiquetado **"Message Queue"** que contiene cuatro mensajes en fila: **Msg D**, **Msg C**, **Msg B**, **Msg A** (de izquierda a derecha). El Sender está conectado al extremo izquierdo de la cola con una línea punteada, y el Receiver está conectado al extremo derecho con otra línea punteada.

**Interpretación:** Esta es la representación más simple de una cola de mensajes FIFO. El emisor deposita mensajes por la "entrada" de la cola (izquierda), y el receptor los consume por la "salida" (derecha). Los mensajes se entregan en el mismo orden en que fueron encolados: el mensaje A (el primero en entrar) es el primero en ser entregado al receptor. La cola actúa como buffer que desacopla emisor y receptor.

---

## 7. Java Message Service (JMS)

**JMS** es una **API estándar de Java** para el intercambio de mensajes. Define las interfaces y el modelo de programación, pero no la implementación (que la proveen los _proveedores JMS_ como ActiveMQ, IBM MQ, etc.).

### 7.1 Arquitectura General de JMS y JNDI

El estándar JMS involucra tres actores en su configuración:

```
┌──────────────────┐        Bind        ┌──────────────────────────┐
│ Administrative   │──────────────────► │     JNDI Namespace       │
│ Tool             │                    │  ┌────┐  ┌────┐          │
└──────────────────┘                    │  │ CF │  │ D  │          │
                                        └──┴────┴──┴────┴──────────┘
┌──────────────────┐       Lookup              ▲
│                  │──────────────────────────►│
│   JMS Client     │
│                  │──────────────────► ┌──────────────────────────┐
└──────────────────┘  Logical           │     JMS Provider         │
                      Connection        └──────────────────────────┘
```

#### Diagrama: Rol del Proveedor JMS / Administrative Tool (Página 41)

**Descripción literal (Imagen 16):** El diagrama muestra cuatro componentes. En la parte superior izquierda: un rectángulo amarillo **"Administrative Tool"**. En la parte superior derecha: un rectángulo lila **"JNDI Namespace"** que contiene dos círculos morados etiquetados **"CF"** (ConnectionFactory) y **"D"** (Destination). El Administrative Tool tiene una flecha marrón gruesa apuntando hacia el JNDI Namespace, etiquetada **"Bind"**. En la parte inferior izquierda: un rectángulo amarillo **"JMS Client"**. En la parte inferior derecha: una nube morada etiquetada **"JMS Provider"** (resaltada con un círculo rojo). El JMS Client tiene dos flechas marrones gruesas: una apunta hacia arriba hacia el JNDI Namespace (**"Lookup"**) y otra apunta hacia la derecha hacia el JMS Provider (**"Logical Connection"**). El círculo rojo resalta el JMS Provider.

**Interpretación:** La herramienta administrativa registra (_bind_) la ConnectionFactory (CF) y el Destination (D) en el directorio JNDI. El cliente JMS primero hace un _lookup_ en JNDI para encontrar estos objetos por nombre, y luego usa la ConnectionFactory para establecer una conexión lógica con el JMS Provider (el broker real). El círculo rojo en esta diapositiva indica que el foco está en el **JMS Provider** como componente clave.

#### Diagrama: Rol del JMS Client (Página 42)

**Descripción literal (Imagen 17):** Mismo diagrama que el anterior, pero ahora el círculo rojo resalta el componente **"JMS Client"** (rectángulo amarillo inferior izquierdo). El flujo de flechas es idéntico: el Administrative Tool hace _Bind_ hacia JNDI Namespace (con CF y D), y el JMS Client hace _Lookup_ hacia JNDI y tiene una _Logical Connection_ hacia el JMS Provider (nube morada).

**Interpretación:** Esta diapositiva pone el foco en el **JMS Client**: el cliente es responsable de (1) consultar el directorio JNDI para obtener las referencias a la ConnectionFactory y al Destination, y (2) usar esas referencias para establecer la conexión con el proveedor y comenzar a producir o consumir mensajes. El cliente nunca se conecta directamente al broker sin pasar primero por JNDI.

#### Diagrama: Rol del JNDI Namespace (Página 43 — primera parte)

**Descripción literal (Imagen 18):** Mismo diagrama de tres componentes, pero ahora el círculo rojo resalta el **"JNDI Namespace"** (rectángulo lila superior derecho con los círculos CF y D). Las flechas son las mismas: Administrative Tool hace _Bind_ hacia JNDI, y JMS Client hace _Lookup_ desde JNDI y _Logical Connection_ hacia JMS Provider.

**Interpretación:** Esta diapositiva destaca el rol del **JNDI Namespace** como directorio de servicios central. JNDI (Java Naming and Directory Interface) actúa como el "libro de contactos" del sistema JMS: la herramienta administrativa registra los objetos administrados (CF y D) con nombres lógicos, y los clientes los buscan por ese nombre. Esto desacopla a los clientes de los detalles de implementación del proveedor: si cambia el proveedor o la configuración, solo hay que actualizar JNDI, no el código del cliente.

#### Diagrama: JMS Punto a Punto — Queue (Página 43 continuación / Imagen 19)

**Descripción literal (Imagen 19):** El diagrama muestra tres componentes horizontales. A la izquierda: un rectángulo amarillo **"Client 1"** con un ícono de documento etiquetado "Msg" sobre una flecha marrón gruesa apuntando hacia el centro. En el centro: un objeto con forma de cápsula/barril azul oscuro etiquetado **"Queue"**. A la derecha: un rectángulo amarillo **"Client 2"** con un ícono de documento "Msg" y dos flechas marrones que apuntan hacia el centro etiquetadas **"Consumes"** y **"Acknowledges"**. La flecha de Client 1 tiene la etiqueta **"Sends"**.

**Interpretación:** El diagrama ilustra el modelo **punto a punto** de JMS. Client 1 envía (_Sends_) un mensaje a la Queue. Client 2 consume (_Consumes_) ese mensaje de la Queue y luego lo reconoce (_Acknowledges_) para informarle al broker que fue procesado exitosamente. El _Acknowledge_ es importante: si el consumidor no lo envía (por ejemplo, porque falló durante el procesamiento), el broker puede re-entregar el mensaje. Cada mensaje es consumido exactamente una vez por un solo consumidor.

#### Diagrama: JMS Publicación-Inscripción — Topic (Página 43 continuación / Imagen 20)

**Descripción literal (Imagen 20):** El diagrama muestra Client 1 a la izquierda con un ícono de documento "Msg" y una flecha marrón gruesa hacia el centro etiquetada **"Publishes"**. En el centro hay un cilindro marrón etiquetado **"Topic"**. A la derecha hay dos clientes: **Client 2** y **Client 3**, cada uno con una flecha bidireccional hacia el Topic: una flecha entrante etiquetada **"Subscribes"** y una flecha saliente etiquetada **"Delivers"** (con un ícono de documento "Msg" al final de cada flecha de entrega).

**Interpretación:** El diagrama ilustra el modelo **publicación-inscripción** de JMS. Client 1 publica un mensaje en el Topic. Tanto Client 2 como Client 3 se han suscrito previamente al Topic, por lo que el broker entrega una copia del mensaje a cada uno. A diferencia de la Queue (donde el mensaje es consumido una sola vez), en un Topic el mismo mensaje se entrega a **todos los suscriptores activos**. Si un cliente no está suscrito en el momento del envío, no recibe el mensaje (a menos que use suscripciones durables).

### 7.2 Componentes JMS

| Componente | Rol |
|-----------|-----|
| **Proveedor JMS** | Implementa las interfaces; gestiona el broker de mensajes. |
| **Clientes JMS** | Productores y/o consumidores de mensajes. |
| **Mensajes JMS** | Objetos que se transfieren entre clientes. |
| **Destinos (_Destinations_)** | Objetos que identifican dónde los productores envían mensajes y de dónde los consumidores los reciben (Queues o Topics). |
| **ConnectionFactory** | Objeto que los clientes usan para crear conexiones con el proveedor. |
| **JNDI** | Directorio que permite localizar ConnectionFactories y Destinations por nombre. |

### 7.3 Modelo Punto a Punto (Queues)

Ver el **Diagrama: JMS Punto a Punto — Queue** en la sección 7.1 (Imagen 19).

Características:
- Cada mensaje tiene **un solo consumidor**.
- **No hay dependencias de tiempo** entre emisor y receptor.
- El receptor **confirma la lectura** del mensaje (_acknowledge_).
- Si el receptor no está disponible, el mensaje permanece en la cola hasta que lo lea.

### 7.4 Modelo Publicación-Inscripción (Topics)

Ver el **Diagrama: JMS Publicación-Inscripción — Topic** en la sección 7.1 (Imagen 20).

Características:
- Cada mensaje puede tener **múltiples consumidores**.
- Productores y consumidores tienen **dependencias de tiempo** controladas por la suscripción (si el consumidor no está suscrito al momento del envío, puede perder el mensaje a menos que use suscripción duradera).
- Corresponde al patrón publicación-inscripción clásico.

### 7.5 Modelo de Programación JMS

**Diagrama conceptual: Flujo de programación JMS**

```
1. Lookup en JNDI ──► ConnectionFactory + Destination
                              │
2. createConnection() ────────►
                              │
3. createSession() ───────────►  Session
                              │
4a. createProducer(dest) ─────►  MessageProducer
    producer.send(msg)

4b. createConsumer(dest) ─────►  MessageConsumer
    consumer.receive()           (bloqueante)
    consumer.setMessageListener  (asíncrono/callback)
```

**Descripción del flujo:**
1. El cliente consulta el directorio JNDI para obtener el `ConnectionFactory` y el `Destination` (Queue o Topic).
2. Usa el `ConnectionFactory` para crear una `Connection`.
3. De la `Connection` crea una `Session` (contexto de trabajo para producir/consumir mensajes).
4a. Para **producir**: crea un `MessageProducer` y llama a `send()`.
4b. Para **consumir**: crea un `MessageConsumer` y usa `receive()` (bloqueante) o registra un `MessageListener` (asíncrono).

---

## 8. JMS usando ActiveMQ

**Apache ActiveMQ** es una implementación open source del estándar JMS.

### 8.1 Configuración inicial

Para usar JMS con ActiveMQ, los pasos son:

1. **Instalar JDK 21** (versión requerida).
2. **Descargar ActiveMQ** desde el sitio oficial de Apache.
3. **Ejecutar ActiveMQ:**
   ```bash
   DIR_INSTALACIÓN/bin/activemq.bat start
   ```
4. **Consola de administración** disponible en: `http://localhost:8161`
   - Usuario: `admin`
   - Contraseña: `admin`
5. **Importar librerías** en el proyecto:
   - `DIR_INSTALACIÓN/activemq-all-X.X.jar`
   - `DIR_INSTALACIÓN/lib/optional/log4j*.jar`

### 8.2 Proyectos de ejemplo con ActiveMQ

#### JMSqueueAMQ — Ejemplo con Colas

Incluye los siguientes componentes:

| Clase | Función |
|-------|---------|
| `MessageSender` | Envía mensajes a una cola. |
| `MessageReceiver` | Recibe mensajes de una cola (bloqueante). |
| `MessageQueueBrowser` | Inspecciona el contenido de la cola sin consumir los mensajes. |
| `AsynchMessReceiver` | Recibe mensajes de forma asíncrona mediante un listener. |

#### JMStopicAMQ — Ejemplo con Topics

Demuestra cómo configurar la comunicación publicación-inscripción con ActiveMQ.

**Diferencias clave entre Queues y Topics en ActiveMQ:**

| Aspecto | Queue (Punto a Punto) | Topic (Pub/Sub) |
|---------|----------------------|-----------------|
| Consumidores por mensaje | 1 | N (todos los suscritos) |
| Persistencia por defecto | Sí | Solo con suscripción duradera |
| Dependencia temporal | No | Sí (sin suscripción duradera) |
| Caso de uso | Tareas de trabajo | Notificaciones / eventos |

---

## 9. Prácticas de Laboratorio

### 9.1 Sistema Financiero con Topics — JMSTopicsFinancialSystem

Este sistema simula un escenario financiero real donde un proveedor de información distribuye noticias negativas de mercado a múltiples agentes de bolsa.

#### Arquitectura del Sistema

```
┌──────────────────────────────────┐
│  Proveedor de Información        │
│  (1 instancia)                   │
│                                  │
│  Publica N noticias a 5 topics:  │
│  - Telecommunications            │
│  - Banks                         │
│  - Transportation                │
│  - FoodSupply                    │
│  - Education                     │
│                                  │
│  Al terminar: envía señal        │
│  "fin de sesión financiera"      │
│  a TODOS los agentes             │
└──────────────┬───────────────────┘
               │ Topics JMS
               ▼
    ┌──────────────────────────┐
    │   Broker ActiveMQ        │
    │   (distribuye noticias   │
    │    por categoría/topic)  │
    └───────────┬──────────────┘
                │
    ┌───────────┼───────────┐
    ▼           ▼           ▼
Agente 1    Agente 2    Agente N
(suscrito   (suscrito   (suscrito
 a Banks)  a Telecom)   a Education)

Si gravedad > 5: VENDE ACCIONES
```

#### Proveedor de Información

- **Una sola instancia** en el sistema.
- Publica información de **5 categorías** (Topics): `Telecommunications`, `Banks`, `Transportation`, `FoodSupply`, `Education`.
- El número de noticias a transmitir se puede configurar al iniciar.
- La **categoría y el nivel de gravedad** de cada noticia se determinan **aleatoriamente**.
- Cuando todas las noticias se han enviado, el proveedor envía una notificación de **fin de sesión financiera** a todos los agentes de bolsa (broadcast a todos los topics).

#### Agente de Bolsa

- Puede haber **N agentes** simultáneos.
- Cada agente se registra a **una sola categoría** (topic), determinada aleatoriamente al inicio.
- Lógica de negocio: si el nivel de gravedad de la noticia es **mayor a 5**, el agente ejecuta una orden de venta de acciones.
- Termina su proceso al recibir la notificación de **fin de sesión financiera**.

### 9.2 El Juego de la Papa — JMSQueuesThePotatoGame

Un juego de 2 jugadores implementado con colas de mensajes JMS que demuestra la comunicación asíncrona y concurrente.

#### Objetos del Juego

**Objeto Papa:**
- `identificador`: ID único de la papa.
- `tiempo`: tiempo aleatorio para "caerse" (entero que va decrementando).

**Objeto Jugador:**
- Tiene **una cola de entrada** donde recibe papas de otros jugadores.
- Tiene **una cola de salida** donde envía papas a otros jugadores.

#### Lógica del Juego

```
Jugador 1                    Jugador 2
    │                            │
    │  Tiene Papa A (tiempo=5)   │  Tiene Papa B (tiempo=3)
    │                            │
    │──[ Papa A ]──────────────► │  Recibe Papa A, revisa tiempo
    │                            │  tiempo > 0? → regresa Papa A
    │ ◄────────────[ Papa A ]────│  tiempo = tiempo - 1
    │                            │
    │  Recibe Papa A, tiempo=4   │──[ Papa B ]──────────────►│
    │  tiempo > 0? → regresa     │  Recibe Papa B...
    │  ...                       │
    │                            │
    │  Si tiempo llega a 0:      │
    │  PIERDE el juego           │
    └────────────────────────────┘
```

**Descripción del juego:** Cada jugador tiene su propia papa con un tiempo aleatorio. Los jugadores se lanzan la papa (vía colas de mensajes JMS) y cada vez que reciben una papa comprueban si el tiempo ha llegado a cero. Si el tiempo es mayor a cero, restan 1 al contador y re-envían la papa al otro jugador. El primer jugador cuya papa llegue a tiempo=0 **pierde el juego**, que entonces termina.

#### Flujo de operación de un Jugador

1. **Avientar la papa:** Envía su papa a la cola de mensajes del otro jugador.
2. **Verificar si recibió una papa:** Consulta su propia cola de mensajes.
3. Si recibió una papa:
   - Verifica si el `tiempo` llegó a 0 → **PIERDE**, termina el juego.
   - Si `tiempo > 0` → decrementa el tiempo y regresa la papa al remitente vía cola de mensajes.

#### Consideraciones Técnicas

```java
// Para mensajes de texto:
session.createTextMessage()
message.setText("contenido")

// Para mensajes con objetos serializables (como el objeto Papa):
session.createObjectMessage()
message.setObject(papa)

// Importante: Para que ActiveMQ permita recibir objetos arbitrarios
connectionFactory.setTrustAllPackages(true);
```

**Nota importante:** Para enviar objetos Java (como el objeto `Papa`) a través de JMS con ActiveMQ, el objeto debe implementar `java.io.Serializable`. Además, se debe configurar `setTrustAllPackages(true)` en la fábrica de conexión para que ActiveMQ permita la deserialización de clases personalizadas por razones de seguridad.

---

## Resumen General

| Modelo | Acoplamiento | Casos de uso |
|--------|-------------|-------------|
| **Memoria Distribuida Compartida** | Bajo (espacial) | Intercambio de datos sin mensajes explícitos |
| **Comunicación Grupal** | Bajo | Multicast fiable, replicación, monitorización |
| **Publicación-Inscripción** | Muy bajo (espacial y temporal) | Eventos, notificaciones, sistemas reactivos |
| **Colas de Mensajes** | Muy bajo (espacial y temporal) | Integración de sistemas, transacciones, trabajo asíncrono |

Todos estos modelos comparten el objetivo de **reducir el acoplamiento** entre los componentes del sistema distribuido, aumentando así la flexibilidad, escalabilidad y tolerancia a fallos del sistema en su conjunto.

---

*Notas elaboradas a partir del material del curso de Sistemas Distribuidos — ITAM*  
*Dr. J. Octavio Gutiérrez García*
