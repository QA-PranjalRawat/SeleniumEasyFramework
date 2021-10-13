package com.qtest.easy.automation.actions.intermediate;

import com.qtest.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AjaxFormActions extends GetPage {

    public AjaxFormActions(WebDriver driver) {
        super(driver, "intermediate/AjaxForm");
    }

    public void clickOnAjaxFormSubmit(){
        logInfo("Clicking on Ajax Form Submit");

        wait.waitForElementToBeClickable(element("ajaxFormBtn"));
        element("ajaxFormBtn").click();

        logInfo("Successfully Clicked on Ajax Form");
    }

    public void verifyAjaxFormPage(){
        logInfo("Verifying Ajax Form Page");

        String expectedUrl = "ajax-form-submit-demo.html";
        String actualUrl = getCurrentURL();

        Assert.assertTrue(actualUrl.contains(expectedUrl));
        logInfo("Successfully Verified Ajax Form Page");
    }

    public void ajaxForm() {

        String name = "THis is my name";
        String comment = "Hi, this is the comment for this Ajax Form";
        String expectedProcessingMessage = "Ajax Request is Processing!";
        String expectedSuccessMessage = "Form submited Successfully!";

        logInfo("Verifying Ajax FOrm");
        logInfo("Filling the Form");

        logInfo("Entering the Name");
        element("name").sendKeys(name);

        logInfo("Entering Comment");
        element("comment").sendKeys(comment);

        logInfo("Submitting the Form");
        wait.waitForElementToBeClickable(element("submitBtn"));
        element("submitBtn").click();

        String actualProcessingMessage = element("submitMessage").getText();

        logInfo("Verifying Processing Message");
        Assert.assertTrue(actualProcessingMessage.contains(expectedProcessingMessage));
        logInfo("Processing Message Successfully Verified");

        wait.waitForExactValueOfElement(element("submitMessage"),expectedSuccessMessage);
        String actualSuccessMessage = element("submitMessage").getText();

        logInfo("Verifying Success Message");
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage));
        logInfo("Success Message Successfully Verified");

        logInfo("Ajax Form Successfully Verified");
        wait.hardWait(1);
    }
}
