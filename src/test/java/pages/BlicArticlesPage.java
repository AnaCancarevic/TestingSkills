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
public class BlicArticlesPage extends BaseHelper
{
    @FindBy(className="news-box")
    WebElement newsBox;
         WebDriver driver;
        public BlicArticlesPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
        public String textFromArticleTitle;
        public void clickOnThirdArticle(String term) {
            wdWait.until(ExpectedConditions.visibilityOf(newsBox));
             Assert.assertTrue(newsBox.getText().contains(term));
             List<WebElement> articles=newsBox.findElements(By.tagName("article"));
             System.out.println("List size: "+articles.size());
             System.out.println("Text from article at the beginning:"+ textFromArticleTitle);
             WebElement thirdArticle= articles.get(2);
             textFromArticleTitle=thirdArticle.getText();
             System.out.println("article text:"+ textFromArticleTitle);
             thirdArticle.findElement(By.tagName("h2")).click();
    }
}
