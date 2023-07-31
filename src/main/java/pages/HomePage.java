package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

public class HomePage {
    private WebDriver driver;
    private By bySearchBar = By.xpath("//input[@data-testid='search-bar']");
    private By bySearchBtn = By.xpath("//input[@data-testid='search-bar']/following-sibling::button[@type='submit']");
    private By byRepoCount = By.xpath("//section[@class='sc-bcXHqe cSGkzu section-center']/article[1]//div/h3");
    private By byFollowerCount = By.xpath("//section[@class='sc-bcXHqe cSGkzu section-center']/article[2]//div/h3");
    private By byFollowingCount = By.xpath("//section[@class='sc-bcXHqe cSGkzu section-center']/article[3]//div/h3");
    private By byGistsCount = By.xpath("//section[@class='sc-bcXHqe cSGkzu section-center']/article[4]//div/h3");
    private By byEmployingCompany = By.xpath("//div[@class='links']/p[1]");
    private By byState = By.xpath("//div[@class='links']/p[2]");
    private By byCompanyLink = By.xpath("//div[@class='links']/a");
    private By byFollowerNames = By.xpath("//div[@class='followers']/article//div/h4");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void searchFor(String searchText){
        driver.findElement(bySearchBar).clear();
        driver.findElement(bySearchBar).sendKeys(searchText);
        driver.findElement(bySearchBtn).click();
    }

    public String getRepoCount(){
        return driver.findElement(byRepoCount).getText();
    }

    public String getFollowerCount(){
        return driver.findElement(byFollowerCount).getText();
    }

    public String getFollowingCount(){
        return driver.findElement(byFollowingCount).getText();
    }

    public String getGistsCount(){
        return driver.findElement(byGistsCount).getText();
    }

    public String getEmployingCompany(){
        return driver.findElement(byEmployingCompany).getText();
    }

    public String getState(){
        return driver.findElement(byState).getText();
    }

    public String getEmployerLink(){
        return driver.findElement(byCompanyLink).getText();
    }

    public List<String> getFollowerNames(){
        List<String> nameList = new LinkedList<>();
        for (WebElement element: driver.findElements(byFollowerNames)) {
            nameList.add(element.getText());
        }
        return nameList;
    }
}
