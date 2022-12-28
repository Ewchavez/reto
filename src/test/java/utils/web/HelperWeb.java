package utils.web;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class HelperWeb {
    public static WebDriver driver;
    Hooks Hoocks=new Hooks();

    public void ScrollElement(By element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void HelperWeb(){
        driver=Hoocks.getDriver();
        PageFactory.initElements(driver,this);
    }

    public String getCurrentWindow(){
        return driver.getWindowHandle();
    }

    public void closeWindow(){
        driver.close();
    }
    public void changeWindow(String window){
        driver.switchTo().window(window);
    }

    public void setWindowToActualDrive(){
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
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