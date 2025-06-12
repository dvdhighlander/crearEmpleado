<h1> SERVICIO CREAR EMPLEADO</h1> 
<h2> CONECCION A URL </h2> 

Se crearon 2 servicios, un servicio SOPA para crear el empleado, y un serrvicio REST GET que llama el servicio anterior </br>
<h3> ENDPOINTS DISPONIBLES REST </h3> 
Hay un SWAGGER disponible: http://localhost:8080/swagger-ui/index.html#/employees-controller/createEmployee
<h4>- Servicio REST para crear nuevo empleado: </h4> 
<b>METODO:</b> GET</br>
<b>PUERTI:</b> 8080</br>
<b>URL:</b> http://localhost:8080/employee/create</br>
<b>NOTAS:</b> Debe recibirlos siguientes parametros:</br>
- nombre</br>
- apellido</br>
- tipoDocumento</br>
- docuento</br>
- fechaNacimiento</br>
- fechaVinculacion</br>
- cargo</br>
- salario</br>
Las fechas deben ir en formato <b>yyyy-MM-dd</b>
<h4>- Servicio SOAP para crear nuevo empleado: </h4> 
<b>PUERTO:</b> 8081</br>
<b>URL:</b> localhost:8081/ws/employee.wsdl</br>
<b>NOTAS:</b> El wsdl se puede obtener de esa dirección con el servicio corriendo, o hay una copia dentro del proyecto Employees, pero esta apunta a localhost, por lo que habria que editarla y cambiar la linea:</br>
<soap:address location="http://localhost:8081/ws" /></soap:address>br>
por la url donde se despliegue este servicio

<h2> CONECCION A BASE DE DATOS </h2> 
La base de datos utilizada fue MySQL tal y cmo se pidio en el ejercicio</br>
El scripts para la creación de la tabla es:</br>

CREATE TABLE `defaultdb`.`empleado` (</br>
  `id` INT NOT NULL,</br>
  `nombre` VARCHAR(100) NOT NULL,</br>
  `apellido` VARCHAR(100) NOT NULL,</br>
  `tipoDocumento` VARCHAR(10) NOT NULL,</br>
  `documento` VARCHAR(100) NOT NULL,</br>
  `fechaNacimiento` DATE NOT NULL,</br>
  `fechaVinculacion` DATE NOT NULL,</br>
  `cargo` VARCHAR(45) NOT NULL,</br>
  `salario` DOUBLE NOT NULL,</br>
  PRIMARY KEY (`id`)); </br>
<h2> CONFIGURACIONES NECESARIAS </h2> 
<b>Para correr el código fuente se necesita:</br></b>
     - JAVA 17</br>
     - Maven
     - SpringBoot 3.4.5</br>
     - MySQL 8</br>
  </br>   
- En el proyecto CreateEmployee se debe ajustar la configuración para conetar a la BD en el archivo: application.properties.</br>
  Se debe cambiar la URL, el Usuario y la Clave.</br>
- Se debe cambiar en el WSDL en el proyecto Employee la URL donde esta desplegado el servicio wsdl, si se este se desplegó en un ambiente diferente a localhost
