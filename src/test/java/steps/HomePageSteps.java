package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utils.TestContext;

import static junit.framework.TestCase.assertTrue;

public class HomePageSteps {
    PageObjectManager pageObjectManager;
    TestContext testContext = new TestContext();
    HomePage homePage;
    WebDriver driver;

    @Before
    public void setUp(){
        this.driver = testContext.getDriver();
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
}
