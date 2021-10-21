package com.qtest.easy.automation.actions.advanced;

import com.qtest.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TableFilterActions extends GetPage {
    public TableFilterActions(WebDriver driver) {
        super(driver, "advanced/TableFilter");
    }

    public void tableFilterClick(){
        logInfo("CLicking on Table Filter");

        wait.waitForElementToBeClickable(element("tableFilterBtn"));
        element("tableFilterBtn").click();
        logInfo("Successfully CLicked on Table Filter");
    }

    public void verifyTableFilterPage(){
        logInfo("Verifying Table Filter Page");

        String expectedUrl = "table-records-filter-demo.html";
        String actualUrl = getCurrentURL();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        logInfo("Successfully Verified Table Filter Page");
    }

    public void tableRecordsFilter(){
        logInfo("Verifying the Functionality of Table Filter");
        int total =5;
        int totalElements=0;

        logInfo("Verifying the Number of Green Element present");
        wait.waitForElementToBeClickable(element("greenFilterBtn"));
        element("greenFilterBtn").click();
        wait.hardWait(1);
        totalElements = getElementsHiddens("nonFilteredElements").size();
        Assert.assertEquals(2,totalElements);
        logInfo("Successfully Verified the Number of Green Element present");

        logInfo("Verifying the Number of Orange Element present");
        wait.waitForElementToBeClickable(element("orangeFilterBtn")).click();
        wait.hardWait(1);
        totalElements = getElementsHiddens("nonFilteredElements").size();
        Assert.assertEquals(2,totalElements);
        logInfo("Successfully Verified the Number of Orange Element present");

        logInfo("Verifying the Number of Red Element present");
        wait.waitForElementToBeClickable(element("redFilterBtn")).click();
        wait.hardWait(1);
        totalElements = getElementsHiddens("nonFilteredElements").size();
        Assert.assertEquals(1,totalElements);
        logInfo("Successfully Verified the Number of Red Element present");

        logInfo("Verifying the Number of All Element present");
        wait.waitForElementToBeClickable(element("allFilterBtn")).click();
        wait.hardWait(1);
        totalElements = getElementsHiddens("nonFilteredElements").size();
        Assert.assertEquals(total,totalElements);
        logInfo("Successfully Verified the Number of All Element present");

        logInfo("Successfully Verified the Functionality of Table Filter");
        wait.hardWait(1);
    }
}
