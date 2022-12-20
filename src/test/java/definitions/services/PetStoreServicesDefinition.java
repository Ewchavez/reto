package definitions.services;
import cucumber.api.java.es.E;
import services.PetStore;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import org.junit.Assert;
import utils.services.Hooks;

import java.io.IOException;

public class PetStoreServicesDefinition {
    PetStore petStore = new PetStore();
    utils.services.Hooks Hooks= new Hooks();

    @Dado("^que agrego la mascota \"([^\"]*)\"$")
    public void queAgregoLaMascota(String arg0) throws Throwable {
        petStore.ingresoMascota(arg0);
    }

    @Entonces("^valido el codigo espera \"([^\"]*)\"$")
    public void validoElCodigoEspera(String arg0) throws Throwable {
       Assert.assertTrue(petStore.validoElCodigoEspera(arg0));
    }

    @Y("^consulto la mascota previamente consultada$")
    public void consultoLaMascotaPreviamenteConsultada() throws IOException {
        petStore.realizoConsultaDeMascota();
    }

    @Y("^modifico la mascota previamente creada$")
    public void modificoLaMascotaPreviamenteCreada() throws IOException {
        petStore.modifoMascota();
    }

    @Y("^elimino la mascota previamente consultada$")
    public void eliminoLaMascotaPreviamenteConsultada() throws IOException {
        petStore.eliminarMascota();
    }

    @Dado("^que obtengo una lista de mascotas con estado \"([^\"]*)\"$")
    public void queObtengoUnaListaDeMascotasConEstado(String estado) throws Throwable {
        petStore.obtenerMascotas(estado);
    }

    @E("^elimino la mascota previamente consultada con la autorizacion \"([^\"]*)\"$")
    public void eliminoLaMascotaPreviamenteConsultadaConLaAutorizacion(String key) throws Throwable {
        petStore.eliminarMascota(key);
    }
}
