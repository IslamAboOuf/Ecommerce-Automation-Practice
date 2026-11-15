package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreationPage {
    //variable
    protected WebDriver driver;
    protected WebDriverWait wait;

    //locators
    private final By isCreated = By.xpath("//b[text()='Account Created!']");
    private final By continueButton = By.cssSelector("a[data-qa='continue-button']");

    //constructor
    public CreationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //actions
    public boolean isAccountCreated() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(isCreated)).isDisplayed();
    }
    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }
}
