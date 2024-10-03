package tests;

import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.IkeaAddingToCartPage;
import pages.IkeaHomePage;
import pages.IkeaSearchResultsPage;


public class IkeaPOMTest extends BaseTest{
    @SneakyThrows
    @Test
    public void IkeaPomTest()
    {
        String url="https://www.ikea.com/rs/sr/";
        String searchTerm="radni sto";
        String filter1="Cena";
        String price="0-4.999";
        String filter2="Vrsta";
        String productType="radni sto";
        String sortResultsFilter="Sortiraj";
        String sortOption="Cena: od najniže ka najvišoj";
        String messageText="Dodato u korpu";



        IkeaHomePage homePage=new IkeaHomePage(driver);
        homePage.searchIkea(url,searchTerm);


        IkeaSearchResultsPage resultsPage=new IkeaSearchResultsPage(driver);
        resultsPage.selectArticlesInPriceRange(filter1, price, filter2, productType, sortResultsFilter, sortOption);

        IkeaAddingToCartPage addingToCartPage=new IkeaAddingToCartPage(driver);
        addingToCartPage.clickOnButtonAddingToCartProduct();

        //poruka-dodato u korpu
        wdWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("rec-modal-header__title-wrapper--padded")));
        WebElement message=driver.findElement(By.className("rec-modal-header__title-wrapper--padded"));
        WebElement productDescriptionContainer=driver.findElement(By.className("rec-product__description"));

        //dva dugmeta sa akcijama
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("rec-add-to-cart-product-carousel")));
        WebElement continueShoppingButton=driver.findElement(By.className("rec-btn--secondary"));
        WebElement goToShoppingCart=driver.findElement(By.className("rec-btn--primary"));


        Assert.assertTrue(message.getText().toLowerCase().contains(messageText.toLowerCase()));
        Assert.assertTrue(productDescriptionContainer.getText().toLowerCase().contains(searchTerm));
        Assert.assertTrue(continueShoppingButton.getText().contains("Nastavi kupovinu"));
        Assert.assertTrue(goToShoppingCart.getText().contains("Idi na korpu za kupovinu")); 





    }


}
