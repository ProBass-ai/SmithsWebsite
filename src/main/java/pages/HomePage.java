package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestHelper;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

public class HomePage {
    private final WebDriver driver;
    private final By bySearchBar = By.xpath("//input[@data-testid='search-bar']");
    private final By bySearchBtn = By.xpath("//input[@data-testid='search-bar']/following-sibling::button[@type='submit']");
    private final By byRepoCount = By.xpath("//section[@class='sc-bcXHqe cSGkzu section-center']/article[1]//div/h3");
    private final By byFollowerCount = By.xpath("//section[@class='sc-bcXHqe cSGkzu section-center']/article[2]//div/h3");
    private final By byFollowingCount = By.xpath("//section[@class='sc-bcXHqe cSGkzu section-center']/article[3]//div/h3");
    private final By byGistsCount = By.xpath("//section[@class='sc-bcXHqe cSGkzu section-center']/article[4]//div/h3");
    private final By byEmployingCompany = By.xpath("//div[@class='links']/p[1]");
    private final By byState = By.xpath("//div[@class='links']/p[2]");
    private final By byCompanyLink = By.xpath("//div[@class='links']/a");
    private final By byFollowerNames = By.xpath("//div[@class='followers']/article//div/h4");
    private By getByFollowerName(String followerName){
        return By.xpath("//div[@class='followers']/article//div/h4[text()=translate('" + followerName + "', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')]");
    }

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void searchFor(String searchText){
        driver.findElement(bySearchBar).clear();
        driver.findElement(bySearchBar).sendKeys(searchText);
        driver.findElement(bySearchBtn).click();
    }

    public boolean isExpectedRepoCount(String expected){
        return TestHelper.isTextPresentInElement(driver, byRepoCount, expected);

    }

    public boolean isExpectedFollowerCount(String expected){
        return TestHelper.isTextPresentInElement(driver, byFollowerCount, expected);
    }

    public boolean isExpectedFollowingCount(String expected){
        return TestHelper.isTextPresentInElement(driver, byFollowingCount, expected);
    }

    public boolean isExpectedGistsCount(String expected){
        return TestHelper.isTextPresentInElement(driver, byGistsCount, expected);
    }

    public boolean isExpectedEmployingCompany(String expected){
        return TestHelper.isTextPresentInElement(driver, byEmployingCompany, expected);
    }

    public boolean isExpectedState(String expected){
        return TestHelper.isTextPresentInElement(driver, byState, expected);
    }

    public boolean isExpectedEmployerLink(String expected){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.attributeToBe(byCompanyLink, "href" , expected));
    }

    public List<String> getFollowerNames(){
        List<String> nameList = new LinkedList<>();
        for (WebElement element: driver.findElements(byFollowerNames)) {
            nameList.add(element.getText());
        }
        return nameList;
    }

    public boolean isFollower(String followerName){
         try {
             WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
             wait.until(ExpectedConditions.visibilityOfElementLocated(getByFollowerName(followerName)));
             return true;
         } catch (Exception e){
             return false;
         }
    }
}
