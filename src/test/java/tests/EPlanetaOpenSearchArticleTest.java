package tests;

import lombok.SneakyThrows;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.EPlanetaHomePage;
import pages.EPlanetaSearchedResultsPage;

public class EPlanetaOpenSearchArticleTest extends BaseTest
{

    @Test
    @SneakyThrows
    public void ePlanetaSearchTest()
    {
        String url= "https://eplaneta.rs/";
        String searchTerm="usb";



        EPlanetaHomePage homepage=new EPlanetaHomePage(driver);
        homepage.searchTest(url,searchTerm);

        EPlanetaSearchedResultsPage resultsPage=new EPlanetaSearchedResultsPage(driver);
        resultsPage.clickOnRequestedArticle(searchTerm);

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("product-name")));
        WebElement article=driver.findElement(By.className("product-name"));
        String titleText=article.getText();
        System.out.println("title:" +titleText);

        Assert.assertTrue(article.getText().toLowerCase().contains(searchTerm));
    }
}



