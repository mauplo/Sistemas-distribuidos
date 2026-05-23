**Clave única:** ______________________ **Nombre:** _______________________________________

**(0.5 puntos)** Una empresa te contrata para integrar el registro de ventas de sus dos sucursales. Debido a una planeación inadecuada del departamento de TI de la empresa, una sucursal, la TIENDA 1, registra sus ventas mediante un servicio web SOAP; y la otra sucursal, la TIENDA 2, registra sus ventas con un servicio web RESTful.

Tu trabajo consiste en integrar (y reutilizar) los servicios en una sola aplicación Web. Con esto se busca que las sucursales tengan una URL única parametrizada para poder capturar sus ventas.

Dado que la empresa mencionada es ficticia, parte de tu trabajo es:

**a. Implementar y desplegar un servicio web SOAP**
Este servicio debe tener un método para registrar la venta de la TIENDA 1. Cuando este método sea llamado tiene que imprimir un mensaje de éxito en la consola de su servidor.

**b. Implementar y desplegar un servicio web REST**
Este servicio debe tener un método para registrar la venta de la TIENDA 2. Cuando este método sea llamado tiene que imprimir un mensaje de éxito en la consola de su servidor.

**c. Implementar una aplicación web en DJANGO** para que con una URL única parametrizada, ambas sucursales puedan capturar sus ventas. La vista de DJANGO debe llamar a los servicios web correspondientes (ya sea SOAP o REST dependiendo la tienda) e imprimir un mensaje de **Venta registrada** como se muestra en la Figura 1.

---

*(Descripción del esquema conceptual de la Figura 1)*

**TIENDA 1** Registra venta de $10,000.45 usando un navegador Web
`127.0.0.1:8000/integracion/1/10000.45/recibe_ventas/`

*(Diagrama central que muestra tiendas registrando ventas hacia una Aplicación WEB DJANGO (WWW) que responde "Venta registrada". A su vez, la aplicación web se comunica con un "Servicio Web SOAP" si es la TIENDA 1, o con un "Servicio Web REST" si es la TIENDA 2).*

**TIENDA 2** Registra venta de $20,000.75 usando un navegador Web
`127.0.0.1:8000/integracion/2/20000.75/recibe_ventas/`

*(Desglose de la estructura de la URL paramétrica):*

* `[Nombre aplicación]` = integracion
* `[Tienda ID]` = 1 o 2
* `[Monto de Venta]` = 10000.45 o 20000.75
* `[Nombre de la vista]` = recibe_ventas

**Fig. 1. Interacción entre los elementos del sistema integrado.**
