package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignupLoginPage {
    //variable
    protected WebDriver driver;
    protected WebDriverWait wait;


    //Locators
    private final By nameField = By.cssSelector("input[data-qa='signup-name']");
    private final By emailField = By.cssSelector("input[data-qa='signup-email']");
    private final By signUpButton = By.cssSelector("button[data-qa='signup-button']");
    private final By isSignUpTextVisible = By.xpath("//h2[text()='New User Signup!']");
    private final By LoginText = By.xpath("//h2[text()='Login to your account']");
    private final By LoginEmail = By.cssSelector("input[data-qa='login-email']");
    private final By LoginPassword = By.cssSelector("input[data-qa='login-password']");
    private final By logInButton = By.cssSelector("button[data-qa='login-button']");
    private final By LoginError = By.xpath("//p[text()='Your email or password is incorrect!']");
    private final By emailExistingError = By.xpath("//p[text()='Email Address already exist!']");


    //Constructor
    public SignupLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Actions
    public void EnterName(String name){
        driver.findElement(nameField).sendKeys(name);
    }

    public void EnterEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public void clickSignUpButton() {
        driver.findElement(signUpButton).click();
    }

    public boolean isSignUpTextVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(isSignUpTextVisible)).isDisplayed();
    }

    public boolean isLoginTextVisible(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(LoginText)).isDisplayed();

    }

    public void LogInEmail(String email){
        driver.findElement(LoginEmail).sendKeys(email);
    }

    public void SetLoginPassword(String password){
        driver.findElement(LoginPassword).sendKeys(password);
    }

    public void clickLogInButton() {
        driver.findElement(logInButton).click();
    }

    public boolean isErrorMessageVisible(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(LoginError)).isDisplayed();
    }

    public boolean isEmailExistingErrorVisible(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emailExistingError)).isDisplayed();
    }
}
