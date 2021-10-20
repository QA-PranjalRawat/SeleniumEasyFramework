package com.qtest.easy.automation.actions.advanced;

import com.qtest.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;

public class TablePaginationActions extends GetPage {
    public TablePaginationActions(WebDriver driver) {
        super(driver, "advanced/TablePagination");
    }

    public void tablePaginationClick(){
        logInfo("Clicking on Table Pagination");

        wait.waitForElementToBeClickable(element("tablePaginationBtn"));
        element("tablePaginationBtn").click();

        logInfo("Successfully Clicked on Table Pagination");
    }

    public void verifyTablePaginationPage(){
        logInfo("Verifying Table Pagination Page");

        String expectedUrl = "";
        String actualUrl = getCurrentURL();

        Assert.assertTrue(actualUrl.contains(expectedUrl));
        logInfo("Successfully Verified Table Pagination Page");
    }

    public void tableRowNumber(){
        logInfo("Performing actions on Table Pagination");

        logInfo("Verifying first Pagination Page");
        int first = 1;
        int last = 5;
        for(int i=first;i<=last;i++){
            Assert.assertTrue(contains("tableRowNo",String.valueOf(i)));
        }
        logInfo("Successfully Verified first Pagination Page");

        logInfo("Navigating to Next Page");
        wait.waitForElementToBeClickable(element("nextBtn"));
        element("nextBtn").click();

        logInfo("Verifying second Pagination Page");
        first = 6;
        last = 10;
        for(int i=first;i<=last;i++){
            Assert.assertTrue(contains("tableRowNo",String.valueOf(i)));
        }
        logInfo("Successfully Verified second Pagination Page");

        logInfo("Navigating to Next Page");
        wait.waitForElementToBeClickable(element("nextBtn"));
        element("nextBtn").click();

        logInfo("Verifying Third Pagination Page");
        first = 11;
        last = 13;
        for(int i=first;i<=last;i++){
            Assert.assertTrue(contains("tableRowNo",String.valueOf(i)));
        }
        logInfo("Successfully Verified Third Pagination Page");

        logInfo("Successfully Verified the Working of the Table Pagination");
        wait.hardWait(1);
    }
}
