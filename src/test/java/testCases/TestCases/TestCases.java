package testCases.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCases extends base.TestBase{
    @Test(description = "Verify that the user can navigate to the Test Cases page from the home page")
    public void testNavigateToTestCasesPage() {
        //Verify that home page is visible successfully
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");
        //Click on 'Test Cases' button
        homePage.clickTestCasesButton();
        //Verify that user is navigated to Test Cases page successfully
        Assert.assertTrue(testCasesPage.isTestCasesHeaderVisible(), "Test Cases header is not visible");
    }
}
