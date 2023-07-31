package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestContext {
    WebDriver driver;

    public TestContext(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        if(!System.getProperty("os.name").contains("Windows")){
            options.addArguments("--headless");
        }
        driver = new ChromeDriver(options);
    }

    public PageObjectManager getPageObjManager(){
        return new PageObjectManager(this.driver);
    }

    public WebDriver getDriver(){
        return this.driver;
    }


}
