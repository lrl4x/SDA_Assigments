package pages.Task1week7RegisterAccount;

import engine.ActionsBot;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register extends Pages{

    /*
    go to url : https://ecommerce-playground.lambdatest.io/index.php?route=account/register
    register account test with fluent page object approach
    */
    private final String url = "https://ecommerce-playground.lambdatest.io/index.php?route=account/register";
    private final By FirstNameI= By.id("input-firstname");
    private final By LastNameI = By.id("input-lastname");
    private final By EmailI=  By.id("input-email");
    private final By TelephoneI= By.id("input-telephone");
    private final By PasswordI= By.id("input-password");
    private final By ConfirmPasswordI= By.id("input-confirm");
    private final By Subscribe= By.id("input-newsletter-yes");
    private final By ConfirmPrivacyI= By.id("input-agree");
    private final By submitI = By.cssSelector("input.btn.btn-primary");
    private final By productsLabel = By.cssSelector(".page-title.my-3");
    public Register(WebDriver driver, ActionsBot bot) {
        super(driver, bot);
    }
    @Step("Given I am on the Register page")
    public Register goTo(){
        bot.navigate(url);
        return this;
    }

    public Register register(String FirstName, String LastName, String Email, String Telephone,String Password ,String ConfirmPassword){
        driver.findElement(FirstNameI).sendKeys(FirstName);
        driver.findElement(LastNameI).sendKeys(LastName);
        driver.findElement(EmailI).sendKeys(Email);
        driver.findElement(TelephoneI).sendKeys(Telephone);
        driver.findElement(PasswordI).sendKeys(Password);
        driver.findElement(ConfirmPasswordI).sendKeys(ConfirmPassword);
        bot.click(Subscribe);
        bot.click(ConfirmPrivacyI);
        bot.click(submitI);
        return this;
    }
    @Step("Read the massage")
    public String message(){
        return bot.getText(productsLabel);
    }


}
