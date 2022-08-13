#language: es
@Liniologin
Característica: Login Linio
  Yo, como usuario
  Quiero, tener una opción para iniciar sesión
  Para ver todos los productos y añadirlo al carrito de compras

  @test
  Escenario: Iniciar sesión en Linio
    Dado que me encuentro en la página de login de Linio
    Cuando inicio sesión con las credenciales email: "probrandotes@gmail.com" y contraseña: "probando1230..."
    Y hago click en el botón Iniciar Sesión Segura
    Entonces valido que debería aparecer mi username "probando" en el icono de user profile
    Y hago click en mejores calificados
    Y selecciono cualquier producto
    Y añado al carrito
    Y valido que debia aparecerme este mensaje: "Tu producto se agregó al carrito"