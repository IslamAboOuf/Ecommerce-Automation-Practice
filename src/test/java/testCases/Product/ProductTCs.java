package testCases.Product;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ProductTCs extends base.TestBase{
    @Test(description = "Verify that the user can view products on the Products page & Product Details Page.")
    public void viewProductsAndDetails(){
        //Verify that home page is visible successfully
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");
        //Click on 'Products' button
        homePage.clickProductButton();
        //Verify user is navigated to ALL PRODUCTS page successfully
        //Verify that products page is visible
        Assert.assertTrue(productPage.isProductListVisible(), "Products page is not visible");
        //Click on 'View Product' of first product
        productPage.viewFirstProduct();
        //User is landed to product detail page
        //Verify that detail is visible: product name, category, price, availability, condition, brand
        Assert.assertTrue(productDetailsPage.isProductDetailsVisible(), "Product name is not visible");
        //Get Product Details
        String productName = productDetailsPage.getProductName();
        String productCategory = productDetailsPage.getProductCategory();
        String productPrice = productDetailsPage.getProductPrice();
        String productAvailability = productDetailsPage.getProductAvailability();
        String productCondition = productDetailsPage.getProductCondition();
        String productBrand = productDetailsPage.getProductBrand();
        //Print Details
        System.out.println("Product Name: " + productName);
        System.out.println("Product Category: " + productCategory);
        System.out.println("Product Price: " + productPrice);
        System.out.println("Product Availability: " + productAvailability);
        System.out.println("Product Condition: " + productCondition);
        System.out.println("Product Brand: " + productBrand);

    }

    @Test
    public void productSearch(){
        //Verify that home page is visible successfully
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");
        //Click on 'Products' button
        homePage.clickProductButton();
        //Verify user is navigated to ALL PRODUCTS page successfully
        //Verify that products page is visible
        Assert.assertTrue(productPage.isProductListVisible(), "Products page is not visible");
        //Search for product
        String productName = "T-Shirt";
        productPage.enterProductName(productName);
        productPage.clickSearchButton();
        //Verify 'SEARCHED PRODUCTS' is visible
        List<String> actualProductNames = productPage.getProductActualName();
        for(String name : actualProductNames){
            Assert.assertTrue(name.contains(productName), "Product name "+name+" does not match");
        }
    }

    @Test
    public void addToCart(){
        //Verify that home page is visible successfully
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");
        //Click on 'Products' button
        homePage.clickProductButton();
        //Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(productPage.isProductListVisible(), "Products page is not visible");
        //Click on 'Add to Cart' of first product
        productPage.clickAddToCartButton(1);
        //Verify Modal Show Visible
        Assert.assertTrue(productPage.isModalVisible(), "Modal is not visible");
        //Click on 'Continue Shopping' button
        productPage.clickContinueShoppingButton();
        //Click on 'Add to Cart' of Second product
        productPage.clickAddToCartButton(2);
        //Verify Modal Show Visible
        Assert.assertTrue(productPage.isModalVisible(), "Modal is not visible");
        //Click 'View Cart' button
        productPage.clickViewCartButton();
        //Verify that cart page is displayed
        Assert.assertTrue(cartPage.isShoppingCartVisible(), "Cart page is not visible");
        //Verify both products are added to Cart

        Assert.assertTrue(cartPage.isCartProductsTableVisible(), "Cart products table is not visible");
        Assert.assertTrue(cartPage.isProductInCart(1), "First product is not in cart");
        Assert.assertTrue(cartPage.isProductInCart(2), "Second product is not in cart");
        //Verify their prices, quantity and total price

        System.out.println("------------------------------");
        System.out.println(cartPage.getProductInfo(1));
        System.out.println("------------------------------");
        System.out.println(cartPage.getProductInfo(2));




    }


}
