# techShop
Servicios básicos para gestionar procesos de actividad comercial de una tienda


En el repositorio es posible encontrar el proyecto backend en spring-boot junto a sus respectivas pruebas unitarias en junit.
Adicional a eso se adjunta coleccion de postman para realizar llamadas a los servicios. EL proyecto se encuentra pre-cargado con data para el inventario de la tienda,
sin embargo su contenido se puede modificar si así se requiere.

Por otro lado, la cuenta o factura del cliente se inicializa sin ningún valor y se puede ir agregando productos con los servicios del proyecto. Para probar una ejecucion
rápida de los servicios es posible hacerlo mediante las pruebas unitarias, o si se desea hacer cargas o modificaciones más puntuales se puede utilizar la coleccion de postman.

Finalmente el proyecto está desarrollado con una base de datos en MYSQL y se conecta a la base que se crea por defecto llamada sys, para modificar este valor se puede hacer en el archivo
application.properties.

