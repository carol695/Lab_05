### Escuela Colombiana de Ingeniería

### Procesos de Desarrollo de Software

### INTRODUCCIÓN A PROYECTOS WEB

### INTEGRANTES 

* Carol Tatiana Cely 
* Julian Andres Largo 

## PARTE I. - JUGANDO A SER UN CLIENTE HTTP

1. Abra una terminal Linux o consola de comandos Windows
2. Realice una conexión síncrona TCP/IP a través de Telnet al siguiente servidor:

   Host: www.escuelaing.edu.co
    Puerto: 80
    
    ![image](https://user-images.githubusercontent.com/63822072/197437403-79696d43-02bf-4145-a28c-4b99a0cd3808.png)
    
3. Antes de que el servidor cierre la conexión por falta de comunicación:

    Revise la página 36 del RFC del protocolo HTTP, sobre cómo realizar una petición GET. Con esto, solicite al servidor el recurso ‘sssss/abc.html’,usando la versión 1.0 de HTTP.
    
    Asegúrese de presionar ENTER dos veces después de ingresar el comando.
    
    Revise el resultado obtenido. ¿Qué codigo de error sale?, revise el signific ado del mismo en la lista de códigos de estado HTTP.
    
    ![image](https://user-images.githubusercontent.com/63822072/197437876-4d5d745c-0fcd-4abc-b1c1-baa637893ce2.png)

   ### Se genero el código de error 400: Esta clase de código de estado está pensada para situaciones en las que el error parece haber sido causado por el cliente. Excepto cuando responde a una solicitud HEAD, el servidor debe incluir una entidad que contenga una explicación de la situación de error y si se trata de una condición temporal o permanente. Estos códigos de estado son aplicables a cualquier método de solicitud . Los agentes de usuario deben mostrar cualquier entidad incluida al usuario
    
    ¿Qué otros códigos de error existen?, ¿En qué caso se manejarán?
    
    ### 1xx 
    
    Una respuesta informativa indica que la solicitud fue recibida y entendida. Se emite con carácter provisional mientras continúa la tramitación de la solicitud. Alerta al cliente para que espere una respuesta final. El mensaje consta únicamente de la línea de estado y los campos de encabezado opcionales, y termina con una línea vacía. 
    
    ### 2xx
    
    Esta clase de códigos de estado indica que la acción solicitada por el cliente fue recibida, comprendida y aceptada
    
    ### 3xx
    
    Esta clase de código de estado indica que el cliente debe realizar una acción adicional para completar la solicitud. Muchos de estos códigos de estado se utilizan en la redirección de URL . Un agente de usuario puede realizar la acción adicional sin interacción del usuario solo si el método utilizado en la segunda solicitud es GET o HEAD. Un agente de usuario puede redirigir automáticamente una solicitud. Un agente de usuario debe detectar e intervenir para evitar los redireccionamientos cíclicos.
    
    ### 5xx
    
    El servidor no pudo cumplir con una solicitud.
    
4. Realice una nueva conexión con telnet, esta vez a:
       Host: www.httpbin.org
       Puerto: 80
       Versión HTTP: 1.1
       Ahora, solicite (GET) el recurso /html. ¿Qué se obtiene como resultado?
       
       ![image](https://user-images.githubusercontent.com/63822072/197438334-ffa3a342-afe9-422a-b69f-c99960efdf2e.png)

¡Muy bien!, ¡Acaba de usar del protocolo HTTP sin un navegador Web!. Cada vez que se usa un navegador, éste se conecta a un servidor HTTP, envía peticiones(del protocolo HTTP), espera el resultado de las mismas, y -si se trata de contenido HTML- lo interpreta y dibuja.

5. Seleccione el contenido HTML de la respuesta y copielo al cortapapeles CTRL-SHIFT-C. Ejecute el comando wc (word count) para contar palabras con laopción -c para contar el número de caracteres:

![image](https://user-images.githubusercontent.com/63822072/197438462-0916f5ab-995d-49db-8f17-39f9c637ae31.png)

Claro está, las peticiones GET son insuficient es en muchos casos. Investigue: ¿Cuál es la diferencia entre los verbos GET y POST? ¿Qué otros tipos depeticiones existen?

El GET envia los datos de manera visible, asi cualquier persona que acceda al URL puede ver toda la informacion de este, mientras que el POST los manda ocultos asi no son visibles por el usuario, son muy usados para formularios

Tambien existen las siguientes peticiones:

GET
HEAD
PUT/POST
TRACE

6. En la practica no se utiliza telnet para hacer peticiones a sitios web sino el comando curl con ayuda de la linea de comandos:

![image](https://user-images.githubusercontent.com/63822072/197438800-091fdf15-5b0b-4ee1-b81f-bd46f862da48.png)

Utilice ahora el parámetro -v y con el parámetro -i:

![image](https://user-images.githubusercontent.com/63822072/197438864-b301eaae-42a7-4e4b-a389-f8b9d3ed4916.png)

¿Cuáles son las diferencias con los diferentes parámetros?

curl -v nos muestra el encabezado de la URL y las respuestas esperadas, en pocas palabras nos muestra toda la informacion del GET, la coneccion al puerto 80, la IP a la que se desea acceder y demas informacion, se usa cuando se tienen problemas o se desea validar informacion. El comando curl -i no nos muestra tanta informacion como el -v, alli se ve la hora, el tipo de archivo html, la version del HTTP y la longitud de coneccion.

## PARTE I. - HACIENDO UNA APLICACIÓN WEB DINÁMICA A BAJONIVEL

En este ejercicio, va a implementar una aplicación Web muy básica, haciendo uso de los elementos de más bajo nivel de Java-EE (Enterprise Edition), con el finde revisar los conceptos del protocolo HTTP. En este caso, se trata de un módulo de consulta de clientes Web que hace uso de una librería de acceso a datosdisponible en un repositorio Maven local.

### I. Para esto, cree un proyecto maven nuevo usando el arquetipo de aplicación Web estándar maven-archetype-webapp y realice lo siguiente:

1. Revise la clase SampleServlet incluida a continuacion, e identifique qué hace:

![image](https://user-images.githubusercontent.com/63822072/197439304-37b7b613-06ac-435f-8f5d-551bf4b1cf55.png)

2. En el pom.xml, modifique la propiedad "packaging" con el valor "war". Agregue la siguiente dependencia:

![image](https://user-images.githubusercontent.com/63822072/197439361-3651c0f0-0ada-4a8f-9517-d8bb24462225.png)

![image](https://user-images.githubusercontent.com/63822072/197439428-e19ebf06-1cf5-4392-95b7-23390f803e77.png)

3. Revise en el pom.xml para qué puerto TCP/IP está configur ado el servidor embebido de Tomcat (ver sección de plugins).
4. Compile y ejecute la aplicación en el servidor embebido Tomcat, a través de Maven con:

![image](https://user-images.githubusercontent.com/63822072/197439470-fcfba6eb-953b-45bd-9889-c0686312d32b.png)

