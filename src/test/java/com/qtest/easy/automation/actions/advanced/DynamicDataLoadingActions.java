package com.qtest.easy.automation.actions.advanced;

import com.qtest.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DynamicDataLoadingActions extends GetPage {

    public DynamicDataLoadingActions(WebDriver driver){
        super(driver, "advanced/DynamicDataLoading");
    }

    public void dynamicDataLoadingClick(){
        logInfo("Clicking on Dynamic Data Loading");

        wait.waitForElementToBeClickable(element("dynamicDataBtn"));
        element("dynamicDataBtn").click();
        logInfo("Successfully Clicked on Dynamic Data Loading");
    }

    public void verifyDynamicDataLoadingPage(){
        logInfo("Verifying Dynamic Data Loading Page");

        String expectedUrl = "dynamic-data-loading-demo.html";
        String actualUrl = getCurrentURL();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        logInfo("Successfully Verified Dynamic Data Loading Page");
    }

    public void dynamicDataLoading(){
        logInfo("Verifying the Functionality of Dynamic Data Loading");

        wait.waitForElementToBeClickable(element("getNewUser"));
        element("getNewUser").click();

        wait.waitUntilExactValueOfElement(element("loading"),"loading...");

        Assert.assertTrue(element("loading").getText().contains("First Name"));
        Assert.assertTrue(element("loading").getText().contains("Last Name"));

        logInfo("Successfully Verified Dynamic Data Loading");
        wait.hardWait(1);
//        System.out.println(element("loading").getText());
    }
}
