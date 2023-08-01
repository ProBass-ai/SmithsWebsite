package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.HomePage;

import static junit.framework.TestCase.assertTrue;

public class HomePageSteps {
    PageObjectManager pageObjectManager;
    HomePage homePage;
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //the sandbox removes unnecessary privileges from the processes that don't need them in Chrome, for security purposes. Disabling the sandbox makes your PC more vulnerable to exploits via webpages, so Google don't recommend it.
        options.addArguments("--no-sandbox");
        //"--disable-dev-shm-usage" Only added when CI system environment variable is set or when inside a docker instance. The /dev/shm partition is too small in certain VM environments, causing Chrome to fail or crash.
        options.addArguments("--disable-dev-shm-usage");
        if(!System.getProperty("os.name").contains("Windows")){
            options.addArguments("--headless");
        }
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        this.pageObjectManager = new PageObjectManager(driver);
        this.homePage = pageObjectManager.getHomePage();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("the user is on the home page")
    public void theUserIsOnTheHomePage(){
        driver.get("https://gh-users-search.netlify.app/");
    }

    @When("a user seaches for {string}")
    public void aUserSeachesFor(String username) {
        homePage.searchFor(username);
    }

    @Then("the repo count must be {string}")
    public void theRepoCountMustBe(String expectedRepoCount) {
        assertTrue(homePage.isExpectedRepoCount(expectedRepoCount));
    }

    @Then("the follower count must be {string}")
    public void theFollowerCountMustBe(String expected) {
        assertTrue(homePage.isExpectedFollowerCount(expected));
    }

    @Then("the the following count must be {string}")
    public void theTheFollowingCountMustBe(String expected) {
        assertTrue(homePage.isExpectedFollowingCount(expected));
    }

    @Then("the the gists count must be {string}")
    public void theTheGistsCountMustBe(String expected) {
        assertTrue(homePage.isExpectedGistsCount(expected));
    }

    @Then("the company tag is {string}")
    public void theCompanyTagIs(String expected) {
        assertTrue(homePage.isExpectedEmployingCompany(expected));
    }

    @Then("the location is {string}")
    public void theLocationIs(String expected) {
        assertTrue(homePage.isExpectedState(expected));
    }

    @Then("the link is {string}")
    public void theLinkIs(String expected) {
        assertTrue(homePage.isExpectedEmployerLink(expected));
    }

    @Then("{string} is in the follower list")
    public void isInTheFollowerList(String expected) {
        assertTrue(homePage.isFollower(expected));
    }
}
