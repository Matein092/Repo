Para desplegar este proyecto se puede hacer de diferentes maneras de acuerdo el IDE utilizado,
en mi caso utilice Eclipse, por lo cual para correrlo se da clic derecho sobre la carpeta del proyecto
después seleccionar RUN AS maven build y en la sección del Goal escribir:quarkus:dev, 
para otros entornos como consola la aplicacion se levantara con el comando mvn quarkus:dev, 
y para verificar los JUNITS test mvn test.

5.3 Diagnostico de LOGS
En el primer punto se nos pide identificar la causa raiz de la excepcion lanzada, lo cual es producto de que el programa esta intentando
convertir una cadena no numerica en este caso "abc" a un numero entero, por lo que la excepcion indica que la entrada no pudo ser validada
En cuanto a que implementaria para prevenir este error a futuro, desarrollaria una validacion de la entrada y que cumpla con los párametros 
para poder ser convertido a un numero entero. El nivel del log es el adecuado ya que el error detiene la ejecucion por el simpleSchdule y se indica el fallo, pero podria mejorar si se especificara que se esperaba un valor numerico.
5.4 Preguntas AWS
1. Preferiria utilizar EC2 a cambio de lambda en proyectos en los que el control total sobre el proyecto es necesario ya que lambda solo es optimo en escenarios donde las tareas no duran mas de cierto tiempo (15min).
2.  Cloud Watch: Sirve para monitorear el rendimiento de los recursos y aplicaciones AWS tales como el uso de CPU, memoria, entre otros.
   X-ray: Sirve para el rastreo y depuracion de solicitudes para identificar cuellos de botella
   CloudTrail: sirve para el registro de las acciones que son llevadas acabo sobre los servicios de AWS, para asi obtener un cumplimiento de auditoria y seguridad.

5.5
1. SELECT FROM productos
   WHERE price > 100000
   ORDER BY price DESC
   LIMIT 5;
2. Se evidencia la mejora cuando las consultas que se realizan son frecuentes con filtros o cuando son especificas a busquedas por nombre,
3. para estos casos lo que el indice hace es acelerar la localizacion ahorrandonos la busqueda total.
