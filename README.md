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
