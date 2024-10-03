package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class IkeaSearchResultsPage  extends BaseHelper {
    WebDriver driver;

    public IkeaSearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "plp-filter-bar__options")
    WebElement filterBar;

   private WebElement filterBlock;

    @FindBy (className = "plp-drop-down")
    WebElement dropDownMenuPrice;

    @FindBy(id="filter-TYPE")
    WebElement dropDownMenuType;

    @FindBy (className = "plp-drop-down")
    WebElement dropDownMenuSort;

    @FindBy(className = "plp-price-module__name-decorator")
    WebElement lowestPriceResultLink;

    @FindBy (id="product-list")
    WebElement listOfSortedProducts;


    private void clickOnFilterPrice(String filter1) {
        wdWait.until(ExpectedConditions.visibilityOf(filterBar));
        List<WebElement> filterList = filterBar.findElements(By.tagName("button"));
        for (WebElement filter : filterList) {
            if (filter.getText().toLowerCase().contains(filter1.toLowerCase())) {
                filter.click();
                filterBlock = filter;
                break;
            }
        }
    }

    private void choosePriceOption(String price) {
        wdWait.until(ExpectedConditions.visibilityOf(dropDownMenuPrice));
        List<WebElement> priceOptions=dropDownMenuPrice.findElements(By.className("plp-checkbox__wrapper"));
        WebElement myPrice= priceOptions.get(0);
        myPrice.click();
    }


    private void clickOnFilterType(String filter2) {
        wdWait.until(ExpectedConditions.visibilityOf(filterBar));
        List<WebElement> filterList = filterBar.findElements(By.tagName("button"));
        for (WebElement filter : filterList) {
            if (filter.getText().toLowerCase().contains(filter2.toLowerCase())) {
                filter.click();
                filterBlock = filter;
                break;
            }

        }
    }

    private void chooseTypeOption(String productType) {
        wdWait.until(ExpectedConditions.visibilityOf(dropDownMenuType));
        List<WebElement> typeOptions=dropDownMenuPrice.findElements(By.className("plp-checkbox__wrapper"));
        for (WebElement myType : typeOptions) {
            if (myType.getText().toLowerCase().contains(productType.toLowerCase())) {
                myType.click();
            }
        }
    }

    private void sortResults(String sortResultsFilter) {
        wdWait.until(ExpectedConditions.visibilityOf(filterBar));
        List<WebElement> filterList = filterBar.findElements(By.tagName("button"));
        for (WebElement filter : filterList) {
            if (filter.getText().toLowerCase().contains(sortResultsFilter.toLowerCase())) {
                filter.click();
                filterBlock = filter;
                break;
            }
        }
    }

    private void selectTheSortMethod(String sortOption){
        wdWait.until(ExpectedConditions.visibilityOf(dropDownMenuSort));
        List<WebElement>sortOptions=dropDownMenuSort.findElements(By.className("plp-radio-button__text"));
        for (WebElement mySortOption:sortOptions){
            if(mySortOption.getText().toLowerCase().contains(sortOption.toLowerCase())){
                mySortOption.click();
            }
        }
    }

    private void clickOnLowestPriceResults(){
        wdWait.until(ExpectedConditions.visibilityOf(listOfSortedProducts));
        lowestPriceResultLink.click();
    }

    
    public void selectArticlesInPriceRange(String filter1, String price, String filter2, String productType, String sortResultsFilter, String sortOption) {
        clickOnFilterPrice(filter1);
        choosePriceOption(price);
        clickOnFilterType(filter2);
        chooseTypeOption(productType);
        sortResults(sortResultsFilter);
        selectTheSortMethod(sortOption);
        clickOnLowestPriceResults();
    }







}
