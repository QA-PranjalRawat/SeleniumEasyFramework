package com.qtest.easy.automation.actions.intermediate;

import com.qtest.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DataListFilterActions extends GetPage {
    public DataListFilterActions(WebDriver driver) {
        super(driver, "intermediate/DataListFilter");
    }

    public void dataListFilterClick(){
        logInfo("Clicking on Data List Filter");

        wait.waitForElementToBeClickable(element("dataListBtn"));
        element("dataListBtn").click();
        logInfo("Successfully Clicked on Data list filter");
    }

    public void verifyDataListPage(){
        logInfo("Verifying Data List Filter Page");

        String expectedUrl = "data-list-filter-demo.html";
        String actualUrl = getCurrentURL();
        System.out.println(actualUrl);
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        logInfo("Successfully Verified Data list Filter Page");
    }

    public void searchDataList(){
        String nameContains = "Glenn";
        String phoneContains = "555";
        logInfo("Verifying the Functionality of Search Field in Data List Filter");

        logInfo("Searching for elements in the search field whose name contains Glenn");
        element("searchInput").sendKeys(nameContains);

        logInfo("Verifying Number of Elements");
        int len = elements("listItems").size();
        Assert.assertEquals(len,2);
        logInfo("Successfully verified the number of elements whose name contains Glenn");

        logInfo("Searching for elements in the search field whose phone contains 555");
        element("searchInput").clear();
        element("searchInput").sendKeys(phoneContains);

        logInfo("Verifying Number of Elements");
        len = elements("listItems").size();
        Assert.assertEquals(len,3);
        logInfo("Successfully verified the number of elements whose phone contains 555");

        logInfo("Successfully Verified the Functionality of Search Field in Data List Filter");
        wait.hardWait(1);
    }
}
