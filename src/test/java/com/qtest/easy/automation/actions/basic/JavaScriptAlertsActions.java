package com.qtest.easy.automation.actions.basic;

import com.qtest.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class JavaScriptAlertsActions extends GetPage {

    public JavaScriptAlertsActions(WebDriver driver) {
        super(driver, "basic/JavaScriptAlerts");
    }

    public void javaScriptAlertClick(){
        logInfo("Clicking on JavaScript Alert");

        wait.waitForElementToBeClickable(element("javaScriptAlertClick"));
        element("javaScriptAlertClick").click();

        logInfo("Successfully Clicked on JavaScript Alert");
    }

    public void verifyJavaScriptAlert(){
        logInfo("Verifying JavaScript Page");

        String actualUrl = getCurrentURL();
        String expectedUrl = "javascript-alert-box-demo.html";
        Assert.assertTrue(actualUrl.contains(expectedUrl));

        logInfo("Successfully Verified JavaScript Page");
    }

    public void simpleAlertBox(){
        logInfo("Verifying simple alert box");
        logInfo("Clicking on Simple alert Click Me Button");

        element("simpleClickMe").click();

        wait.waitForAlertToPresent();
        alertHandlerAccept();

        logInfo("Successfully Handled Simple Alert Box");
        wait.hardWait(1);
    }

    public void confirmAlertBox(){
        logInfo("Verifying Confirm alert box");

        logInfo("Clicking on Confirm alert Click Me Button");
        element("confirmClickMe").click();

        logInfo("Verifying for OK Confirm Alert button");
        wait.waitForAlertToPresent();
        alertHandlerAccept();

        String confirmMessage = element("confirmMessage").getText();
        Assert.assertTrue(confirmMessage.contains("OK!"));
        logInfo("Successfully Verified OK Confirm Alert button");

        logInfo("Verifying for Cancel Confirm Alert button");
        element("confirmClickMe").click();

        wait.waitForAlertToPresent();
        alertHandlerDismiss();

        confirmMessage = element("confirmMessage").getText();
        Assert.assertTrue(confirmMessage.contains("Cancel!"));
        logInfo("Successfully Verified Cancel Confirm Alert button");

        logInfo("Confirm Alert successfully verified");
        wait.hardWait(1);
    }

    public void promptAlertBox(){
        String promptMessage = "This is my Name";
        logInfo("Verifying Prompt alert box");
        logInfo("Clicking on Prompt alert Click Me Button");

        element("promptClickMe").click();

        logInfo("Sending data to Prompt Alert Box");
        wait.waitForAlertToPresent();
        promptAlertHandler(promptMessage);

        logInfo("Verifying Prompt alert box data");
        String actualPromptMessage = element("promptMessage").getText();

        Assert.assertTrue(actualPromptMessage.contains(promptMessage));
        logInfo("Successfully Verified Prompt Alert Box");

        wait.hardWait(1);
    }
}
