package tests.junit;

import engine.ActionsBot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class Task5week6 extends Tests{
    //Go to URL: http://crossbrowsertesting.github.io/
    //Click to To-Do App
    //Checking Box to do-4 and Checking Box to do-5
    //If both clicks worked, then the following List should be have length 3.
    //Assert that this is correct
    //Assert that the to do we added is present in the list
    //Archiving old todos
    //If our archive link worked, then the following list should have length 4.
    //Assert that this is true as well
    //Doing Cross Browser Testing.
    @Test
    public void testTodoApp() {
        //Go to URL: http://crossbrowsertesting.github.io/
        driver.navigate().to("https://crossbrowsertesting.github.io/todo-app.html");
        driver.findElement(By.name("todo-4")).click();
        driver.findElement(By.name("todo-5")).click();

        Assertions.assertTrue(driver.findElement(By.name("todo-4")).isSelected(), "Todo-4 should be checked");
        Assertions.assertTrue(driver.findElement(By.name("todo-5")).isSelected(), "Todo-5 should be checked");

        driver.findElement(By.linkText("archive")).click();
        List<WebElement> todos3 = driver.findElements(By.tagName("li"));
        Assertions.assertEquals(3, todos3.size(), "There should be 3 items left in the list after archiving");

        driver.findElement(By.id("todotext")).sendKeys("new task :ReactJs");
        driver.findElement(By.id("addbutton")).click();

        List<WebElement> todos4 = driver.findElements(By.tagName("li"));
        Assertions.assertEquals(4, todos4.size(), "There should be 4 items left in the list after archiving");
    }
}
