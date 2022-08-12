@LoginGuru
Feature:  Guru Bank

  Scenario: login a guru
    Given que estoy en la pagina de inicio de guru
    When ingreso mis credenciales de usuario "68195" y contraseña "1234!"
    And  hago click en login
    And valido que estoy logueado correctamente
