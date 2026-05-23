***
# Introducción al curso
## Parcial 1 - Sistemas Distribuidos
* **Curso:** Sistemas Distribuidos.
* **Objetivos del Curso:**
    * Diseñar e implementar sistemas distribuidos.
    * Entender y manejar las tecnologías existentes para su implementación.
    * Implementar los métodos de comunicación entre procesos distribuidos.
    * Desarrollar servicios y aplicaciones web.
    * Implementar mecanismos de concurrencia entre procesos distribuidos.
* **Temario:**
    * Introducción a los sistemas distribuidos.
    * Comunicación entre procesos: Concurrencia, Sockets TCP y UDP, Serialización de Java, XML, JSON, y Protocol Buffers.
    * Invocación remota: RPC, RMI y microservicios con gRPC, Protocolos request-reply.
    * Modelos de comunicación indirecta: Java Message Service, Servicios de Temas (Topics) y Colas (Queues).
    * Programación Web: HTML y CSS, JavaScript y comunicación asíncrona, Flask & Django.
    * Servicios web: SOAP, RESTful, GraphQL.
* **Bibliografía y Recursos:**
    * Tanenbaum, A., Van Steen M., *Distributed Systems principles and paradigms*. Segunda edición, Ed. Pearson-Prentice Hall, 2016.
    * Coulouris G., Dollimore J., & KindBerg T. (2012). *Distributed Systems Concepts and Designs*. Quinta edición, Addison Wesley.
    * Código para prácticas disponible en: https://github.com/octavio-gutierrez.

---

## Introducción a Sistemas Distribuidos
* **¿Qué es un Sistema Distribuido (SD)?**
    * Es un sistema en el cual los componentes de *hardware o software*, localizados en computadoras unidas *mediante red, se comunican y coordinan* sus acciones únicamente mediante el paso de *mensajes*.
* **Características Principales:**
    * Concurrencia de los componentes.
    * *No existe un reloj global*.
    * Fallos independientes de los componentes.
* **Ejemplos de Sistemas Distribuidos:**
    * Internet, redes corporativas, redes de teléfonos móviles, y redes domésticas/universitarias.
    * *Diagrama 1 (Redes de un coche):* Muestra diferentes unidades de control interconectadas, incluyendo ABS, puertas, unidad central, caja de cambios automática y motor.
    * Sistemas de archivos distribuidos y estructuras de almacenamiento.
    * Sistemas de candados distribuidos.
    * Modelos de programación como MapReduce.
    * Centros de datos globales.
    * Juegos online multijugador, usando arquitecturas que asignan usuarios a servidores "cercanos" o investigando arquitecturas Punto-a-Punto.
* **Tendencias:**
    * Redes *omnipresentes* (computación *ubicua*), con tecnologías como WiFi, WiMAX, Bluetooth y redes telefónicas nG.
    * *Movilidad* de usuarios y creciente demanda de servicios *multimedia*.
    * Visión de los SDs como un *servicio básico*.
    * Blockchain (bitcoin, ethereum, dodge, etc.).
    * *Diagrama 2 (Redes de internet moderna):* Muestra computadoras conectadas a un ISP protegido por firewall, y otras conexiones con servidores y redes.

---

## Computación Ubicua, Móvil y la Nube
* **Factores Clave:**
    * Redes inalámbricas y miniaturización de dispositivos.
    * Auge de los dispositivos "Smart-*" (laptops, celulares, GPS, relojes inteligentes, dispositivos embebidos en el hogar como refrigeradores).
    * Integración de asistentes inteligentes (ej. Alexa, Josh.ai) con consciencia de ubicación y contexto (Location-aware & context-aware).
* **Computación Ubicua:**
    * Premisa "Anywhere & Anytime".
    * La abundancia de dispositivos es más útil cuando interactúan entre sí, requiriendo interoperación espontánea y descubrimiento de servicios.
    * *Diagrama 3 (Red de conectividad):* Muestra la conexión de Internet en casa enlazada a impresoras, red inalámbrica (WLAN) y laptops. También ilustra un teléfono móvil conectado a Internet de forma directa mediante red 3G y recibiendo señales satelitales GPS.
* **Sistemas Multimedia y Cloud Computing:**
    * Webcasting (transmisión de video y audio) requiriendo Calidad de Servicio (QoS).
    * La computación distribuida se ofrece como servicio público mediante el **Cloud Computing**: infraestructura virtualizada (hardware y software) accesible vía internet bajo contratos de nivel de servicio (SLA).
    * *Diagrama 4 (Cloud Computing):* Ilustra la "Nube" dividida en tres capas: Software, Plataforma e Infraestructura (bases de datos, identificación), conectándose a múltiples dispositivos externos.

---

## Retos de los Sistemas Distribuidos
* **Heterogeneidad:**
    * Variaciones en redes, hardware, sistemas operativos, lenguajes de programación e implementaciones de diferentes desarrolladores.
    * Se soluciona mediante **Middleware**: una capa intermedia de software que provee una abstracción de programación (ejemplo: JBoss ESB).
* **Código Móvil:**
    * Código enviado de una computadora a otra para ser ejecutado en el destino (ej. Javascript, o Máquinas Virtuales como la JVM).
* **Extensibilidad y Sistemas Abiertos:**
    * Capacidad del sistema de ser extendido y re-implementado.
    * Un sistema es "abierto" si permite agregar nuevos servicios compartidos mediante interfaces públicas y mecanismos de comunicación estandarizados para hardware/software heterogéneo.
* **Seguridad:**
    * Requiere garantizar confidencialidad, integridad y disponibilidad.
    * Protección contra ataques de denegación de servicios (lentos y rápidos) y seguridad del código móvil.
* **Escalabilidad:**
    * Debe mantener eficiencia al incrementar usuarios y recursos.
* **Manejo de Fallos:**
    * Incluye procesos de detección, enmascaramiento, tolerancia, recuperación y redundancia.
* **Concurrencia y Transparencia:**
    * Servicios y recursos compartidos que pueden accederse al mismo tiempo por varios usuarios (procesos).
    * *Diagrama 5:* Ilustra la interacción de múltiples procesos accediendo a un recurso compartido.
    * El usuario final debe ver el sistema como una sola entidad (Transparencia).

---

## Transparencia y Modelos de Sistemas Distribuidos
* **Tipos de Transparencia:**
    * De acceso, de ubicación, de concurrencia, de replicación, de fallas, y de movilidad de componentes.
* **Calidad de Servicio (QoS):**
    * Incluye propiedades no funcionales: confiabilidad, seguridad, rendimiento y adaptabilidad.
* **Modelos de Sistemas Distribuidos:**
    * **Modelos Físicos:** Representación del hardware y redes de interconexión.
        * *Diagrama 6 (Arquitectura de Red Data Center):* Presenta una jerarquía física: "Core switches" arriba, conectados a "Aggregate Switches", que a su vez se conectan a "ToR (Top of Rack) switches" y finalmente comunican a los servidores físicos ("Racks").
    * **Modelos Arquitectónicos:**
        * Describen los SDs en tareas computacionales y de comunicación de los componentes.
        * Definen la estructura de los componentes y sus interrelaciones, identificando las entidades, cómo se comunican, sus roles y su ubicación geográfica o de red.
    * **Modelos Fundamentales:**
        * Modelo de Interacción, Modelo de Fallo y Modelo de Seguridad.

---

## Balanceo de Carga y Paradigmas de Comunicación
* **Ejemplo de Modelo Arquitectónico (Cloud Data Center):**
    * *Diagrama 7 (Estructura Cloud Data Center):* Muestra servidores físicos que contienen "server manager agents". Los agentes de máquinas virtuales (virtual machine agents) envían información a este manager, y el "front-end agent" procesa el uso de recursos para asignar rutas y cargas (Gutiérrez et al. 2015).
* **Balanceo de carga (Gutiérrez et al. 2022):**
    * *Diagrama 8 (Secuencia UML):* Modela un balanceo de carga iniciado por un servidor sobrecargado. Los servidores se agrupan en "coaliciones". La comunicación fluye desde un 'Internal Initiator', pasando por un 'Internal Coalition Member', hasta un 'External Coalition Leader' y un 'External Coalition Member'.
* **Entidades Comunicantes:**
    * Desde el sistema: Procesos (hilos) y Nodos (ej. sensores).
    * Desde la programación: Objetos, Componentes y Servicios Web.
* **Paradigmas de Comunicación:**
    * Comunicación entre procesos (sockets).
    * Invocación remota: Protocolos de solicitud-respuesta (HTTP), llamadas a procedimientos remotos (RPC) e invocación de métodos remotos (RMI).
    * Comunicación indirecta: Comunicación en grupo.

---

