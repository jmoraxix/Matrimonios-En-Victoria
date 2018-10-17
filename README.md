# Matrimonios-En-Victoria

[![Build Status](https://dev.azure.com/efloresg934/Matrimonios%20En%20Victoria/_apis/build/status/jmoraxix.Matrimonios-En-Victoria)](https://dev.azure.com/efloresg934/Matrimonios%20En%20Victoria/_build/latest?definitionId=1)

Trabajo de AnaÌ�lisis, DisenÌƒo e ImplementacioÌ�n de Sistemas. Tercer Cuatrimestre, 2018. Ulacit.

1. Crear un archivo nombrado settings.xml en la carpeta .m2 en su directorio de home con el siguiente contenido:
```
<settings>
  <servers>
    <server>
      <id>TomcatServer</id>
      <username>user</username>
      <password>password</password>
    </server>
  </servers>
</settings>
```
2. Actualizar el usuario y la contraseÃ±a con los utilizados en su configuraciÃ³n de Tomcat.
3. Hacer deploy de la aplicaciÃ³n al servidor:
```
mvn tomcat7:deploy
```
To skip tests use:
```
mvn tomcat7:deploy -DskipTests
```