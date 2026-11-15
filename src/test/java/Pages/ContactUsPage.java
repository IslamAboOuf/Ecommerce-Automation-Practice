package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsPage {
    //variable
    protected WebDriver driver;
    protected WebDriverWait wait;

    //locators
    private final By contactUsForm = By.xpath("//h2[contains(., 'Get In Touch')]");
    private final By nameField = By.cssSelector("input[data-qa='name']");
    private final By emailField = By.cssSelector("input[data-qa='email']");
    private final By subjectField = By.cssSelector("input[data-qa='subject']");
    private final By messageField = By.cssSelector("textarea[data-qa='message']");
    private final By uploadFileButton = By.name("upload_file");
    private final By submitButton = By.cssSelector("input[data-qa='submit-button']");
    private final By successMessage = By.cssSelector("div.status.alert.alert-success");
    private final By homeButton = By.cssSelector(".btn.btn-success");

    //constructor
    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    //Actions
    public boolean isGetInTouchVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(contactUsForm)).isDisplayed();
    }
    public void EnterName(String name){
        driver.findElement(nameField).sendKeys(name);
    }
    public void EnterEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }
    public void EnterSubject(String subject){
        driver.findElement(subjectField).sendKeys(subject);
    }
    public void EnterMessage(String message){
        driver.findElement(messageField).sendKeys(message);
    }
    public void UploadFile(String filePath){
        driver.findElement(uploadFileButton).sendKeys(filePath);
    }
    public void SubmitForm(){
        driver.findElement(submitButton).click();
    }
    public boolean isSuccessMessageVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
    }
    public void clickHomeButton() {
        driver.findElement(homeButton).click();
    }

}
