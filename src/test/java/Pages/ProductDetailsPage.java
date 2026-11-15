package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailsPage {
    //Variable
    protected WebDriver driver;
    protected WebDriverWait wait;

    //Locators
    private final By productName = By.cssSelector(".product-information h2");
    private final By productCategory = By.xpath("//div[@class='product-information']//p[contains(.,'Category:')]");
    private final By productPrice = By.xpath("//div[@class='product-information']//span[contains(.,'Rs')]");
    private final By productAvailability = By.xpath("//div[@class='product-information']//p[contains(.,'Availability:')]");
    private final By productCondition = By.xpath("//div[@class='product-information']//p[contains(.,'Condition:')]");
    private final By productBrand = By.xpath("//div[@class='product-information']//p[contains(.,'Brand:')]");
    private final By addToCartButton = By.cssSelector("button[class='btn btn-default cart']");


    //Constructor
    public ProductDetailsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Actions
    public boolean isProductDetailsVisible(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(productCategory)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(productAvailability)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(productCondition)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(productBrand)).isDisplayed();
        return true;
    }

    public String getProductName(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
    }

    public String getProductCategory(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productCategory)).getText();
    }

    public String getProductPrice(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice)).getText();
    }

    public String getProductAvailability(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productAvailability)).getText();
    }

    public String getProductCondition(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productCondition)).getText();
    }

    public String getProductBrand(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productBrand)).getText();
    }

    public void clickAddToCartButton(){
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }
}
