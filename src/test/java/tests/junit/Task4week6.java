package tests.junit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task4week6 extends Tests{
//Open the site: http://opencart.abstracta.us/index.php?route=account/login
    //Login with that credentials
    //Email: clarusway@gmail.com
    //Password: 123456789
    //Using the Search function do it with Data Provider for Mac, iPad and Samsung.

    @BeforeClass
    public void BeforeClass(){
        driver=new ChromeDriver();
        driver.get("http://opencart.abstracta.us/index.php?route=account/login");
    }

    @Test
    public void search(){
        driver.findElement(By.id("input-email")).sendKeys("clarusway@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("123456789");

        driver.findElement(By.xpath("//input[@type='submit']")).click();


    }
    @DataProvider(name = "searchTerms")
    public Object[][] dataProviderMethod() {
        return new Object[][] {
                {"Mac"}, {"iPad"}, {"Samsung"}
        };
    }

    @Test(priority = 2, dataProvider = "searchTerms")
    public void search(String searchTerm) {
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys(searchTerm);
        driver.findElement(By.name("search")).submit();
    }



}
