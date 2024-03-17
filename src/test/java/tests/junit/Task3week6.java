package tests.junit;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Task3week6 extends Tests{
    /* go to "https://practicetestautomation.com/practice-test-login/"
enter username - "student"
enter password - "incorrectPassword"
and login
SOFT ASSERT the error message shown
SOFT ASSERT the error message is "Your password is invalid!" */

    @BeforeClass
    public void setUp(){
        driver=new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.manage().window().minimize();

    }
    @Test
    public void SortAssertLogin(){
        By Username = By.id("username");
        driver.findElement(Username).sendKeys("student");

        By Password =By.id("password");
        driver.findElement(Password).sendKeys("incorrectPassword");

        By Submit = By.id("submit");
        driver.findElement(Submit).click();

        By error= By.id("error");
        String errorMessage=driver.findElement(error).getText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("Your password is invalid!",errorMessage,"The expected error message did not match the actual error message.");

        softAssert.assertAll();
    }


}
