package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    //variable
    protected WebDriver driver;
    protected WebDriverWait wait;


    //Locators
    private final By RegistrationPage = By.cssSelector("a[href='/login']");
    private final By Logedin = By.xpath("//a[contains(., 'Logged in as')]");
    private final By DeleteAccount = By.cssSelector("a[href='/delete_account']");
    private final By homeslider = By.id("slider");
    private final By logOutButton = By.cssSelector("a[href='/logout']");
    private final By contactUsButton = By.cssSelector("a[href='/contact_us']");
    private final By TestCasesButton = By.cssSelector("a[href='/test_cases']");
    private final By productButton = By.cssSelector("a[href='/products']");


    //Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Actions

    public void NavigateToRegisterPage() {
        driver.findElement(RegistrationPage).click();
    }

    public void DeleteAccount() {
        driver.findElement(DeleteAccount).click();
    }

    public boolean isLoggedIn() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(Logedin)).isDisplayed();
    }

    public boolean isHomePageVisible(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(homeslider)).isDisplayed();
    }

    public void clickLogoutButton() {
        driver.findElement(logOutButton).click();
    }

    public void clickContactUsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(contactUsButton)).click();
    }

    public void clickTestCasesButton() {
        wait.until(ExpectedConditions.elementToBeClickable(TestCasesButton)).click();
    }

    public void clickProductButton(){
        wait.until(ExpectedConditions.elementToBeClickable(productButton)).click();
    }
}
