package Pages;

import java.util.List;
import java.util.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;


public class ProductPage {
    //Variable
    protected WebDriver driver;
    protected WebDriverWait wait;

    //Locators
    private final By productHeader = By.cssSelector("h2.title.text-center");
    private final By productList = By.className("features_items");
    private final By viewProduct = By.cssSelector("a[href='/product_details/1']");
    private final By productSearch = By.name("search");
    private final By SearchButton = By.id("submit_search");
    private final By searchedProducts = By.xpath("//h2[contains(.,'Searched Products')]");
    private final By productActualName = By.cssSelector(".productinfo.text-center p");
    private  By addProductToCart( int productId) { return By.cssSelector(".productinfo a[data-product-id='" + productId + "']"); };
    private final By modal = By.xpath("//h4[contains(text(), 'Added!')]");
    private final By continueShoppingButton = By.cssSelector("button[data-dismiss='modal']");
    private final By viewCartButton = By.xpath("//u[contains(text(), 'View Cart')]");


    //Constructor
    public ProductPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Actions
    public boolean isProductHeaderVisible(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productHeader)).isDisplayed();
    }

    public boolean isProductListVisible(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productList)).isDisplayed();
    }

    public void viewFirstProduct(){
        driver.findElement(viewProduct).click();
    }

    public void enterProductName(String ProductName){
        driver.findElement(productSearch).sendKeys(ProductName);
    }

    public void clickSearchButton(){
        driver.findElement(SearchButton).click();
    }

    public boolean isSearchedProductsVisible(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchedProducts)).isDisplayed();
    }

    public List<String> getProductActualName(){
        return wait.until
                (ExpectedConditions.visibilityOfAllElementsLocatedBy(productActualName)).stream().map(WebElement::getText).toList();
    }

    public void clickAddToCartButton(int productId){
        wait.until(ExpectedConditions.elementToBeClickable(addProductToCart(productId))).click();
    }

    public boolean isModalVisible(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(modal)).isDisplayed();
    }

    public void clickContinueShoppingButton(){
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("cartModal")));
    }

    public void clickViewCartButton(){
        wait.until(ExpectedConditions.elementToBeClickable(viewCartButton)).click();
    }

}
