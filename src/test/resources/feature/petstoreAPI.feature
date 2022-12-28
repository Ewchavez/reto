#language: es
Característica: Consulta Petstore APIS


  @AgregarMascota
  Esquema del escenario:  Agregar Mascota<ID_Caso>
    Dado que agrego la mascota "<mascota>"
    Y valido el codigo espera "200"
    Entonces consulto la mascota previamente consultada
    Ejemplos:
      | ID_Caso | mascota                             |
      | CP001   | NohayFormadeHacerCaer21=[23[2/.,:{} |

  @ListarMascotas
  Esquema del escenario:  Lista mascotas <ID_Caso>
    Dado que obtengo una lista de mascotas con estado "<estado>"
    Y valido el codigo espera "<codigo>"
    Ejemplos:
      | ID_Caso | estado       | codigo |
      | CP001   | available    | 200    |
      | CP002   | siLlegaaCAer | 400    |
      | CP003   | sold         | 200    |
      | CP004   | pending      | 200    |
      | CP005   | sinCODIGO    | 400    |

  @ActualizoMascota
  Esquema del escenario:  Actualizar Mascota <ID_Caso>
    Dado que agrego la mascota "<mascota>"
    Entonces valido el codigo espera "200"
    Y consulto la mascota previamente consultada
    Entonces valido el codigo espera "200"
    Y modifico la mascota previamente creada
    Entonces valido el codigo espera "200"
    Y consulto la mascota previamente consultada
    Entonces valido el codigo espera "200"
    Ejemplos:
      | ID_Caso | mascota                             |
      | CP001   | PELUDO                              |
      | CP002   | NohayFormadeHacerCaer21=[23[2/.,:{} |

  @EliminarMascota
  Esquema del escenario:  Eliminar Mascota <ID_Caso>
    Dado que agrego la mascota "<mascota>"
    Entonces valido el codigo espera "200"
    Y consulto la mascota previamente consultada
    Entonces valido el codigo espera "200"
    Y elimino la mascota previamente consultada
    Entonces valido el codigo espera "200"
    Y consulto la mascota previamente consultada
    Entonces valido el codigo espera "404"
    Ejemplos:
      | ID_Caso | mascota                             |
      | CP001   | pepe                                |
      | CP002   | NohayFormadeHacerCaer21=[23[2/.,:{} |

  @flujoAPIKey
  Esquema del escenario:  Eliminar Mascota con API key <ID_Caso>
    Dado que agrego la mascota "<mascota>"
    Entonces valido el codigo espera "200"
    Y consulto la mascota previamente consultada
    Entonces valido el codigo espera "200"
    Cuando cargo la pagina petstore3 en "Chrome"
    Y ingreso a la opcion "Authorize"
    Y autorizo el valor api_key "<apikey>"
    E elimino la mascota previamente consultada con la autorizacion "<apikey>"
    Entonces valido el codigo espera "200"
    Y consulto la mascota previamente consultada
    Entonces valido el codigo espera "404"
    Ejemplos:
      | ID_Caso | mascota | apikey    |
      | CP001   | loro    | xx1PaiKey |
