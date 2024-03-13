package tests.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class Task4week5 extends Tests{
     /*   Go to URL: http://facebook.com
        getCookies,
        addCookie,
        deleteCookieNamed,
        deleteAllCookies
     */
    @Test
    public void cookies(){
        bot.navigate("http://facebook.com");
        System.out.println("getCookies");
        driver.manage().getCookies().forEach(System.out::println);

        //add cookies
        driver.manage().addCookie(new Cookie("Browser1","Chrome"));
        driver.manage().addCookie(new Cookie("Browser2","FireFox"));

        //delete cookie
        driver.manage().deleteCookieNamed("Browser1 ");
        System.out.println("After delete Browser1 ");
        driver.manage().getCookies().forEach(System.out::println);

        //delete all cookies
        driver.manage().deleteAllCookies();
        System.out.println("After delete All Cookies");
        driver.manage().getCookies().forEach(System.out::println);

    }
}
