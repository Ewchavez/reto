package definitions.web;

import objects.HomePage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Y;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
import utils.SessionManager;
import utils.web.Hooks;

public class PetStoreWebDefinition extends ScenarioSteps {
    Hooks hooks =new Hooks();
    SessionManager sessionManager=new SessionManager();
    private Scenario myScenario;
    HomePage homePage =new HomePage();
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

    @Dado("^cargo la pagina DemoBlaze en \"([^\"]*)\"$")
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

    @Y("^autorizo el valor api_key \"([^\"]*)\"$")
    public void autorizoElValorApi_key(String arg0) throws Throwable {
        homePage.ingresarAPIkey(arg0);
        homePage.autorizarKey();
        Assert.assertTrue(homePage.obtenerRespuesta());
    }
}
