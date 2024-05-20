# Selenium | Java | TestNG | Maven | GitHub Actions CI

## Introducción 

---
Este es un mini proyecto de automatización end-to-end que 
tiene la intención de presentar una forma de trabajar el
desarrollo de casos de prueba automatizados con Selenium + Java.
<p>
El patrón de diseño elegido para organizar las pruebas es el Page Object
Model (POM), cada modelo de página lo encuentra en el directorio 
[pages](https://github.com/vertonepa/orangehrm-selenium/tree/qa/src/main/java/pages).
<p>
Tambien se pueden ejecutar las pruebas en Chrome 
y Firefox sobre las últimas versiones de los sistemas operativos 
Windows y Ubuntu a través de un pipeline de integración continua 
de GitHub Actions. Una vez pasada la ejecución se generarán 
los reportes correspondientes como artefactos descargables.


## Comandos de ejecución de pruebas

---
Mediante CLI podemos ejecutar pruebas localmente de la
siguiente manera: 
```bash
./mvnw clean test -Dtests=example-test
```
Donde:
- `./mvnw` es el comando del Maven Wrapper del que se hace uso
en este proyecto.
- Toda la instrucción `./mvnw clean test` asegura que las pruebas se ejecuten en un entorno limpio
- Luego de esto se utilizan propiedades establecidas en el proyecto para 
dar la directiva de qué archivo de pruebas se va a correr y en qué navegador

**Parámetros del proyecto:** 
```bash
./mvnw clean test -Dtests=example-test
```
Tomando el ejemplo anterior se puede decir lo siguiente
- El parámetro `tests` contiene el argumento `example-test`. Este argumento
es el nombre de un archivo de extensión .xml donde está definida la ejecución
del test
- Por defecto, las pruebas se corren en modo headless
- Se loggea a la aplicación por consola de forma automática a través de las 
propiedades `username=Admin` y `password=admin123` (en un entorno real estos datos estarían ocultos
o se ingresarían de forma manual). 

<p>El comando anterior es similar a escribir</p>

```bash
./mvnw clean test -Dtests=example-test -Dbrowser=headless -Dusername=admin -Dpassword=admin123
```

Los parámetros están definidos en la clase [CLIParams](src/main/java/runner/CLIParams.java), con excepción del 
parámetro `tests` el cual está definido en el archivo [pom.xml](pom.xml)


## Reportes

---
Este framework tiene una integración con ExtentReports, cada vez
que se ejecute una prueba se generará un reporte HTML que puede ser
consultado.
Toda la información necesaria para un reporte se detallará en él:
- autores de los tests 
- horario de la última ejecución
- porcentaje de tests que pasaron, fallaron y fueron salteados

![ejemplo de reporte de prueba local](img/test-local-cap-1.png)
![ejemplo de metricas de prueba local](img/test-local-cap-2.png)

También se generarán artefactos de reportes luego de ejecutar los
tests de forma remota en GitHub Actions, estos están disponibles para 
descargar y chequear.
![artefactos en gha](img/artifact-reports.png)


