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

## PARTE II. - HACIENDO UNA APLICACIÓN WEB DINÁMICA A BAJONIVEL

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

5. Abra un navegador, y en la barra de direcciones ponga la URL con la cual se le enviarán peticiones al ‘SampleServlet’. Tenga en cuenta que la URL tendrácomo host ‘localhost’, como puerto, el configur ado en el pom.xml y el path debe ser el del Servlet. Debería obtener un mensaje de saludo.

![image](https://user-images.githubusercontent.com/63822072/197439867-c0e2f102-35ea-4530-b4a4-94544bb4646f.png)

6. Observe que el Servlet ‘SampleServlet’ acepta peticiones GET, y opcionalmente, lee el parámetro ‘name’. Ingrese la misma URL, pero ahora agregandoun parámetro GET (si no sabe como hacerlo, revise la documentación en http://www.w3schools.com/tags/ref_httpmethods.asp).

![image](https://user-images.githubusercontent.com/63822072/197439941-b9626dbd-d9eb-4e8d-a872-d9f9ab2263f8.png)

7. Busque el artefacto gson en el repositorio de maven y agregue la dependencia.

![image](https://user-images.githubusercontent.com/63822072/197439988-845d404b-96c7-41c8-8b86-67fb9768157d.png)

8. En el navegador revise la dirección https://jsonplaceholder.typicode.com/todos/1. Intente cambiando diferentes números al final del path de la url.

![image](https://user-images.githubusercontent.com/63822072/197440045-dd7844da-66e9-444a-98b9-ceab613ed019.png)

![image](https://user-images.githubusercontent.com/63822072/197440058-fd0cdafd-2f5a-4944-a72f-30f91e1ca082.png)

![image](https://user-images.githubusercontent.com/63822072/197440081-760b49d7-905d-4252-973d-293d2411a35b.png)

9. Basado en la respuesta que le da el servicio del punto anterior, cree la clase edu.eci.cvds.servlet.model.Todo con un constructor vacío y losmétodos getter y setter para las propiedades de los "To Dos" que se encuentran en la url indicada.

![image](https://user-images.githubusercontent.com/63822072/197440204-cd2136d2-e930-4532-b9d0-12434fc1be62.png)

10. Utilice la siguiente clase para consumir el servicio que se encuentra en la dirección url del punto anterior:

![image](https://user-images.githubusercontent.com/63822072/197440245-a6a94bf0-f8db-4e48-b012-41d37dd04c79.png)

13. Teniendo en cuenta las siguientes métodos disponibles en los objetos ServletRequest y ServletResponse recibidos por el método doGet:

   response.setStatus(N); <- Indica con qué código de error N se generará la respuesta. Usar la clase HttpServletResponse para indicar el código der espuesta.
   
   request.getParameter(param); <- Consulta el parámetro recibido, asociado al nombre ‘param’.
   
   response.getWriter() <- Retorna un objeto PrintWriter a través del cual se le puede enviar la respuesta a quien hizo la petición.
   
   response.setContentType(T) <- Asigna el tipo de contenido (MIME type) que se entregará en la respuesta.Implemente dicho método de manera que:

   Asuma que la petición HTTP recibe como parámetro el número de id de una lista de cosas por hacer (todo), y que dicha identific ación es unnúmero entero.
   
   Con el identificador recibido, consulte el item por hacer de la lista de cosas por hacer, usando la clase "Service" creada en el punto 10.
   
   ### Si el item existe:
   Responder con el código HTTP que equivale a ‘OK’ (ver referencia anterior), y como contenido de dicha respuesta, el código htmlcorrespondiente a una página con una tabla que tenga los detalles del item, usando la clase "Service" creada en el punto 10 par crear la tabla.
   
   ### Si el item no existe:
   
   Responder con el código correspondiente a ‘no encontrado’, y con el código de una página html que indique que no existe un item con elidentific ador dado.
   
   Si no se paso parámetro opcional, o si el parámetro no contiene un número entero, devolver el código equivalente a requerimientoinválido.
   
   Si se genera la excepcion MalformedURLException devolver el código de error interno en el servidorPara cualquier otra excepcion, devolver el código equivalente a requerimiento inválido.
   
   ![image](https://user-images.githubusercontent.com/63822072/197440824-b35b8168-fd42-4a96-86d6-cb20dc5a446b.png)

   14. Una vez hecho esto, verifique e l funcionamiento de la aplicación, recompile y ejecute la aplicación.
   
  ![image](https://user-images.githubusercontent.com/63822072/197440881-6ad88931-fb92-4132-8c84-f2db7d29bdaa.png)

![image](https://user-images.githubusercontent.com/63822072/197440916-068609a5-6759-44e0-9449-b975fb8a7bb8.png)

15. Intente hacer diferentes consultas desde un navegador Web para probar las diferentes funcionalidades.

![image](https://user-images.githubusercontent.com/63822072/197440956-46146384-4f21-4527-9908-7d48e8d7761c.png)

![image](https://user-images.githubusercontent.com/63822072/197440977-55cc48c4-2c85-4eae-801b-c89b71c79d4e.png)

![image](https://user-images.githubusercontent.com/63822072/197440988-2d413711-33e9-4aad-b680-c37068b303f4.png)

## PARTE III.

16. En su servlet, sobreescriba el método doPost, y haga la misma implementación del doGet.

![image](https://user-images.githubusercontent.com/63822072/197441168-f35255c2-1273-4e5a-8da8-2479c15fe38f.png)

17. Cree el archivo index.html en el directorio src/main/webapp/index.html de la siguiente manera:

![image](https://user-images.githubusercontent.com/63822072/197441189-e6a60159-0f48-4a44-9ba5-c55ffc6c977e.png)

18. En la página anterior, cree un formulario que tenga un campo para ingresar un número (si no ha manejado html antes, revisehttp://www.w3schools.com/html/ ) y un botón. El formulario debe usar como método ‘POST’, y como acción, la ruta relativa del último servlet creado(es decir la URL pero excluyendo ‘http://localhost:8080/’).

![image](https://user-images.githubusercontent.com/63822072/197441274-2e0a4cc5-6dfe-4541-9fd5-be0607bd4ac1.png)

19. Revise este ejemplo de validación de formularios con javascript y agruéguelo a su formulario, de manera que -al momento de hacer ‘submit’- desde elbrowser se valide que el valor ingresado es un valor numérico.

![image](https://user-images.githubusercontent.com/63822072/197441300-1d011296-320d-4156-b55d-4ecc6f2eec23.png)

20. Recompile y ejecute la aplicación. Abra en su navegador en la página del formulario, y rectifique que la página hecha anteriormente sea mostrada.Ingrese los datos y verifique los resultados. Cambie el formulario para que ahora en lugar de POST, use el método GET . Qué diferencia observa?

![image](https://user-images.githubusercontent.com/63822072/197441367-2e043893-7329-426a-a3df-d88362d016e2.png)

![image](https://user-images.githubusercontent.com/63822072/197441379-1d5a087b-ac8b-41ad-bce4-328b7b4f2899.png)

![image](https://user-images.githubusercontent.com/63822072/197441391-45ad20f1-aa6c-46a7-8abc-a99946e07836.png)

![image](https://user-images.githubusercontent.com/63822072/197441400-b6fa6c65-d076-431e-acfd-9285002ab21a.png)

![image](https://user-images.githubusercontent.com/63822072/197441410-2eb9b06f-769c-45b4-9cbb-7a07e4741e48.png)

## PARTE IV. FRAMEWORKS WEB MVC – JAVA SERVER FACES /PRIME FACES

En este ejercicio, usted va a desarrollar una aplicación Web basada en el marco JSF, y en una de sus implementaciones más usadas: PrimeFaces. Se trata de unjuego en línea para adivinar un número, en el que el ganador, si atina en la primera oportunidad, recibe $100.000. Luego, por cada intento fallido, el premiose reduce en $10.000

1. Al proyecto Maven, debe agregarle las dependencias mas recientes de javax.javaee-api, com.sun.faces.jsf-api, com.sun.faces.jsf-impl,javax.servlet.jstl y Primefaces (en el archivo pom.xml).

![image](https://user-images.githubusercontent.com/63822072/197441516-f7ba99c9-1d39-4531-887c-0d20daf1038f.png)

2. Para que configur e automáticamente el descriptor de despliegue de la aplicación (archivo web.xml), de manera que el framework JSF se active al iniciode la aplicación, en el archivo web.xml agregue la siguiente configur ación:

![image](https://user-images.githubusercontent.com/63822072/197441550-5f0dfed9-425f-4e98-92d1-b50c9b8d2a43.png)

3. Revise cada una de las configuraciones agregadas anteriormente para saber qué hacen y por qué se necesitan. Elimine las que no se necesiten.

4. Ahora, va a crear un Backing-Bean de sesión, el cual, para cada usuario, mantendrá de lado del servidor las siguientes propiedades:

   a. El número que actualmente debe adivinar (debe ser un número aleatorio).
   
   b. El número de intentos realizados.
   
   c. El premio acumulado hasta el momento.
   
   d. El estado del juego, que sería una cadena de texto que indica si ya ganó o no, y si ganó de cuanto es el premio.
   
 Para hacer esto, cree una clase que tenga:
 
   * el constructor por defecto (sin parámetros)
   
   * los métodos get/set necesarios dependiendo si las propiedades son de escritura o lectura
   
   * coloque las anotaciones:
   
      * @ManagedBean, incluyendo el nombre: @ManagedBean(name = "guessBean").
      * @ApplicationScoped.
         
   A la implementación de esta clase, agregue los siguientes métodos:
   
   * guess: Debe recibir un intento de adivinanza y realizar la lógica para saber si se adivinó, de tal forma que se ajuste el valor del premio y/o actualiceel estado del juego.
   * restart: Debe volver a iniciar el juego (inicializar de nuevo el número a adivinar, y restaurar el premio a su valor original).

![image](https://user-images.githubusercontent.com/63822072/199776135-83d14381-e427-4b6c-bdb2-c8584ac55b9a.png)

![image](https://user-images.githubusercontent.com/63822072/199776197-f89758e3-84d2-4128-b093-a857784c5ba0.png)

![image](https://user-images.githubusercontent.com/63822072/199776244-aa40d4e3-2f38-4e07-a0b6-ef9560584db9.png)

5. Cree una página XHTML, de nombre guess.xhtml (debe quedar en la ruta src/main/webapp). Revise en la página 13 del manual de PrimeFaces, quéespacios de nombres XML requiere una página de PrimeFaces y cuál es la estructura básica de la misma.

![image](https://user-images.githubusercontent.com/63822072/199776575-475c8aff-688c-43c6-aa9c-8615258ec9cc.png)


6. Con base en lo anterior, agregue un formulario con identific ador guess_form con el siguiente contenido básico:

![image](https://user-images.githubusercontent.com/63822072/199776675-e5fa5ffc-87e5-4d10-a866-ee3986457456.png)

![image](https://user-images.githubusercontent.com/63822072/199776793-710ccd7d-8f98-4ec9-896c-aeaeea4716d9.png)


7. Al formulario, agregue:

   a. Un elemento de tipo <p:outputLabel> para el número que se debe adivinar, sin embargo, este elemento se debe ocultar. Para ocultarlo, sepuede agregar el estilo display: none; al elemento. Una forma de hacerlo es por medio de la propiedad style.En una aplicacion real, no se debería tener este elemento, solo se crea con el fin de simplific ar una prueba futura.
   
   b. Un elemento <p:inputText> para que el usuario ingrese su número.
   
   c. Un elemento de tipo <p:outputLabel> para mostrar el número de intentos realizados.
   
   d. Un elemento de tipo <p:outputLabel> para mostrar el estado del juego.e. Un elemento de tipo <p:outputLabel> para mostrar en cuanto va el premio.Y asocie dichos elementos al BackingBean de sesión a través de su propiedad value, y usando como referencia el nombre asignado:

![image](https://user-images.githubusercontent.com/63822072/199776996-4708ba56-1cc7-4c25-8990-136aa2b1c23b.png)

![image](https://user-images.githubusercontent.com/63822072/199777124-60e7f5db-451d-4e1b-97a6-450bb5b7bfd9.png)


8. Al formulario, agregue dos botones de tipo <p:commandButton>, uno para enviar el número ingresado y ver si se atinó, y otro para reiniciar el juego.

a. El botón de envío de adivinanza debe tener asociado a su propiedad update el nombre del formulario en el que se agregaron los campos antesdescritos, de manera que al hacer clic, se ejecute un ciclo de JSF y se refresque la vista.

b. Debe tener también una propiedad actionListener con la cual se le indicará que, al hacer clic, se ejecutará el método guess, creado en elbacking-bean de sesión:

![image](https://user-images.githubusercontent.com/63822072/199777472-a83db825-a37e-4720-a406-33f8b86da33d.png)

c. El botón de reiniciar juego tendrá las mismas propiedades de update y actionListener del otro con el valor correspondiente:

![image](https://user-images.githubusercontent.com/63822072/199777526-a1177627-6912-4b70-b23f-2d5f11609af4.png)

### Resultado 

![image](https://user-images.githubusercontent.com/63822072/199777339-6468d9e2-bb5f-4b69-9fc3-0a5fe0e01e94.png)

9. Para verific ar el funcionamiento de la aplicación, agregue el plugin tomcat-runner dentro de los plugins de la fase de construcción (build). Tenga encuenta que en la configur ación del plugin se indica bajo que ruta quedará la aplicación:

a. mvn package
b. mvn tomcat7:run

Si no hay errores, la aplicación debería quedar accesible en la URL: http://localhost:8080/faces/guess.xhtml

![image](https://user-images.githubusercontent.com/63822072/199778650-eaf03cb6-c352-40bf-88f0-44815eaee40e.png)


10. Si todo funcionó correctamente, realice las siguientes pruebas:a. Abra la aplicación en un explorador. Realice algunas pruebas con el juego e intente adivinar el número.

![image](https://user-images.githubusercontent.com/63822072/199778837-0daab1c9-8505-4f54-9e24-58e97760db60.png)


![image](https://user-images.githubusercontent.com/63822072/199779359-41fad266-aca6-48f4-a338-311806672529.png)

