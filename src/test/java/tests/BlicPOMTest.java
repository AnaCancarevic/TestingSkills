package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BlicArticlesPage;
import pages.BlicHomePage;

public class BlicPOMTest extends BaseTest
{

    @Test
    public void articlesTitleCheckTest() throws InterruptedException
    {

        String term="Veselin Jevrosimović";
        BlicHomePage homepage=new BlicHomePage(driver);
        homepage.search(term);

        BlicArticlesPage articlelist=new BlicArticlesPage(driver);
        articlelist.clickOnThirdArticle(term);


        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h2")));
        WebElement title=driver.findElement(By.tagName("h2"));

        String titleText= title.getText();
        System.out.println("title:"+titleText);

        Assert.assertTrue(articlelist.textFromArticleTitle.contains(titleText));
    }


}
