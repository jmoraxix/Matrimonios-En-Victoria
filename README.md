# Matrimonios-En-Victoria
Trabajo de Análisis, Diseño e Implementación de Sistemas. Tercer Cuatrimestre, 2018. Ulacit.

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
2. Actualizar el usuario y la contraseña con los utilizados en su configuración de Tomcat.
3. Hacer deploy de la aplicación al servidor:
```
mvn tomcat7:deploy
```
To skip tests use:
```
mvn tomcat7:deploy -DskipTests
```