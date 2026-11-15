package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountDeletedPage {
    //variable
    protected WebDriver driver;
    protected WebDriverWait wait;

    //locators
    private final By isDeleted = By.xpath("//b[text()='Account Deleted!']");
    private final By continueButton = By.cssSelector("a[data-qa='continue-button']");

    //constructor
    public AccountDeletedPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //actions
    public boolean isAccountDeleted() {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(isDeleted))).isDisplayed();
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }
}
