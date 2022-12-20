package objects;

import org.openqa.selenium.By;
import userinterfaces.HomePath;
import utils.web.HelperWeb;
import utils.web.Hooks;

public class HomePage extends HelperWeb {
    Hooks hooks = new Hooks();


    public void isPageRenderedProperly() throws Exception {
        initDriver();
    }


    public  void clickButtonAutorizar() throws Exception {
        isPageRenderedProperly();
        waitElementAppear(By.cssSelector(HomePath.btnAuthorize),3);
        driver.findElement(By.cssSelector(HomePath.btnAuthorize)).click();
        hooks.takeScrenn();

    }


    public void ingresarAPIkey(String arg0) {
        waitElementAppear(By.cssSelector(HomePath.inputValueKey),3);
        driver.findElement(By.cssSelector(HomePath.inputValueKey)).sendKeys(arg0);
        hooks.takeScrenn();
    }

    public void autorizarKey() {
        waitElementAppear(By.cssSelector(HomePath.btnSubmitAutorize),3);
        driver.findElement(By.cssSelector(HomePath.btnSubmitAutorize)).click();
    }

    public boolean obtenerRespuesta() {
        waitElementAppear(By.cssSelector(HomePath.labelResult),3);
        String response= driver.findElement(By.cssSelector(HomePath.labelResult)).getText();
        hooks.takeScrenn();
        if (response.equals("Authorized")){
            return true;
        }
        return false;
    }


}
