# prueba_farmatodo

Antes de iniciar el proyecto, se recomienda ejecutar los scripts sql en el esquema publico, estos scripts se ubican en la ruta especificada por la prueba

1. Ejecutar el proyecto spring en su ide de preferencia.

2. Servicios, todos los servicios corren por POST el cuerpo de la peticion se maneja como raw -> JSON

 2.1 Ejecucion Servicio episodios rick y morty
   *Direccion del servicio para pruebas locales: http://localhost:9095/api/consultar/episodio
   *Direccion del servicio para pruebas en el despliegue heroku: https://prueba-farmatodo.herokuapp.com/api/consultar/episodio


   *Cuerpo de la peticion:
   {
    "nmro_episodio": 10 (Este es el numero del episodio a buscar)
    }

 2.2 Ejecucion Servicio listado de numeros felices
   *Direccion del servicio: http://localhost:9095/api/consultar/numeros/felices
   *Direccion del servicio para pruebas en el despliegue heroku: https://prueba-farmatodo.herokuapp.com/api/consultar/numeros/felices
   
   *Cuerpo de la peticion:
   {
    "numeros": [10,5,22] (Listado de numeros a evaluar)
   }

2.3 Ejecucion Servicio sumatoria de numeros naturales
   *Direccion del servicio: http://localhost:9095/api/sumatoria/numeros/naturales
   *Direccion del servicio para pruebas en el despliegue heroku: https://prueba-farmatodo.herokuapp.com/api/sumatoria/numeros/naturales
   
   *Cuerpo de la peticion:
   {
    "numero":10 (numero de veces a sumar)
   }


3. Pruebas unitarias, para las pruebas del punto 4 correr la clase "NumerosServiceImplTest" ubicada en la carpeta a nivel de proyecto: test/java/com.prueba.farmatodo/services