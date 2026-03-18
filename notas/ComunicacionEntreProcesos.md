# Notas de Curso: Introducción a Sistemas Distribuidos

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
