package testCases.ContactUs;

import Pages.ContactUsPage;
import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestContactUs extends TestBase {
    @Test(description = "Verify that a user can submit the contact us form successfully.")
    public void testContactUsFormSubmission() {
        //Verify that home page is visible successfully
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");
        //Click on 'Contact Us' button
        homePage.clickContactUsButton();
        //Verify 'GET IN TOUCH' is visible
        Assert.assertTrue(contactUsPage.isGetInTouchVisible(), "'GET IN TOUCH' is not visible");
        //Enter name, email, subject and message
        contactUsPage.EnterName("John Doe");
        contactUsPage.EnterEmail("johndoe@example.com");
        contactUsPage.EnterSubject("Test Subject");
        contactUsPage.EnterMessage("Test Message");
        //Upload file
        contactUsPage.UploadFile("C:\\Users\\Magic\\OneDrive\\Desktop\\Test.txt");
        //Click 'Submit' button
        contactUsPage.SubmitForm();
        //Click OK button
        driver.switchTo().alert().accept();
        //Verify success message 'Success! Your details have been submitted successfully.' is visible
        Assert.assertTrue(contactUsPage.isSuccessMessageVisible(), "Success message is not visible");
        //Click 'Home' button and verify that landed to home page successfully
        contactUsPage.clickHomeButton();
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible after clicking 'Home' button");
    }

}
