package pages;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CategoryPage extends BaseHelper
{
    @FindBy (className="sub-categories")
    WebElement categoryHolder;

    @FindBy (xpath = "/html/body/div[1]/div/div/div[1]/div/div[2]/div[1]/div/a[2]")
    WebElement buttonAutomobile;

    WebDriver driver;
    public CategoryPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    private void navigateToCategoryPage()
    {
       driver.get("https://olx.ba/kategorije");
    }

    private void clickOnButtonAutomobile()
    {
        buttonAutomobile.click();
    }

    public void openResults()
    {
        navigateToCategoryPage();
        clickOnButtonAutomobile();
    }
}
