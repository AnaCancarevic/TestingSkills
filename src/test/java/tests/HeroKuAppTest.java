package tests;

import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.HeroKuAppLoginPage;
import pages.TheInternetHerokuAppHomePage;

import static org.junit.Assert.assertTrue;

public class HeroKuAppTest extends BaseTest {
    @Test
    @SneakyThrows

    public void LogInWithValidCredentials()
    {
        String username="tomsmith";
        String password="SuperSecretPassword!";
        String message="You logged into secure area!";


        HeroKuAppLoginPage loginPage= new HeroKuAppLoginPage(driver);
        loginPage.loginWithCredentials(username,password);


        wdWait.until(ExpectedConditions.urlToBe("https://the-internet.herokuapp.com/secure"));
        WebElement messageBox= driver.findElement(By.className("success"));
        WebElement logOutButton=driver.findElement(By.className("icon-signout"));

        String messageRecieved= messageBox.getText();
        System.out.println(messageRecieved);

        Assert.assertTrue(messageBox.getText().contains(message));//pitati sto mi ovo ne radi
        Assert.assertTrue(logOutButton.getText().contains("Logout"));


    }


    @Test
    @SneakyThrows

    public void LogInWithWrongUsername() throws InterruptedException {
        String username="wrongUsername";
        String password="SuperSecretPassword!";
        String message="Your username is invalid!";


        TheInternetHerokuAppHomePage homePage=new TheInternetHerokuAppHomePage(driver);
        homePage.openPage();
        Thread.sleep(2000);

        HeroKuAppLoginPage loginPage= new HeroKuAppLoginPage(driver);
        loginPage.loginWithCredentials(username,password);


        //ovde se ne menja str pa sada preko elementa a ne url
       wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("flash")));
        WebElement messageBox= driver.findElement(By.id("flash"));

        Assert.assertTrue(messageBox.getText().contains(message));

         Thread.sleep(2000);
    }


}
