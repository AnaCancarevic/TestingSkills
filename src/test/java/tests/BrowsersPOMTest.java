package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.GoogleHomePage;

public class BrowsersPOMTest extends BaseTest
{
    @Test
    public void googleSearchTest() throws InterruptedException
    {
        String searchTerm="Veselin Jevrosimovic";

        GoogleHomePage homepage=new GoogleHomePage(driver);
        homepage.search(searchTerm);


        wdWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("rcnt")));
        WebElement searchResults= driver.findElement(By.id("rcnt"));

        Assert.assertTrue(searchResults.getText().contains(searchTerm));

        Thread.sleep(3000);

    }


}
