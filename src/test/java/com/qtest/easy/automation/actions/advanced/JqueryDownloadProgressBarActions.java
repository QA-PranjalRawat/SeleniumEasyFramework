package com.qtest.easy.automation.actions.advanced;

import com.qtest.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class JqueryDownloadProgressBarActions extends GetPage {
    public JqueryDownloadProgressBarActions(WebDriver driver) {
        super(driver, "advanced/JqueryDownloadProgressBar");
    }

    public void jqueryDownloadProgressBarClick(){
        logInfo("Clicking on JQuery Download Progress Bar");
        wait.waitForElementToBeClickable(element("jqueryProgressBtn"));
        element("jqueryProgressBtn").click();
        logInfo("Successfully Clicked on JQuery Download Progress Bar");
    }

    public void verifyJqueryDownloadPage(){
        logInfo("Verifying Jquery Download Progress Bar Page");

        String expectedUrl = "jquery-download-progress-bar-demo.html";
        String actualUrl = getCurrentURL();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        logInfo("Successfully Verified Jquery Download Progress Page");
    }

    public void jqueryDownloadProgressBar(){
        logInfo("Verifying the Functionality of Jquery Download Progress bar");

        wait.waitForElementToBeClickable(element("downloadBtn"));
        element("downloadBtn").click();

        logInfo("Starting Downloading Progress Bar");
        wait.waitForElementToAppear(element("dialog"));
        wait.waitForExactValueOfElement(element("statusMessage"),"Complete!");
        Assert.assertTrue(element("statusMessage").getText().contains("Complete!"));
        logInfo("Download Progress Successfully Completed");

        wait.waitForExactValueOfElement(element("closeBtn"),"Close");
        element("closeBtn").click();

        logInfo("Successfully Verified the Functionality of Jquery Download Progress bar");
        wait.hardWait(1);
    }
}
