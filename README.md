# Pruebas Automatizadas para OrangeHRM

Este proyecto contiene pruebas automatizadas utilizando Selenium WebDriver, Java y Cucumber para evaluar diferentes funcionalidades de la página web OrangeHRM. Se utiliza el entorno de desarrollo IntelliJ IDEA para escribir, organizar y ejecutar las pruebas.

## Requisitos previos

Antes de comenzar, asegúrate de tener lo siguiente instalado en tu sistema:

- IntelliJ IDEA
- Java Development Kit (JDK)
- Dependencias de Maven en el archivo `pom.xml`

## Estructura del Proyecto

La estructura del proyecto se organiza de la siguiente manera:

### Directorio `src`

1. **main**
   - `java`
     - `pages`: Contiene clases que representan diferentes páginas y componentes de la aplicación web.
     - `utilities`: Incluye utilidades para la ejecución de pruebas, como la clase `DriverManager` que proporciona el controlador de Selenium WebDriver.
2. **test**
   - `java`
     - `stepDefinitions`: Contiene las clases de definición de pasos para las pruebas.
     - `utils`: Contiene utilidades para las pruebas, como `screenRecorderUtil`.
     - `TestRunner`: Desde aquí se ejecutan las pruebas. Haz clic derecho y selecciona "Run" en `TestRunner` para ejecutar las pruebas.
   - `resources`: Contiene los archivos `.feature` y `extent.properties`.

### Directorio `test-output`

En este directorio se encuentran los reportes generados por las pruebas:

1. **HTML Report**
   - `HTMLReport`
     - `Extent.html`: Abre este archivo en tu navegador preferido para ver el reporte HTML de las pruebas.

2. **PDF Report**
   - `PdfReport`
     - `ExtentPdf.pdf`: Abre este archivo en tu explorador de archivos para ver el reporte PDF de las pruebas.

3. **Spark Report**
   - `SparkReport`
     - `Spark.html`: Abre este archivo en tu navegador preferido para ver el reporte Spark de las pruebas.

## Ejecución de Pruebas

Para ejecutar las pruebas, sigue estos pasos:

1. Abre el proyecto en IntelliJ IDEA.
2. Asegúrate de que las dependencias de Maven se hayan descargado correctamente.
3. Navega hasta la ubicación de los archivos `.feature` en `src → test → resources`.
4. Selecciona el archivo `.feature` que deseas ejecutar (por ejemplo, `Login.feature`).
5. Haz clic derecho en el archivo `.feature` seleccionado y selecciona "Run" para ejecutar esa prueba específica.

### Nota sobre Admin.feature

Para el archivo `Admin.feature`, se deben ejecutar ambas pruebas (agregar y eliminar empleado) juntas para que funcione correctamente. Puedes hacerlo seleccionando `Admin.feature`, haciendo clic derecho y eligiendo "Run".

También puedes ejecutar todas las pruebas desde `TestRunner` para generar los reportes.

## Notas adicionales

- Las pruebas son ejecutadas utilizando el framework JUnit y Cucumber.