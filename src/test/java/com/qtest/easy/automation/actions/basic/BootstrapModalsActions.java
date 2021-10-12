package com.qtest.easy.automation.actions.basic;

import com.qtest.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BootstrapModalsActions extends GetPage {

    public BootstrapModalsActions(WebDriver driver) {
        super(driver, "basic/BootstrapModals");
    }

    public void bootstrapModalClick(){
        logInfo("Clicking on BootStrap Modal");

        wait.waitForElementToBeClickable(element("bootstrapModalClick"));
        element("bootstrapModalClick").click();

        logInfo("Successfully clicked on Bootstrap Modal");
    }

    public void verifyBootstrapModalPage(){
        logInfo("Verifying Bootstrap Modal Page");

        String expectedUrl = "bootstrap-modal-demo.html";
        String actualUrl = getCurrentURL();

        Assert.assertTrue(actualUrl.contains(expectedUrl));
        logInfo("Successfully Verified Bootstrap Modal Page");
    }

    public void singleBootstrapModal(){
        logInfo("Verifying Single Bootstrap Modal");

        logInfo("Clicking on Single Launch Modal Button");
        element("singleLaunchModalBtn").click();

        logInfo("Fetching Title of Single Launch Modal");
        String expectedTitle = "Modal Title";
        String actualTitle = element("singleModalTitle").getText();

        logInfo("Closing the Single Modal");
        element("singleModalCloseBtn").click();

        Assert.assertTrue(actualTitle.contains(expectedTitle));
        logInfo("Single Bootstrap Modal Successfully Verified");
    }

    public void MultiBootstrapModal(){
        logInfo("Verifying Multiple Bootstrap Modal");

        logInfo("Clicking on multi Launch Modal Button");
        element("multipleLaunchModalBtn").click();

        logInfo("Verifying First Multi Modal");

        logInfo("Fetching Title of First Multi Launch Modal");
        String expectedFirstModalTitle = "First Modal";
        String actualFirstModalTitle = element("firstMultiModalTitle").getText();

        Assert.assertTrue(actualFirstModalTitle.contains(expectedFirstModalTitle));
        logInfo("Successfully Verified First Multi Modal");

        logInfo("Verifying Second Multi Modal");

        logInfo("Launching Second Multi Modal");
        element("secondMultiModalLaunchBtn").click();

        logInfo("Fetching Title of Second Multi Launch Modal");
        String expectedSecondModalTitle = "Modal 2";
        String actualSecondModalTitle = element("secondMultiModalTitle").getText();

        Assert.assertTrue(actualSecondModalTitle.contains(expectedSecondModalTitle));
        logInfo("Successfully Verified Second Multi Modal");

        logInfo("Closing the Second Multi Modal");
        element("secondMultiModalCloseBtn").click();

        logInfo("Closing the First Multi Modal");
        element("firstMultiModalCloseBtn").click();

        logInfo("Successfully Verified Bootstrap Multi Modal");
    }
}
