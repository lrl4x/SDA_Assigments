package tests.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Task3week5 extends Tests{
    /*
   Go to Amazon
   Scroll to the bottom of the page using a robot
   Click on the "Back to top" web element
   Click on the Amazon logo at the bottom of the page (in the footer) using JavascriptExecutor
   Use Actions to type "ClarusWay" in the search box and perform the search
*/
    @BeforeEach
    public void beforeEach(){
        driver = new ChromeDriver();
        driver.manage().window().minimize();
        driver.navigate().to("https://www.amazon.sa/-/en/ref=nav_logo");
    }

    @Test
    public void scroll() throws AWTException {
        WebElement scroll = driver.findElement(By.xpath("//a[@href='/-/en/?ref_=footer_logo']/div"));
        scroll.click();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

        robot.delay(4000);

    }

    @Test
    public void Backtotop(){
        WebElement Backtotop = driver.findElement(By.xpath("//span[@class='navFooterBackToTopText']"));
        Backtotop.click();
    }
    @Test
    public void clickatAmazonlogo(){
        WebElement scrollB = driver.findElement(By.xpath("//a[@href='/-/en/?ref_=footer_logo']/div"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");


    }
@Test
public void searchbox() {
    WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
    new Actions(driver)
            .sendKeys(search,"ClarusWay",Keys.ENTER)
            .perform();
}



}
