package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void searchFor(String searchText){
        driver.findElement(bySearchBar).clear();
        driver.findElement(bySearchBar).sendKeys(searchText);
        driver.findElement(bySearchBtn).click();
    }

    public boolean isExpectedRepoCount(String expected){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(byRepoCount, expected));
    }

    public boolean isExpectedFollowerCount(String expected){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(byFollowerCount, expected));
    }

    public boolean isExpectedFollowingCount(String expected){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(byFollowingCount, expected));
    }

    public boolean isExpectedGistsCount(String expected){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(byGistsCount, expected));
    }

    public boolean isExpectedEmployingCompany(String expected){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(byEmployingCompany, expected));
    }

    public boolean isExpectedState(String expected){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(byState, expected));
    }

    public boolean isExpectedEmployerLink(String expected){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(byCompanyLink, expected));
    }

    public List<String> getFollowerNames(){
        List<String> nameList = new LinkedList<>();
        for (WebElement element: driver.findElements(byFollowerNames)) {
            nameList.add(element.getText());
        }
        return nameList;
    }
}
