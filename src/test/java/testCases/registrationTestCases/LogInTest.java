package testCases.registrationTestCases;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTest extends TestBase {
    @Test(description = "Verify that user can log in with correct email and password")
    public void testLogIn() {
        //Verify that home page is visible successfully
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");
        //Click on 'Signup / Login' button
        homePage.NavigateToRegisterPage();
        //Verify 'Login to your account' text is visible
        Assert.assertTrue(signupLoginPage.isLoginTextVisible(), "Login text is not visible");
        //Enter correct email address and password
        signupLoginPage.LogInEmail("Testrawy@gmail.com");
        signupLoginPage.SetLoginPassword("123456");
        //Click 'Login' button
        signupLoginPage.clickLogInButton();
        //Verify that 'Logged in as username' is visible
        Assert.assertTrue(homePage.isLoggedIn(), "User is not logged in");

    }

    @Test(description = "Verify that user cannot log in with incorrect email and password")
    public void testLogInWithIncorrectCredentials() {
        //Verify that home page is visible successfully
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");
        //Click on 'Signup / Login' button
        homePage.NavigateToRegisterPage();
        //Verify 'Login to your account' text is visible
        Assert.assertTrue(signupLoginPage.isLoginTextVisible(), "Login text is not visible");
        //Enter incorrect email address and password
        signupLoginPage.LogInEmail("Testrwy@gmail.com");
        signupLoginPage.SetLoginPassword("wrongpassword");
        //Click 'Login' button
        signupLoginPage.clickLogInButton();
        //Verify that error message is visible
        Assert.assertTrue(signupLoginPage.isErrorMessageVisible(), "Error message is not visible");
    }

    @Test(description = "Verify that user can log in with correct email and password and log out successfully")
    public void testLogInAndLogOut() {
        //Verify that home page is visible successfully
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");
        //Click on 'Signup / Login' button
        homePage.NavigateToRegisterPage();
        //Verify 'Login to your account' text is visible
        Assert.assertTrue(signupLoginPage.isLoginTextVisible(), "Login text is not visible");
        //Enter correct email address and password
        signupLoginPage.LogInEmail("Testrawy@gmail.com");
        signupLoginPage.SetLoginPassword("123456");
        //Click 'Login' button
        signupLoginPage.clickLogInButton();
        //Verify that 'Logged in as username' is visible
        Assert.assertTrue(homePage.isLoggedIn(), "User is not logged in");
        //Click 'Logout' button
        homePage.clickLogoutButton();
        //Verify that user is navigated to login page
        Assert.assertTrue(signupLoginPage.isLoginTextVisible(), "Login text is not visible");
    }
}