package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FillDetailsPage {
    //variable
    protected WebDriver driver;
    protected WebDriverWait wait;

    //Locators
    private final By accountInformationText = By.xpath("//b[text()='Enter Account Information']");
    private final By maleRadioButton = By.id("id_gender1");
    private final By femaleRadioButton = By.id("id_gender2");
    private final By passwordField = By.id("password");
    private final By dayDropdown = By.id("days");
    private final By monthDropdown = By.id("months");
    private final By yearDropdown = By.id("years");
    private final By newsletterCheckbox = By.id("newsletter");
    private final By offersCheckbox = By.id("optin");
    private final By firstNameField = By.id("first_name");
    private final By lastNameField = By.id("last_name");
    private final By companyField = By.id("company");
    private final By addressField = By.id("address1");
    private final By countryDropdown = By.id("country");
    private final By stateField = By.id("state");
    private final By cityField = By.id("city");
    private final By zipcodeField = By.id("zipcode");
    private final By mobileNumberField = By.id("mobile_number");
    private final By createAccountButton = By.cssSelector("button[data-qa='create-account']");

    //constructor
    public FillDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Actions

    public boolean isEnterAccountInformationTextVisible() {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(accountInformationText))).isDisplayed();
    }

    public void selectMale() {
        driver.findElement(maleRadioButton).click();
    }

    public void selectFemale() {
        driver.findElement(femaleRadioButton).click();
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void selectDay(String day) {
        new Select(driver.findElement(dayDropdown))
                .selectByValue(day);
    }

    public void selectMonth(String month) {
        new Select(driver.findElement(monthDropdown))
                .selectByVisibleText(month);
    }

    public void selectYear(String year) {
        new Select(driver.findElement(yearDropdown))
                .selectByValue(year);
    }

        public void selectNewsletter() {
        driver.findElement(newsletterCheckbox).click();
    }

    public void selectOffers() {
        driver.findElement(offersCheckbox).click();
    }

    public void setFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void setCompany(String company) {
        driver.findElement(companyField).sendKeys(company);
    }

    public void selectCountry(String country) {
        new Select(driver.findElement(countryDropdown))
                .selectByVisibleText(country);
    }

    public void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void setState(String state) {
        driver.findElement(stateField).sendKeys(state);
    }

    public void setCity(String city) {
        driver.findElement(cityField).sendKeys(city);
    }

    public void setZipcode(String zipcode) {
        driver.findElement(zipcodeField).sendKeys(zipcode);
    }

    public void setMobileNumber(String mobileNumber) {
        driver.findElement(mobileNumberField).sendKeys(mobileNumber);
    }

    public void clickCreateAccountButton() {
        driver.findElement(createAccountButton).click();
    }
}
