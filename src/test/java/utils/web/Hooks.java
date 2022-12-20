package utils.web;

import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.SessionManager;

import java.awt.*;
import java.io.IOException;

public class Hooks extends utils.SessionManager {

    private static WebDriver driver;

    utils.SessionManager SessionManager=new SessionManager();

    public WebDriver getDriver(){
       return this.driver;

   }

    public void takeScrenn() {
        SessionManager.scenario=SessionManager.obternerSesion("scenario");
        try {
            byte[] screenshot = (byte[])((TakesScreenshot)this.driver).getScreenshotAs(OutputType.BYTES);
            SessionManager.scenario.embed(screenshot, "image/png");
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }
    }



    public void stopDriver(Scenario scenario){
            try {
                this.driver.close();
            }catch (Exception e){
                e.getMessage();
            }

            try{
                this.driver.quit();
            }catch (Exception e){
                e.getMessage();
            }
        }





    public  void instancioElDriver(String navegador, String url) throws InterruptedException, AWTException, IOException {
       WebDriver webDriver;
        switch (navegador) {
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                webDriver.navigate().to(url);
                webDriver.manage().window().maximize();
                webDriver.manage().deleteAllCookies();
                this.driver=webDriver;
                break;
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                webDriver.navigate().to(url);
                webDriver.manage().window().maximize();
                webDriver.manage().deleteAllCookies();
                this.driver=webDriver;
                break;

        }





    }



}
