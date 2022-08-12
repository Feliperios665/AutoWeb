@LoginGuru
Feature:  Guru Bank

  Scenario: login a guru
    Given que estoy en la pagina de inicio de guru
    When ingreso mis credenciales de usuario  "vivalavidaloca!"
    And  hago click en login
    And valido que estoy logueado correctamente
