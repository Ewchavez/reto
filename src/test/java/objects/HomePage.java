package objects;

import models.PetStore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        hooks.takeScreen();

    }


    public void ingresarAPIkey(String arg0) {
        waitElementAppear(By.cssSelector(HomePath.inputValueKey),3);
        driver.findElement(By.cssSelector(HomePath.inputValueKey)).sendKeys(arg0);
        hooks.takeScreen();
    }

    public void autorizarButton(int locate) {
        waitElementAppear(By.xpath(HomePath.btnSubmitAutorize),3);
        driver.findElements(By.xpath(HomePath.btnSubmitAutorize)).get(locate).click();
    }

    public boolean obtenerRespuesta() {
        waitElementAppear(By.cssSelector(HomePath.labelResult),3);
        String response= driver.findElement(By.cssSelector(HomePath.labelResult)).getText();
        hooks.takeScreen();
        if (response.equals("Authorized")){
            return true;
        }
        return false;
    }
    public void closeModal(){
        driver.findElement(By.xpath(HomePath.btnClose)).click();
    }



    public boolean validoElCodigoEspera(String arg0) {

        hooks.takeScreen();
        if (PetStore.ResponseCode.contains(arg0)){
            return true;
        }
        return false;
    }
    public void setStatus(String status) {
        driver.findElement(By.cssSelector(HomePath.selectStatus)).click();
        for (WebElement e: driver.findElements(By.cssSelector(HomePath.selectValues)) ){
            if (e.getText().contains(status)){
                e.click();
                break;
            }
        }
        ScrollElement(By.cssSelector(HomePath.selectValues)) ;
        hooks.takeScreen();

    }

    public void executeAPI() {
        driver.findElement(By.xpath(HomePath.btnEjecutarAPI)).click();
    }

    public void getResponse() {
        waitElementAppear(By.cssSelector(HomePath.responseCode),5);
        ScrollElement(By.cssSelector(HomePath.responseCode));
        PetStore.ResponseCode=driver.findElement(By.cssSelector(HomePath.responseCode)).getText();
        PetStore.responseDescription=driver.findElement(By.cssSelector(HomePath.responseDescription)).getText();
    }

    public String getBody() {
        return driver.findElement(By.cssSelector(HomePath.textAreaRequest)).getText();
    }

    public void actualizarRequestBody( String body) {
        ScrollElement(By.cssSelector(HomePath.textAreaRequest));
        driver.findElement(By.cssSelector(HomePath.textAreaRequest)).clear();
        driver.findElement(By.cssSelector(HomePath.textAreaRequest)).sendKeys(body);
        hooks.takeScreen();

    }

    public void writePetID(String petID) {
        ScrollElement(By.cssSelector(HomePath.inputPetID));
        driver.findElement(By.cssSelector(HomePath.inputPetID)).sendKeys(petID);
        hooks.takeScreen();
    }
}
