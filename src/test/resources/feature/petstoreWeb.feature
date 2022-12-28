#language: es
Característica: Consulta Petstore Web

  Antecedentes:
    Dado cargo la pagina petstore3 en "Chrome"
    Y ingreso a la opcion "Authorize"
    Cuando obtengo el usuario autorizador
    Entonces procedo a autorizar al usuario


  @ListarPets
  Esquema del escenario: Listar Mascotas <ID_Caso>
    Dado que despliego la opcion "listar mascotas"
    Y busco mascotas con status "<status>"
    Cuando ejecuto la operacion
    Entonces valido el codigo respuesta "<codigo>"
    Ejemplos:
      | ID_Caso | status    | codigo |
      | CP001   | available | 200    |
      | CP002   | --        | 400    |

  @CrearPet
  Esquema del escenario: Crear Mascotas <ID_Caso>
    Dado que despliego la opcion "crear mascota"
    Y creo la mascota "<nombre>" con el numero id "<numero>"
    Cuando ejecuto la operacion
    Entonces valido el codigo respuesta "<codigo>"
    Ejemplos:
      | ID_Caso | nombre | numero | codigo |
      | CP001   | dogi   | 21     | 200    |
      | CP002   | sazon  | id     | 400    |

  @ActualizarPet
  Esquema del escenario: Actualizar Mascotas <ID_Caso>
    Dado que despliego la opcion "actualizar mascota"
    Y actualizo la mascota con id "<numero>", con el nombre "<nombre>"
    Cuando ejecuto la operacion
    Entonces valido el codigo respuesta "<codigo>"
    Ejemplos:
      | ID_Caso | nombre | numero | codigo |
      | CP001   | dogi   | 21     | 200    |
      | CP002   | sazon  | id     | 400    |


  @EliminarPet
  Esquema del escenario: Actualizar Mascotas <ID_Caso>
    Dado que despliego la opcion "eliminar mascota"
    Y elimino la mascota con numero id "<numero>"
    Cuando ejecuto la operacion
    Entonces valido el codigo respuesta "<codigo>"
    Ejemplos:
      | ID_Caso | numero                            | codigo |
      | CP001   | 10                                | 200    |
      | CP002   | 211111111112222222333333333333331 | 400    |
