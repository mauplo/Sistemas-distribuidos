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
            socket.close();
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

### Ejemplo: Escuchador de Golpes
```java
public class EscuchadorGolpes extends Thread {
    @Override
    public void run() {
        // Lógica para aceptar conexiones y procesar golpes.
    }
}
```

