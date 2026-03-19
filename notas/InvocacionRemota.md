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
