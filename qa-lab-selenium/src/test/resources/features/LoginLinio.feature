@Linio

Feature: Linio

  Scenario: login y compra en linio
    Given que estoy en la pagina de inicio de sesion Linio
    When ingreso mis datos de usuario "feliperios878@gmail.com" y contraseña "vivalavidaloca"
    And  hago click en inisiar secion segura
    And valido que estoy en la pagina principal
    And hago click en mejores calificados
    And seleccion un producto
    And añado al carrito