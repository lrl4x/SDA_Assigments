package engine;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class CustomListener implements ITestListener , WebDriverListener {
//-- Breakout task: 40 minutes
// implement and use any one of the listeners we discussed (testng listener, webdriver listener)
// and optionally implement the allure @step annotation to your actions bot class
//-> use the rest of the 40 minutes to make sure that your project is fixed and following us with everything we do


    public void onTestFailure(ITestResult result) {
        System.out.println(result.getInstanceName() + "." + result.getName() + " FAILED");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getInstanceName() + "." + result.getName() + " PASSED");
    }

    public void afterGetText(WebElement element, String result) {
        try (InputStream is = Files.newInputStream(element.getScreenshotAs(OutputType.FILE).toPath())) {
            Allure.attachment("image.png", is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
