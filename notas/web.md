## Página 1: Portada
* **Materia:** Programación Web.
*  **Profesor:** Dr. J. Octavio Gutiérrez García.
*  **Contacto:** octavio.gutierrez@itam.mx.
*(Descripción visual: La página incluye logotipos representativos de tecnologías web como HTML5, JavaScript, Flask y Django, además de un diagrama de nodos conectados)*.

## Página 2: Estructura Básica HTML
* Etiquetas HTML.
* Estructura básica de "Mi primer página web":
```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> HTML Mi primer página web </title>
</head>
<body>
...
</body>
</html>
```
*Código derivado de las líneas*. *(Descripción visual: Icono de un archivo con el símbolo de HTML)*.

## Página 3: Etiquetas de Texto HTML
* Etiquetas HTML.
* Párrafo: `<p> </p>`.
* Encabezados: `<h1></h1> ... <h6></h6>`.
* Contenedores genéricos en línea: `<span> </span>`.
* Contenedores genéricos en bloque: `<div> </div>`.
* Saltos de línea y líneas horizontales: `<br> <hr>`.

## Página 4: Tablas HTML
* Etiquetas HTML.
* Estructura para crear una tabla con encabezados y filas:
```html
<table>
  <tr>
    <th>Nombre</th>
    <th>Edad</th>
  </tr>
  <tr>
    <td>Jose</td>
    <td>55</td>
  </tr>
  <tr>
    <td>Luis</td>
    <td>48</td>
  </tr>
</table>
```
*(Descripción visual: Se muestra una cuadrícula genérica representando una tabla con columnas y filas)*.

## Página 5: Listas HTML
* Etiquetas HTML.
* **Listas Ordenadas (Ordered List):** Utilizan la etiqueta `<ol>` y enumeran los elementos (1, 2, 3...).
* **Listas Desordenadas (Unordered List):** Utilizan la etiqueta `<ul>` y marcan los elementos con viñetas.

```html
<ol>
  <li>Elemento A</li>
  <li>Elemento B</li>
  <li>Elemento C</li>
</ol>

<ul>
  <li>Elemento A</li>
  <li>Elemento B</li>
  <li>Elemento C</li>
</ul>
```

## Página 6: Enlaces e Imágenes
* Etiquetas HTML.
* **Vínculos (Enlaces):** 
* Abre en nueva pestaña: `<a href="https://www.google.com" target="_blank">Vinculo</a>`
* Abre en la misma pestaña: `<a href="https://www.google.com" target="_self">Vinculo</a>`
* **Vínculo a correo electrónico:** `<a href="mailto:ejemplo@email.com">Correo</a>`.
* **Imágenes:** `<img src="imagenes/perfil.jpg" alt="foto" height="200">`.
*(Descripción visual: Se muestra la silueta de un perfil de usuario anónimo)*.

## Página 7: Formularios HTML (Parte 1)

* Etiquetas HTML.
* Formulario básico para enviar datos mediante el método GET:
```html
<form action="otra.html" method="get">
  </form>

```
*(Descripción visual: Ejemplo de un diseño de interfaz de formulario con campos para nombre, sitio web, mensaje y correo)*.

## Página 8: Elementos de Entrada (Inputs)
* Etiquetas HTML.
* **Campo de texto corto:** 
```html
<label for="nombre">Ingresa tu nombre:</label><br>
<input type="text" id="nombre" name="nombre"><br>
```
* **Botones de opción (Radio):** Permiten seleccionar solo una opción.
```html
<input type="radio" id="tipo" name="tipo" value="tipo">
<label for="tipo"> Tipo 1 </label>
```
* **Menú desplegable (Select):**.
```html
<label for="tipo">Selecciona un tipo</label>
<select id="tipo" name="tipo">
  <option value="opcion 1" selected>Opcion 2</option>
</select>
```
* **Casilla de verificación (Checkbox):**.
```html
<input type="checkbox" id="opcion" name="opcion" checked><br>
<label for="opcion">Esta una opción </label>
```
* **Área de texto largo (Textarea):**.
```html
<label for="texto_largo">Escribe algo:</label>
<textarea name="texto_largo" id="texto_largo" rows="10" cols="30">
Este es un mensaje largo
</textarea><br>
```

## Página 9: Botones de Formulario

* Etiquetas HTML.
* **Enviar datos:** `<input type="submit" value="Enviar">`.
* **Restablecer formulario:** `<input type="reset" value="Borrar">`.
* **Botón genérico:** `<input type="button" value="Genérico">`.
*(Descripción visual: Tres botones con diseño redondeado en diferentes colores)*.

## Página 10: DOM (Document Object Model)

* **Haciendo referencia a elementos de HTML:**.
* **DOM (Document Object Model):** Es un estándar oficial de la W3C para acceder a elementos HTML.
* Ejemplos de métodos de acceso y modificación:
* `document.write()`.
* `document.getElementById("id")`.
* `document.getElementById("id").innerHTML`.
*(Descripción visual: Logotipo oficial del World Wide Web Consortium - W3C)*.

## Página 11: Introducción a JavaScript

* JS JavaScript.
* Lenguaje script de la WEB, interpretado en tiempo de ejecución (en lugar de ser compilado).
* Utilizado del lado del cliente.
* Se puede insertar en páginas HTML.
* Compatible con múltiples navegadores.
*(Descripción visual: Icono de JavaScript y logotipos de varios navegadores web populares como Chrome, Firefox, Safari y Edge)*.

## Página 12: Insertando JavaScript en HTML

* Introduciendo JavaScript en documentos HTML.
* Se pueden insertar scripts en las etiquetas `<body>` o `<head>`.

```html
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
<h1>Hello World!</h1>
<script>
  document.write("<p>This is my first line using JavaScript</p>");
</script>
</body>
</html>

```

*Código derivado de las líneas*.

## Página 13: Parámetros URL en JavaScript

* Introduciendo JavaScript en documentos HTML para capturar datos de la URL.
```javascript
const all_parameters = window.location.search;
document.write("Estos son los parametros:" + all_parameters);

const urlParams = new URLSearchParams(all_parameters);
const nombre = urlParams.get("nombre");
console.log(nombre);

document.write("Este el nombre:" + nombre);

```
*Código derivado de las líneas*.

## Página 14: Estructuras de Control

* Conceptos fundamentales en JavaScript:
* Operadores.
* Estructuras de control.
* Condiciones.
* Ciclos.
*(Descripción visual: Fotografía de un conejo y un gatito juntos, posiblemente utilizada como decoración por el profesor)*.

## Página 15: Alcance (Scope) de las Variables

* **Scope en Javascript:**.
* Variable `global`.
* `var variable` -> Alcance de función (function scope).
* `let variable` -> Alcance de bloque (block scope).

## Página 16: Variables y Arreglos

* **Tipos dinámicos:** La misma variable puede almacenar diferentes tipos de datos.
* `var x;` // Ahora x no está definida.
* `x = 5;` // Ahora x es un número.
* `x = "Juan";` // Ahora x es una String.
* **Constantes y variables:**.
* `const pi = 3.14;`.
* `person = "Juan Perez";`.
* `var person = "Juan Perez";`.
* `let person = "Juan Perez";`.
* **Arrays (Arreglos):** Diferentes formas de declararlos e inicializarlos.
* `var cars = new Array(); cars[0]="Saab"; cars[1]="Volvo"; cars[2]="BMW";`.
* `var cars = new Array("Saab", "Volvo", "BMW");`.
* `var cars = ["Saab", "Volvo", "BMW"];`.

## Página 17: Funciones

* Normalmente las funciones se agregan en el `<head>`, al final del documento `<body>`, o en un archivo `.js` separado (cuando son muchas).
```javascript
// Ejemplo de función en un script
function changeText(elementId) {
  var element = document.getElementById(elementId);
  element.innerHTML = "12345678910";
}

// Ejemplo de retorno básico
function myFunction() {
  var x = 5;
  return x;
}

```
*Código derivado de las líneas*.

* Ejemplo de llamada a la función desde un botón HTML:
`<input type="button" value="change" onclick="changeText('one');" [cite_start]/>`.

## Página 18: Archivos Externos de JavaScript

* Cómo vincular archivos `.js` externos.

```html
<html>
<body>
  <script src="myjavascriptfile.js"></script> 
  <script src="myjavascriptfile.js" defer></script>  
  <script src="myjavascriptfile.js" async></script>
</body>
</html>

```
*Código derivado de las líneas*.

## Página 19: Orden de Ejecución de Scripts

* **`<script>` (Carga normal):** Interrumpe la descarga y parseo de HTML. Ejecuta la descarga del script y luego la ejecución del script inmediatamente.
* **`<script async>` (Carga asíncrona):** El script se descarga en paralelo con el parseo del HTML, y el HTML se detiene solo en el momento en que el script está listo para ser ejecutado.
* **`<script defer>` (Carga diferida):** El script se descarga en paralelo, pero su ejecución se retrasa hasta que todo el HTML ha sido analizado por completo.
  
## Página 20: Eventos

* Reaccionando a eventos manipulando los atributos de los elementos del DOM.

```html
<img id="myimage" onclick="changeImage()" src="IMAGES/down.jpg">

```
*Código derivado de la línea*.
```javascript
// Lógica de la función en JS
function changeImage() {
  var element = document.getElementById("myimage");
  if (element.src.match("down")) {
    element.src = "IMAGES/up.jpg";
  } else {
    element.src = "IMAGES/down.jpg";
  }
}

```
*Código derivado de las líneas*.
*(Descripción visual: Ilustración en pixel art de Mario Bros saltando)*.

## Página 21: JSON: Objetos en JavaScript

* **Título:** JSON: Objetos en JavaScript.

* *(Descripción visual: Aparece la fotografía de una máscara de hockey idéntica a la del personaje Jason Voorhees, en clara referencia y juego de palabras con "JSON")*.

* **Ejemplo de código HTML y JavaScript:** 

```html
<p>
  Name: <span id = "aName"> </span> <br/>
  Year: <span id = "aYear"> </span> <br/>
</p>

<script>
  var anObject= {
    name:"Smith",
    year:1984
  };
  
  anObject.name;
  anObject["name"];
  
  document.getElementById("aName").innerHTML = anObject.name;
  document.getElementById("aYear").innerHTML = anObject.year;
  
  var person = new Object();
  person.firstName = "Juan";
  person.age = 50;
  
  document.write(person.firstName + " is " + person.age + " years old.");
</script>

```

## Página 22: JSON: Objetos en JavaScript (Continuación)

* **Título:** JSON: Objetos en JavaScript.
* *(Descripción visual: Se repite la misma imagen de la máscara de hockey)*.
* **Ejemplo de código JavaScript agregando métodos:** 

```javascript
<script>
  var person = new Object();
  person.firstName = "Juan";
  person.age = 50;
  
  person.aMethod = function(x){
    person.age = person.age + x;
  }
  
  person.aMethod(3);
  
  document.write(person.firstName + " is " + person.age + " years old.");
</script>

```

## Página 23: Excepciones en JavaScript

* **Título:** Excepciones en JavaScript.
* *(Descripción visual: Un emoticón amarillo tapándose la boca con la mano en señal de error, con la palabra "OOPS" en letras verdes)*.
* **Ejemplo de validación con Try-Catch:** 
```html
<script>
  function myFunction() {
    var y = document.getElementById("mess");
    y.innerHTML="";
    try {
      var x= document.getElementById("demo").value;
      if (x==="") throw "empty";
      if (isNaN(x)) throw "not a number";
      if (x>10) throw "too high";
      if (x<5) throw "too low";
    } catch(err) {
      y.innerHTML="Error: " + err + ".";
    }
  }
</script>

<p>Please input a number between 5 and 10:</p>
<input id="demo" type="text">
<button type="button" onclick="myFunction()">Test Input</button>
<p id="mess"></p>

```
## Página 24: Añadiendo eventos: Ejemplo 1

