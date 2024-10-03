package pages;

import helpers.BaseHelper;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TheInternetHerokuAppHomePage extends BaseHelper
{

    @FindBy (xpath="/html/body/div[2]/div/ul/li[21]/a")
    WebElement formAuthLink;
    WebDriver driver;
    public TheInternetHerokuAppHomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    private void navigateToHomePage() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/");
       Thread.sleep(2000);
    }
    private void clickOnFormAuthLink()
    {
     formAuthLink.click();
    }
    public void openPage() throws InterruptedException {
        navigateToHomePage();
        clickOnFormAuthLink();
    }

}
