package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.LimundoSearchResultsPageDrugiPut;
import pages.LimundoWellcomePageDrugiPut;

import java.util.List;

public class LimundoFilterSearchResultsTestDrugiPut extends BaseTest{
    @Test
    public void LimundoFilterSearchResultsTestDrugiPut()
    {
        String url="https://www.limundo.com/";
        String searchTerm="Iphone";
        String searchCategoryName="Mobilni telefoni";
        String filterName="Cena";
        String priceFrom="1000";
        String priceTo="2000";

        LimundoWellcomePageDrugiPut searchOnWellcomePageDrugiPut= new LimundoWellcomePageDrugiPut(driver);
        searchOnWellcomePageDrugiPut.searchLimundo(url, searchTerm);

        LimundoSearchResultsPageDrugiPut resultsPageDrugiPut=new LimundoSearchResultsPageDrugiPut(driver);
        resultsPageDrugiPut.selectArticlesInPriceRange(searchCategoryName, filterName, priceFrom, priceTo);



        //search term is displayed on results page
        //klasa assert ima metodu assert true kojoj prosledjujemo uslov i poruku
        //prvi nacin je da samo napravim string od celog teksta iz pretrage i proverim da li sadrzi search term ali to da i neke koji ne sadrze
        //String filterResultsText=filterResults.getText();
        //Assert.assertTrue(filterResultsText.contains(searchTerm));

        //zato radim sa listom, prvo ceo web element sa rez  pretrage, pa onda listu sa svakim izvucenim, i for petlja
        //koja ide kroz listu, uzima svaki naslov koji nosi tag h3 i uporedjuje
        WebElement filterResults=driver.findElement(By.className("list-view-listing"));
        List<WebElement> results=filterResults.findElements(By.className("list-view-listing-item"));

        for (WebElement result:results){
            String title=result.findElement(By.tagName("h3")).getText();
            Assert.assertTrue("trazeni pojam se ne nalazi u rezultatima." + "\nNaslov artikla je: " + title + "\nOcekivano je da ce da sadrzi: " + searchTerm,title.toLowerCase().contains(searchTerm.toLowerCase()));
        }

      //moj test pada jer u listi ima clanova koji ne sadrze trazeni pojam


    }
}
