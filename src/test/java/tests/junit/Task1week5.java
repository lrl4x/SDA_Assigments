package tests.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Task1week5 extends Tests {
    /*
Go to URL: http://demo.guru99.com/test/drag_drop.html
Drag and drop the BANK button to the Account section in DEBIT SIDE
Drag and drop the SALES button to the Account section in CREDIT SIDE
Drag and drop the 5000 button to the Amount section in DEBIT SIDE
Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
Verify the visibility of Perfect text .
*/


    @Test
    public void Draganddrop() {
        bot.navigate("http://demo.guru99.com/test/drag_drop.html");

        By bank = By.id("credit2");
        By accountD = By.id("bank");
        bot.drag(bank, accountD);

        By sales = By.id("credit1");
        By accountC = By.id("loan");
        bot.drag(sales, accountC);

        By fourth1 = By.id("fourth");
        By amountD = By.id("amt7");
        bot.drag(fourth1, amountD);

        By fourth2 = By.id("fourth");
        By amountC = By.id("amt8");
        bot.drag(fourth2, amountC);

        By text = By.xpath("//div[@id='equal']/a");
        Assertions.assertEquals("Perfect!", driver.findElement(text).getText());
    }

}
