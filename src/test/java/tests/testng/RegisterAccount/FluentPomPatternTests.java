package tests.testng.RegisterAccount;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import pages.Task1week7RegisterAccount.Register;
import tests.junit.Tests;

public class FluentPomPatternTests extends Tests {
     /*
     go to url : https://ecommerce-playground.lambdatest.io/index.php?route=account/register
     register account test with fluent page object approach
      */

    @Test(description = "Successful Account Registration")
    public void registerAccountTest(){
        String expectedMessage = "Your Account Has Been Created!";
        String actualMessage = new Register(driver, bot)
                .goTo()
                .register("user123z",
                        "user123z",
                        "user123z33@hotmail.com",
                        "user123z",
                        "user123z",
                        "user123z")
                .message();
        Assertions.assertEquals(expectedMessage,actualMessage, "Account creation message did not match expected.");
    }

}
