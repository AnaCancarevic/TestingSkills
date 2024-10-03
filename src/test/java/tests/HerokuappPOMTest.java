package tests;

import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.HerokuappHomePage;

import static org.junit.Assert.*;

public class HerokuappPOMTest extends BaseTest
{
    @Test
    public void logInWithValidCredentials() throws InterruptedException {
        String username="tomsmith";
        String password="SuperSecretPassword!";
        String messageText="You logged into a secure area!";

        HerokuappHomePage homepage = new HerokuappHomePage(driver);
        homepage.logIn(username, password);


        wdWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("flash")));
        WebElement message= driver.findElement(By.id("flash"));
        WebElement logOutButton=driver.findElement(By.className("icon-signout"));


        assertTrue(message.getText().contains(messageText));
        assertTrue(logOutButton.getText().contains("Logout"));
        Thread.sleep(3000);


    }

    @Test
    @SneakyThrows
    public void logInWithWrongUsername()
    {
        String username="wrongusername";
        String password="SuperSecretPassword!";
        String messageText="Your username is invalid!";

        HerokuappHomePage homepage = new HerokuappHomePage(driver);
        homepage.logIn(username, password);


        wdWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("flash")));
        WebElement message= driver.findElement(By.id("flash"));



        assertTrue(message.getText().contains(messageText));


    }
}
