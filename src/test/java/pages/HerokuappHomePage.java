package pages;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


//struktura page 1.javna klasa koja nasledi basehelper, 2. formiranje webelemenata uz @findby,
// 3. tih 6 redova konstruktora da ne menja str, 4. privatne metode koliko je TC
//5. javna metoda gde pozove sve privatne
public class HerokuappHomePage extends BaseHelper
{

    @FindBy(id = "username")
    WebElement usernameField;

    @FindBy(name = "password")
            WebElement passwordField;

    @FindBy(className = "fa-sign-in")
            WebElement loginButton;

    WebDriver driver;
    public HerokuappHomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
   //navigate to loginpage
    private void navigateToLogInPage()
    {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    //enter username
    private void enterUserameInUserameField(String username) {usernameField.sendKeys(username);}

    //enter password
    private void enterPasswordInPasswordField(String password)
    {
        passwordField.sendKeys(password);
    }


    //click on login button
    private void clickOnLoginButton()
    {
        loginButton.click();
    }


    //javna metoda koja poziva sve redom privatne
    public void logIn(String username, String password)
    {
        navigateToLogInPage();
        enterUserameInUserameField(username);
        enterPasswordInPasswordField(password);
        clickOnLoginButton();
    }
}

