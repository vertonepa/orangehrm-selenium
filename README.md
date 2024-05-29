# Selenium | Java | TestNG | Maven | GitHub Actions CI

---

## Requisitos
Para poder realizar pruebas con este proyecto se debe:

- **Tener instalado Git**
- **Instalar JDK temurin-11.0.22**
- **Configurar las correspondientes variables de entorno**


## Introducción

Proyecto de automatización end-to-end que tiene el objetivo de presentar
mi forma de trabajar el desarrollo de casos de prueba automatizados con Selenium + Java.

El patrón de diseño elegido para organizar las pruebas es el Page Object
Model (POM), cada modelo de página se encuentra en la carpeta
[pages](src/main/java/pages).

Las pruebas, además, están preparadas para ejecutarse en Chrome
y Firefox sobre las últimas versiones de los sistemas operativos
Windows y Ubuntu a través de un workflow de GitHub Actions.
Una vez pasada la ejecución se generarán
los reportes correspondientes como artefactos descargables.


### Organización:

El repositorio se organiza en ramas: `master`, `qa` y `feature/...`.

La rama `qa` es en donde se integra todo el trabajo de una feature.

En las ramas `feature/...` se crea el test set de una historia de usuario,
en estas ramas se desarrollan todos los casos de prueba, se ejecutan localmente,
se crean reportes.

Una vez ubicados en el proyecto

![organization](https://i.postimg.cc/4NPRWrRy/organization.png)

Dentro de `src` se encuentran las carpetas `main` y `test`, el primero
va a contener el manejo de los drivers, generación de reportes,
utilidades del framework, modelos de página,
listeners, manejo de excepciones personalizadas, entre otros.

En `test` se coloca, únicamente, todo lo que tenga que ver
con la lógica de las pruebas.



### Mecánica de trabajo en este proyecto

**[ 1 ]** Se posiciona en la rama `qa` y ejecutar el comando `git pull origin` para actualizar la rama

**[ 2 ]** Se crea una rama `feature/...`, ejemplo:
``` bash
git checkout -b feature/new-feature
```

**[ 3 ]** Se crea una clase de prueba en [testcases](src/test/java/testcases), esta debe extender
de **BaseTest**.

**[ 4 ]** Se crea un archivo .xml en la carpeta test-suites, por ejemplo, `US01-new-test-excecution.xml`.
La estructura de los archivos de ejecución de este proyecto es la siguiente:
```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >

<suite name="Test Suite 01">
  <!-->
     CustomListener escucha los eventos que suceden en la clase de prueba 
     y genera reportes a través de ello
  <-->
    <listeners>
        <listener class-name="listener.CustomListener"/>
    </listeners>
    <test name="Test">
        <classes>
          <!-->
             Indicar el nombre de la clase que contiene los TCs que planea ejecutar
             en la rama feature que esté trabajando
          <-->
            <class name="testcases.TS01_NewTestSuite"/>
        </classes>
    </test>
</suite>
```

**[ 5 ]**

Se dirige al archivo [CI-Suite.yml](.github/workflows/CI-Suite.yml) y modificar el step "Run the tests"
```yaml
      - name: Run the tests
        run: echo ./mvnw clean test -Dtests=example-test -Dbrowser=${{matrix.browser}} -Dusername=${{secrets.USERNAME}} -Dpassword=${{secrets.PASSWORD}
```
cambiando `-Dtests=example-tests` para que apunte al archivo de ejecución de la
actual feature que estemos trabajando, tomando el ejemplo anterior: `-Dtests=US01-new-test-excecution` (Importante: NO indicar la extensión .xml, solo filename)

**[ 6 ]** Se agrega un archivo markdown a la carpeta `docs` que documente la funcionalidad
que se va a probar

**[ 7 ]**

Una vez hecho esto, se envía como primer cambio al repositorio remoto de forma correspondiente:
- `git add xyz`: _xyz_ representa cada carpeta a agregarse
- `git commit -m "primer commit us-n"`
- `git push --set-upstream origin new-example-feature-branch`

NOTA 1: al ser un proyecto de trabajo para una sola persona no hace falta
actualizar repositorio local antes de pushear.

NOTA 2: cuando se trabaja en una feature solo agregar a stage las siguientes carpetas:
```bash 
git add .github
```
```bash 
git add docs
```
```bash 
git add src
```
```bash 
git add test-suites
```

**[ 8 ]** A partir de este momento se comienza a repetir un ciclo
donde se agregan nuevos cambios en remoto hasta terminar con las pruebas.
Luego, enviar PR y mergear los cambios en rama `qa`.

**[ 9 ]** Se dirige a la rama `qa` en el repositorio local y ejecutar `git pull`
para traer los cambios actualizados del remoto.



## Comandos de ejecución de pruebas

Mediante CLI se pueden ejecutar pruebas localmente de la
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

Este framework tiene una integración con ExtentReports, cada vez
que se ejecute una prueba se generará un reporte HTML que puede ser
consultado.
Toda la información necesaria para un reporte se detallará en él:
- autores de los tests
- horario de la última ejecución
- porcentaje de tests que pasaron, fallaron y fueron salteados

![test-local-cap-1](https://i.postimg.cc/VvFBvTZS/test-local-cap-1.png)
![test-local-cap-2](https://i.postimg.cc/prvJ2xCb/test-local-cap-2.png)

También se generarán artefactos de reportes luego de ejecutar los
tests de forma remota en GitHub Actions, estos están disponibles para
descargar y chequear.

![artifact-reports](https://i.postimg.cc/QNgqf9NX/artifact-reports.png)
