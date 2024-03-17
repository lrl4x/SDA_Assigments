package tests.junit;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Task1week6 extends Tests{
     /*
    Create tests that depend on each other
    Create beforeClass and set up settings.
    By creating interdependent tests;
    First go to Facebook.
    Then go to Google depending on Facebook,
    Then go to Amazon depending on Google
    Close the driver.
     */
    @BeforeClass
    public void BeforeClass(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void goToFacebook() {
        System.out.println("Navigating to Facebook");
        driver.get("https://www.facebook.com");
    }

    @Test(dependsOnMethods = {"goToFacebook"})
    public void goToGoogle() {
        System.out.println("Navigating to Google");
        driver.get("https://www.google.com");
    }

    @Test(dependsOnMethods = {"goToGoogle"})
    public void goToAmazon() {
        System.out.println("Navigating to Amazon");
        driver.get("https://www.amazon.com");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Closing Browser");
        driver.quit();
    }

}
