package com.qtest.easy.automation.actions.advanced;

import com.qtest.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BootstrapDownloadProgressBarActions extends GetPage {
    public BootstrapDownloadProgressBarActions(WebDriver driver) {
        super(driver, "advanced/BootstrapDownloadProgressBar");
    }

    public void bootstrapDownloadProgressBarClick(){
        logInfo("Clicking on Bootstrap Download Progress Bar");

        wait.waitForElementToBeClickable(element("bootstrapDownloadBtn"));
        element("bootstrapDownloadBtn").click();
        logInfo("Successfully Clicked on Bootstrap download Progress Bar");
    }

    public void verifyBootstrapDownloadProgressBarPage(){
        logInfo("Verifying Bootstrap Download Progress Page");

        String expectedUrl = "bootstrap-download-progress-demo.html";
        String actualUrl = getCurrentURL();

        Assert.assertTrue(actualUrl.contains(expectedUrl));
        logInfo("Successfully Verified Bootstrap Download Progress Bar Page");
    }

    public void bootstrapDownloadProgressBar(){
        logInfo("Verifying the Functionality of Bootstrap Download Progress Bar");

        wait.waitForElementToBeClickable(element("downloadBtn"));
        element("downloadBtn").click();
        logInfo("Downloading Progress Bar Started");

        wait.waitForExactValueOfElement(element("percentText"),"100%");
        Assert.assertTrue(element("percentText").getText().contains("100%"));
        logInfo("Download Successfully Completed");

        logInfo("Successfully verified the Functionality of Bootstrap Download Progress Bar");
        wait.hardWait(1);
    }
}
