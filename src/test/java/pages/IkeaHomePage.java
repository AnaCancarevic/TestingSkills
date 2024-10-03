package pages;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class IkeaHomePage extends BaseHelper {

    WebDriver driver;

    public IkeaHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy (id="onetrust-button-group-parent")
    WebElement clearCookiesField;
    @FindBy (id="onetrust-accept-btn-handler")
    WebElement acceptAllCookies;

    @FindBy(className = "search-field__input")
    WebElement searchInputField;

    @FindBy(id = "search-box__searchbutton")
    WebElement searchButton;

    private void navigateToIkeaHomePage(String url)
    {
        driver.get(url);
    }

    private void acceptAllCookiesFiled(){
        wdWait.until(ExpectedConditions.visibilityOf(clearCookiesField));
        acceptAllCookies.click();
    }

    private void inputTermInTheSearchField(String searchTerm)
    {
        wdWait.until(ExpectedConditions.visibilityOf(searchInputField));
        searchInputField.sendKeys(searchTerm);
    }

    private void clickOnSearchButton()
    {
        wdWait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
    }

    public void searchIkea(String url, String searchTerm){
        navigateToIkeaHomePage(url);
        acceptAllCookiesFiled();
        inputTermInTheSearchField(searchTerm);
        clickOnSearchButton();
    }

}
