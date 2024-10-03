package pages;

import helpers.BaseHelper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class EPlanetaSearchedResultsPage extends BaseHelper
{

    @FindBy (className = "products")
    WebElement searchedResults;



    public EPlanetaSearchedResultsPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

   public void clickOnRequestedArticle(String searchTerm)
   {
        wdWait.until(ExpectedConditions.visibilityOf(searchedResults));
        List<WebElement> articleList= searchedResults.findElements(By.tagName("li"));
       WebElement articleNumberOne = articleList.get(0);
       articleNumberOne.click();

   }


}
