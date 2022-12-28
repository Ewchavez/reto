###### Guia
```
.........................................................................................
```
1 ABRIR EL PROYECTO CON EL IDE INTELLIJ `
2 DESCARGAR LAS DEPENDENCIAS DE MAVEN`
3 INSTALAR EL PLUGIN CUCUMBER`
```
.........................................................................................
```
EJECUCION

UBICARSE DENTRO DEL PROYECTO  E IR A LA RUTA /src/resources/feature

DENTRO DEL FEATURE ABRIR EL ARCHIVO "petstores.feature"

- AHI SE OBSERVARA 5 ESCENARIOS, PARA EJECUTAR COPIAR EL TAG DEL ESCENARIO
EN EL RUNNER TEST, EL CUAL SE UBICA EN /src/test/java/RunTest, ESTO EN TAGS
EJEMPLO: tags = {"@AgregarMascota"} O  SI ES EJECUCION CONSECUTIVA
tags = {"@realizarRegistroDeUsuario",@LoginLogoutUsuario,@AgregarCompra} o dejar vacio para una ejecución completa


UNA VEZ SELECCIONADO EL ESCENARIO EN RUNNER TEST, CLICK DERECHO Y SELECCIONAR RUN
```
.........................................................................................
```
UNA VEZ FINALICE LA EJECUCION

PARA GENERAR EL REPORTE SE DEBE EJECUTAR EL COMANDO MAVEN

mvn post-integration-test -DskipTests

LUEGO DE ELLO SE CREARA UN FILE DE REPORTE WEB EN LA RUTA

\target\cucumber-reports\ test Report\cucumber-html-reports

AHI SE OBSERVARA VARIOS ARCHIVOS HTML
ABRIR EL ARCHIVO overview-tags.html o overview-features.html

DENTRO DEL REPORTE ES OBSERVARA TODOS LOS ESCENARIOS EJECUTADOS 
SELECCIONAR EL DESEADO, UNA VEZ DENTRO SE VERA LA EVIDENCIA CASO POR CASO


SOBRE EL FLUJO "Authorizations", INGRESAR AL HTML "overview-features.html" O A LA OPCIÓN FEATURES, ESTO DEBIDO A QUE 
ES UN FLUJO REPETITIVO PARA CADA ESCENARIO, POR LO QUE ESTE SE ENCUENTRA CON EL TAG ANTECEDENTE







