package base;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {


    protected WebDriver driver;
    protected WebDriverWait wait;

    protected HomePage homePage;
    protected CreationPage creationPage;
    protected AccountDeletedPage accountDeletedPage;
    protected FillDetailsPage fillDetailsPage;
    protected SignupLoginPage signupLoginPage;
    protected ContactUsPage contactUsPage;
    protected TestCasesPage testCasesPage;
    protected ProductPage productPage;
    protected ProductDetailsPage productDetailsPage;
    protected CartPage cartPage;

    @BeforeMethod
    public void setup()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--user-data-dir=C:\\Selenium\\ChromeProfile"
        );
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");

        homePage = new HomePage(driver);
        creationPage = new CreationPage(driver);
        accountDeletedPage = new AccountDeletedPage(driver);
        fillDetailsPage = new FillDetailsPage(driver);
        signupLoginPage = new SignupLoginPage(driver);
        contactUsPage = new ContactUsPage(driver);
        testCasesPage = new TestCasesPage(driver);
        productPage = new ProductPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        cartPage = new CartPage(driver);
    }

    @AfterMethod
    public void close()
    {
        driver.quit();
    }

}
