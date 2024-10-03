package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IkeaAddingToCartPage extends BaseHelper {

    WebDriver driver;

    public IkeaAddingToCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy (className = "pip-buy-module__buy-button-container")
    WebElement addingToCartHolder;

    @FindBy (className = "pip-btn--emphasised")
    WebElement addingToCartButton;

   public void clickOnButtonAddingToCartProduct(){
        wdWait.until(ExpectedConditions.visibilityOf(addingToCartHolder));
      addingToCartButton.click();

    }




}