* **Título:** Añadiendo eventos: Ejemplo I.
* **Ejemplo de código de manipulación de texto en un clic:** 
```html
<script>
  function increaseText(id){
    document.getElementById(id).innerHTML=
    document.getElementById(id).innerHTML.charAt(0)+
    document.getElementById(id).innerHTML;
  }
</script>

<h1 id="anyld1" onclick="increaseText('anyld1')">Click on this text!</h1>
<h1 id="anyld2" onclick="increaseText('anyld2')">Click on this text!</h1>
```

## Página 25: Añadiendo eventos: Ejemplo 2

* **Título:** Añadiendo eventos: Ejemplo 2.
* *(Descripción visual: Se muestran diversas secuencias de letras del abecedario en minúsculas y mayúsculas esparcidas por la diapositiva: abc ABC def DEF ghi GHI jkl JKL mno MNO pqr PQR stu STU VWX VWX yz YZ)*.

* **Ejemplo de evento onchange para pasar a mayúsculas:** 
```html
<script>
  function upperCase(id){
    var text=document.getElementById(id);
    text.value=text.value.toUpperCase();
  }
</script>

<input type="text" id="anyld3" onchange="upperCase('anyld3');">

```

## Página 26: Añadiendo eventos: Ejemplo 3

* **Título:** Añadiendo eventos: Ejemplo 3.
* *(Descripción visual: Un dibujo clipart de un ratón gris de computadora/animal visto desde arriba)*.
* **Ejemplo de eventos onmouseover y onmouseout:** 
```html
<script>
  function eventMouseOver (obj) {
    obj.innerHTML="Thank You";
  }
  function eventMouseOut(obj){
    obj.innerHTML="Mouse Over Me";
  }
</script>

<div onmouseover="eventMouseOver(this)" onmouseout="eventMouseOut(this)">
  Mouse Over Me
</div>

```

## Página 27: Validación de Formularios

* **Título:** Validación de Formularios.
* *(Descripción visual: Dibujo de un lápiz naranja como un cohete dibujando una gráfica ascendente)*.
* **Ejemplo de validación en el evento onsubmit:** 
```html
<script>
  function validateForm(){
    var x= document.forms["myForm"]["fname"].value;
    if ( x== null || x=="" ) {
      alert("First name must be filled out");
      return false;
    }
    return true;
  }
</script>

<form name="myForm" action="nextpage.html" onsubmit="return validateForm()" method="get">
  First name: <input type="text" name="fname"> <br />
  <input type="submit" value="Submit">
</form>

```

## Página 28: Temporización

* **Título:** Temporización.
* **setTimeout:** `setTimeout(función, tiempo)`.
* Dispara la función una sola vez.
* `clearTimeout()` borra el evento.
* JavaScript Clock.
* **setInterval:** `setInterval(función, tiempo)`.
* Dispara la función repetidamente.
* `clearInterval()` borra el evento.

## Página 29: Eventos de la "ventana"
* **Título:** Eventos de la "ventana".
* *(Descripción visual: Una ventana de marco blanco abierta que deja ver un cielo azul con nubes)*.
* **Lista de eventos:**
* `onpagehide`.
* `onafterprint`.
* `onbeforeprint`.
* `onpageshow`.
* `onbeforeunload`.
* `onerror`.
* `onhaschange`.
* `onload`.
* `onmessage`.
* `onoffline`.
* `ononline`.
* `onpopstate`.
* `onredo`.
* `onresize`.
* `onstorage`.
* `onundo`.
* `onunload`.
  
## Página 30: Eventos de "Form"
* **Título:** Eventos de "Form".
* *(Descripción visual: Una ilustración de múltiples formularios y hojas de papel apiladas de varios colores)*.
* **Lista de eventos:**
* `onblur`.
* `onchange`.
* `oncontextmenu`.
* `onfocus`.
* `onformchange`.
* `onforminput`.
* `oninput`.
* `oninvalid`.
* `onreset`.
* `onselect`.
* `onsubmit`.

## Página 31: Eventos del teclado
* **Título:** Eventos del teclado.
* *(Descripción visual: Fotografía lateral de un teclado plano ultramoderno donde las teclas son pantallas táctiles iluminadas. Se aprecian las letras S, E, 1234567890, QWERTYUIOPIJ, ASDFGHJKL en el diseño)*.
* **Lista de eventos:**
* `onkeydown`.
* `onkeypress`.
* `onkeyup`.

## Página 32: Eventos del mouse

* **Título:** Eventos del mouse.
* *(Descripción visual: Fotografía lateral de un ratón de computadora estilo gamer, negro con detalles metálicos plateados y textura tipo panal en los costados)*.
* **Lista de eventos:**
* `onclick`.
* `ondrop`.
* `ondblclick`.
* `onmousedown`.
* `ondrag`.
* `onmousemove`.
* `ondragend`.
* `onmouseout`.
* `ondragenter`.
* `onmouseover`.
* `ondragleave`.
* `onmouseup`.
* `ondragover`.
* `ondragstart`.
* `onmousewheel`.
* `onscroll`.

## Página 33: Browser Object Model - BOM
* **Título:** Browser Object Model - BOM.
* *(Descripción visual: Ilustración cómica de una batalla entre los íconos de los navegadores web: Google Chrome cayendo en picada, Mozilla Firefox atacando con una espada a Internet Explorer, quien se defiende con un escudo. Todo ocurre sobre el marco de una computadora)*.

* Objeto `window`. Ejemplos: 
* `window.innerHeight`.
* `window.moveTo()`.
* `window.resizeTo()`.
* Objeto `screen`. Ejemplos: 
* `screen.pixelDepth`.
* Objeto `history`. Ejemplos: 
* `history.back()`.
* `history.forward()`.

## Página 34: Browser Object Model - BOM (Continuación)
* **Título:** Browser Object Model - BOM.
* *(Descripción visual: Misma ilustración cómica de los navegadores web peleando)*.
* Objeto `navigator`. Ejemplos: 
* `navigator.cookieEnabled`.
* `navigator.systemLanguage`.
* Mensajes. Ejemplos: 
* `alert`.
* `prompt`.
* `confirm`.

## Página 35: Práctica de laboratorio
* **Título:** Práctica de laboratorio.
* **Subtítulo:** Sistema de Cotización de Seguros de Auto.
* **Sección:** Datos personales.
* *(Descripción visual: Un recuadro gris que enlista en texto "Eventos: onchange, onkeypress, onkeydown, onkeyup")*.
* **Tabla de formulario (ejemplo):** 
* **Nombre:** Jose.
* **Apellidos:** Octavio.
* **Género:** Masculino / Femenino.
* **Edad:** 55.
* **Estado:** Aguascalientes.
* Botones: Limpiar, Enviar.

* **Instrucciones adicionales:**
* Utiliza un archivo .js.
* Eventos: `onchange`, `onkeypress`, `onkeydown`, `onkeyup`.
* Texto esperado en interfaz: Gracias Sr. Jose Octavio por el interés en nuestros seguros.
* Estructura sugerida: `If () { } else { }`.

## Página 36: Práctica de laboratorio: request-reply
* **Título:** Práctica de laboratorio: request-reply.
* *(Descripción visual: Una fotografía de una mano humana sosteniendo un modelo de automóvil a escala (un Ford Mustang plateado con franjas azules))*.
* **Instrucciones:**
* Extrae parámetros con:
`const params= window.location.search; const urlParams = new URLSearchParams(params); const a_param = urlParams.get("aParam");`.
* Guarda parámetros con `<input type="hidden" ...`.

* **Ejemplo visual de la interfaz del navegador:**
* Datos de Auto - Mozilla Firefox.
* Localhost: `localhost:8084/Wek`.
* **Título en página:** Sistema de Cotización de Seguros de Auto.
* **Datos personales:** Estimado Sr. Octavio Gutierrez. Género: masculino. Edad: Desconocida. Estado: Jalisco.
* **Datos del auto:** 
* Marca: Chevrolet.
* Modelo: 2008.
* Placas: 122-HGZ.
* Botones: Limpiar, Enviar.

## Página 37: Práctica de laboratorio (Continuación)
* **Título:** Práctica de laboratorio.
* **Funciones útiles:** `Num.toString()`, `parseInt(texto)`, `parseFloat(texto)`.
* **Ejemplos de las respuestas generadas en la página (Cotización):**
* **Ejemplo 1:** Cotización de seguro para Automóvil. Estimado Sr(a): Octavio Gutierrez. En función a los datos proporcionados: Género: masculino. Edad: Desconocida. Estado: Jalisco. Marca: Chevrolet. Modelo: 2008. Placas: 122-HGZ. La cotización de su seguro es: $7,800.00 pesos.
* **Ejemplo 2:** Cotización de seguro para Automóvil. Estimado Sr(a) Octavio Gutierrez. En función a los datos proporcionados: Género: masculino. Edad: Desconocida. Estado: Jalisco. Marca: Chevrolet. Modelo: 1999. Placas: 122-HGZ. La cotización de su seguro es: $4,200.00 pesos.

## Página 38: Portada Transición
* **Institución:** ITAM.
* **Materia:** Servicios Web.
* *(Descripción visual: Las letras "WEB" en azul brillante y en 3D, rodeadas por herramientas mecánicas, tornillos y tuercas metálicas, ilustrando la "construcción" web)*.
* **Profesor:** Dr. J. Octavio Gutiérrez García.
* **Contacto:** octavio.gutierrez@itam.mx.

## Página 39: Problemas de aplicaciones Web
* **Título:** Problemas de aplicaciones Web.
* *(Descripción visual: Un dibujo hecho con una línea negra gruesa que simula un garabato o un nudo enredado)*.
* **Conceptos:**
* Diversas tecnologías: 
* Applets, 
* CGI (Common Gateway Interface), 
* Lenguajes de Scripts, 
* COM (Component object model), etc. 
* Desarrollos muy ad-hoc.

## Página 40: Servicios Web (Introducción)
* **Título:** Servicios Web.
* *(Descripción visual: Tres pequeñas ilustraciones apiladas verticalmente. 1. Un foco brillante amarillo (Idea). 2. Un globo terráqueo conectado a múltiples computadoras y usuarios (Red). 3. Un personaje 3D blanco sosteniendo una diana roja con flechas clavadas en el centro (Objetivo))*.
* **Puntos principales:**
* **Idea:** Adaptar el modelo de programación web (débilmente acoplado) para su uso en aplicaciones no basadas en navegador.
* **Objetivo:** ofrecer una plataforma para construir aplicaciones distribuidas utilizando un software que enmascare la heterogeneidad.


## Página 41: Servicios Web RESTful
* **Título:** Servicios Web RESTful.
* REST significa REpresentational State Transfer.
* No es un estándar.
* Usa métodos de HTTP.
* Cada operación en un servicio web RESTful es identificada por un URL único.
* Eso los hace más rápidos que los servicios web SOAP.
*(Descripción visual: Caricatura de un hombre descansando en una hamaca atada entre dos árboles)*.