## Estrategias de Colocación y Patrones Arquitectónicos
* **Más Paradigmas de Comunicación Indirecta:**
    * Sistemas de publicación y subscripción (uno-a-muchos), Colas de mensajes (uno-a-uno), Espacios de tuplas y Memoria distribuida compartida.
* **Roles y Responsabilidades:**
    * **Cliente-Servidor:** Un cliente invoca un servicio, el servidor procesa y regresa un resultado. Un servidor también puede actuar como cliente e invocar a otro servidor.
        * *Diagrama 9:* Procesos de clientes y servidores interactuando en diferentes computadoras.
    * **Igual-a-Igual (Peer-to-Peer):** Arquitectura descentralizada.
        * *Diagrama 10:* Múltiples aplicaciones ("Peers") conectadas entre sí uno a uno, conteniendo objetos compartibles.
* **Estrategias de Colocación:**
    * Asignación de servicios a múltiples servidores, Almacenamiento en caché, Código móvil y Agentes móviles.
    * *Diagrama 11 (Múltiples servidores):* Clientes externos comunicándose con un bloque de servicio interno que contiene varios servidores intercomunicados.
    * *Diagrama 12 (Caché):* Clientes conectándose a un "Proxy Server", el cual funciona como intermediario con múltiples Web Servers para almacenar información en caché.

---

## Código Móvil y Patrones de Arquitectura
* *(Continuación del diagrama del Proxy Server comunicando con Web Servers)*.
* **Código Móvil:**
    * Se refiere a código transferido y ejecutado en el cliente (ej. NativeClient para web apps).
    * *Diagrama 13:* Muestra al cliente recibiendo código de un servidor web para interactuar y, posteriormente, ejecutando ese código de manera independiente.
* **Código móvil en Sandboxes:**
    * *Diagrama 14:* Internet se conecta a un archivo ejecutable aislado (software.exe) mediante un entorno de tiempo de ejecución (service runtime). Esto interactúa de forma segura con los componentes del navegador web (Módulo NaCl, JavaScript, HTML, CSS).
* **Agentes Móviles:**
    * Programas que viajan por la red recolectando datos.
    * *Diagrama 15:* Una red de computadoras periféricas e impresoras interactuando de forma distribuida.
* **Patrones Arquitectónicos:**
    * **Arquitectura en 2 capas:**
        * Capa 1 (Cliente): Vista del usuario, controles y manipulación de datos.
        * Capa 2 (Servidor): Administración de la aplicación y bases de datos.

---

## Otras Arquitecturas (3 Capas, SOA y Microservicios)
* *(Continuación de los diagramas de 2 y 3 capas)*.
    * **Arquitectura en 3 capas:** Divide responsabilidades en Capa 1 (Cliente / Vista), Capa 2 (Servidor de aplicaciones / Lógica de negocio) y Capa 3 (Servidor de base de datos).
    * **Arquitecturas Orientadas a Servicios (SOA):**
        * *Diagrama 16:* Consumidores (humanos y de la nube) interactúan con un "Enterprise Service Bus" (BUS de servicio de negocio). Este BUS orquesta la comunicación hacia diferentes proveedores de servicios (ej. estatus de orden, carrito de compras, activación de cuenta), los cuales están conectados a diversas bases de datos.
    * **Arquitecturas de Microservicios:**
        * *Diagrama 17:* Servicios independientes como Órdenes e Inventario que pueden compartir una base de datos, mientras que servicios como Envíos y Tienda en Línea mantienen sus bases de datos exclusivas, garantizando la independencia de cada dominio.
    * **Clientes Ligeros:**
        * *Diagrama 18:* Un dispositivo en red ejecuta un "cliente ligero" cuya única tarea es conectarse a la red para comunicarse con un servidor de cómputo, donde reside realmente el proceso pesado de la aplicación.

---

## Modelos de Interacción y Sincronización Temporal
* *(Continuación del concepto de clientes ligeros)*.
* **Modelo de Interacción:**

    * Factores críticos que afectan la interacción en SDs: el desempeño de los canales de comunicación es un cuello de botella y es matemáticamente imposible mantener una noción global precisa del tiempo.
* **Desempeño de Canales de Comunicación:**
    * **Latencia:** Tiempo total que toma a un mensaje llegar. Suma el retardo de acceso a la red y el tiempo de procesamiento del SO al enviar/recibir.
    * **Ancho de banda:** Capacidad del canal.
    * **Fluctuación (Jitter):** Variación irregular en el tiempo para completar la entrega de mensajes (crítico para apps multimedia).
* **Clasificación Temporal (Relojes):**
    * **SDs síncronos:** Cada paso de un proceso tiene límite temporal inferior/superior, el mensaje llega en un tiempo límite conocido y cada proceso tiene un reloj local vinculado a uno real.
    * **SDs asíncronos:** Sin límites de tiempo de ejecución, la latencia es arbitraria y los valores de los relojes locales no están sincronizados con la realidad temporal.
* **Relación "Happens-Before" de Lamport:**
    * Denotada como a -> b (el evento 'a' sucedió cronológicamente antes que el evento 'b').
    * Es transitiva: Si a -> b y b -> c, entonces a -> c.
    * Reloj Lógico: Si a -> b, entonces el valor reloj(a) < reloj(b).
    * **Eventos Concurrentes:** Si ocurren en procesos que no intercambian mensajes, no se puede asegurar su orden. No aplica la relación a -> b ni viceversa.
    * **Regla de Sincronización:** El reloj debe avanzar siempre. Si el reloj local del receptor es menor que la estampa temporal del mensaje entrante, se ajusta usando: Nuevo reloj = estampa del mensaje + 1.

---

## Relojes Lógicos y Modelos de Fallo
* **Algoritmo de Relojes Lógicos de Lamport:**
    * *Diagrama 19:* Ilustra tres procesos paralelos independientes (P1, P2, P3). Los eventos (nodos negros 'a' a la 'k') son acciones secuenciales. Las flechas muestran mensajes de comunicación, donde la base es el envío y la punta la recepción.
    * Demostración de **"sincronización hacia adelante"**:
        * Evento 'h': A P2 le tocaría el tiempo local 2, pero recibe un mensaje de 'e' (tiempo 5). El reloj lógico se ajusta mediante la fórmula max(1,5)+1=6.
        * Evento 'k': A P3 le tocaría tiempo 2, pero recibe un mensaje de 'f' (tiempo 6). El reloj se ajusta a max(1,6)+1=7.
    * Avanza el reloj en cada evento. Permite obtener un ordenamiento parcial de los eventos.
* **Modelos de Fallo:**
    * Fallos por omisión (en el proceso o la red de comunicación).
    * Fallos de temporización.
    * Fallos arbitrarios (bizantinos), donde los componentes asumen comportamientos impredecibles o maliciosos.
* **Modelo de Seguridad:**
    * Depende estructuralmente de dos factores: Proteger los objetos lógicos de los procesos intrusos, y proteger la integridad de los canales de comunicación de red.
    * *Diagrama 20:* Muestra al "Principal (User/Cliente)" enviando una invocación por la red al "Principal (Server/Servidor)", este último cuenta con un sistema de "Derechos de acceso (Access rights)" validando la solicitud para interactuar con los objetos y devolver los resultados.

---

