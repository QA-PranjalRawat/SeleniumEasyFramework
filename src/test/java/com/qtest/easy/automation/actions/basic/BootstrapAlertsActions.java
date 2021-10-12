package com.qtest.easy.automation.actions.basic;

import com.qtest.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BootstrapAlertsActions extends GetPage {

    public BootstrapAlertsActions(WebDriver driver) {
        super(driver, "basic/BootstrapAlerts");
    }

    public void bootstrapAlertClick(){
        logInfo("Clicking on Bootstrap Alerts");

        wait.waitForElementToBeClickable(element("bootstrapAlertClick"));
        element("bootstrapAlertClick").click();

        logInfo("Successfully Clicked on Bootstrap Alert");
    }

    public void verifyBootstrapAlertPage(){
        logInfo("Verifying Bootstrap Alert Page");

        String expectedUrl = "bootstrap-alert-messages-demo.html";
        String actualUrl = getCurrentURL();

        Assert.assertTrue(actualUrl.contains(expectedUrl));
        logInfo("Successfully verified Bootstrap Alert Page");
    }

    public void autocloseableSuccessMessage(){
        logInfo("Verifying Autocloseable Success Message");
        logInfo("Clicking on Autocloseable Success Message");

        element("autocloseableSuccessBtn").click();
        String expectedMessage = "autocloseable success message";

        logInfo("Retrieving and Asserting Success Message");
        String actualMessage = element("alertMessage").getText();

        Assert.assertTrue(actualMessage.contains(expectedMessage));
        logInfo("Successfully Verified Autocloseable Success Message");
        wait.hardWait(1);
    }

    public void normalSuccessMessage(){
        refreshPage();
        logInfo("Verifying Normal Success Message");
        logInfo("Clicking on Normal Success Message");

        element("normalSuccessBtn").click();
        String expectedMessage = "normal success message";

        logInfo("Retrieving and Asserting Success Message");
        String actualMessage = element("alertMessage").getText();

        element("alertCloseBtn").click();

        Assert.assertTrue(actualMessage.contains(expectedMessage));
        logInfo("Successfully Verified Normal Success Message");
        wait.hardWait(1);
    }

    public void autocloseableWarningMessage(){
        logInfo("Verifying Autocloseable Warning Message");
        logInfo("Clicking on Autocloseable Warning Message");

        element("autocloseableWarningBtn").click();
        String expectedMessage = "autocloseable warning message";

        logInfo("Retrieving and Asserting Warning Message");
        String actualMessage = element("alertMessage").getText();

        Assert.assertTrue(actualMessage.contains(expectedMessage));
        logInfo("Successfully Verified Autocloseable Warning Message");
        wait.hardWait(1);
    }

    public void normalWarningMessage(){
        refreshPage();
        logInfo("Verifying Normal Warning Message");
        logInfo("Clicking on Normal Warning Message");

        element("normalWarningBtn").click();
        String expectedMessage = "normal warning message";

        logInfo("Retrieving and Asserting Warning Message");
        String actualMessage = element("alertMessage").getText();

        element("alertCloseBtn").click();

        Assert.assertTrue(actualMessage.contains(expectedMessage));
        logInfo("Successfully Verified Normal Warning Message");
        wait.hardWait(1);
    }

    public void autocloseableDangerMessage(){
        logInfo("Verifying Autocloseable Danger Message");
        logInfo("Clicking on Autocloseable Danger Message");

        element("autocloseableDangerBtn").click();
        String expectedMessage = "autocloseable danger message";

        logInfo("Retrieving and Asserting Danger Message");
        String actualMessage = element("alertMessage").getText();

        Assert.assertTrue(actualMessage.contains(expectedMessage));
        logInfo("Successfully Verified Autocloseable Danger Message");
        wait.hardWait(1);
    }

    public void normalDangerMessage(){
        refreshPage();
        logInfo("Verifying Normal Danger Message");
        logInfo("Clicking on Normal Danger Message");

        element("normalDangerBtn").click();
        String expectedMessage = "normal danger message";

        logInfo("Retrieving and Asserting Danger Message");
        String actualMessage = element("alertMessage").getText();

        element("alertCloseBtn").click();

        Assert.assertTrue(actualMessage.contains(expectedMessage));
        logInfo("Successfully Verified Normal Danger Message");
        wait.hardWait(1);
    }

    public void autocloseableInfoMessage(){
        logInfo("Verifying Autocloseable Info Message");
        logInfo("Clicking on Autocloseable Info Message");

        element("autocloseableInfoBtn").click();
        String expectedMessage = "autocloseable info message";

        logInfo("Retrieving and Asserting Info Message");
        String actualMessage = element("alertMessage").getText();

        Assert.assertTrue(actualMessage.contains(expectedMessage));
        logInfo("Successfully Verified Autocloseable Info Message");
        wait.hardWait(1);
    }

    public void normalInfoMessage(){
        refreshPage();
        logInfo("Verifying Normal Info Message");
        logInfo("Clicking on Normal Info Message");

        element("normalInfoBtn").click();
        String expectedMessage = "normal info message";

        logInfo("Retrieving and Asserting Info Message");
        String actualMessage = element("alertMessage").getText();

        element("alertCloseBtn").click();

        Assert.assertTrue(actualMessage.contains(expectedMessage));
        logInfo("Successfully Verified Normal Info Message");
        wait.hardWait(1);
    }

}
