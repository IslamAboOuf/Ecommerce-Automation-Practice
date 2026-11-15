package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    //variable
    protected WebDriver driver;
    protected WebDriverWait wait;

    //locators

    private final By shoppingCartTitle = By.xpath("//li[contains(text(),'Shopping Cart')]");
    private final By cartProductsTable = By.id("cart_info_table");
    private By productElement (int id){return By.id("product-" + id);}
    private  By getProductPrice (int id) { return By.xpath("//tr[@id='product-%d']//td[@class='cart_price']/p"); }
    private By getCartProductQuantity (int id) { return By.xpath("//tr[@id='product-%d']//td[@class='cart_quantity']/button"); }
    private By getProductTotalPrice (int id) { return By.xpath("//tr[@id='product-%d']//td[@class='cart_total']/p"); }

    //constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Actions
    public boolean isShoppingCartVisible(){
       return wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCartTitle)).isDisplayed();
    }

    public boolean isCartProductsTableVisible(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartProductsTable)).isDisplayed();
    }

    public boolean isProductInCart(int productId){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productElement(productId))).isDisplayed();
    }

    public String getProductInfo(int id){
        WebElement productRow = wait.until(ExpectedConditions.visibilityOfElementLocated(productElement(id)));
        String productName = productRow.findElement(By.xpath(".//td[@class='cart_description']/h4/a")).getText();
        String productPrice = productRow.findElement(By.xpath(".//td[@class='cart_price']/p")).getText();
        String productQuantity = productRow.findElement(By.xpath(".//td[@class='cart_quantity']/button")).getText();
        String productTotalPrice = productRow.findElement(By.xpath(".//td[@class='cart_total']/p")).getText();
        return String.format("Name: %s, Price: %s, Quantity: %s, Total Price: %s", productName, productPrice, productQuantity, productTotalPrice);
    }

}
