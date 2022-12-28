package objects;

import org.openqa.selenium.By;
import userinterfaces.HomePath;
import userinterfaces.LoginPath;
import utils.web.HelperWeb;
import utils.web.Hooks;

public class LoginPage extends HelperWeb {
    Hooks hooks = new Hooks();


    public void isPageRenderedProperly() throws Exception {
        initDriver();
    }


    public  void clickAllowBtn() throws Exception {
        isPageRenderedProperly();
        driver.findElement(By.cssSelector(LoginPath.btnAllow)).click();
    }


    public String getUser() {
        waitElementAppear(By.cssSelector(LoginPath.inputUser),2);
        String user=driver.findElement(By.cssSelector(LoginPath.inputUser)).getAttribute("value");
        hooks.takeScreen();
        return user;
    }

    public void desplegarLista(String key) {
        driver.findElement(By.xpath(HomePath.listAPI.replace("key",key))).click();
    }

    public void probarAPI() {
        waitElementAppear(By.xpath(HomePath.btnIntentarAPI),2);
        driver.findElement(By.xpath(HomePath.btnIntentarAPI)).click();
    }
}