## Amenazas de Seguridad y Soluciones
* *Diagrama 21 (Vulnerabilidad del canal):* Ilustra un escenario donde el proceso 'p' envía información 'm' a través de un canal al proceso 'q'. Un enemigo (infiltrado de forma maliciosa) logra escuchar el canal para obtener una "copia de m" (m').
* **Técnicas para vencer las amenazas:**
    * Criptografía para cifrar el contenido.
    * Autenticación rigurosa de las identidades involucradas.
    * Implementación de Canales seguros, tales como VPN o SSL.
    * *Diagrama 22 (Canal Seguro):* Ilustra el establecimiento de un "Canal Seguro" entre el "Principal A" (Proceso p) y el "Principal B" (Proceso q) que bloquea intentos maliciosos de filtrado.
* **Otras Amenazas en Sistemas Distribuidos:**
    * Ataques de Denegación de Servicio (DoS), sobrecargando el sistema.
        * *Diagrama 23 (DoS):* Una avalancha de solicitudes coordinadas (múltiples bloques) dirigidas a un servidor central para incapacitarlo.
    * Amenazas provenientes de código móvil malicioso.

# Comunicación entre Procesos

## Comunicación entre Procesos
La comunicación entre procesos abarca las aplicaciones, los servicios, la invocación remota y la comunicación indirecta. Se basa en primitivas subyacentes de comunicación como Sockets, paso de mensajes, empaquetado y representación de datos, utilizando protocolos como UDP y TCP.

### Primitivas de Comunicación
El flujo básico de comunicación se da de la siguiente manera: **Primitivas -> Mensaje -> Proceso Receptor**.
* **Emisor:** `send(destino, mensaje)`
* **Receptor:** `receive(origen, mensaje)`

> **Diagrama de arquitectura base:** > * **1 Computadora:** Dos "Procesos de Usuario" se comunican entre sí pasando el mensaje a través de un único "Sistema Operativo (SO)" compartido, el cual actúa como intermediario. 
> * **2 Computadoras:** Para que los procesos se comuniquen, el mensaje debe bajar al SO de la máquina emisora, viajar a través de un medio externo hasta el SO de la máquina receptora y subir al proceso destino.

### Clasificación de la Comunicación
* **Síncrona:** Ej. Llamada de teléfono.
* **Asíncrona:** Ej. Mandar un correo.

#### Comunicación Síncrona (Bloqueante)
Las operaciones `Enviar()` y `Recibir()` son de bloqueo.

> **Diagrama de Comunicación Síncrona:** > Hay dos procesos (A y B) avanzando en su ejecución temporal. 
> * **El proceso A espera al B:** Ocurre un envío bloqueante. El proceso A envía un mensaje antes de que el Proceso B esté listo para procesarlo, por lo que A entra en "Espera" hasta que B ejecuta la instrucción de recibir.
> * **El proceso B espera al A:** Ocurre una recepción bloqueante. El proceso B llega a su instrucción "recibir" antes de que el Proceso A haya enviado los datos, por lo que B entra en "Espera" hasta que A envía el mensaje.

#### Comunicación Asíncrona (No bloqueante)
* `Enviar()` es no bloqueante.
* `Recibir()` puede ser bloqueante o no bloqueante.

> **Diagrama de Comunicación Asíncrona:**
> El Proceso A no se bloquea al enviar; deposita el mensaje y continúa su ejecución de inmediato. 
> * Más adelante, el Proceso B llega a su instrucción de recibir. Si no hay un mensaje listo, el Proceso B entra en estado de "Espera". 
> * Tiempo después, el Proceso A ejecuta "enviar" y continúa su camino sin detenerse. El Proceso B recibe el mensaje, sale del estado de espera y sigue su ejecución.

---

## Sockets y Puertos
Tanto UDP como TCP utilizan la abstracción de Sockets.

> **Diagrama de Sockets:**
> Una flecha central indica que los datos viajan desde la máquina **cliente** (identificada por su Dirección IP, ej. `138.37.88.249`, y un puerto efímero o "cualquier puerto") directamente hacia la máquina **servidor** (identificada por su Dirección IP, ej. `138.37.94.248`, y un puerto acordado). Ambos procesos tienen un socket con un puerto asignado para mandar y recibir la información. Cada máquina se ilustra con cientos de puertos disponibles (medialunas libres), lo que permite que varios procesos se comuniquen por la red de forma simultánea e independiente.

### Clasificación de Puertos
* **Puertos Reservados:** `<= 1023`
* **Puertos Registrados (ICANN):** `1024 <= Puertos <= 49151`
* **Puertos Libres:** `49152 <= Puertos <= 65535`

---

## Protocolos de Transporte

### User Datagram Protocol (UDP)
UDP es un protocolo sin conexión y no confiable (Connectionless and Unreliable).

> **Diagrama de red UDP:**
> Muestra la transmisión de datos entre dos computadoras a través de una red de enrutadores. Los datos originales del emisor se dividen en paquetes independientes llamados datagramas (Datagram 1, 2, 3...). Cada datagrama puede tomar una ruta completamente distinta a través de la malla de enrutadores para llegar a su destino. Como resultado, los datagramas no llegan en orden ("Out of order datagrams are not re-ordered") y si se pierden en el camino, no se vuelven a mandar ("Lost datagrams are not re-sent").

**Cuestiones importantes para la comunicación usando Sockets UDP:**
* El proceso de recepción debe especificar un arreglo de bytes de un tamaño en particular en el cual se recibirá el mensaje (`<= 8 Kb`).
* **Bloqueo:** `Enviar()` es no bloqueante. `Recibir()` es bloqueante (una opción es usar otro Hilo).
* Se puede definir un tiempo límite de espera (Timeouts).

**Comunicación UDP en Java:**
* **Librerías:** `java.net.*`, `java.io.*`
* **Clases principales:**
    * `DatagramSocket(serverPort)`
    * `DatagramPacket(m, m.length, aHost, serverPort)` *(para envío)*
    * `DatagramPacket(buffer, buffer.length)` *(para recepción)*
    * `InetAddress`

### Transmission Control Protocol (TCP)
TCP maneja la comunicación a través de streams (flujos) y está **orientado a conexión**.

La abstracción de streams oculta las siguientes características de la red:
* La aplicación puede elegir la cantidad de datos que quiere escribir o leer del stream.
* Los mensajes perdidos son detectados vía acuse de recibo y son reenviados.
* **Control de flujo:** TCP ajusta las velocidades de los procesos que leen y escriben en un stream.
* **Duplicación y ordenamiento:** Controlado vía identificadores incrustados en los mensajes.
* **Destino de los mensajes:** Los procesos establecen una conexión previa para comunicarse mediante el stream.

**Cuestiones importantes para la comunicación de streams TCP:**
* Debe haber concordancia de elementos de datos escritos y leídos del stream.
* **Bloqueo:** Los datos escritos en el stream se quedan en una cola en el Socket destino.
    * Cuando un proceso intenta leer, obtiene datos de la cola; si no hay, se bloquea hasta que lleguen.
    * El proceso que escribe puede ser bloqueado (por el control de flujo de TCP) si el socket del otro lado tiene llena la cola de entrada.
* Los servidores suelen crear hilos por cada cliente.

**Comunicación TCP en Java:**
* **Librerías:** `java.net.*`, `java.io.*`
* **Clases principales:** `Thread`, `ServerSocket(serverPort)`, `Socket`, `Connection(Socket)`, `DataInputStream`, `DataOutputStream`.

---

## Comunicación Multicast
Consiste en comunicación en grupo, de un proceso a un grupo de procesos. Sólo está disponible vía UDP.

**Utilidad:**
* Tolerancia a fallos en servicios replicados.
* Descubrimiento de servicios.
* Mejor rendimiento a través de datos replicados.
* Propagación de notificaciones.

**Multicast IP:**
* Se asocia un grupo multicast a una dirección multicast (Clase D: de `224.0.0.0` a `239.255.255.255`, asignadas por la IANA).
* Los grupos son dinámicos.
* Una computadora se une a un grupo multicast cuando uno o más de sus procesos tiene sockets que pertenecen al grupo.
* **Time to live (TTL):** Número de routers que el mensaje puede pasar (0..255).

**Multicast en Java:**
* **Librerías:** `java.net.DatagramPacket`, `java.net.InetAddress`, `java.net.MulticastSocket`, `java.net.SocketException`, `java.io.IOException`.
* **Clases y métodos:** `MulticastSocket` (`joinGroup`, `receive`, `send`, `leaveGroup`), `InetAddress`, `DatagramPacket`.

---

## Representación Externa de Datos
Los datos en los programas están en estructuras de datos nativas. Para su transmisión y recepción a través de la red, deben convertirse a una secuencia de bytes.

El problema radica en que diferentes dispositivos tienen diferentes formas de almacenar datos.
> **Diagrama de representación en memoria:**
> Se muestra un ejemplo de número de punto flotante de 64 bits en memoria. Utiliza 1 bit para el signo (bit 63), 11 bits para el exponente y 52 bits para la fracción/mantisa (bits 0 a 51). Otras arquitecturas podrían representarlo de manera distinta.

**Mecanismos para intercambiar datos:**
Para que computadoras de cualquier tipo se entiendan, se debe utilizar una representación externa de datos. Una forma es transmitir los datos en el formato del emisor e indicar en el mensaje qué formato se utilizó.

**Empaquetamiento:**
Es el proceso que toma una colección de elementos de datos y los ensambla de un modo adecuado para su transmisión.

Los estándares de representación comunes son:
1.  Representación común de datos de CORBA (Common Object Request Broker Architecture)
2.  Serialización de objetos en Java
3.  XML (Extensible Markup Language)
4.  JSON (JavaScript Object Notation)

### 1. Representación común de datos de CORBA
* **Tipos primitivos:** `short`, `long`, `unsigned short`, `unsigned long`, `float`, `double`, `char`, `boolean`, `octet`, `any`.
* **Tipos compuestos:** `String`, `array`, `struct`, `enumerated`, `union`, `sequence`.

**Ejemplo de Empaquetamiento (Struct Person):**
Para el struct con valores `{'Smith', 'London', 1984}`:

| Índice en Secuencia | 4 bytes |
| :--- | :--- |
| 0-3 | 5 (longitud de Smith) |
| 4-7 | "Smit" |
| 8-11 | "h\0\0\0" |
| 12-15 | 6 (longitud de London) |
| 16-19 | "Lond" |
| 20-23 | "on\0\0" |
| 24-27 | 1984 |

**Empaquetamiento en CORBA IDL (Interface Definition Language):**
```idl
module HelloApp {
    interface Hello {
        struct Person {
            string name;
            string place;
            unsigned long year;
        };
        string sayHello(in Person p);
        oneway void shutdown ();
    };
};
```

### 2. Serialización de objetos en Java
Es mejor serializar para evitar problemas con clases

**Clase original:**
```java
public class Person {
    private String name;
    private String place;
    private int year;
}
```

**Clase serializable:**
```java
import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private String place;
    private int year;

    public Person(String aName, String aPlace, int aYear){
        name = aName;
        place = aPlace;
        year = aYear;
    }
    // seguido de los métodos para acceder a los valores de los atributos
}
```
**Clases y métodos utilizados:**
`java.io.Serializable`, `implements Serializable`, `ObjectInputStream`, `ObjectOutputStream`, `writeObject`, `readObject`

**Ejemplo de uso:**
```java
Person me = new Person("Octavio", "Jalisco", 1980);
out.writeObject(me);
me = (Person) in.readObject();
```
### 3. XML (Extensible Markup Language)
**Ejemplo de elementos y atributos:**
```xml
<person id="123456789">
    <name>Smith</name>
    <place>London</place>
    <year>1984</year>
    </person>
```
**XML Namespace:**
Un archivo XML puede contener elementos o atributos de más de un vocabulario XML. El uso de Namespace permite resolver la ambigüedad
```xml
<pers:person pers:id="123456789" xmlns:pers="[http://any.url.com/person](http://any.url.com/person)">
    <pers:name> Smith </pers:name>
    <pers:place> London </pers:place>
    <pers:year> 1984 </pers:year>
</pers:person>
```
**XML Esquemas (.xsd):**
Describe la estructura de un archivo XML.
```xml
<xs:schema xmlns:xs="[http://any.url.com/MyXMLSchema](http://any.url.com/MyXMLSchema)">
    <xs:element name="person" type="personType" />
    <xs:complexType name="personType">
        <xs:sequence>
            <xs:element name="name" type="xs:string"/>
            <xs:element name="place" type="xs:string"/>
            <xs:element name="year" type="xs:positiveInteger"/>
        </xs:sequence>
        <xs:attribute name="id" type="xs:positiveInteger"/>
    </xs:complexType>
</xs:schema>
```

**Ejemplos de Restricciones en Esquemas:**
* **Rangos:** `<xs:minInclusive value="0"/>`, `<xs:maxInclusive value="120"/>`.
* **Enumeraciones:** `<xs:enumeration value="Audi"/>`.
* **Patrones Regex:**
    * [cite_start]Letras minúsculas: `<xs:pattern value="[a-z]"/>`.
    * [cite_start]Iniciales en mayúscula: `<xs:pattern value="[A-Z][A-Z][A-Z]"/>`.
    * [cite_start]Contraseñas: `<xs:pattern value="[a-zA-Z0-9]{8}"/>`.
* [cite_start]**Longitudes:** `<xs:length value="8"/>`, `<xs:minLength value="5"/>`, `<xs:maxLength value="8"/>`.

**Hacer referencia a un Esquema XML:**
```xml
<nt:note 
    xmlns:xsi="[http://www.w3.org/2001/XMLSchema-instance](http://www.w3.org/2001/XMLSchema-instance)"
    xmlns:nt="[http://any.url.com](http://any.url.com)"
    xsi:schemaLocation="[http://any.url.com](http://any.url.com) note.xsd">
    <nt:to>Juan</nt:to>
    <nt:from>Pedro</nt:from>
    <nt:priority>Alta</nt:priority>
    <nt:date>2015-03-16</nt:date>
    <nt:heading>Recordatorio</nt:heading>
    <nt:body>¡Estudiar para el examen de SD!</nt:body>
</nt:note>
```

### 4. Json (JavaScript Object Notation)
**Ejemplo de integración en HTML/JavaScript:**
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Document</title>
</head>
<body>
    <label for="nombre">Nombre: <span id="nombre"></span></label><br>
    <label for="lugar">Lugar: <span id="lugar"></span></label><br>
    <label for="anio">Año: <span id="anio"></span></label><br>
    <script>
        var JSONObject = {
            "name": "Juan",
            "place": "Jalisco",
            "year": 1989
        };
        document.getElementById("nombre").innerHTML = JSONObject["name"];
        document.getElementById("lugar").innerHTML = JSONObject["place"];
        document.getElementById("anio").innerHTML = JSONObject["year"];
    </script>
</body>
</html>
```

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

# Introducción a Sistemas Distribuidos: Invocación Remota

## Capas de Comunicación en Sistemas Distribuidos
La arquitectura de comunicación se divide en tres niveles principales:
* **Capa superior:** Aplicaciones y Servicios.
* **Capa intermedia:** Invocación remota, comunicación indirecta.
* **Capa inferior:** Primitivas subyacentes de comunicación entre procesos (Sockets, paso de mensajes, empaquetado y representación de datos, UDP y TCP).

## Invocación Remota
La invocación remota es una abstracción de alto nivel que permite a una aplicación invocar funcionalidad en otro proceso o nodo utilizando una sintaxis similar a una llamada local, ocultando así los detalles complejos de la red.

Existen diferentes paradigmas de comunicación:
* **RPC:** Remote Procedure Call (Llamadas a procedimientos remotos).
* **RMI:** Remote Method Invocation (Invocación de métodos remotos).
* **gRPC:** Google Remote Procedure Call (Framework Universal de RPC).
* **HTTP:** Hyper Text Transfer Protocol (Protocolos request-reply).

### Llamada a Procedimientos Remotos (RPC)
Desarrollado originalmente por Birrel y Nelson (1985), el objetivo principal de RPC es acercar la semántica de las llamadas a procedimientos convencionales a un entorno distribuido para lograr transparencia. Es el núcleo de muchos sistemas distribuidos y ha evolucionado hacia la orientación a objetos con RMI.

**Comunicación Cliente-Servidor (Diagrama Básico)**
* **Cliente:** Solicita una operación (invoca enviando un mensaje de petición), espera, y luego continúa al recibir la respuesta.
* **Servidor:** Recibe la petición, selecciona el servicio, ejecuta el servicio y envía un mensaje de respuesta.

Una RPC tiene dos participantes:
1.  Un cliente activo que envía una RPC al servidor.
2.  Un servidor pasivo que calcula un resultado y lo devuelve al cliente.

**Flujo de ejecución de una RPC**:
1.  El proceso que realiza la llamada empaqueta los argumentos en un mensaje.
2.  Envía el mensaje a otro proceso.
3.  Espera el resultado.
4.  El proceso que ejecuta el procedimiento extrae los argumentos del mensaje.
5.  Realiza la llamada de forma local.
6.  Envía el resultado de vuelta al cliente.

#### Los Stubs (Suplentes)
Los stubs son los responsables de convertir los parámetros de la aplicación cliente/servidor durante una llamada a procedimiento remoto. Son generados automáticamente por el software de RPC. El cliente se comunica con su stub local, quien a su vez se comunica a través de la red con el stub del servidor.

**Protocolo Básico del Cliente**:
1.  Conectar al servidor.
2.  Invocar una llamada a procedimiento remoto
3. **Acciones del Stub del cliente:** 
    * Empaquetar los parámetros y construir los mensajes.
    * Enviar los mensajes al servidor.
    * Bloquearse hasta esperar la respuesta.
    * Obtener la respuesta.

**Protocolo Básico del Servidor**:
1.  Registrar las RPC.
2.  Implementar los procedimientos.
3.  **Acciones del Stub del servidor:** 
    * Recibir petición del cliente.
    * Desempaquetar los parámetros.
    * Invocar el procedimiento de manera local.
    * Enviar respuesta al cliente (después de bloquearse esperando resolución).

#### Programación con Interfaces (IDL)
Se utiliza un Lenguaje de Definición de Interfaz (IDL) para especificar el formato exacto de los procedimientos remotos (nombres, parámetros de entrada/salida y tipos de datos). Esta interfaz es un contrato compartido entre el cliente y el servidor. Se utiliza un "Generador STUB" que toma esta interfaz para crear los stubs de ambas partes.

#### Enlace (Binding) y Servicio de Nombres
El enlace es la asociación entre el cliente y el servidor, lo cual implica localizar al servidor correcto en la red. Para lograr esto, el servidor registra su dirección en un servicio de nombres (conocido como *binder*).

**Esquema de Registro y Enlace (Diagrama)**:
1.  Servidor obtiene dirección.
2.  Servidor registra su dirección en el Binder.
3.  Cliente busca el servidor en el Binder.
4.  Binder devuelve la dirección al Cliente.
5.  Cliente envía petición al Servidor.
6.  Servidor envía respuesta al Cliente.
7.  El servidor borra la dirección al finalizar el servicio.

#### Ejemplo Práctico: Aplicación Hello en C
Los stubs en este tipo de aplicaciones se crean con compiladores especializados como MIDL (Microsoft Interface Description Language).

**El Servidor (`Hellop.c`)**:
```c
#include <stdio.h>
#include <windows.h>

// Saluda
void HelloProc(char* pszString) {
    printf("%s\n", pszString);
}

// Deja de escuchar
void Shutdown(void) {
    RPC_STATUS status;
    status = RpcMgmtStopServerListening(NULL);
    if (status) { exit(status); }
    
    // Se da de baja
    status = RpcServerUnregisterIf(NULL, NULL, FALSE);
    if (status) { exit(status); }
}
```
**La Interfaz (`hello.idl`)**:
```
[
    uuid(3f9fd0c7-d4a1-4bb8-b46b-c763b28a06e5),
    version(1.0) [cite: 166]
]
interface hello { 
    void HelloProc([in, string] unsigned char* pszString); 
    void Shutdown(void); 
}
```
**El Stub del Cliente (`hello_c.s`):**:
```
void HelloProc(/* [string][in] */ unsigned char *pszString) { 
    NdrClientCall2(
        (PMIDL_STUB_DESC)&hello_StubDesc, 
        (PFORMAT_STRING)&hello_MIDL_ProcFormatString.Format[0], 
        (unsigned char *)&pszString
    );
} 

void Shutdown(void) { 
    NdrClientCall2(
        (PMIDL_STUB_DESC)&hello_StubDesc,
        (PFORMAT_STRING)&hello_MIDL_ProcFormatString.Format[30], 
        (unsigned char *)0 
    ); 
} 
```
**Aplicación del Cliente:**:
Crea el enlace:
```
RpcBindingFromStringBinding( 
    pszStringBinding, 
    &hello_IfHandle
);
```
Llama a los procedimientos remotos:
```
RpcTryExcept { 
    HelloProc(pszString); 
    Shutdown();  
} 
```
**Aplicación del Servidor**: 
* Registrar el servidor con el servicio de nombres (Binder): RpcServerRegisterIf(hello_v1_0_s_ifspec, ...); 
* Escucha peticiones: RpcServerListen(cMinCalls, RPC_C_LISTEN_MAX_CALLS_DEFAULT, fDontWait); 
* Detiene el servidor (Dejar de escuchar): RpcMgmtStopServerListening(NULL); 
* Dar de baja el servicio: RpcServerUnregisterIf(NULL, NULL, FALSE); 

**Fallos en las RPC** 
* El cliente podría no ser capaz de localizar al servidor. 
* Pérdidas de mensajes (se pierde la petición del cliente o la respuesta del servidor). 
* El servidor falla después de recibir una petición. 
* El cliente falla después de enviar una petición.

### Invocación de Métodos Remotos (RMI) 

Es un modelo equivalente a las llamadas a procedimientos remotos y representa la primera aproximación al uso de un modelo orientado a objetos sobre aplicaciones distribuidas. Los objetos distribuidos dentro de una red proporcionan métodos, los cuales dan acceso a los servicios.

Ventajas y Desventajas:

Ventajas: Los programas RMI son más sencillos de diseñar y soportan un servidor RMI concurrente. 

Inconvenientes: Los Sockets tienen menos sobrecarga, y tradicionalmente se consideraba "RMI sólo para plataformas Java". 

**RMI vs RPC**:
*En común: Utilizan interfaces, están basados en protocolos petición-respuesta y son transparentes. 
*Diferencias: RMI utiliza programación orientada a objetos y permite enviar referencias a los objetos como parámetros. 
*Java RMI: Ofrece mecanismos para crear servidores y objetos cuyos métodos se pueden invocar remotamente, además de mecanismos para que los clientes localicen los objetos. Utiliza rmiregistry, un servicio de directorios de Java que se ejecuta en la máquina servidor objeto.

### Framework gRPC (Google Remote Procedure Call) 

gRPC es un framework universal de RPC de código abierto y alto rendimiento. 

Características y Ventajas: 

Multi-lenguaje. 

Tiene soporte para balanceo de carga, rastreo, verificación de estado y autenticación. 

Conecta servicios dentro (y entre) centros de datos, dispositivos, aplicaciones móviles y navegadores a servicios de back-end. 

Un cliente puede llamar directamente a un método en una aplicación de un servidor como si fuera un objeto local. 

Se define la interfaz de un servicio y se implementa la interfaz/servicio. 

Instalación (Python):
```
python -m pip install --upgrade pip 
python -m pip install grpcio 
python -m pip install grpcio-tools 
python -m pip install mypy-protobuf
```

###Protocol Buffers (Protobuf)
Es un mecanismo open source para serialización de objetos multi-plataforma. 
* Es más pequeño, rápido y simple que XML y JSON. 
* No es legible por humanos (i.e., binario). 
* Genera empaquetadores para: Java, Python, Objective-C, C++, C#, Kotlin, Dart, Go, Ruby y PHP. 

Ejemplo de sintaxis proto3 (`holamundo.proto`):
```
syntax = "proto3"; 
package ejemplos;
message Person { 
    optional string name = 1; 
    optional int32 id = 2; 
    enum PhoneType { 
        MOBILE = 0; 
        WORK = 1;
    }
    message PhoneNumber {
        optional string number = 1; 
        optional PhoneType type = 2; 
    }
    repeated PhoneNumber phones = 3; 
} 
message AddressBook {
    repeated Person people = 1; 
}
```
**Compilación de Protos**:
```
python -m grpc_tools.protoc -I. \
    --python_out=. \ 
    --pyi_out=. \
    --grpc_python_out=. \ 
    ./holamundo.proto
```

**Prácticas de Laboratorio gRPC**
1. Práctica CREDENCIALES 
Objetivo: Generar un servicio llamado Autenticador con un método autenticar. El package debe llamarse autenticador. 
Request (AuthenticationRequest): Debe recibir Nombre (string), Lugar de nacimiento (string), Año de nacimiento (int32) y Contraseña (string). 
Reply (AuthenticationReply): Debe regresar un Mensaje y un Status (false o true). 
El Cliente: Debe solicitar la autenticación e imprimir la respuesta. 

2. Práctica VENDEDORES 
El Servidor (Almacenamiento): Almacena en diccionarios: Vendedores, Tiendas, Productos y Asignaciones (de un vendedor a una tienda). Utiliza contadores para crear IDs (folio_vendedores, folio_productos, folio_tiendas, folio_asignaciones). 

El Cliente realiza: 
El registro de dos vendedores e imprime listado de vendedores. 
El registro de dos tiendas e imprime listado de tiendas. 
Dos asignaciones de vendedores a tiendas e imprime listado de asignaciones. 
Agrega dos productos e imprime listado de productos. 
El Servidor debe tener los siguientes RPC: 

Registrar vendedor (RegistroVendedor) → Status 
Registrar tienda (RegistroTienda) → Status 
Asignar a tienda (RegistroAsignacion) → Status 
Listado de tiendas → stream RegistroTienda 
Listado de vendedores → stream RegistroVendedor 
Listado de asignaciones → ListadoAsignaciones 
Agrega productos (stream Producto) → Status 
Listado de productos → stream Producto 
Mensajes / Estructuras de Datos: 
Status: éxito (true o false). 

Producto: id (numérico), cantidad, Descripción. 
RegistroVendedor: id (numérico), nombre, edad, salario. 
RegistroTienda: id (numérico), descripción, alcaldía. 
RegistroAsignacion: id asignación, id tienda, id vendedor. 
ListadoAsignaciones: repeated RegistroAsignacion.

# Guía Maestra de Tecnologías Distribuidas

Esta guía tiene como objetivo proporcionar una descripción detallada y autocontenida de las tecnologías distribuidas implementadas en este proyecto. Cada sección incluye explicaciones sobre la utilidad, estructura, funcionamiento, métodos importantes y ejemplos de código comentado para facilitar la comprensión y el aprendizaje.

---

## 1. gRPC

### ¿Qué es gRPC?
gRPC es un framework de comunicación remota que permite a los clientes y servidores comunicarse de manera eficiente utilizando protocolos binarios. Es ideal para sistemas distribuidos debido a su alto rendimiento y soporte para múltiples lenguajes.

### Estructura de gRPC
1. **Archivo `.proto`**: Define los servicios y mensajes.
2. **Archivos generados (`*_pb2.py`, `*_pb2_grpc.py`)**: Contienen las clases necesarias para la serialización y deserialización.
3. **Cliente y Servidor**: Implementan la lógica de negocio.

### Ejemplo Básico
#### Cliente
```python
import grpc
import holamundo_pb2
import holamundo_pb2_grpc

def run():
    # Crear un canal inseguro para conectarse al servidor.
    with grpc.insecure_channel("localhost:50051") as channel:
        # Crear un stub para invocar métodos remotos.
        stub = holamundo_pb2_grpc.SaludadorStub(channel)
        # Llamar al método remoto "diHola" definido en el servidor.
        respuesta = stub.diHola(holamundo_pb2.HelloRequest(name="Octavio"))
        print("El cliente recibió:", respuesta.message)

if __name__ == "__main__":
    run()
```
**Descripción de líneas importantes:**
- `grpc.insecure_channel`: Establece la conexión con el servidor.
- `SaludadorStub`: Clase generada automáticamente para invocar métodos remotos.
- `diHola`: Método remoto definido en el servidor.

#### Servidor
```python
from concurrent import futures
import grpc
import holamundo_pb2
import holamundo_pb2_grpc

class Saludador(holamundo_pb2_grpc.SaludadorServicer):
    # Implementación del método remoto "diHola".
    def diHola(self, request, context):
        return holamundo_pb2.HelloReply(message=f"¡Hola {request.name}!")

def ofrece_servicios():
    # Crear un servidor gRPC con un pool de hilos.
    servidor = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    # Registrar el servicio "Saludador" en el servidor.
    holamundo_pb2_grpc.add_SaludadorServicer_to_server(Saludador(), servidor)
    servidor.add_insecure_port("[::]:50051")
    servidor.start()
    print("Servidor escuchando en el puerto 50051")
    servidor.wait_for_termination()

if __name__ == "__main__":
    ofrece_servicios()
```
**Descripción de líneas importantes:**
- `SaludadorServicer`: Clase base generada automáticamente para implementar servicios.
- `add_SaludadorServicer_to_server`: Registra el servicio en el servidor.
- `ThreadPoolExecutor`: Permite manejar múltiples solicitudes concurrentes.

---

## Creación de Archivos `.proto`

### ¿Qué es un Archivo `.proto`?
Un archivo `.proto` es un archivo de definición utilizado por Protocol Buffers (protobuf), el sistema de serialización de datos de Google. Estos archivos definen la estructura de los datos y los servicios que se utilizarán en gRPC.

### Estructura de un Archivo `.proto`
1. **Sintaxis**: Especifica la versión de protobuf.
2. **Mensajes**: Define las estructuras de datos.
3. **Servicios**: Define los métodos remotos para gRPC.

#### Ejemplo de Archivo `.proto`
```proto
syntax = "proto3";

// Definición del paquete para organizar el código generado.
package holamundo;

// Mensaje de solicitud.
message HelloRequest {
    string name = 1; // Campo de tipo string con índice 1.
}

// Mensaje de respuesta.
message HelloReply {
    string message = 1; // Campo de tipo string con índice 1.
}

// Servicio gRPC que define los métodos remotos.
service Saludador {
    // Método remoto que toma un HelloRequest y devuelve un HelloReply.
    rpc diHola (HelloRequest) returns (HelloReply);
}
```

### Descripción de las Secciones
- **`syntax = "proto3";`**: Especifica que se utiliza la versión 3 de protobuf.
- **`package holamundo;`**: Define un espacio de nombres para evitar conflictos.
- **`message`**: Declara una estructura de datos con campos y tipos.
  - `string name = 1;`: Define un campo de tipo `string` con el índice 1.
- **`service`**: Declara un servicio gRPC con métodos remotos.
  - `rpc diHola (HelloRequest) returns (HelloReply);`: Define un método que toma un `HelloRequest` y devuelve un `HelloReply`.

### Generación de Código desde un Archivo `.proto`
1. **Instalar el compilador de protobuf**:
   ```bash
   brew install protobuf # En macOS
   ```
2. **Generar código para Python**:
   ```bash
   python -m grpc_tools.protoc -I=. --python_out=. --grpc_python_out=. holamundo.proto
   ```
   - `-I=.`: Especifica el directorio de entrada.
   - `--python_out=.`: Genera las clases protobuf.
   - `--grpc_python_out=.`: Genera las clases gRPC.

### Buenas Prácticas
- **Nombres descriptivos**: Utiliza nombres claros para mensajes y servicios.
- **Versionado**: Incluye la versión de protobuf para evitar problemas de compatibilidad.
- **Organización**: Agrupa mensajes y servicios relacionados en el mismo archivo.

---

## 2. JMS (Java Message Service)

### ¿Qué es JMS?
JMS es una API de Java para la comunicación asíncrona entre aplicaciones mediante mensajes. Es útil para sistemas distribuidos que requieren desacoplamiento entre componentes.

### Estructura de JMS
1. **Productor de mensajes**: Envía mensajes a una cola o tópico.
2. **Consumidor de mensajes**: Recibe mensajes de una cola o tópico.
3. **Broker**: Middleware que gestiona las colas y tópicos.

## JMS Queues

### ¿Qué son las JMS Queues?
Las JMS Queues son un mecanismo de mensajería en el que los mensajes se envían a una cola y son consumidos por un único receptor. Este modelo se conoce como "punto a punto".

### Estructura de las JMS Queues
1. **Sender (Productor)**: Envía mensajes a una cola.
2. **Receiver (Consumidor)**: Recibe mensajes de una cola.
3. **Broker**: Middleware que gestiona las colas y distribuye los mensajes.

### Ejemplo de Implementación
#### Sender (Productor de Mensajes)
```java
import jakarta.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageSender {
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static String queueName = "JOGG_QUEUE";

    public void produceMessages() {
        try {
            // Crear conexión al broker.
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
            Connection connection = connectionFactory.createConnection();
            connection.start();

            // Crear sesión y cola.
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue queue = session.createQueue(queueName);

            // Crear productor y enviar mensajes.
            MessageProducer producer = session.createProducer(queue);
            TextMessage message = session.createTextMessage("Hola, JMS Queue!");
            producer.send(message);

            System.out.println("Mensaje enviado a la cola: " + message.getText());

            producer.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MessageSender().produceMessages();
    }
}
```
**Descripción:**
- `createQueue`: Crea una cola para enviar mensajes.
- `createProducer`: Crea un productor para enviar mensajes a la cola.
- `send`: Envía el mensaje a la cola.

#### Receiver (Consumidor de Mensajes)
```java
import jakarta.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageReceiver {
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static String queueName = "JOGG_QUEUE";

    public void getMessages() {
        try {
            // Crear conexión al broker.
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
            Connection connection = connectionFactory.createConnection();
            connection.start();

            // Crear sesión y cola.
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue queue = session.createQueue(queueName);

            // Crear consumidor y recibir mensajes.
            MessageConsumer consumer = session.createConsumer(queue);
            TextMessage message = (TextMessage) consumer.receive();

            System.out.println("Mensaje recibido de la cola: " + message.getText());

            consumer.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MessageReceiver().getMessages();
    }
}
```
**Descripción:**
- `createConsumer`: Crea un consumidor para recibir mensajes de la cola.
- `receive`: Bloquea hasta que se recibe un mensaje.

### Funcionamiento
1. **Envío**: El productor envía mensajes a la cola.
2. **Distribución**: El broker almacena los mensajes en la cola hasta que un consumidor los reciba.
3. **Recepción**: El consumidor recibe y procesa los mensajes.

### Casos de Uso
- **Procesamiento de tareas**: Sistemas de trabajo en cola.
- **Comunicación punto a punto**: Envío de mensajes entre dos aplicaciones.


---
## JMS Topics

### ¿Qué son los JMS Topics?
Los JMS Topics son un mecanismo de mensajería en el que los mensajes se publican en un "tópico" y todos los suscriptores interesados reciben una copia del mensaje. Este modelo se conoce como "publicación-suscripción".

### Estructura de los JMS Topics
1. **Publisher (Productor)**: Publica mensajes en un tópico.
2. **Subscriber (Consumidor)**: Se suscribe a un tópico para recibir mensajes.
3. **Broker**: Middleware que gestiona los tópicos y distribuye los mensajes.

### Ejemplo de Implementación
#### Publisher (Productor de Mensajes)
```java
import jakarta.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageSender {
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static String topicName = "JOGG_TOPIC";

    public void produceMessages() {
        try {
            // Crear conexión al broker.
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
            Connection connection = connectionFactory.createConnection();
            connection.start();

            // Crear sesión y tópico.
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Topic topic = session.createTopic(topicName);

            // Crear productor y enviar mensajes.
            MessageProducer producer = session.createProducer(topic);
            TextMessage message = session.createTextMessage("Hola, JMS Topic!");
            producer.send(message);

            System.out.println("Mensaje enviado al tópico: " + message.getText());

            producer.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MessageSender().produceMessages();
    }
}
```
**Descripción:**
- `createTopic`: Crea un tópico para publicar mensajes.
- `createProducer`: Crea un productor para enviar mensajes al tópico.
- `send`: Envía el mensaje al tópico.

#### Subscriber (Consumidor de Mensajes)
```java
import jakarta.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageReceiver {
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static String topicName = "JOGG_TOPIC";

    public void getMessages() {
        try {
            // Crear conexión al broker.
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
            Connection connection = connectionFactory.createConnection();
            connection.start();

            // Crear sesión y tópico.
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Topic topic = session.createTopic(topicName);

            // Crear consumidor y recibir mensajes.
            MessageConsumer consumer = session.createConsumer(topic);
            TextMessage message = (TextMessage) consumer.receive();

            System.out.println("Mensaje recibido del tópico: " + message.getText());

            consumer.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MessageReceiver().getMessages();
    }
}
```
**Descripción:**
- `createConsumer`: Crea un consumidor para recibir mensajes del tópico.
- `receive`: Bloquea hasta que se recibe un mensaje.

### Funcionamiento
1. **Publicación**: El productor envía mensajes al tópico.
2. **Distribución**: El broker distribuye los mensajes a todos los suscriptores activos.
3. **Recepción**: Los consumidores reciben los mensajes en tiempo real.

### Casos de Uso
- **Notificaciones en tiempo real**: Actualizaciones de mercado, alertas de seguridad.
- **Sistemas de publicación-suscripción**: Chats grupales, sistemas de eventos.

---

## 3. Multicast

### ¿Qué es Multicast?
Multicast es un método de comunicación en red donde un mensaje se envía a múltiples receptores simultáneamente. Es útil para aplicaciones como streaming de video o juegos en red.

### Ejemplo de Multicast
#### Envío de Mensajes
```java
import java.net.*;

public class MulticastSender {
    public static void main(String[] args) {
        try {
            MulticastSocket socket = new MulticastSocket();
            InetAddress group = InetAddress.getByName("228.5.6.7");
            String message = "Hola, Multicast!";
            DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(), group, 6789);
            socket.send(packet);
            System.out.println("Mensaje enviado: " + message);
            socket.close(); //socket.leaveGroup{group, netIf} y luego en finally el close
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
**Descripción de líneas importantes:**
- `MulticastSocket`: Crea un socket para enviar mensajes multicast.
- `send`: Envía un paquete de datos al grupo multicast.

#### Recepción de Mensajes
```java
import java.net.*;

public class MulticastReceiver {
    public static void main(String[] args) {
        try {
            MulticastSocket socket = new MulticastSocket(6789);
            InetAddress group = InetAddress.getByName("228.5.6.7");
            socket.joinGroup(group);

            byte[] buffer = new byte[1000];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            String message = new String(packet.getData()).trim();
            System.out.println("Mensaje recibido: " + message);

            socket.leaveGroup(group);
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
**Descripción de líneas importantes:**
- `joinGroup`: Une el socket al grupo multicast.
- `receive`: Bloquea hasta que se recibe un paquete de datos.
---

## 4. Ejercicios de Sockets TCP y UDP

### ¿Qué son los Sockets?
Los sockets son puntos finales para la comunicación entre dos máquinas. TCP es orientado a conexión, mientras que UDP es sin conexión.

### Ejemplo de TCP
#### Cliente TCP
```java
// Clase que implementa un cliente TCP.
public class TCPClient {
    public static void main(String args[]) {
        try (Socket s = new Socket("localhost", 49152)) {
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            out.writeUTF("Hello");
            String data = in.readUTF();
            System.out.println("Received: " + data);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```
**Descripción:**
- `Socket`: Crea una conexión con el servidor.
- `writeUTF`: Envía datos al servidor.
- `readUTF`: Recibe datos del servidor.

#### Servidor TCP
```java
// Clase que implementa un servidor TCP.
public class TCPServer {
    public static void main(String args[]) {
        try (ServerSocket listenSocket = new ServerSocket(49152)) {
            while (true) {
                Socket clientSocket = listenSocket.accept();
                new Connection(clientSocket).start();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

// Clase que maneja la conexión con un cliente.
class Connection extends Thread {
    private Socket clientSocket;

    public Connection(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (DataInputStream in = new DataInputStream(clientSocket.getInputStream());
             DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream())) {
            String data = in.readUTF();
            out.writeUTF(data);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```
**Descripción:**
- `ServerSocket`: Escucha conexiones entrantes.
- `accept`: Acepta una conexión de un cliente.

### Ejemplo de UDP
#### Cliente UDP
```java
// Clase que implementa un cliente UDP.
public class UDPClient {
    public static void main(String args[]) {
        try (DatagramSocket socket = new DatagramSocket()) {
            String message = "Hello";
            byte[] buffer = message.getBytes();
            InetAddress host = InetAddress.getByName("localhost");
            DatagramPacket request = new DatagramPacket(buffer, buffer.length, host, 49152);
            socket.send(request);
            DatagramPacket reply = new DatagramPacket(new byte[1000], 1000);
            socket.receive(reply);
            System.out.println("Reply: " + new String(reply.getData()).trim());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```
**Descripción:**
- `DatagramSocket`: Crea un socket UDP.
- `send`: Envía un paquete al servidor.
- `receive`: Recibe un paquete del servidor.

#### Servidor UDP
```java
// Clase que implementa un servidor UDP.
public class UDPServer {
    public static void main(String args[]) {
        try (DatagramSocket socket = new DatagramSocket(49152)) {
            byte[] buffer = new byte[1000];
            while (true) {
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                socket.receive(request);
                DatagramPacket reply = new DatagramPacket(request.getData(), request.getLength(), request.getAddress(), request.getPort());
                socket.send(reply);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```
**Descripción:**
- `receive`: Bloquea hasta que se recibe un paquete.
- `send`: Envía un paquete de respuesta al cliente.

---

## 5. Ejercicios de Hilos (ThreadsTutorial)

### ¿Qué son los Hilos en Java?
Los hilos permiten la ejecución concurrente de múltiples tareas dentro de un programa. Son útiles para aprovechar los procesadores multinúcleo y realizar tareas en paralelo.

### Estructura de los Ejercicios
1. **HelloRunnable**: Implementa la interfaz `Runnable`.
2. **HelloThread**: Extiende la clase `Thread`.
3. **Counter y SynchronizedThread**: Demuestran sincronización entre hilos.
4. **Main**: Coordina la ejecución de los hilos.

#### HelloRunnable
```java
// Clase que implementa Runnable para crear un hilo.
public class HelloRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(i + " hola desde Hilo Runnable " + Thread.currentThread().getName());
        }
    }
}
```
**Descripción:**
- `run`: Método que define la lógica del hilo.
- `Thread.currentThread().getName()`: Obtiene el nombre del hilo actual.

#### HelloThread
```java
// Clase que extiende Thread para crear un hilo.
public class HelloThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(i + " hola desde Extends " + Thread.currentThread().getName());
        }
    }
}
```
**Descripción:**
- Similar a `HelloRunnable`, pero utiliza herencia.

#### Counter y SynchronizedThread
```java
// Clase que representa un contador compartido entre hilos.
public class Counter {
    private int count = 0;

    public synchronized void increase(String threadId) {
        for (int i = 0; i < 10000; i++) {
            count++;
            System.out.println(count + " soy " + threadId);
        }
    }
}

// Clase que utiliza Counter para demostrar sincronización.
public class SynchronizedThread extends Thread {
    private Counter counter;

    public SynchronizedThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.increase(Thread.currentThread().getName());
    }
}
```
**Descripción:**
- `synchronized`: Asegura que solo un hilo acceda al método `increase` a la vez.

#### Main
```java
// Clase principal que coordina la ejecución de los hilos.
public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Hola desde el principal " + Thread.currentThread().getName());
            HelloThread hilo1 = new HelloThread();
            Thread hilo2 = new Thread(new HelloRunnable());
            hilo1.start();
            hilo2.start();
            hilo1.join();
            hilo2.join();
            System.out.println("Todos terminaron correctamente");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
```
**Descripción:**
- `start`: Inicia la ejecución de un hilo.
- `join`: Espera a que un hilo termine antes de continuar.

---
## 6. Proyecto Alpha

### Descripción General
El Proyecto Alpha es un juego distribuido donde múltiples jugadores interactúan con un servidor central para registrar golpes y competir por puntos. Utiliza TCP para la comunicación y JMS para la coordinación de eventos.

### Componentes Principales
1. **ServidorMonstruos**: Coordina el juego y publica eventos.
2. **JugadorMonstruo**: Representa a un jugador que interactúa con el servidor.
3. **Escuchadores**: Manejan conexiones TCP para logins y golpes.
4. **Estresador**: Realiza pruebas de carga al servidor.

### Ejemplo: ServidorMonstruos
```java
import java.io.*;
import java.net.*;
import java.util.concurrent.*;

/**
 * Clase principal que implementa el servidor del juego.
 * Escucha conexiones de múltiples jugadores y delega el manejo a hilos.
 */
public class ServidorMonstruos {
    private static final int PORT = 12345; // Puerto donde el servidor escucha conexiones

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(10); // Pool de hilos para manejar clientes
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("ServidorMonstruos escuchando en el puerto " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept(); // Acepta nuevas conexiones
                pool.execute(new ClientHandler(clientSocket)); // Maneja cada cliente en un hilo separado
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 * Clase que maneja la comunicación con un cliente.
 */
class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
            String input;
            while ((input = in.readLine()) != null) { // Lee mensajes del cliente
                System.out.println("Recibido: " + input);
                out.println("Procesado: " + input); // Responde al cliente
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
**Resumen de funciones:**
- `main`: Inicia el servidor y maneja múltiples clientes concurrentemente.
- `ClientHandler`: Procesa mensajes de un cliente específico.

### Ejemplo: JugadorMonstruo
```java
import java.io.*;
import java.net.*;

/**
 * Clase que representa a un jugador en el juego.
 * Se conecta al servidor y envía mensajes.
 */
public class JugadorMonstruo {
    private static final String HOST = "localhost"; // Dirección del servidor
    private static final int PORT = 12345; // Puerto del servidor

    /**
     * Método principal que inicia la conexión con el servidor.
     * Envía un mensaje y recibe la respuesta.
     */
    public static void main(String[] args) {
        try (Socket socket = new Socket(HOST, PORT); // Crea un socket para conectarse al servidor
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Lee datos del servidor
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) { // Envía datos al servidor

            out.println("Golpe al monstruo"); // Envía un mensaje al servidor
            String response = in.readLine(); // Lee la respuesta del servidor
            System.out.println("Respuesta del servidor: " + response); // Imprime la respuesta recibida

        } catch (IOException e) {
            e.printStackTrace(); // Maneja errores de entrada/salida
        }
    }
}
```
**Resumen de funciones:**
- `main`: Punto de entrada del cliente interactivo. Inicia el cliente en el hilo de UI de Swing.
- `start`: Coordina la inicialización completa del cliente, incluyendo login, conexión y construcción de la interfaz.
- `askPlayerName`: Solicita el nombre del jugador mediante un cuadro de diálogo.
- `showScaledMessageDialog`: Muestra mensajes de error o aviso con una interfaz escalada.
- `doLogin`: Realiza el login TCP enviando el nombre del jugador al servidor.
- `buildUI`: Construye la ventana principal y el tablero de juego 3x3.
- `connectHitChannel`: Abre un socket persistente para enviar golpes al servidor.
- `startTopicConsumer`: Se suscribe al tópico JMS para recibir eventos del juego.
- `sendHit`: Envía un golpe al servidor utilizando el canal TCP persistente.
- `closeHitChannel`: Cierra los streams y el socket del canal de golpes para liberar recursos.
- `handleTopicMessage`: Interpreta mensajes del tópico JMS y actualiza la interfaz del cliente.
- `showMonster`: Muestra un monstruo en una casilla específica y activa un temporizador.
- `showWinner`: Muestra al ganador de la ronda y prepara la interfaz para el siguiente juego.
- `clearBoard`: Limpia el tablero y resetea el estado visual.
- `GameMessageListener`: Clase interna que escucha mensajes JMS y los delega al hilo de Swing para su procesamiento.

---

## 7. JMS Queues: The Potato Game

### Descripción General
The Potato Game es un ejemplo de sistema distribuido basado en colas JMS. En este juego, los jugadores pasan un "potato" (objeto) entre ellos a través de colas de mensajes. El objetivo es evitar que el "potato" se "caiga" (es decir, que su tiempo restante llegue a cero) mientras se pasa entre los jugadores.

### Componentes Principales
1. **Deployer**: Clase principal que inicializa y arranca los jugadores.
2. **Player**: Representa a un jugador que envía y recibe "potatoes" a través de colas JMS.
3. **Potato**: Clase que modela el objeto "potato" con un tiempo restante antes de "caer".

### Ejemplo: Deployer
```java
package mx.itam.packages.jmsqueuesthepotatogame;

/**
 * Clase principal que inicializa y arranca los jugadores.
 */
public class Deployer {

    public static void main(String[] args) {
        // Crea dos jugadores con colas de entrada y salida.
        Player player1 = new Player("queue1", "queue2", "potatoA");
        Player player2 = new Player("queue2", "queue1", "potatoB");

        // Inicia los jugadores en hilos separados.
        player1.start();
        player2.start();
    }
}
```
**Resumen de funciones:**
- `main`: Inicializa dos jugadores con colas de entrada y salida y los arranca en hilos separados.

### Ejemplo: Player
```java
package mx.itam.packages.jmsqueuesthepotatogame;

/**
 * Clase que representa a un jugador en el juego.
 * Envía y recibe "potatoes" a través de colas JMS.
 */
public class Player extends Thread {

    private String inputQueue;
    private String outputQueue;
    private String potatoId;

    public Player(String inputQueue, String outputQueue, String potatoId) {
        this.inputQueue = inputQueue;
        this.outputQueue = outputQueue;
        this.potatoId = potatoId;
    }

    @Override
    public void run() {
        // Configura las conexiones JMS y las colas.
        // Envía y recibe "potatoes" hasta que uno "caiga".
    }
}
```
**Resumen de funciones:**
- `Player(String inputQueue, String outputQueue, String potatoId)`: Constructor que inicializa las colas de entrada y salida y el ID del "potato".
- `run`: Configura las conexiones JMS, envía y recibe "potatoes" hasta que uno "caiga".

### Ejemplo: Potato
```java
package mx.itam.packages.jmsqueuesthepotatogame;

/**
 * Clase que modela el objeto "potato".
 */
public class Potato implements Serializable {

    private String id;
    private int remainingTime;

    public Potato(String id, int remainingTime) {
        this.id = id;
        this.remainingTime = remainingTime;
    }

    public String getId() {
        return id;
    }

    public void decreaseRemainingTime() {
        remainingTime--;
    }

    public boolean isDropped() {
        return remainingTime == 0;
    }
}
```
**Resumen de funciones:**
- `Potato(String id, int remainingTime)`: Constructor que inicializa el ID y el tiempo restante del "potato".
- `getId`: Devuelve el ID del "potato".
- `decreaseRemainingTime`: Disminuye el tiempo restante del "potato".
- `isDropped`: Devuelve `true` si el tiempo restante es cero.

---

## 8. JMS Topics: Financial System

### Descripción General
El sistema financiero basado en JMS Topics es un ejemplo de sistema distribuido donde los "Floor Brokers" reciben noticias financieras categorizadas en diferentes tópicos. Estas noticias son generadas por un "Information Provider" y distribuidas a través de tópicos JMS. Los brokers reaccionan a las noticias dependiendo de su severidad.

### Componentes Principales
1. **Deployer**: Clase principal que inicializa y arranca los brokers.
2. **FloorBroker**: Representa a un broker que escucha noticias de un tópico específico.
3. **InformationProvider**: Genera y publica noticias financieras en diferentes tópicos.

### Ejemplo: Deployer
```java
package mx.itam.packages.jmstopicsfinancialsystem;

/**
 * Clase principal que inicializa y arranca los brokers.
 */
public class Deployer {

    public static void main(String[] args) {
        int floorBrokers = 5; // Número de brokers a inicializar
        for (int i = 0; i < floorBrokers; i++) {
            new FloorBroker().start(); // Inicia cada broker en un hilo separado
        }
    }
}
```
**Resumen de funciones:**
- `main`: Inicializa múltiples brokers y los arranca en hilos separados.

### Ejemplo: FloorBroker
```java
package mx.itam.packages.jmstopicsfinancialsystem;

/**
 * Clase que representa a un broker financiero.
 * Escucha noticias de un tópico específico y reacciona según su severidad.
 */
public class FloorBroker extends Thread {

    @Override
    public void run() {
        // Configura la conexión JMS y escucha noticias del tópico asignado.
        // Reacciona a las noticias dependiendo de su severidad.
    }
}
```
**Resumen de funciones:**
- `run`: Configura la conexión JMS, escucha noticias del tópico asignado y reacciona a las noticias dependiendo de su severidad.

### Ejemplo: InformationProvider
```java
package mx.itam.packages.jmstopicsfinancialsystem;

/**
 * Clase que genera y publica noticias financieras en diferentes tópicos.
 */
public class InformationProvider {

    public void produceNews() {
        // Genera noticias financieras y las publica en tópicos JMS.
        // Notifica el final de la sesión financiera.
    }

    public static void main(String[] args) {
        new InformationProvider().produceNews(); // Inicia la generación de noticias
    }
}
```
**Resumen de funciones:**
- `produceNews`: Genera noticias financieras, las publica en tópicos JMS y notifica el final de la sesión financiera.
- `main`: Punto de entrada para iniciar la generación de noticias.

---
