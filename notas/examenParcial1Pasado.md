**Examen Parcial de Sistemas Distribuidos**

**1. (0.2 puntos) Indique si las siguientes oraciones son FALSAS o CIERTAS:**

* **[ Cierto ]** Los componentes de un sistema distribuido se coordinan a través de mensajes. 
* **[ Falso ]** Los sistemas distribuidos se coordinan con relojes globales.

**2. (0.2 puntos) Complete las frases usando una de las siguientes tres opciones:**
"ASÍNCRONA", "SÍNCRONA" o "SÍNCRONA y ASÍNCRONA"

* Los Sockets UDP soportan comunicación **Síncrona y asíncrona**.
* Los Sockets TCP soportan comunicación **Síncrona y asíncrona**.

**3. (0.2 puntos) Indique si las siguientes oraciones son FALSAS o CIERTAS:**

* **[ Cierto ]** La comunicación vía sockets TCP ajusta las velocidades de los procesos que leen y escriben
* **[ Falso ]** En la comunicación vía sockets UDP, la aplicación puede elegir la cantidad de datos que quiere escribir o leer del stream. 

**4. (0.2 puntos) ¿Cuándo debo utilizar JSON sobre XML para serializar mensajes?**

> **Respuesta:** Cuando tengo restricciones de capacidad en los canales de comunicación o necesito hacer más ligeros los mensajes (p. ej., QoS)

**5. (0.2 puntos) ¿Qué función tienen los schemas de XML?**

> **Respuesta:** Definir la estructura y tipos de datos de los mensajes. (permite múltiples vocabularios en un mismo mensaje)

**6. Describa un ejemplo donde debido a la concurrencia, dos hilos generen una condición de carrera.**

**a) (0.1 puntos) Defina el contexto y/o dominio del ejemplo (Nota: Se podrá utilizar cualquier contexto y/o dominio excepto incrementar un contador).**

> **Respuesta:** Sistema de cargos a cuentas monetarias (como servicios financieros del ITAM) con una base de datos centralizada.

**b) (0.1 puntos) En función del dominio seleccionado, defina el pseudocódigo a ser accedido por los hilos concurrentemente:**

> **Respuesta:**
> 1. Buscar el saldo del estudiante X
> 2. Calcular el nuevo saldo (según la compra)
> 3. Guardar el nuevo saldo en la base.

**c) (0.1 puntos) Indique un posible entrelazamiento de la ejecución de los hilos que genere una condición de carrera:**

**Ejemplo de respuesta esperada (con modificaciones a mano por el alumno):**

* Valor inicial de la variable compartida: **1000**
* Hilo A, ejecuta línea de pseudocódigo 1, **2**
* Hilo B, ejecuta línea de pseudocódigo 1, **2**
* Hilo B, ejecuta línea de pseudocódigo 2, **3**
* Hilo A, ejecuta línea de pseudocódigo 2, **3**
* Valor final de la variable compartida: **900**
*(Deberá ser un valor inconsistente derivado de la condición de carrera)*

> Supongamos que llegan dos cargos al estudiante X de manera consecutiva, el primero por $100 y el segundo por $200. Imaginemos que tenía $1000 al inicio.
> Ambos hilos leen un saldo inicial de 1000, luego el hilo B guarda un saldo de 800 y el hilo A lo sobreescribe con 900.

**(0.2 puntos) Explique las diferencias entre los servicios de temas (topics) y colas (queues).**

> **Respuesta:** Los topics no desacoplan temporalmente y los queues sí (persistencia).
> Los topics entregan los mensajes a todos los consumidores suscritos (como una dinámica Multicast) y en las queues los mensajes desaparecen en cuanto un suscriptor lo consume (y da acuse de recibo).

**8. (0.2 puntos) Para cada uno de los siguientes enunciados, indique SI es o NO es una función realizada por una interfaz en gRPC**

* **[ SÍ ]** Dan el nombre del servicio que utilizan los clientes y servidores
* **[ SÍ ]** Indican los tipos de datos de los argumentos/parámetros.

**9. (0.1 puntos) ¿Qué es un Protocol Buffer?**

> **Respuesta:** Un mecanismo de serialización binaria multiplataforma, más rápido que JSON y XML. Es usado en sistemas de invocación remota.
