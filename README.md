# Descripción
Este proyecto se creó a modo de ejemplo para integrar codigo C/C++ en un proyecto de Android utilizando JNI y NDK.
A continuación están los pasos a seguir para lograr este integración.

# Demostración
La aplicación Android suma dos numeros enteros, cada vez que se hace un cambio en alguno de los numero se realiza de nuevo la suma, esta
suma está hecha en el lenguaje C.

![Demo](https://github.com/CrissAlvarezH/ImagenesRepos/blob/master/imgs/AddCodigoCEnAndroid/demo.gif)

# Guía

Esta guía está separada en varias partes, la integración de codigo C en el cual
muestro como escribir codigo C en un proyecto de Android, la creación de las librerías compartidas `.so` y por ultimo
el consumo de dichas librerias.

## Integración con codigo C

<img alt="Clase con metodo navite"  src="https://github.com/CrissAlvarezH/ImagenesRepos/blob/master/imgs/AddCodigoCEnAndroid/clase_nativa.png" />

Empezamos creando una clase en Java que contendrá los metodos que se escribirán en C. Como puedes notar utilizamos la palabra reservada
`native` para declarar el metodo, tambien puedes notar que no tiene cuerpo, esto es porque el cuerpo se lo definiremos en C.

</br>

<img alt="Compilar clase nativa" src="https://github.com/CrissAlvarezH/ImagenesRepos/blob/master/imgs/AddCodigoCEnAndroid/compilar_clase_nativa.png" />

Compilamos la clase que acabos de crear utilizando `javac`, esto nos dará como resultado un `.class` 

</br>

<img alt="Crear cabecera" src="https://github.com/CrissAlvarezH/ImagenesRepos/blob/master/imgs/AddCodigoCEnAndroid/crear_cabecera_de_java.png" />

Ahora creamos el fichero de cabecera JNI para dicha clase, esto lo hacemos con el comando </br>
`javah -c java <nombre del paquete>.<nombre de la clase>`, posteriormente
creamos un directorio llamado `jni` y movemos nuestro `.h` recién creado dentro.

<img alt="Cabecera" src="https://github.com/CrissAlvarezH/ImagenesRepos/blob/master/imgs/AddCodigoCEnAndroid/cabecera_clase_nativa.png" />

Al abrir el archivo podemos ver que contiene la función que hemos declarado en `ClaseNativa.java`, pero su nombre tiene la siguiente estructura
`Java_<nombre del paquete separado por guión bajo>_<nombre de la clase>_<nombre de la función>`.

</br>

<img alt="Crear c" src="https://github.com/CrissAlvarezH/ImagenesRepos/blob/master/imgs/AddCodigoCEnAndroid/crear_c_copiado_de_cabecera.png" />

Ahora debemos crear el codigo C asociado a esa cabecera, para esto copiamos el archivo y lo pegamos en la misma carpeta pero le cambiamos la 
extención de `.h` a `.c` y le hacemos los siguientes cambios

</br>

<img alt="Codigo c jni" src="https://github.com/CrissAlvarezH/ImagenesRepos/blob/master/imgs/AddCodigoCEnAndroid/codigo_c_con_jni.png" />

En el archivo `.c` que creamos en el anterior paso vamos implementar el codigo C de la función, le definimos los parametros y le creamos
el cuerpo a la función. Aquí lo que vemos es una simple suma hecha en el lenguaje C.

</br>

## Crear librearías compartidas `.so`

Ahora que ya tenemos el codigo hecho lo que resta es crear las librerías para su posterior consumo en el codigo Java.

</br>

<img alt="Android mk" src="https://github.com/CrissAlvarezH/ImagenesRepos/blob/master/imgs/AddCodigoCEnAndroid/archivo_android_mk.png" />

Creamos un archivo llamado `Android.mk` en la carpeta `jni` el cual tendrá las ordenes necesarias para la creación de las librerías.
Una vez hecho esto podemos proceder a crear las librerías.

</br>

<img alt="Comando ndk-build" src="https://github.com/CrissAlvarezH/ImagenesRepos/blob/master/imgs/AddCodigoCEnAndroid/comando_ndk-build.png" />

El comando `ndk-build` realiza la tarea de construir las librerías para cada una de las arquitecturas, si lo deseamos podemos especificarle
que arquitecturas quemos pasandole el parametro `APP_ABI = x86` por ejemplo.
Sin embargo, otra forma de hacerlo es crear un archivo `Application.mk` (opcional) en la carpeta `jni` donde especifiquemos esto.

</br>

<img alt="Application mk" src="https://github.com/CrissAlvarezH/ImagenesRepos/blob/master/imgs/AddCodigoCEnAndroid/archivo_application_mk.png" />

Aquí especificamos que queremos todas las arquitecturas.

</br>

<img alt="Librerías compiladas" src="https://github.com/CrissAlvarezH/ImagenesRepos/blob/master/imgs/AddCodigoCEnAndroid/librerias_compiladas.png" />

La ejecución del anterior comando nos da como resultado las librerías para todas las arquitecturas en una carpeta llamada `libs`.

## Consumo de las librerías

Ahora procedemos a la parte mas sencilla, utilizar las librerías para ejecutar el codigo C en nuestro proyecto Android. Para esto debemos
renombrar la carpeta `libs` a `jniLibs` y despues agregar las siguientes lineas de codigo a nuestra clase `ClaseNativa.java`

<img alt="Librerías compiladas" src="https://github.com/CrissAlvarezH/ImagenesRepos/blob/master/imgs/AddCodigoCEnAndroid/clase_nativa_loadlibrary.png" />

El nombre debe ser el de la librería sin el prefijo `lib`y sin la extención `.so`

Y con todo esto ya podremos hacer uso de nuestra suma en C llamando a la funcion `ClaseNativa.sumar()`.

