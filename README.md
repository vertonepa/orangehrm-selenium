# Selenium | Java | TestNG | Maven | Extent Reports
---


## Comando para ejecutar pruebas
---
Mediante CLI podemos ejecutar pruebas de nuestro proyecto Maven de la
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
es el nombre de un archivo .xml donde está definida la ejecución
del test
- Por defecto, las pruebas se corren en modo headless
- Se loggea a la aplicación por consola de forma automática a través de las 
propiedades `username=admin` y `password=admin123`. 

<p>Entonces, el comando anterior es similar a escribir</p>

```bash
./mvnw clean test -Dtests=example-test -Dbrowser=headless -Dusername=admin -Dpassword=admin123
```

Los parámetros están definidos en la clase [CLIParams](src/main/java/runner/CLIParams.java), con excepción del 
parámetro `tests` el cual está definido en el archivo [pom.xml](pom.xml)