## Página 42: Métodos HTTP
* **Título:** Métodos HTTP.
* **GET** : Solicita datos al servidor.
* **POST** : Envía datos al servidor para crear un recurso.
* **PUT** : Reemplaza completamente un recurso.
* **DELETE** : Borra un recurso.
* *(Descripción visual: Ilustración de múltiples flechas de diferentes colores entrelazadas apuntando a diversas direcciones)*.

## Página 43: Métodos HTTP (Continuación)
* **Título:** Métodos HTTP.
* **CONNECT** : Establece conexión con el servidor.
* **HEAD** : Igual a GET pero sin cuerpo.
* **TRACE** : El servidor devuelve exactamente la misma solicitud que recibió.
* **PATCH** : Modifica parcialmente un recurso existente.
* **OPTIONS** : Devuelve los métodos HTTP soportados por el servidor.

## Página 44: Códigos de Status HTTP
| Categoría | Códigos |
| :--- | :--- |
| **1XX**<br>INFORMATIONAL | 100 Continue<br>101 Switching Protocols |
| **2XX**<br>SUCCESS | 200 OK<br>201 Created<br>204 No Content |
| **3XX**<br>REDIRECTION | 301 Moved Permanently<br>302 Found |
| **4XX**<br>CLIENT ERROR | 400 Bad Request<br>401 Unauthorized<br>403 Forbidden<br>404 Not Found<br>429 Too Many Requests |
| **5XX**<br>SERVER ERROR | 500 Internal Server Error<br>503 Service Unavailable<br>504 Gateway Timeout |

