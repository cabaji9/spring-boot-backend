## SPRING BOOT BACKEND 

El siguiente proyecto esta realizado en spring boot y cuenta con:

- Servicios Rest
- Jpa
- Log
- Gradle 

En la carpetas se encuentra las definiciones:

- controller se encuentra los rest de ejemplo 
- entity -> Entidades
- repository -> Repositorio para realizar JPA
- service -> Servicios que se inyectan en el controlador

En el archivo resources se encuentra application.properties que nos sirve para poder realizar los parametros de la base y la configuración.

El archivo logback-spring.xml nos permite configurar el log.

Se configuró tambien CORS para poder realizar las llamadas con cross-domain a los servicios REST.

Se configuro un unit test.

### EJECUCION

Se compila el proyecto con el siguiente comando 

```
$ gradle build

```

Se ejecuta con el siguiente comando.

```
$ java -jar java -jar build/libs/gs-spring-boot-1.0.0.jar

```
Si se quiere realizar debug añadir:

```
java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n -jar [jar]

```



### INSTALACION DE BASE DE DATOS

Una vez que ya se tenga la base de datos
crear usuario y la base.

```
CREATE USER deep WITH
  LOGIN
  SUPERUSER
  INHERIT
  CREATEDB
  CREATEROLE
  NOREPLICATION;


CREATE DATABASE deep
WITH
OWNER = deep
ENCODING = 'UTF8'
LC_COLLATE = 'C'
LC_CTYPE = 'C'
TABLESPACE = pg_default
CONNECTION LIMIT = -1 TEMPLATE template0;


ALTER USER deep WITH PASSWORD 'deep';

``