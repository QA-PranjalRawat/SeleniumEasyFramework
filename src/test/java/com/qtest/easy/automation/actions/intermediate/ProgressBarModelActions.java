package com.qtest.easy.automation.actions.intermediate;

import com.qtest.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProgressBarModelActions extends GetPage {

    public ProgressBarModelActions(WebDriver driver) {
        super(driver, "intermediate/ProgressBarModel");
    }

    public void progressBarModelClick(){
        logInfo("Clicking on Progress Bar Modal");

        wait.waitForElementToBeClickable(element("progressBarBtn"));
        element("progressBarBtn").click();

        logInfo("Successfully Clicked on Progress Bar Model");
    }

    public void verifyProgressBarPage(){
        logInfo("Verifying Progress Bar Model Page");

        String expectedUrl = "bootstrap-progress-bar-dialog-demo.html";
        String actualUrl = getCurrentURL();

        Assert.assertTrue(actualUrl.contains(expectedUrl));
        logInfo("Successfully Verified Progress Bar Model Page");
    }

    public void dialogProgressBar(){
        logInfo("Verifying Modal dialog with progress bar");

        logInfo("Verifying Simple Dialog");
        logInfo("Clicking on Show Dialog");

        wait.waitForElementToBeClickable(element("simpleDialogBtn"));
        element("simpleDialogBtn").click();
        wait.waitForElementToBeVisible(element("progressModalHead"));

        String actualTitle = element("progressModalHead").getText();
        String expectedTitle = "Loading";

        Assert.assertTrue(actualTitle.contains(expectedTitle));
        logInfo("Successfully Verified Simple Dialog");
        wait.hardWait(3);


        logInfo("Verifying Dialog with Custom message");
        logInfo("Clicking on Show Dialog");

        wait.waitForElementToBeClickable(element("customMessageDialogBtn"));
        element("customMessageDialogBtn").click();
        wait.waitForElementToBeVisible(element("progressModalHead"));

        actualTitle = element("progressModalHead").getText();
        expectedTitle = "Custom message";

        Assert.assertTrue(actualTitle.contains(expectedTitle));
        logInfo("Successfully Dialog with Custom message");
        wait.hardWait(3);

        logInfo("Verifying Dialog with Custom Settings");
        logInfo("Clicking on Show Dialog");

        wait.waitForElementToBeClickable(element("customSettingDialogBtn"));
        element("customSettingDialogBtn").click();
        wait.waitForElementToBeVisible(element("progressModalHead"));

        actualTitle = element("progressModalHead").getText();
        expectedTitle = "Hello Mr. Alert !";

        Assert.assertTrue(actualTitle.contains(expectedTitle));
        logInfo("Successfully Dialog with Custom Settings");

        logInfo("Successfully Verified Modal dialog with progress bar");
    }
}
