package managers;

import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class PageObjectManager {
    private WebDriver driver;

    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }

    public HomePage getHomePage(){
        return new HomePage(this.driver);
    }
}
