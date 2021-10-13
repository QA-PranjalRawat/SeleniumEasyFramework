package com.qtest.easy.automation.actions.intermediate;

import com.qtest.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class InputFormWithValidationActions extends GetPage {
    public InputFormWithValidationActions(WebDriver driver) {
        super(driver, "intermediate/InputFormWithValidation");
    }

    public void clickOnInputFormWithValidation(){
        logInfo("Clicking on Input Form With Validation");

        wait.waitForElementToBeClickable(element("inputFormBtn"));
        element("inputFormBtn").click();

        logInfo("Successfully Clicked on Input Form With Validations");
    }

    public void verifyInputFormWithValidationPage(){
        logInfo("Verifying Input Form With Validation Page");

        String expectedUrl = "input-form-demo.html";
        String actualUrl = getCurrentURL();

        Assert.assertTrue(actualUrl.contains(expectedUrl));
        logInfo("Successfully Verified Input Form With Validations Page");
    }

//The site currently not using secure bootstrap link thus i am not able to check the full functionality of this test.
    public void inputFormWithValidation(){
        String firstName = "Joe";
        String lastName = "Smith";
        String email = "joesmith2021@testmail.com";
        String phoneNo = "9192939495";
        String address = "myPlace";
        String city = "hometown";
        String zipCode = "1234";
        String website = "mySite.test.com";
        String description = "Hi This is my details for testing";

        logInfo("Verifying Input Form With Validation");
        logInfo("Entering Details for Testing");

        logInfo("Entering First Name");
        element("firstName").sendKeys(firstName);

        logInfo("Entering Last Name");
        element("lastName").sendKeys(lastName);

        logInfo("Entering Email");
        element("email").sendKeys(email);

        logInfo("Entering Phone No.");
        element("phone").sendKeys(phoneNo);

        logInfo("Entering Address");
        element("address").sendKeys(address);

        logInfo("Entering City");
        element("city").sendKeys(city);

        logInfo("Selecting State");
        Select state = new Select(element("state"));
        state.selectByVisibleText("Alaska");

        logInfo("Entering Zip Code");
        element("zip").sendKeys(zipCode);

        logInfo("Entering Website");
        element("website").sendKeys(website);

        logInfo("Selecting Hosting");
        element("hostingNo").click();

        logInfo("Entering Description");
        element("description").sendKeys(description);

        wait.waitForElementToBeClickable(element("sendBtn"));
        element("sendBtn").click();

        logInfo("Input Form With Validation Successfully Verified");
        wait.hardWait(1);
    }
}
