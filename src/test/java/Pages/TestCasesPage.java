package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestCasesPage {
    //Variable
    protected WebDriver driver;
    protected WebDriverWait wait;

    //locators
    private final By testCasesHeader = By.cssSelector("h2.text-center");

    //Constructor
    public TestCasesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Actions
    public boolean isTestCasesHeaderVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(testCasesHeader)).isDisplayed();
    }
}
