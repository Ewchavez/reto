package utils.web;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class HelperWeb {
    public static WebDriver driver;
    Hooks Hoocks=new Hooks();


    public void HelperWeb(){
        driver=Hoocks.getDriver();
        PageFactory.initElements(driver,this);
    }

    public void initDriver() throws Exception{
        HelperWeb();
    }

    public  boolean waitElementAppear(By locator, int seconts){
        try {
        WebDriverWait wait = new WebDriverWait(driver, seconts);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }







}