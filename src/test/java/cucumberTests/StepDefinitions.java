package cucumberTests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StepDefinitions {
     WebDriver driver;
     WebDriverWait wait;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @Given("user goes to the {string}")
    public void user_goes_to_the(String url) {
        driver.navigate().to(url);
    }

    @Then("user waits for {int} seconds")
    public void user_waits_for_seconds(Integer int1) {
        try {
            Thread.sleep(int1 * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    @And("verifies that the page title contains the word {string}")
    public void verifies_that_the_page_title_contains_the_word(String string) {
        String title = driver.getTitle();
        Assertions.assertTrue(title.contains(string), "The title does not contain the expected text.");
    }

    @And("closes the page")
    public void closes_the_page() {
        driver.quit();
    }

    @After
    public void terminate() {
        if (driver != null) {
            driver.quit();
        }
    }
}
