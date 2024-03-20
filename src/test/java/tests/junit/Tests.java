package tests.junit;

import engine.ActionsBot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public abstract class Tests {
    protected WebDriver driver;
    protected Wait<WebDriver> wait;
    protected static Logger logger;
    protected ActionsBot bot;

    @BeforeSuite
    public static void beforeAll(){
        Configurator.initialize(null, "src/main/resources/properties/log4j2.properties");
        logger = LogManager.getLogger(Tests.class.getName());
    }

//    @BeforeEach
//    public void beforeEach(){
//        logger.info("Opening Chrome Browser");
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("start-maximized");
//        driver = new ChromeDriver(chromeOptions);
//
//        logger.info("Configuring 5 second explicit wait");
//        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        bot = new ActionsBot(driver, wait, logger);
//    }
@Parameters({ "target-browser" })
@BeforeMethod
public void beforeMethod(@Optional("chrome") String targetBrowser){
    logger.info("Opening "+targetBrowser+" Browser");

    switch (targetBrowser){
        case "chrome" -> driver = new ChromeDriver();
        case "firefox" -> driver = new FirefoxDriver();
        case "edge" -> driver = new EdgeDriver();
    }
    driver.manage().window().maximize();
    logger.info("Configuring 5 second explicit wait");
    wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    bot = new ActionsBot(driver, wait, logger);
}

    @AfterEach
    public void afterEach(){
        logger.info("Quitting Browser");
        driver.quit();
    }

}