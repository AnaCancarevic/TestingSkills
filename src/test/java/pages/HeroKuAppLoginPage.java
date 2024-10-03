package pages;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

//korak 1: pravljenje metode koja se zove kao i TC, nasledjuje basehepler
public class HeroKuAppLoginPage extends BaseHelper
{


    //korak 3: definisanje elemenata *obratiti paznju na to da ide i naziv i vrednost atributa,
    //vrednost ne sme imati razmake, ostavis 1 rec za koju mislis da radi, mora className jer je class rezervisana rec
    //ako je xpath napises
 @FindBy (id="username")  WebElement usernameField;

 @FindBy (name="password") WebElement passwordField;

 @FindBy (xpath="/html/body/div[2]/div/div/form/button")  WebElement loginButton;

   //korak 2: kopiranje custom konstruktora, obavezno izmeni naziv da se zove isto kao Klasa!
    WebDriver driver;
    public HeroKuAppLoginPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    //korak 4: pravljenje onoliko privatnih metoda koliko imas koraka u TC

    private void navigateToLoginPage()
    {
        wdWait.until(ExpectedConditions.urlToBe("https://the-internet.herokuapp.com/login"));
    }



    //vec znas da ce ti za ovo trebati ulazni parametri, stoga se vratis da ih definises i stavis ovde odmah
    private void enterUsernameInUsernameField(String username)
    {
     usernameField.sendKeys(username);
    }

    private void enterPasswordInPaswwordField(String password)
    {
    passwordField.sendKeys(password);
    }

    private void clickOnLoginButton()
    {
    loginButton.click();
    }


    //javna metoda je samo logovanje koje objedinjuje sve korake TC
    public void loginWithCredentials(String username, String password)
    {
        navigateToLoginPage();
        enterUsernameInUsernameField(username);
        enterPasswordInPaswwordField(password);
        clickOnLoginButton();
    }


}
