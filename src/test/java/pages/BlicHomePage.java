package pages;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlicHomePage extends BaseHelper
{
    @FindBy (name="q")
    WebElement searchBox;
    @FindBy (tagName="button")
    WebElement magniferGlassIcon;
    WebDriver driver;
    public BlicHomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
   private void navigateToBlicHomePage() { driver.get("https://www.blic.rs/");}
   private void enterSearchTermInSearchBox(String term) {searchBox.sendKeys(term);}
   private void clickOnMagnifierGlassIcon() {magniferGlassIcon.click();}
   public void search(String term)
   {
       navigateToBlicHomePage();
       enterSearchTermInSearchBox(term);
       clickOnMagnifierGlassIcon();
   }

}
