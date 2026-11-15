package testCases.registrationTestCases;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest extends TestBase {
    @Test(description = "Verify that a user can sign up successfully with valid credentials and can delete their account.")
    public void testSignUpAndDeleteAccount() {
        //Verify that home page is visible successfully
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");
        //Click on 'Signup / Login' button
        homePage.NavigateToRegisterPage();
        //Verify 'New User Signup!' is visible
        Assert.assertTrue(signupLoginPage.isSignUpTextVisible(), "Sign Up text is not visible");
        //Enter name and email address
        signupLoginPage.EnterName("Ali");
        String email = "ali" + System.currentTimeMillis() + "@gmail.com";
        signupLoginPage.EnterEmail(email);
        //Click 'Signup' button
        signupLoginPage.clickSignUpButton();
        // Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue(fillDetailsPage.isEnterAccountInformationTextVisible(), "Enter Account Information section is not visible");

        // Fill details
        fillDetailsPage.selectMale();
        fillDetailsPage.setPassword("123456");
        fillDetailsPage.selectDay("1");
        fillDetailsPage.selectMonth("January");
        fillDetailsPage.selectYear("2000");
        fillDetailsPage.selectNewsletter();
        fillDetailsPage.selectOffers();
        fillDetailsPage.setFirstName("Ali");
        fillDetailsPage.setLastName("Khan");
        fillDetailsPage.setCompany("ABC Company");
        fillDetailsPage.setAddress("123 Main St");
        fillDetailsPage.selectCountry("Canada");
        fillDetailsPage.setState("Ontario");
        fillDetailsPage.setCity("Toronto");
        fillDetailsPage.setZipcode("M1A 2B3");
        fillDetailsPage.setMobileNumber("1234567890");

        //Click 'Create Account button'
        fillDetailsPage.clickCreateAccountButton();
        //Verify that 'ACCOUNT CREATED!' is visible
        Assert.assertTrue(creationPage.isAccountCreated(), "Account Created text is not visible");
        //Click 'Continue' button
        creationPage.clickContinueButton();
        //Verify that 'Logged in as username' is visible
        Assert.assertTrue(homePage.isLoggedIn(), "User is not logged in");
        //Click 'Delete Account' button
        homePage.DeleteAccount();
        //Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        Assert.assertTrue(accountDeletedPage.isAccountDeleted(), "Account Deleted text is not visible");
        accountDeletedPage.clickContinueButton();
        //Verify that home page is visible successfully
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");
    }

    @Test(description = "Verify that a user cannot sign up with existing email address.")
    public void testSignUpWithExistingEmail() {
        //Verify that home page is visible successfully
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");
        //Click on 'Signup / Login' button
        homePage.NavigateToRegisterPage();
        //Verify 'New User Signup!' is visible
        Assert.assertTrue(signupLoginPage.isSignUpTextVisible(), "Sign Up text is not visible");
        //Enter name and email address
        signupLoginPage.EnterName("Ali");
        signupLoginPage.EnterEmail("ali@gmail.com");
        //Click 'Signup' button
        signupLoginPage.clickSignUpButton();
        //Verify error 'Email Address already exist!' is visible
        Assert.assertTrue(signupLoginPage.isEmailExistingErrorVisible(), "Email already exist error is not visible");

    }
}
