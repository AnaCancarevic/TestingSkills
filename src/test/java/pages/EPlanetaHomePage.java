package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EPlanetaHomePage extends BaseHelper
{

    @FindBy(id = "search")
    WebElement searchInputField;

    @FindBy(id = "search_mini_form")
    WebElement searchComponent;

    public EPlanetaHomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    private void navigateToEPlaneta(String url)
    { driver.get(url);}

    private void enterSearchTerm(String searchTerm)
    { wdWait.until(ExpectedConditions.visibilityOf(searchInputField));
        searchInputField.sendKeys(searchTerm);}

    private void clickOnSearchButton()
    {  wdWait.until(ExpectedConditions.visibilityOf(searchComponent));
        WebElement searchButton = searchComponent.findElement(By.tagName("button"));
        searchButton.click();

    }

    public void searchTest(String url, String searchTerm)
    {
        navigateToEPlaneta(url);
        enterSearchTerm(searchTerm);
        clickOnSearchButton();
    }
}
