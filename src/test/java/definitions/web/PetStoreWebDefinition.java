package definitions.web;

import cucumber.api.PendingException;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import models.PetStore;
import objects.HomePage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Y;
import net.thucydides.core.steps.ScenarioSteps;
import objects.LoginPage;
import org.junit.Assert;
import utils.SessionManager;
import utils.web.Hooks;

public class PetStoreWebDefinition extends ScenarioSteps {
    Hooks hooks =new Hooks();
    SessionManager sessionManager=new SessionManager();
    private Scenario myScenario;
    HomePage homePage =new HomePage();
    LoginPage loginPage=new LoginPage();
    @Before
    public void before(Scenario scenario) {

        if (sessionManager.obternerSesion("scenario")==null){
            sessionManager.GuardarSesion("scenario", scenario);
            myScenario = scenario;
        }else {
            myScenario = sessionManager.obternerSesion("scenario");
        }
    }

    @After
    public void cerrrar(Scenario scenario) {
        hooks.stopDriver(scenario);
    }

    @Dado("^cargo la pagina petstore3 en \"([^\"]*)\"$")
    public void cargoLaPaginaPetStore3En(String arg0) throws Throwable {
        hooks.instancioElDriver(arg0,hooks.getSerenityParams("URL.PETSTORE").trim());
    }

    @Y("^ingreso a la opcion \"([^\"]*)\"$")
    public void ingresoALaOpcion(String btn) throws Throwable {
        switch (btn){
            case "Authorize":
                homePage.clickButtonAutorizar();
                break;
            case "UnAuthorize":
                break;
        }

    }


    @Dado("^que despliego la opcion \"([^\"]*)\"$")
    public void queDespliegoLaOpcion(String opcion) throws Throwable {
        switch (opcion){
            case "actualizar mascota":
                loginPage.desplegarLista("Update an existing pet");
                break;

            case "crear mascota":
                loginPage.desplegarLista("Add a new pet to the store");
                break;

            case "listar mascotas":
                loginPage.desplegarLista("Finds Pets by status");
                break;

            case "eliminar mascota":
                loginPage.desplegarLista("Deletes a pet");
                break;
        }
        loginPage.probarAPI();

    }

    @Cuando("^obtengo el usuario autorizador$")
    public void obtengoElUsuarioAutorizador() throws Exception {
        homePage.autorizarButton(0);
        loginPage.setWindowToActualDrive();
        loginPage.clickAllowBtn();
        PetStore.user=loginPage.getUser();
        loginPage.closeWindow();
        loginPage.setWindowToActualDrive();

    }

    @Entonces("^procedo a autorizar al usuario$")
    public void procedoAAutorizarAlUsuario() {
        homePage.ingresarAPIkey(PetStore.user);
        homePage.autorizarButton(1);
        Assert.assertTrue(homePage.obtenerRespuesta());
        homePage.closeModal();
    }



    @Y("^autorizo el valor api_key \"([^\"]*)\"$")
    public void autorizoElValorApi_key(String arg0) throws Throwable {
        homePage.ingresarAPIkey(arg0);
        homePage.autorizarButton(1);
        Assert.assertTrue(homePage.obtenerRespuesta());
    }


    @Y("^busco mascotas con status \"([^\"]*)\"$")
    public void buscoMascotasConStatus(String status) throws Throwable {
        homePage.setStatus(status);
    }


    @Entonces("^valido el codigo respuesta \"([^\"]*)\"$")
    public void validoElCodigoRespuesta(String codigo) throws Throwable {
        homePage.getResponse();
        Assert.assertTrue(homePage.validoElCodigoEspera(codigo));
    }

    @Cuando("^ejecuto la operacion$")
    public void ejecutoLaOperacion() {
        homePage.executeAPI();
    }



    @Y("^creo la mascota \"([^\"]*)\" con el numero id \"([^\"]*)\"$")
    public void creoLaMascotaConElNumeroID(String nombre, String matricula) throws Throwable {
        String body=homePage.getBody();
        body=body.replace("10",matricula).replace("doggie",nombre);
        homePage.actualizarRequestBody(body);

    }

    @Y("^actualizo la mascota con id \"([^\"]*)\", con el nombre \"([^\"]*)\"$")
    public void actualizoLaMascotaConIdConElNombre(String matricula, String nombre) throws Throwable {
        String body=homePage.getBody();
        body=body.replace("10",matricula).replace("doggie",nombre);
        homePage.actualizarRequestBody(body);
    }

    @Y("^elimino la mascota con numero id \"([^\"]*)\"$")
    public void eliminoLaMascotaConNumeroID(String petID) throws Throwable {
        homePage.writePetID(petID);
    }
}
