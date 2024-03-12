package tests.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Task2week5 extends Tests {
    /** ( This task should be managed with keyboard actions ) */
// go to https://www.google.com/
// search for "Scroll Methods" by using an Actions object

    @BeforeEach
    public void beforeEach(){
        driver = new ChromeDriver();
        driver.manage().window().minimize();
        driver.navigate().to("https://www.google.com/");
    }
    @Test
    public void ScrollMethods(){
        WebElement draggable = driver.findElement(By.id("APjFqb"));
        new Actions(driver)
                .sendKeys("Scroll Methods", Keys.ENTER)
                .perform();
    }
}