* Enlace de referencia: [https://developer.mozilla.org/es/docs/Web/HTTP/Status](https://developer.mozilla.org/es/docs/Web/HTTP/Status).

## Página 45: Servicios Web RESTful (Comparación)

* **Título:** Servicios Web RESTful.
* Mensajes en servicios web RESTful no requieren ser empaquetados en "sobres", como es el caso de servicios web SOAP.
* Servicios web SOAP regresan datos en XML.
* Servicios web RESTful regresan datos en XML, JSON, HTML y texto plano.
* (Descripción visual: Un muñeco 3D descansando tranquilamente , un símbolo rojo de prohibido sobre cartas/sobres , e íconos que representan XML, json y TXT ).

## Página 46: ¿Quién usa servicios web RESTful?
* **Título:** ¿Quién usa servicios web RESTful?.
* Plataformas como Twitter y Amazon Web Services.
* Específicamente Amazon Simple Storage Service (S3).
* *(Descripción visual: Un diagrama en el que carpetas suben desde servidores locales hacia una nube y luego se descargan a diferentes dispositivos de usuario)*.

## Página 47: Portada Transición a Flask
* **Institución:** ITAM.
* **Materia:** Servicios Web RESTful.
* **Tema Principal:** Flask.
* **Profesor:** Dr. J. Octavio Gutiérrez García.
* **Contacto:** octavio.gutierrez@itam.mx.

## Página 48: Logotipos (Python y Jinja)
* *(Descripción visual: Aparecen los logotipos representativos de Python y Jinja)*.

## Página 49: Logotipo JSON
* *(Descripción visual: Aparece el logo de {JSON} y su significado "JavaScript Object Notation")*.

## Página 50: Logotipos (Python y Pickle)
* *(Descripción visual: Se muestran los logotipos de Python y PICKLE)*.

## Página 51: Modelo de Regresión Logística
* **CONTEXTO:** Datos y Modelo de Regresión Logística.
* Se ilustra una gráfica para la probabilidad de Taquicardia.
* Eje Y: Probabilidad de 0.0 a 1.0.
* Eje X: Latidos por minuto de 60 a 200.
* Los puntos con probabilidad cercana a 0.0 se clasifican como NORMAL.
* La fórmula mostrada es: $\frac{1}{1 + e^{-(b_{0}+b_{1}x)}}$.
* *(Descripción visual: Gráfica de dispersión mostrando la probabilidad de taquicardia contra los latidos por minuto con una curva de regresión ajustándose a los datos)*.

## Página 52: Instalación
* **Título:** Instalación.
* Comandos de consola a ejecutar:
* `python -m pip install --upgrade pip` 
* `python -m pip install Flask` 
* `python -m pip install Flask-enterprise` 
* `python -m pip install Flask-ext` 
* `python -m pip install Flask-mysql` 
* `python -m pip install Flask-restful` 
* `python -m pip install numpy` 
* `python -m pip install scikit-learn` 
* `python -m pip install requests` 
* *(Descripción visual: Un dibujo de un nudo complejo hecho de una cuerda negra)*.

## Página 53: Estructura del Proyecto
* **Título:** Estructura del Proyecto.
* Directorio principal: `DESPLIEGUE`.
* Carpeta: `templates`.
* Archivo: `index.html`.
* Archivos Python en raíz:
* `app.py`.
* `creacion_modelo.py`.
* `modelo.pkl` (Creado por `creación_modelo.py`).
* `realiza_solicitud.py`.

## Página 54: index.html
* **Título:** index.html.
* *(Descripción visual: Logotipo del escudo naranja de HTML5)*.
* Código de la interfaz web:
```html
<!DOCTYPE html>
<html >
<head>
<meta charset="UTF-8">
<title>Tutorial de Flask</title>
</head>
<body>
<br>
<h1>Evaluador de Taquicardia</h1>
<form action="{{url_for('clasificaweb')}}" method="post">
<input type="number" id="frecuencia" name="frecuencia" min="0" max="400">
<button type="submit">Clasifica</button>
</form>
{{ clasificacion }}
</body>
</html>

```

## Página 55: app.py [1/5] - Librerías
* **Título:** app.py [1/5] - Librerías.
* Código para importar bibliotecas en Python:
```python
import numpy as np
from flask import Flask, request, jsonify, render_template
import pickle

```

## Página 56: app.py [2/5] - Instanciando App y Modelo
* **Título:** app.py [2/5] - Instanciando App y Modelo.
* Código para cargar la aplicación y el archivo Pickle:
```python
app=Flask(__name__)
modelo=pickle.load(open('modelo.pkl','rb'))

```

## Página 57: app.py [3/5] - Cargando el índice
* **Título:** app.py [3/5] - Cargando el índice.
* *(Descripción visual: Aparece el dibujo de un teléfono inteligente con íconos de colores y el texto "my APP")*.
* Código de ruteo para mostrar el HTML:
```python
@app.route('/')
def home():
    return render_template("index.html")

if __name__ == "__main__":
    app.run(host="0.0.0.0",port=90)

```

## Página 58: app.py [4/5] - Desde la Web
* **Título:** app.py [4/5] - Desde la Web.
* *(Descripción visual: Se aprecia una porción de una pantalla mostrando campos de formulario web con un botón)*.
* Código que atiende la solicitud desde el HTML:
```python
@app.route('/clasificaweb', methods=['POST'])
def clasificaweb():
    entrada = [np.array([int(request.form["frecuencia"])])]
    prediccion = modelo.predict(entrada)
    resultado = ""
    if prediccion[0] == 0:
        resultado = "Sano"
    else:
        resultado = "Taquicardia"
    return render_template('index.html', clasificacion=resultado)

```

## Página 59: app.py [5/5] - API Json
* **Título:** app.py [5/5] - API Json.
* *(Descripción visual: Un dibujo delineado que muestra una máscara de hockey)*.
* Código que atiende la solicitud de una API devolviendo JSON:
```python
@app.route('/clasificaapi', methods=['POST'])
def clasificaapi():
    entrada = request.get_json(force=True)
    prediccion = modelo.predict([np.array([int(entrada["frecuencia"])])])
    resultado = ""
    if prediccion[0] == 0:
        resultado = "Sano-"
    else:
        resultado = "Taquicardia-"
    return jsonify(resultado)

```

## Página 60: creación_modelo.py [1/3] - Datos
* **Título:** creación_modelo.py [1/3] - Datos.
* * *(Descripción visual: Se muestra una ilustración en forma isométrica compuesta por pequeños cubos azules brillantes integrando un cubo más grande)*.
* Código para definir el set de datos para entrenar el modelo:
```python
import pickle
import numpy as np
from sklearn.linear_model import LogisticRegression
from sklearn.model_selection import train_test_split
# Números decimales
np.set_printoptions(suppress=True)
# Frecuencias cardíacas de 20 personas
frecuencias_cardiacas = np.array([[65], [70], [80], [80], [80], [90],
                                  [95], [100], [105], [110], [105],
                                  [110], [110], [120], [120], [130],
                                  [140], [180], [185], [190]])
# Clase de las personas 0: Normal 1: Taquicardía
clase = np.array([0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1])

```
## Página 61: creación_modelo.py [2/3] y [3/3] - Creación 
* **Títulos:** creación_modelo.py [2/3] - Creación. 
* *(Descripción visual: Frasco de cristal relleno con pepinillos enteros con la palabra "Python" en la tapa, haciendo alusión a la librería "pickle")*.
* Código para entrenar y guardar el modelo logístico:
```python
# Creamos conjuntos de entrenamiento y de prueba del modelo
datos_entrena, datos_prueba, clase_entrena, clase_prueba = train_test_split(frecuencias_cardiacas, clase, test_size=0.30)

# Creamos el modelo
modelo = LogisticRegression().fit(datos_entrena, clase_entrena)
pickle.dump(modelo, open('modelo.pkl', 'wb'))
modelo = pickle.load(open('modelo.pkl', 'rb'))

```
## Página 62: creación_modelo.py [3/3] - Evaluación
* **Títulos:** creación_modelo.py [3/3] - Evaluación.
* *(Descripción visual: Una diana con los aros rojo y blanco intercalados, donde el centro fue atravesado por una flecha)*.
* Código para evaluar el modelo:
```python
print(modelo.predict(datos_prueba))
print(modelo.predict_proba(datos_prueba))
print(modelo.score(datos_prueba, clase_prueba))
print(modelo.intercept_, modelo.coef_)

```
* Fórmula adjunta de la regresión logística: $\frac{1}{1+e^{-(b_{0}+b_{1}x)}}$.

## Página 63
* **Descripción visual:** La diapositiva muestra un logotipo con la palabra "API" dentro de un hexágono azul.
* **Archivo:** `realiza_solicitud.py` 
* **Título:** API 
* **Código:**

```python
import requests
url="http://localhost:90/clasificaapi"
respuesta=requests.post(url,json={"frecuencia":100})
print(respuesta.json())

```
## Página 64
* **Título:** Laboratorio: 
* **Subtítulo:** Estructura del Proyecto: 
* FLASK_LAB 
* templates: 
* index.html 
* mensajes.html 
* Archivos Python en raíz:
* app.py 

**Interfaz - index.html:** Enviar mensaje 
* Nombre: Nombre 
* Mensaje: 
* Botón: Enviar 
* Botón: Mensaje 

**Interfaz - mensajes.html:** Mensajes 
* Juan Perez: Hola a todos 
* Luis Jimenez: Este es un mensaje 
* Botón: Volver 

## Página 65
* **Título:** index.html 
* **Interfaz:** Enviar mensaje 
* Nombre: Nombre 
* Mensaje: Mensaje
* Botón: Enviar 

* **Código HTML:**
```html
<input type="text" name="nombre" placeholder="Nombre">
<textarea name="mensaje" placeholder="Mensaje"></textarea>

```
* En el action: 
* `{{url_for('nombre_del_metodo')}}` 

## Página 66
* **Título:** mensajes.html
* **Interfaz:** Mensajes 
* Juan Perez: Hola a todos 
* Luis Jimenez: Este es una mensaje 
* Botón: Volver

Código HTML/jinja:
```html
{% for m in mensajes %}
<li>
<b>{{m.nombre}}</b>:{{m.mensaje}}
</li>
{% endfor %}
```

* Para regresar al index.html: 
* `<a href="/">Volver</a>` 

## Página 67
* **Título:** Endpoints 
* `@app.route("/") def index():` 
* `@app.route("/mensajes", methods=["GET"]) def ver_mensajes():` 
* `@app.route("/nuevo_mensaje", methods=["POST"]) def nuevo_mensaje():` 

## Página 68
**Lógica de Negocio para el ENDPOINT index**: 
* Regresa el template index.html 
**Lógica de Negocio para el ENDPOINT ver_mensajes**: 
* Regresa el template mensajes.html pasando como contexto una lista mensajes de objetos JSON 

## Página 69
**Lógica de Negocio para el ENDPOINT nuevo_mensaje**: 
* Agrega un mensaje a una lista mensajes de objetos JSON 
* Los datos del mensaje a agregar los extrae del objeto request 
* `request.form["nombre"]` ó `request.form.get("nombre")` 
* El elemento de la lista se agrega en formato JSON El objeto JSON tiene dos atributos nombre y mensaje 
* Al final, el endpoint redirecciona a "ver_mensajes" 
* `return redirect(url_for("ver_mensajes"))` 
* **Descripción visual:** Un globo de texto resalta la redirección indicando "Envía a página de mensajes".

## Página 70
**Título principal:** Servicios Web 
**Subtítulo:** SOAP 

## Página 71
* **Descripción visual:** Se muestran dos logotipos clave: una pastilla de jabón rosa con la palabra "SOAP" tallada, y el cubo geométrico del World Wide Web Consortium. También hay un gráfico conceptual mostrando dos monitores de computadora interconectados entre sí por un haz de cables azules de red.
* **Título principal:** Servicios Web SOAP 
* Estandarización controlada por un grupo del W3C: World Wide Web Consortium 
* Definición de W3C: "a software system designed to support interoperable machine-to-machine interaction over a network" 

## Página 72
* **Título principal:** Servicios Web 
* Un servicio web es una colección de protocolos y estándares abiertos que sirven para intercambiar datos entre aplicaciones 
* Escritos en distintos lenguajes de programación 
* Ejecutan en distintos sistemas operativos y arquitecturas 
* Desarrollados de manera independiente 
* Independientes de la aplicación que los usa 

* **Descripción visual:** Además del logo de SOAP, se ilustran dos figuras en 3D pasándose flechas (representando el intercambio de datos entre aplicaciones). Además hay una nube de palabras con lenguajes de programación populares y sistemas: CL, BASH, ERLANG, JAVA, PROLOG, ALICE, C++, RPG, SCALA, FORTH, EVO.NET, FORTRAN, HASKELL, OBJECT PASCAL, JAVASCRIPT, ASSEMBLY, COBOL, LISP, LUA, ABAP, DELPHI, PASCAL, OBJECTIVE-C, RUBY, VB, C#, PYTHON, SCHEME, MATLAB, NXT-G, MAD, GROOVY e INDEPENDENT.

## Página 73
**Título principal:** Servicios Web 
* **Comunicación asíncrona y síncrona** 
* *Descripción visual:Diagrama arquitectónico del flujo de llamadas de servicios. Un "Client" (cliente) envía peticiones de comunicación síncrona y asíncrona hacia un "Travel Agent Service" (agente de viajes). Éste a su vez orquesta peticiones a servicios más pequeños: "hotel booking a", "hotel booking b", "flight booking a", "flight booking b", "hire car booking a", "hire car booking b".*

## Página 74
**Título principal:** Servicios Web 
**Ventajas:** 
* Interoperabilidad entre aplicaciones. 
* Independencia entre el servicio web y el cliente 
* Uso de estándares 
* Al ejecutar “comúnmente” HTTP, pueden atravesar firewalls sin necesidad de cambiar las reglas de filtrado. 

**Desventajas:** 
* Bajo rendimiento comparado con otros modelos de computación distribuida: RMI, RPC o gRPC. 
* Pueden esquivar firewalls 
Enlace: `http://www.zdnet.com/news/xml-web-services-need-a-firewall/298402` 
*Descripción visual:* Dibujo de un profesor calvo de traje negro pesando figurativamente las palabras "PROS" y "CONS" en sus manos.*

## Página 75
* Descripción visual: Este esquema expone la pila tecnológica del protocolo. En la base se ubican "URIs", "XML", y "HTTP, SMTP u otros". En la capa de red principal reside "SOAP". Por encima encontramos "Web Services" y "WSDL". En la capa superior viven las "Aplicaciones", los "Servicios de directorio" y la "Seguridad". Un dibujo adicional muestra bloques 3D apilados formando la palabra "STANDARDS".*

## Página 76
**Título principal:** Interoperabilidad en entornos heterogéneos 
* Servicios basados en protocolos abiertos y mecanismos estándar 
* HTTP 
* Simple Object Access Protocol - SOAP: Empaqueta la información y la transmite entre el cliente y el proveedor del servicio
  
## Página 77
**Título principal:** Interoperabilidad en entornos heterogéneos 
* Servicios basados en protocolos abiertos y mecanismos estándar 
* Extensible Markup Language - XML: Representación externa de los datos y mensajes 
* Universal Description, Discovery and Integration - UDDI: Lista de servicios disponibles 
* Web Service Definition Language - WSDL: Descripción del servicio 
*Descripción visual:* Iconografía técnica que acompaña las definiciones: Un documento genérico con las siglas XML, un logo de malla de red (para UDDI) y una burbuja de chat con la letra "D" y la palabra "description" (para WSDL).*

## Página 78
**Título principal:** SOAP 
* Simple Object Access Protocol permite intercambiar mensajes basados en XML sobre redes de computadoras 
* Define un esquema para: Usa XML para representar el contenido de mensajes 
* SOAP (versión 1.2) usa: HTTP, SMTP, TCP o UDP 
* Enlace: `http://www.w3.org/TR/soap/` 


* Descripción visual: Diagrama superior donde la "Aplicación 1" interactúa con la "Aplicación 2" mediante una flecha direccional por la que transita un documento XML. Otras representaciones visuales muestran a SOAP como un bloque animado musculoso, a un cartero, un sobre de correo, una caja empaquetada y un pequeño diagrama UML con un iniciador y un participante (Initiator/Participant).*

## Página 79
**Título principal:** SOAP 
* SOAP específica: 
* Cómo representar los mensajes de texto en XML 
* Cómo procesar los elementos de los mensajes 
* Cómo se puede combinar un par de mensajes para reproducir un modelo petición-respuesta 
* Cómo utilizar el protocolo de aplicación (HTTP, SMTP, …) para enviar mensajes SOAP 

## Página 80
**Título principal:** Un mensaje SOAP es transportado en un sobre (envelope) 
* Estructura: envelope contiene un header y un body. El header contiene header element y el body contiene body element. 
*Descripción visual:* Diagrama de llaves que desglosa el "envelope" (1) y resalta que el bloque de "header" (2) es de carácter opcional, mientras que el "body" es imperativo.*

## Página 81
**Título principal:** Mensaje 
* **Estructura del Mensaje en código XML:**
```xml
<?xml version="1.0"?>
<soap:Envelope
xmlns:soap="http://www.w3.org/2001/12/soap-envelope"
soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding">

<soap:Header>
...
</soap:Header>

<soap:Body>
...
  <soap:Fault>
  ...
  </soap:Fault>
</soap:Body>

</soap:Envelope>

```
*Descripción visual: Diagrama de jerarquía junto a la pastilla de SOAP que divide conceptualmente un mensaje web en su "Sobre", su "Cabecera" y su "Cuerpo".*

## Página 82
**Título principal:** Sobre (Envelope) 
* Define el documento XML como un mensaje SOAP 
* Obligatorio- xmlns:soap="https...
* EncodingStyle define los tipos de datos usados en el documento.
```
<?xml version="1.0"?>
<soap: Envelope
xmlns:soap="http://www.w3.org/2001/12/soap-envelope"
soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding">
Message information goes here
</soap: Envelope>
```
## Página 83
**Título principal:** Mensaje SOAP 
* Estilo RPC y literal
```
‹soap: envelope>
‹soap: body>
<myMethod>
<x>5< /x>
<y>5.0</y>
< /myMethod>
</ soap:body>
</ soap:envelope>
```

## Página 84
**Título principal:** Mensaje SOAP 
* Estilo RPC y encoding
```
‹soap:envelope>
<soap: body>
<myMethod>
< xsi:type="xsd: int">5</x>
<y xsi: type="xsd: float">5.0</y>
</myMethod>
</ soap:body>
</soap:envelope>
```

## Página 85
**Título principal:** Mensaje SOAP 
```
* Estilo document y literal
‹soap: envelope>
‹soap: body>
<x>5< /x>
<y >5.0</y>
</ soap: body>
</soap:envelope>
```
## Página 86
**Título:** Encabezado (Header) 
* Elemento opcional 
* Incluye información de control 
* Identificador de transacción para su uso con un servicio de transacciones 
* Un identificador de mensajes para relacionar mensajes entre sí 
* Un nombre de usuario, una clave pública, etc. 

*Descripción visual: Se muestran varias imágenes: un escáner de tarjeta de crédito conectado a un teléfono móvil, y dos botellas de cristal etiquetadas como "Botella I" y "Botella 2" que contienen pergaminos con el texto "NEED YOU...".*

## Página 87
**Título:** Encabezado (Header) 
**Código XML:**
```xml
<?xml version="1.0"?> 
<soap:Envelope
xmlns:soap="http://www.w3.org/2001/12/soap-envelope" soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding"> 
<soap:Header> 
<m:Trans xmlns:m="http://www.w3schools.com/transaction/" soap:mustUnderstand="1">234 
</m:Trans> 
</soap:Header>
</soap:Envelope> 

```

## Página 88
* **Título:** Encabezado (Header) 
* Etiqueta XML definida por el usuario (aplicación) 
**Código XML:**
```xml
<?xml version="1.0"?> 
<soap:Envelope 
xmlns:soap="http://www.w3.org/2001/12/soap-envelope" soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding"> 
<soap:Header>
<m:Trans xmlns:m="http://www.w3schools.com/transaction/" soap:mustUnderstand="1">234 
</m:Trans> 
</soap:Header>
</soap:Envelope>

```

## Página 89
* **Título:** Encabezado (Header) 
**Código XML:**
```xml
<?xml version="1.0"?> 
<soap:Envelope 
xmlns:soap="http://www.w3.org/2001/12/soap-envelope" soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding"> 
<soap:Header> 
<m:Trans xmlns:m="http://www.w3schools.com/transaction/" soap:mustUnderstand="1">234 
</m:Trans> 
</soap:Header> 
</soap:Envelope> 

```
* Si el valor es 1, el elemento header DEBE ser procesado 

## Página 90

* **Título:** Encabezado (Header) 
**Código XML:**

```xml
<?xml version="1.0"?> 
<soap:Envelope 
xmlns:soap="http://www.w3.org/2001/12/soap-envelope" soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding"> 
<soap:Header> 
<m:Trans xmlns:m="http://www.w3schools.com/transaction/" soap:mustUnderstand="1">234 
</m:Trans> 
</soap:Header>
</soap:Envelope> 

```
* Valor de la etiqueta XML trans. Ejemplo: Transacción 234 

## Página 91
* **Título:** Encabezado (Header) 
**Código XML:**
```xml
<?xml version="1.0"?> 
<soap:Envelope
xmlns:soap="http://www.w3.org/2001/12/soap-envelope" soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding"> 
<soap:Header> 
<m:Trans xmlns:m="http://www.w3schools.com/transaction/" soap:actor="http://www.w3schools.com/appml/">234 
</m:Trans> 
</soap:Header> 
</soap:Envelope> 

```
* Si el mensaje SOAP pasa por varios endpoints, sólo el endpoint indicado en el elemento **actor** debe de procesar el encabezado 

## Página 92
* **Título:** SOAP 
* **Subtítulo:** Cuerpo (Body) 
* Elemento obligatorio 
En el elemento body se incluye: 
* Mensaje 
* Referencia al esquema XML que describe el servicio 
Comunicación cliente-servidor 
* El elemento body contiene una petición o una respuesta 

*Descripción visual: La ilustración del perfil anatómico de un cuerpo humano (tipo rayos X), mostrando sus órganos internos y sistema óseo.*

## Página 93
**Título:** SOAP 
**Subtítulo:** Cuerpo (Body) 
* PETICIÓN
**Código XML:**
```xml
<?xml version="1.0"?> 
<soap:Envelope 
xmlns:soap="http://www.w3.org/2001/12/soap-envelope" soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding"> 
<soap:Body> 
  <m:GetPrice xmlns:m="http://www.w3schools.com/prices">
    <m:Item>Apples</m:Item> 
  </m:GetPrice> 
</soap:Body> 
</soap:Envelope>

```

* (GetPrice): elemento específico de la aplicación 

## Página 94
**Título:** SOAP 
**Subtítulo:** Cuerpo (Body) 
RESPUESTA 
**Código XML:**
```xml
<?xml version="1.0"?> 
<soap:Envelope 
xmlns:soap="http://www.w3.org/2001/12/soap-envelope" 
soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding"> 
<soap:Body> 
  <m:GetPriceResponse xmlns:m="http://www.w3schools.com/prices"> 
    <m:Price>1.90</m:Price> 
  </m:GetPriceResponse> 
</soap:Body> 
</soap:Envelope> 

```
* (Price, GetPriceResponse): elementos específicos de la aplicación 

## Página 95
**Título:** SOAP & HTTP 
* HTTP + XML = SOAP 
* Un método SOAP es una solicitud/respuesta HTTP que cumple con las reglas de SOAP. 

## Página 96
**Título:** Ejemplo de solicitud 
**Código de la solicitud:**
```http
POST /InStock HTTP/1.1
Host: www.example.org
Content-Type: application/soap+xml; charset=utf-8
Content-Length: nnn

<?xml version="1.0"?>
<soap:Envelope
xmlns:soap="http://www.w3.org/2001/12/soap-envelope"
soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding">

<soap:Body xmlns:m="http://www.example.org/stock">
  <m:GetStockPrice>
    <m:StockName>IBM</m:StockName>
  </m:GetStockPrice>
</soap:Body>

</soap:Envelope>

```

## Página 97
**Título:** Ejemplo de respuesta 
* Código de la respuesta:
```http
HTTP/1.1 200 OK
Content-Type: application/soap+xml; charset=utf-8
Content-Length: nnn

<?xml version="1.0"?>
<soap:Envelope
xmlns:soap="http://www.w3.org/2001/12/soap-envelope"
soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding">

<soap:Body xmlns:m="http://www.example.org/stock">
  <m:GetStockPriceResponse>
    <m:Price>34.5</m:Price>
  </m:GetStockPriceResponse>
</soap:Body>

</soap:Envelope>

```
## Página 98 
**Título:** Servicios Web 
**Subtítulo:** Interfaz 
* Una interfaz de servicio web consta de un conjunto de operaciones que pueden ser accedidas por un cliente en Internet 
* El conjunto de operaciones en un servicio web pueden ser ofrecidas por programas, objetos, bases de datos, etc. 

*Descripción visual:** Gráfico de óvalos entrelazados en colores gris y rosa con la palabra "Interface" en el centro. Debajo, la palabra "anything" escrita en distintas fuentes y bloques de color.*

## Página 99 
**Título:** WSDL 
* Web Services Description Language es un lenguaje de descripción de interfaz (IDL) para servicios Web en XML 
* Describe al servicio web 
* Describe como acceder al servicio web 

*Descripción visual:** Diagrama arquitectónico donde un Proveedor de Servicios ("Service Provider") expone un documento "WSDL" a través de una Plataforma de Servicios Web ("Web Services Platform"), para que un "Client" (cliente) consuma el servicio.*


## Página 100
**Título:** Elementos 
* `<types>` Contenedor para definiciones de tipos de datos usados por el servicio web 
* `<message>` Definición de los datos a ser comunicados 
* `<portType>` Conjunto de operaciones soportadas por uno o mas puntos finales 
* `<binding>` Define el formato del mensaje y el protocolo 

## Página 101
**Título:** Estructura principal de un documento WSDL 
* Estructura XML:
```xml
<definitions>
  <types>
    Definiciones de tipos de datos.... 
  </types>
  <message>
    Definición de los datos a ser comunicados... 
  </message>
  <portType>
    Conjunto de operaciones...... 
  </portType>
  <binding>
    Protocolo y especificación del formato de datos.... 
  </binding>
</definitions>

```

## Página 102: WSDL - Types
**Diagrama jerárquico** que ilustra cómo se organizan los diferentes **tipos de datos** en el estándar XML Schema (utilizado frecuentemente en WSDL para definir la estructura de servicios web). Arbol genealógico de datos que empieza con un tipo general y se va ramificando hacia tipos cada vez más específicos
* **El origen:** En la parte superior, el punto de partida es `anyType`. De aquí salen dos grandes ramas:
1. **all complex types:** Representa estructuras de datos más complejas que tú mismo puedes definir.
2. **anySimpleType:** Es la base de todos los tipos de datos atómicos (valores simples).

* **La rama anySimpleType:** Esta es la parte más detallada del gráfico. A partir de ella, se despliegan varias categorías principales:
* **Tipos de fecha y tiempo:** Incluye formatos como `duration` (duración), `dateTime` (fecha y hora), `time` (hora), `date` (fecha), y otros específicos como `gYear` (año) o `gMonth` (mes).
* **Tipos básicos:** Incluye `boolean` (verdadero/falso), `float` y `double` (números con decimales), `base64Binary` y `hexBinary` (datos binarios), además de otros como `anyURI` y `NOTATION`.
* **Cadenas de texto (Strings):** Comienza con `string` y se vuelve más específica bajando por el árbol hacia `normalizedString`, `token`, y finalmente tipos muy especializados como `language` (idiomas) o `ID` (identificadores únicos).
* **Tipos numéricos (Decimal):** Empieza en `decimal` y desciende hacia `integer` (enteros). Desde aquí, el árbol se divide en:
* **Enteros negativos y no positivos.**
* **Enteros largos y estándar (int, short, byte).**
* **Enteros no negativos y positivos**, que incluyen variantes de tamaños como `unsignedLong`, `unsignedInt`, hasta llegar a `unsignedByte`.

## Página 103: WSDL - Ejemplo
```
<message name="getTermRequest">
  <part name="term" type="xs:string"/>
</message>

<message name="get TermResponse">
  <part name="value" type="xs:string"/>
</message>

<portType name="glossary Terms">
  <operation name="get Term">
    <input message="get TermRequest"/ >
    <output message="get TermResponse"/>
  </operation>
</portType>
```
donde getTerm es una función y getTermRequest/getTermResponse son los parámetros de entrada y salida. 

## Página 104: WSDL – PortType [1/2]
**Define las operaciones del servicio web y los mensajes que están involucrados.**
Tipos de operaciones:
* Sólo ida **(One-way)**: El punto final recibe un mensaje
* Notificación **(Notification)**: El punto final envía un mensaje

## Página 105: WSDL – PortType [2/2]
**Define las operaciones del servicio web y los mensajes que están involucrados.**
Tipos de operaciones
* Solicitud-respuesta **(Request-Response)**: El punto final recibe un mensaje y envía un mensaje correlacionado.
* Petición-respuesta **(Solicit-Response)**: El punto final envía un mensaje y recibe un mensaje correlacionado.

## Página 106: One-way

Código XML:
```
<message name="newTermValues">
  <part name="term" type="xs:string"/>
  <part name="value" type="xs:string"/>
</message>

<portType name="glossaryTerms">
  <operation name="setTerm">
    <input name="newTerm" message="newTermValues"/>
  </operation>
</portType>
```
El Servicio web recibe un mensaje.

*Descripción visual: Un letrero vial oscuro con una flecha apuntando hacia la derecha y el texto "ONE WAY" (Sentido único).*

## Página 107: Notification
Código XML:
```
<message name="notifyNewVersion">
  <part name="version" type="xs:string"/>
</message>

<portType name="glossaryTerms">
  <operation name="newVersion">
    <output name="version" message="notifyNewVersion"/>
  </operation>
</portType>
```
Anotación: El Servicio web envía un mensaje.
*Descripción visual: Campana de notificación azul vibrando, junto a un círculo naranja con un signo de exclamación (!)*

## Página 108: Request-Response
Código XML:
```
<message name="getTermRequest">
  <part name="term" type="xs:string"/>
</message>

<message name="getTermResponse">
  <part name="value" type="xs:string"/>
</message>

<portType name="glossaryTerms">
  <operation name="getTerm">
    <input message="getTermRequest"/> <!-- 1 -->
    <output message="getTermResponse"/> <!-- 2 -->
  </operation>
</portType>
```
Anotación: El servicio web recibe un mensaje y envía un mensaje correlacionado.
*Descripción visual: Una urna roja con la palabra "REQUESTS" en letras blancas 3D y sobres blancos introduciéndose en la ranura. El código tiene números (1 y 2) indicando el orden de ejecución en el <input> y <output>.*

## Página 109: Solicit-Response
Código XML:
```
<message name="getExpirationDateResponse">
  <part name="value" type="xs:string"/>
</message>

<message name="getExpirationDateSolicit">
  <part name="term" type="xs:string"/>
</message>

<portType name="glossaryTerms">
  <operation name="getExpirationDate">
    <output message="getExpirationDateResponse"/> <!-- 1 -->
    <input message="getExpirationDateSolicit"/> <!-- 2 -->
  </operation>
</portType>
```
Anotación: El servicio web envía un mensaje y recibe un mensaje correlacionado.
*Descripción visual: El diseño es idéntico a las páginas anteriores, pero invierte el orden lógico (1 para output, 2 para input).*

## Página 110: WSDL - Vinculación (Binding)
Define el formato del **mensaje** y el **protocolo**

*Descripción visual: Varias figuras de madera con forma de personas en colores vivos interconectadas mediante líneas, simulando una red o vinculación de usuarios.*



## Página 111: Binding
Código XML:
```
<message name="getTermRequest"> ... </message>
<message name="getTermResponse"> ... </message>

<portType name="glossaryTerms">
  <operation name="getTerm">
    <input message="getTermRequest"/>
    <output message="getTermResponse"/>
  </operation>
</portType>

<binding type="glossaryTerms" name="MyBinding">
  <soap:binding style="document" transport="[http://schemas.xmlsoap.org/soap/http](http://schemas.xmlsoap.org/soap/http)" />
  <operation>
    <soap:operation soapAction="[http://example.com/getTerm](http://example.com/getTerm)"/>
    <input><soap:body use="literal"/></input>
    <output><soap:body use="literal"/></output>
  </operation>
</binding>
```

Descripción visual: Cuatro piezas de rompecabezas rojas que encajan formando una cruz, con una pieza amarilla en el centro. Las piezas rojas están conectadas a cables de red del mismo color. Resalta el código: `<portType name="glossaryTerms">` y `<binding type="glossaryTerms" name=“MyBinding">`

## Página 112: Continuación
Se presenta el mismo bloque de código XML de la página 111, pero ahora se resalta el código: `<binding type="glossaryTerms" name=“MyBinding">`

## Página 113: Continuación
Se presenta el mismo bloque, pero hay un globo de texto apuntando a la línea `<soap:binding style="document"` El atributo STYLE se refiere a como traducir el binding a un mensaje SOAP. Document: mensaje que contiene documentos. RPC: mensaje con parámetros y valores de retorno.

## Página 114: Continuación
Ahora se resalta `transport="http://schemas.xmlsoap.org/soap/http"/>`. El atributo TRANSPORT define el protocolo a utilizar.

## Página 115: Continuación
La explicación se centra en el atributo "use" dentro del body:
```
<operation name="getTerm">
  <input message="getTermRequest"/>
  <output message="getTermResponse"/>
</operation>
```
y 
```
<soap:operation soapAction="http://example.com/getTerm"/>
<input><soap:body use="literal"/></input>
<output><soap:body use="literal"/></output>
```
Anotación: encoded o literal.

## Página 116: WSDL y UDDI
* **Universal Description, Discovery and Integration** (UDDI) es un servicio de directorio en el que se pueden registrar y buscar servicios Web.
* Directorio de interfaces WSDL
* Comunicación a través de SOAP
* Servicio de páginas blancas, amarillas y verdes.

*Descripción visual: A la izquierda, un logotipo clásico de UDDI. A la derecha, una lupa analizando las páginas de un libro.*

## Página 117: Transición a SPYNE

*Descripción visual: El logotipo de la librería en letras negras, grandes y gruesas que dicen "SPYNE". A su lado, la conocida pastilla de jabón rosa con las letras incrustadas "SOAP".*

## Página 118: Para Servidor y Client SOAP
```
python -m pip install spyne
python -m pip install suds
python -m pip install lxml
```
* http://spyne.io/
* http://localhost:8000/?wsdl


Clases requeridas:
```
from spyne.protocol.soap import Soap11
from spyne.server.wsgi import WsgiApplication
from wsgiref.simple_server import make_server
from spyne import Application, ServiceBase, rpc
from spyne import Integer 
```

## Página 119: Esqueleto del Servicio Web
```
class Servicio(ServiceBase):
    @rpc(Integer, Integer, _returns=Integer)
    def suma(ctx, a, b):
        return a+b
```

## Página 120: Despliegue del Servicio Web
```
application = Application([Servicio],
    "localhost",
    in_protocol=Soap11(),
    out_protocol=Soap11())

wsgi_app = WsgiApplication(application, 8000)
server = make_server("127.0.0.1", 8000, wsgi_app)
server.serve_forever()
```

## Página 121: Tipos Base
* Integer
* Float
* Boolean
* Unicode
* Iterable(tipo)
```
from spyne import tipo
```

## Página 122: Cliente de Servicio Web
```
from suds.client import Client
client = Client("http://localhost:8000/?wsdl")
result = client.service.suma(3, 4)
print(result)
```

## Página 123: DJANGO
(Página de transición sin texto ni código).

## Página 124: DJANGO
Web framework escrito en Python

Ventajas:
* Derivadas de Python
* Aplicaciones plug & play
* Mapeo Objeto Relacional: Objetos / Base de Datos
* Lenguaje para plantillas
* Interfaz de administrador (configurable)
* Diseño de URLs “elegante”
* MVC

## Página 125: Modelo Vista Controlador
* Datos
* Interfaz
* Lógica de control: Intermediario entre Datos e Interfaz

*Descripción visual: Diagrama del patrón MVC (Modelo Vista Controlador). Muestra a un usuario web enviando un "HTTP Request" al "Controller". Éste envía "Execution Parameters" al "Model" e interactúa con bases de datos. El "Model" devuelve "Resulting Data Arrays" a la "View". El Controller también interactúa enviando comandos a la View. Finalmente, la "View" construye la interfaz gráfica y regresa el "HTTP Response" y el "GUI Output" al usuario web original.*

## Página 126: arquitectura django
1. Nivel de Aplicación (App Layer)
* **User Interface (HTTP Output):** Es el punto de entrada y salida; es lo que el usuario ve y con lo que interactúa a través de su navegador.

2. Patrón MVC (Model-View-Controller)
Esta sección es el "cerebro" de la aplicación y se divide en tres partes que se comunican entre sí:

* **Controller (Controlador):** Recibe las peticiones del usuario, procesa la lógica y decide qué hacer a continuación.
* **Model (Modelo):** Se encarga de gestionar los datos y la lógica de negocio; es el puente directo con la base de datos.
* **View (Vista):** Es el componente encargado de presentar la información visualmente al usuario.

3. Nivel de Base de Datos (Database Layer)
* **MySQL / SQLite:** Es el almacenamiento persistente donde reside toda la información. El **Modelo** consulta o guarda datos aquí para que la aplicación pueda funcionar.

## Página 127: Sitio webs en Django
Un sitio web en Django está conformado por una o *múltiples apps*: 
* Ingreso y registro de usuarios 
* Encuesta 
* Contacto 
* Carrito 
* Etc. 

## Página 128: Apps en Django
Cada App tiene: 
* Modelo (datos) 
* Páginas web (vista) 

Donde:
* M - Model 
* V - View 
* C - Controller 

Cuando se crea una App, Django crea: 
*`models.py`: Almacena información de la App. 
* `views.py`: Funciones de Python que crean lo que usuario ve.
* `urls.py` 

## Página 129: Views
* Las funciones listadas en `views.py` tienen como entrada un objeto `HttpRequest` y como salida un objeto `HttpResponse`. 

## Página 130: HttpRequest
* `HttpRequest.method` 
* `HttpRequest.content_type` 
* `HttpRequest.content_params` 
* `HttpRequest.cookies` 
* `HttpRequest.META`
* `HttpRequest.session` 

## Página 131: HttpResponse
Es responsabilidad del programador crearla. 
* `HttpResponse.content` 
* `HttpResponse.status_code` 
* `HttpResponse.set_cookie()` 
Subclase `JsonResponse` 

## Página 132: Instalación de Django

* 
**Instalación de Django**
```
python -m pip install --upgrade pip
python -m pip install Django
```
* Anaconda package manager 
* Verificar la instalación y versión: `python -m django --version` 

## Página 133: Comandos de Consola de Django
`django-admin startproject mywebsite` 

`python manage.py`: 
* `shell` 
* `runserver` 
* `startapp nombreapp` 
* `createsuperuser` 
* `migrate` 
* `makemigrations nombreapp` 
* `sqlmigrate nombreapp 0001` 

## Página 134: Creación de un proyecto
`django-admin startproject mywebsite` 
* Estructura de archivos generada: 
`MYWEBSITE` 
`mywebsite` 
* `__init__.py` 
* `asgi.py` 
* `settings.py` 
* `urls.py` 
* `wsgi.py` 

EN MYWEBSITE: 
`manage.py` 

*Anotación:`manage.py` permite interactuar con el proyecto Django.* 

## Página 135: (Continuación)
* `asgi.py` -> **Asynchronous Server Gateway Interface** 
* `wsgi.py` -> **Web Server Gateway Interface** 

## Página 136: (Continuación)
* `settings.py`: Configuración del proyecto. 

## Página 137: (Continuación)
* `urls.py`: Índice de servicios/páginas ofrecidas. 

## Página 138: Arranca el Servidor Web
* Directorio: `…\directory\mywebsite` 
* Comando: `python manage.py runserver` 
* URL local: `http://127.0.0.1:8000/` 
*Descripción visual: una nave con la descripción: The install worked succesfully! Congratulations!*

## Página 139: Crea una App
* Comando: `python manage.py startapp myfirstapp` 
*(Esta acción genera la estructura interna de la app, como la carpeta migrations, admin.py, apps.py, models.py, tests.py y views.py dentro de myfirstapp).*

## Página 140: Escribir una Vista
* Archivo: `myfirstapp/views.py` 
```python
from django.shortcuts import render 
from django.http import HttpResponse 

# Create your views here.
def index(request):
    return HttpResponse("Hola a todos desde myfirstapp")

```
## Página 141: Vincula la Vista a una URL
* Archivo a crear: `myfirstapp/urls.py` 
```python
from django.urls import path 
from . import views 

urlpatterns = 
    path("", views.index, name="index"), 
] 

```

## Página 142: Vincular URLs al Sitio Web
* Archivo a modificar: `mywebsite/urls.py` 
```python
from django.contrib import admin 
from django.urls import include, path 

urlpatterns = [ 
    path("myfirstapp/", include("myfirstapp.urls")),
    path("admin/", admin.site.urls),
] 

```

## Página 143: Aplicaciones instaladas por defecto
se gestionan en `…\directory\mywebsite\settings.py`
* Crea las tablas de la BD de las aplicaciones: `python manage.py migrate` 
* Vuelve a ejecutar el servidor web: `python manage.py runserver`

## Página 144: Crea Modelos: Dominio
Ejemplos de entidades en el dominio: Estudiante, Carrera. 

## Página 145: Crea Modelos (Código)
en el archivo `…/myfirstapp/models.py` 
```python
from django.db import models 
class Estudiante(models.Model): 
    nombre = models.CharField(max_length=200) 
    apellidos = models.CharField(max_length=200)
    edad = models.IntegerField(default=0) 
    promedio = models.FloatField(default=9.99) 
    foraneo = models.BooleanField(default=False) 

class Carrera(models.Model):
    LICENCIATURA = 1 
    INGENIERIA = 2 
    
    OPCIONES_TIPO = (
        (LICENCIATURA, "Licenciatura")[cite_start], 
        (INGENIERIA, "Ingenieria")[cite_start], 
    ) 
    
    estudiante = models.ForeignKey(Estudiante, on_delete=models.CASCADE)
    tipo = models.IntegerField(choices=OPCIONES_TIPO, null=True, blank=True)
    nombre = models.CharField(max_length=200)

```
## Página 146: "Instala" tu aplicación
* Archivo a modificar: `...\directory\mywebsite\settings.py`

```python
INSTALLED_APPS = [
    "myfirstapp.apps.MyfirstappConfig",
    "django.contrib.admin",
    "django.contrib.auth",
    "django.contrib.contenttypes",
    "django.contrib.sessions",
    "django.contrib.messages",
    "django.contrib.staticfiles",
]

```
## Página 147: Crea las tablas de tu aplicación recientemente "instalada"
* Para la simulación (preparar los archivos):
`python manage.py makemigrations myfirstapp`
* Échale un ojo a: `myfirstapp/migrations/0001_initial.py`
* Posteriormente ejecuta:
`python manage.py sqlmigrate myfirstapp 0001`
* Finalmente, crea las tablas:
`python manage.py migrate`

## Página 148: Interactúa con el Shell de Django
* Iniciar el shell: `python manage.py shell`
* Importa los modelos:

`from myfirstapp.models import Estudiante, Carrera`

`Estudiante.objects.all()`

* **Error común al crear Objetos**
`estudiante = Estudiante ("José", "Gutiérrez", 49, 8.9, True)`
`estudiante.id`

## Página 149: Continuación

**Forma correcta:**
`>> estudiante = Estudiante (nombre="José", apellidos="Gutiérrez", edad = 49, promedio = 8.9, foraneo=True)`

`estudiante.id`

`estudiante.save()`

`estudiante.id`

* Añade otro estudiante:
`>> Estudiante.objects.all()`


## Página 150: Mostrando los Objetos "Correctamente"
* Archivo a modificar: `.../myfirstapp/models.py`

```python
from django.db import models

class Estudiante (models.Model):
    def __str__(self):
        return self.nombre + " " + self.apellidos
    def aspira_a_beca(self):
        return self.promedio >= 9

class Carrera (models.Model):
    def __str__(self):
        return str(self.tipo) + " " + self.nombre

```

## Página 151: Shell de Django (continuación)

```python
from myfirstapp.models import Estudiante, Carrera
>> Estudiante.objects.all()

estudiante = Estudiante.objects.get(id=1) 
# (o también se puede usar pk)
estudiante = Estudiante.objects.get(pk=1)

estudiante.carrera_set.all()

estudiante.carrera_set.create(tipo=1, nombre="Matematicas")
> estudiante.carrera_set.create(tipo=2, nombre="Computacion")

estudiante.carrera_set.all()

```

## Página 152: Continuación
```python
>> carrera = estudiante.carrera_set.create(tipo=1, nombre="Actuaria")
carrera.estudiante
estudiante.carrera_set.count()

c = estudiante.carrera_set.get(id=1)
c.delete()

```

* Nota: Agrega dos Carreras al estudiante 2

## Página 153: Filtros

```python
from django.db.models import Q

Estudiante.objects.filter(nombre="Jose")
Estudiante.objects.filter(nombre__contains="o")
Estudiante.objects.filter(nombre__icontains="o")
Estudiante.objects.filter(nombre__startswith="o")
Estudiante.objects.filter(nombre__istartswith="o")
Estudiante.objects.filter(nombre__endswith="o")
Estudiante.objects.filter(nombre__iendswith="o")

Estudiante.objects.filter(Q(nombre="Jose") & Q(apellidos="Gutierre"))
Estudiante.objects.filter(Q(nombre="Jose") | Q(apellidos="Gutierre"))
Estudiante.objects.filter(Q(nombre="Jose") & ~Q(apellidos="Gutierre"))

```

## Página 154: Crea un Super usuario
* Comando: `python manage.py createsuperuser`
*Ejemplo de datos ingresados:*
* admin
* admin@admin.com
* 123456
* Acceso: `http://127.0.0.1:8000/admin`

## Página 155: Añade tu App a la Interfaz Admin
* Archivo a modificar: `.../myfirstapp/admin.py`
```python
from django.contrib import admin
from .models import Estudiante, Carrera

admin.site.register(Estudiante)
admin.site.register(Carrera)

```

## Página 156: Entra al sitio de Administración
* Acceso: `http://127.0.0.1:8000/admin`
* Agrega un nuevo Estudiante
* *(Imagen referencial: Pantalla de "Site administration" de Django con las secciones de AUTHENTICATION AND AUTHORIZATION (Groups, Users) y MYFIRSTAPP (Carreras, Estudiantes))*

## Página 157: Creando más vistas y paso de parámetros
* Archivo a modificar: `myfirstapp/views.py`
```python
def detalles(request, estudiante_id):
    return HttpResponse("Detalles del estudiante %s." % estudiante_id)

def carreras(request, estudiante_id):
    return HttpResponse("Carreras del estudiante %s." % estudiante_id)

def agrega_carrera(request, estudiante_id):
    return HttpResponse("Agregando una carrera a %s." % estudiante_id)

```

## Página 158: Vinculando las vistas a URLs y convertidores
**Convertidores**
* `int`
* `str`
* `slug`: ascii con `_-`
Archivo a modificar: `myfirstapp/urls.py`

```python
urlpatterns = [
    # ...
    # ejemplo: /myfirstapp/5/detalles/
    path("<int:estudiante_id>/detalles/", views.detalles, name="detalles"),
    # ejemplo: /myfirstapp/5/carreras/
    path("<int:estudiante_id>/carreras/", views.carreras, name="carreras"),
    # ejemplo: /myfirstapp/5/agrega_carrera/
    path("<int:estudiante_id>/agrega_carrera/", views.agrega_carrera, name="agrega_carrera"),
]

```

## Página 159: Aumentando funcionalidad en las views
```python
from .models import Estudiante
def index(request):
estudiantes = Estudiante.objects.order_by("nombre")
lista =
""
for e in estudiantes:
lista += e.__str__()+", "
return HttpResponse(lista)
```

## Página 160: El lenguaje de template de Django
```html
{% if athlete_list %}
    Number of athletes: {{ athlete_list|length }}
{% elif athlete_in_locker_room_list %}
    Athletes should be out of the locker room soon!
{% else %}
    No athletes.
{% endif %}

```
Documentación: `https://docs.djangoproject.com/en/4.0/ref/templates/language/`

## Página 161: Creando de las Templates
* Archivo a crear: `myfirstapp/templates/myfirstapp/index.html`
```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Index page</title>
</head>
<body>
    <p>Listado de estudiantes</p>
    {% if estudiantes %}
    <ul>
        {% for estudiante in estudiantes %}
        <li><a href="/myfirstapp/{{ estudiante.id }}/detalles">
            {{estudiante.nombre}} 
            {{estudiante.apellidos}} 
        </a></li>
        {% endfor %}
    </ul>
    {% else %}
        <p>No hay estudiantes registrados.</p>
    {% endif %}
</body>
</html>

```

## Página 162: Revisitando la vista index 1
* Archivo a modificar: `myfirstapp/views.py`

```python
# ...
from django.template import loader
# ...
def index(request):
    estudiantes = Estudiante.objects.order_by("nombre")
    template = loader.get_template("myfirstapp/index.html")
    context = {
        "estudiantes": estudiantes,
    }
    return HttpResponse(template.render(context, request))
# ...

```

## Página 163: Revisitando la vista index 2
* Archivo a modificar: `myfirstapp/views.py`
```python
# ...
from django.shortcuts import render
# ...
def index(request):
    estudiantes = Estudiante.objects.order_by("nombre")
    context = {
        "estudiantes": estudiantes,
    }
    return render(request, "myfirstapp/index.html", context)
# ...

```

## Página 164: Creando template para detalles
* Archivo a crear: `templates/myfirstapp/detalles.html`
```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Detalles</title>
</head>
<body>
    <p> Información del Estudiante </p>
    {% if estudiante %}
        <p>{{ estudiante.id }} </p>
        <p>{{ estudiante.nombre }} </p>
        <p>{{ estudiante.apellidos }} </p>
        <p>{{ estudiante.promedio }} </p>
        {% if estudiante.foraneo %}
            <p>Foráneo</p>
        {% else %}
            <p>Local </p>
        {% endif %} 
    {% endif %} 
</body>
</html>

```
## Página 165: Actualizando la vista Detalles
* Archivo a modificar: `myfirstapp/views.py`
```python
# ...
def detalles(request, estudiante_id):
    estudiante = Estudiante.objects.get(pk=estudiante_id)
    return render(request, "myfirstapp/detalles.html", {"estudiante": estudiante})
# ...

```

## Página 166: Excepciones HTTP
* Archivo a modificar: `myfirstapp/views.py`
```python
# ...
from django.http import Http404
# ...
def detalles(request, estudiante_id):
    try:
        estudiante = Estudiante.objects.get(pk=estudiante_id)
    except Estudiante.DoesNotExist:
        raise Http404()
    return render(request, "myfirstapp/detalles.html", {"estudiante": estudiante})
# ...

```
## Página 167: Simplificando la excepción HTTP
* Archivo a modificar: `myfirstapp/views.py`
```python
# ...
from django.shortcuts import get_object_or_404
# ...
def detalles(request, estudiante_id):
    estudiante = get_object_or_404(Estudiante, pk=estudiante_id)
    return render(request, "myfirstapp/detalles.html", {"estudiante": estudiante})
# ...

```

## Página 168: Mostrando las Carreras en el Template detalles.html [1/3]

* Archivo a modificar: `template/myfirstapp/detalles.html`
```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Página de detalles</title>
</head>
<body>
    <p> Información del Estudiante </p>
    <ul>
    {% for carrera in estudiante.carrera_set.all %}
        <li> {{ carrera.tipo }} {{ carrera.nombre }} </li>
    {% endfor %}
    </ul>
    {% endif %} 
</body>
</html>

```
## Página 169: Mostrando las Carreras en el Template detalles.html [2/3]

* Archivo a modificar: `myfirstapp/models.py`

```python
class Carrera (models.Model):
    LICENCIATURA = 1
    INGENIERIA = 2
    OPCIONES_TIPO = ( 
        (LICENCIATURA, "Licenciatura"),
        (INGENIERIA, "Ingenieria") 
    )
    estudiante = models.ForeignKey(Estudiante, on_delete=models.CASCADE)
    tipo = models.IntegerField(choices=OPCIONES_TIPO, null=True, blank=True) 
    nombre = models.CharField(max_length=100)
    # ...
    def get_tipo(self):
        return Carrera.OPCIONES_TIPO[self.tipo-1][1]

```

## Página 170: Mostrando las Carreras en el Template detalles.html [3/3]
* Archivo a modificar: `template/detalles.html`

```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Página de detalles</title>
</head>
<body>
    <p> Información del Estudiante </p>
    <ul>
    {% for carrera in estudiante.carrera_set.all %}
        <li> {{ carrera.get_tipo }} {{ carrera.nombre }} </li>
    {% endfor %}
    </ul>
    {% endif %} 
</body>
</html>

```

## Página 171: Agregando un Namespace a la App
* **Archivo:** `myfirstapp/urls.py`
```python
from django.urls import path
from . import views

app_name = "myfirstapp"

urlpatterns = [
    path("", views.index, name="index"),
]

```
## Página 172: Quitando URL cableadas en Templates
* **Archivo:** `myfirstapp/templates/myfirstapp/index.html`
* *Antes (Cableado):*
`<li><a href="/myfirstapp/{{estudiante.id}}/detalles"> {{estudiante.nombre}} {{estudiante.apellidos}} </a></li>`
* *Después (Usando namespace):*
`<li><a href="{% url 'myfirstapp:detalles' estudiante.id %}"> {{estudiante.nombre}} {{estudiante.apellidos}} </a></li>`

## Página 173: Agrega un Estudiante - POST [1/2]
* **Archivo:** `myfirstapp/templates/myfirstapp/index.html`
```html
<form action="agrega_estudiante_forma" method="POST">
    {% csrf_token %}
    <label> Nombre: <input type="text" name="nombre"> </label> <br>
    <label> Apellidos: <input type="text" name="apellidos"> </label> <br>
    <label> Edad: <input type="text" name="edad"> </label> <br>
    <label> Promedio: <input type="text" name="promedio"> </label> <br>
    <label> <input type="checkbox" value="True" name="foraneo"> Foráneo </label> <br>
    <input type="submit" value="Agregar">
</form>

```

## Página 174: Agrega un Estudiante - POST [2/2]
* **Archivo:** `myfirstapp/views.py`
```
def agrega_estudiante_forma(request):
  nombre = request.POST.get("nombre")
  apellidos = request.POST.get("apellidos")
  edad = int(request.POST.get("edad"))
  if "foraneo" in request.POST:
    foraneo = True
  else:
    foraneo = False
  promedio = float(request.POST.get("promedio"))
  estudiante = Estudiante( nombre=nombre, apellidos=apellidos,edad=int(edad),foraneo=foraneo, promedio=float(promedio))
  estudiante.save()
  return HttpResponse("Estudiante %s agregado exitósamente desde la forma"
% estudiante.id)

```

## Página 175: Completar...

Agrega una Carrera 
* MÉTODO: create()
* ENTRADA: estudiante_id, tipo, nombre
Agrega un Estudiante
* MÉTODOS: Estudiante() save()
* ENTRADA: nombre, apellidos, edad, foraneo, promedio
Borra un Estudiante
* MÉTODO: delete()
* ENTRADA: estudiante_id
Edita el promedio de un Estudiante
* MÉTODOS: get() y save()
* ENTRADA: estudiante_id, promedio

## Página 176: Agrega una Carrera

* **Archivo:** `myfirstapp/views.py`

```python
def agrega_carrera(request, estudiante_id, tipo, nombre):
estudiante = Estudiante.objects.get(pk=estudiante_id)
estudiante.carrera_set.create(tipo = int(tipo), nombre=nombre)
return HttpResponse("Carrera agregada al estudiante %s" % estudiante_id)

```

## Página 177: Agrega un Estudiante

* **Archivo:** `myfirstapp/views.py`

```python
def agrega_estudiante(request, nombre, apellidos, edad, foraneo, promedio):
  foraneo = foraneo.lower() == "true"
  estudiante = Estudiante( nombre=nombre,apellidos=apellidos,edad=int(edad),foraneo=foraneo,promedio=float(promedio))
  estudiante.save()
  return HttpResponse("Estudiante %s agregado exitósamente" %
estudiante.id)

```

## Página 178: Borra un Estudiante

* **Archivo:** `myfirstapp/urls.py`

```python
def borra_estudiante(request, estudiante_id):
  estudiante = Estudiante.objects.get(pk=estudiante_id)
  estudiante.delete()
  return HttpResponse("Estudiante %s borrado exitósamente" % estudiante_id)
```

---

## Página 9: Introducción a AJAX

* **AJAX (Asynchronous JavaScript and XML)**
* Permite actualizar partes de una página sin recargarla por completo.
* Mejora la experiencia de usuario (UX).

---

## Página 10: JavaScript - Fetch API

* Moderno, reemplaza a `XMLHttpRequest`.
* Sintaxis basada en Promesas (`async/await`).

---

## Página 11: Ejemplo Fetch (GET)

```javascript
fetch('/myfirstapp/algunos_datos')
    .then(response => response.json())
    .then(data => console.log(data));

```

---

## Página 12: Ejemplo Fetch (POST)

```javascript
fetch('/myfirstapp/guardar', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json',
        'X-CSRFToken': getCookie('csrftoken')
    },
    body: JSON.stringify({ nombre: 'Juan' })
});

```

---

## Página 13: Manejo de cookies CSRF

* Django requiere un token para peticiones POST.
* Debes obtenerlo del DOM o de las cookies para incluirlo en el header.

---

## Página 14: XMLHttpRequest - Estructura básica

* *Nota:* Aunque es antiguo, importante para sistemas legados.
* `let ajaxRequest = new XMLHttpRequest();`
* `ajaxRequest.onreadystatechange = function() { ... }`

---

## Página 15: Ciclo de vida de estado (ReadyState)

* 0: sin inicializar
* 1: conexión establecida
* 2: solicitud recibida
* 3: procesando
* 4: respuesta lista

---

## Página 16: Estados HTTP en AJAX

* 200: OK
* 404: Not Found
* 500: Error de servidor

---

## Página 17: Diferencias en respuestas

* `responseText`: Recibe el contenido en texto plano.
* `responseXML`: Recibe el contenido parseado como XML.

---

## Página 18: XMLHttpRequest - Petición GET

```javascript
ajaxRequest.open("GET", "page1.jsp?name=Octavio&age=49", true);
ajaxRequest.send();

```

---

## Página 19: XMLHttpRequest - Petición POST

```javascript
ajaxRequest.open("POST", "page1.jsp", true);
ajaxRequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
ajaxRequest.send("name=Octavio&age=49");

```

---

## Página 20: Asincronía en JS

* Uso de `async function`.
* `await` permite escribir código asíncrono que parece síncrono.

---

## Página 21: Ejemplo de implementación asíncrona [1/2]

* Captura de elementos:

```javascript
let name = "name=" + document.getElementById("nombre").value;
let age = "age=" + document.getElementById("edad").value;

```

---

## Página 22: Ejemplo de implementación asíncrona [2/2]

* Envío:

```javascript
let response = await fetch("/myfirstapp/asincrono", {
    method: "POST",
    body: params
});

```

---

## Página 23: Definición de un Web Service

* Conjunto de protocolos y estándares que sirven para intercambiar datos entre aplicaciones.
* Tipos: SOAP, REST.

---

## Página 24: REST (Representational State Transfer)

* Basado en recursos (URLs).
* Uso de verbos HTTP (GET, POST, PUT, DELETE).
* Formatos comunes: JSON, XML.

---

## Página 25: Integración final

* La importancia de conectar el Front-end (Templates + JS) con el Back-end (Django Views + Modelos).
* Resumen: MVC es fundamental para escalar.

---

### Page 1
**Legacy** (Logotipo estilizado)
* Enviando una solicitud al Servidor Legacy
* Tipo de Solicitud Get | Post
* URL de recurso
* `ajaxRequest.open("GET", target, true /*async*/);`
* `ajaxRequest.send();`
* Envía la solicitud. En solicitudes POST, send puede llevar un parámetro String
* Solicitud asíncrona

---

### Page 2
**Legacy** (Logotipo estilizado)
* Async=true
* Legacy
* El evento se activa cuando se encuentra lista la respuesta del servidor
* Con Callback Function

```javascript
ajaxRequest.onreadystatechange = function(){
  if (ajaxRequest.readyState == 4 && ajaxRequest.status == 200) {
    document.getElementById(id).innerHTML-ajaxRequest.responseText;
  }
}
```

* 200: OK
* 404: Page not found
* 0: solicitud sin inicializar
* 1: conexión con el servidor establecida
* 2: respuesta a solicitud recibida
* 3: procesando la respuesta
* 4: respuesta lista
* Respuesta en texto response Text
* Respuesta en XML responseXML

---

### Page 3
**Legacy** (Logotipo estilizado)
* XMLHttpRequest - Get
* Legacy

```javascript
ajaxRequest.open( "GET", "page1.jsp?name=Octavio &age=49", true);
ajaxRequest.send();
```

* Parámetros

---

### Page 4
**Legacy** (Logotipo estilizado)
* Añade encabezado a la solicitud
* XMLHttpRequest - Post

```javascript
ajaxRequest.open("POST", "page l.jsp", true);
// Legacy[cite: 1]
ajaxRequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
ajaxRequest.send("name=Octavio&age=49");
```
* Nombre del encabezado
* Parámetros
* Valor del encabezado
* 808

---

### Page 5
* Incluyendo JS (asíncrono) Post

```javascript
async function asincrona() {
  let name = "name=" + document.getElementById("nombre").value;
  let age = "age=" + document.getElementById("edad").value;
  let csrfToken = document.querySelector('[name=csrfmiddlewaretoken]').value;
  
  let params = new URLSearchParams({
    name: name,
    age: age});
    
  let response = await fetch("/myfirstapp/asincrono", {
    method: "POST",
    headers : {"Content-Type": "application/x-www-form-urlencoded", "X-CSRFToken": csrfToken},
    body: params
  });
  
  if (response.ok) {
    let text = await response.text();
    alert(text);
  } else {
    alert("HTTP-Error: " + response.status);
  }
}
```

---

### Page 6
*(Imagen descriptiva: Una cascada formada por hojas de papel en blanco fluyendo desde la cima de una montaña, terminando en un documento con la etiqueta `<style>` en la base).*

* Cascading Style Sheets - CSS
* Define como desplegar elementos HTML
* CSS externas ahorran mucho trabajo.
* `</style>`

---

### Page 7
* Sintaxis CSS
* Selector `h1`
* Declaration Declaration `{color:blue; font-size:12px;}`
* ↑ ↑
* Property Value
* ↑ Property Value

---

### Page 8
* Selectores en CSS
* tag
* id
* class
* `*`

---

### Page 9
* El selector tag de CSS
* `p, h1, h2, h3, button, input, a,`

```css
h1 {
  font-family: Arial;
  border-bottom: 1px solid #AFAFAF;
  font-size: 16px;
  font-weight: bold;
  margin: 0px;
  padding: 0px;
  color: #D20005;
}
```

---

### Page 10
* El selector tag y sus estados

```css
a:link, a:visited {
  color: #045491;
  font-weight: bold;
  text-decoration: none;
}

a:link:hover, a:visited:hover {
  color: #045491;
  font-weight: bold;
  text-decoration: underline;
}
```

---

### Page 11
*(Imagen descriptiva: Logotipos de diversos navegadores web, incluyendo Brave, Tor, Firefox, Safari, Edge, Vivaldi, Chrome, Opera, DuckDuckGo y UC Browser).*

* El selector id de CSS
* En CSS

```css
#myparagraph {
  text-align: right;
  color: white;
  background-color: #000000;
  padding: 5px;
}
```

* En página

```html
<p id="myparagraph">
  content
</p>
```

---

### Page 12
* El selector class de CSS
* En página

```html
<p id="myparagraph" class="center content">
  content 1
</p>

<p id="myparagraph" class="right_content">
  content 2
</p>
```

* En CSS

```css
#myparagraph {
  color: white;
  background-color: #000000;
  padding: 5px;
}

.center content {
  text-align: center;
  position: relative;
  background-color: #dddddd;
  padding: 5px;
}
```

---

### Page 13
* Incluyendo CSS
* `static/myfirstapp/style.css`

```css
p {
  color: red;
  text-align: center;
}
```

```html
<head>
  <meta charset="utf-8">
  <title>Este es nuestro index del template</title>
  {% load static %}
  <link rel="stylesheet" type="text/css" href="{% static 'myfirstapp/style.css' %}">
</head>
```
---

### Page 14
*Descripción: Las páginas web son dos, una con los nombres de estudiantes y sus links para ver sus detalles..*

* Práctica de Laboratorio: CSS y Asincronía con Fetch
* Dos páginas
* Detalles del Estudiante:
  * Alvarez Octavio Quinto
  * Garcia Octavio
  * Gutierrez Jose
  * Jimenez Luisa
  * Lopez Jeronimo
  * 1
  * Jose
  * Gutierrez
  * 8.9
  * Foraneo
  * Licenciatura Datos
  * Ingenieria Computacion

---

### Page 15
*Descripción: ahora solo se ve una págian con un drop down de los estudiantes que te deja ver sus detalles.*

* Práctica de Laboratorio: CSS y Asincronía con Fetch
* Requerimientos:
  * Javascript
  * Fetch
  * POST
  * Select creado dinámicamente
  * onchange
  * csrfToken
  * CSS
  * DJANGO
  * JsonResponse
* Una página
* AFTER PAYCHECK
* Explorador de Estudiantes
* Gutierrez Jose
  * Identificador: 1
  * Nombre: Jose
  * Apellidos: Gutierrez
  * Promedio: 8.9
  * Origen: Foráneo
  * Beca: No
  * Carreras:
    * Licenciatura Datos
    * Ingenieria Computacion
