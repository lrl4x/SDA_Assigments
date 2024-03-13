package tests.junit;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.junit.jupiter.api.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Task6week5 extends Tests{
    // Go to amazon.com
    // Take Full Page Screenshot.
    // Take any spesific WebElement ScreenShot]'

    @Test

    public void ScreenShoot ()throws IOException {
        bot.navigate("https://www.amazon.com/");
        driver.manage().window().minimize();
        String filePath = "C:\\Users\\Admin\\Desktop\\";

        By elementLocator = By.xpath("//div[@class='navFooterBackToTop']/span");
        WebElement element = driver.findElement(elementLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        //screenshot
        Screenshot fullPageScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        ImageIO.write(fullPageScreenshot.getImage(), "jpg", new File(filePath + "full_page_screenshot.jpg"));


    }}

