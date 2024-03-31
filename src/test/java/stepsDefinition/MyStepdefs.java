package stepsDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.AccessPageTest;

import java.io.IOException;

public class MyStepdefs {

    private WebDriver driver;
    private AccessPageTest accessPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        accessPage = new AccessPageTest(driver);
    }

    @After
    public void tearDown() {
        if (driver != null){
            driver.quit();
        }
    }
    
    @Given("The user access the website")
    public void theUserAccessTheWebsite() {
        driver.get("https://jsonplaceholder.typicode.com/guide/");
    }

    @And("Click on photos menu")
    public void clickOnPhotosMenu() {
        accessPage.clickOnPhotosMenu();
    }

    @And("Capture json")
    public void captureJson() throws IOException {
        accessPage.searchingJson();
    }

    @Then("The id {int} should be displayed")
    public void theIdShouldBeDisplayed(int id) throws IOException {
        accessPage.validatingObjectsInsideTheId6();

    }
}
