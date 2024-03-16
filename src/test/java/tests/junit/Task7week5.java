package tests.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Task7week5 extends Tests{
//Go to URL: https://api.jquery.com/dblclick/
//Double click on the blue square at the bottom of the page and then write the changed color.
//Go top of the page and sendKeys "Thanks to JavascriptExecutor"
//Go to the bottom of the page and click the book, name"jQuery in Action"


    @BeforeEach
    public void beforeEach(){
        driver = new ChromeDriver();
        driver.manage().window().minimize();
        driver.navigate().to("https://api.jquery.com/dblclick/");
    }

    @Test
    public void main(){
        WebElement iframe = driver.findElement(By.cssSelector("div.demo.code-demo iframe"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",iframe);


        driver.switchTo().frame(iframe);
        WebElement element =driver.findElement(By.tagName("div"));
        new Actions(driver)
                .doubleClick(element)
                .perform();

        String changedColor = element.getCssValue("background-color");
        System.out.println("The changed color is: " + changedColor);

        driver.switchTo().defaultContent();

        WebElement GoTop =driver.findElement(By.xpath("//input[@name='s']"));
        JavascriptExecutor jsGoTop= (JavascriptExecutor) driver;
        jsGoTop.executeScript("arguments[0].scrollIntoView(true);",GoTop);

        GoTop.sendKeys("Thanks to JavascriptExecutor");

        WebElement bookLink = driver.findElement(By.partialLinkText("jQuery in Action"));
        js.executeScript("arguments[0].scrollIntoView(true);", bookLink);
        bookLink.click();


    }}
