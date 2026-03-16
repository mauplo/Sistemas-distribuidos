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
