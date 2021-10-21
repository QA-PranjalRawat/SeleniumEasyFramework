package com.qtest.easy.automation.actions.advanced;

import com.qtest.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TableDataSearchActions extends GetPage {
    public TableDataSearchActions(WebDriver driver) {
        super(driver, "advanced/TableDataSearch");
    }

    public void tableDataSearchClick(){
        logInfo("Clicking on Table Data Search");

        wait.waitForElementToBeClickable(element("tableSearchBtn"));
        element("tableSearchBtn").click();

        logInfo("Successfully clicked on Table Data Search");
    }

    public void verifyTableDataSearchPage(){
        logInfo("Verifying Table Data Search Page");

        String expectedUrl = "table-search-filter-demo.html";
        String actualUrl = getCurrentURL();

        Assert.assertTrue(actualUrl.contains(expectedUrl));
        logInfo("Successfully Verified Table Data Search Page");
    }

    public void singleTableRowFilter(){

        String task = "SEO tags";
        String assignee = "Jane Doe";
        String status = "completed";

        logInfo("Filtering data in the Table");
        element("inputFilterField").sendKeys("9");
        element("inputFilterField").clear();

        logInfo("Filtering data based on Task");
        element("inputFilterField").sendKeys(task);
        Assert.assertTrue(contains("filteredRow",task));
        logInfo("Successfully Verified data filtered by Task");
        element("inputFilterField").clear();

        logInfo("Filtering data based on Assignee");
        element("inputFilterField").sendKeys(assignee);
        Assert.assertTrue(contains("filteredRow",assignee));
        logInfo("Successfully Verified data filtered by Assignee");
        element("inputFilterField").clear();

        logInfo("Filtering data based on Status");
        element("inputFilterField").sendKeys(status);
        Assert.assertTrue(contains("filteredRow",status));
        logInfo("Successfully Verified data filtered by Status");

        logInfo("Successfully Verified filtered data in the Table");
        wait.hardWait(1);
    }

    public void multiTableColumnFilter(){
        refreshPage();
        String id = "4";
        String username = "jacobs";
        String firstname = "Zieko";
        String lastname = "Dimarison";
        logInfo("Verifying Table Column Filter");

        logInfo("Enabling column Filtering");
        wait.waitForElementToBeClickable(element("filterActivateBtn"));
        element("filterActivateBtn").click();

        element("filterById").sendKeys("10");
        element("filterById").clear();

        logInfo("Filtering data based on Id");
        element("filterById").sendKeys(id);
        Assert.assertTrue(contains("filteredColumn",id));
        element("filterById").clear();
        logInfo("Successfully Verified Filtering data based on Id");

        logInfo("Filtering data based on username");
        element("filterByUsername").sendKeys(username);
        Assert.assertTrue(contains("filteredColumn",username));
        element("filterByUsername").clear();
        logInfo("Successfully Verified Filtering data based on username");

        logInfo("Filtering data based on firstname");
        element("filterByFirstName").sendKeys(firstname);
        Assert.assertTrue(contains("filteredColumn",firstname));
        element("filterByFirstName").clear();
        logInfo("Successfully Verified Filtering data based on firstname");

        logInfo("Filtering data based on lastname");
        element("filterByLastName").sendKeys(lastname);
        Assert.assertTrue(contains("filteredColumn",lastname));
        element("filterByLastName").clear();
        logInfo("Successfully Verified Filtering data based on lastname");

        logInfo("Successfully Verified Table Column Filter");
        wait.hardWait(1);
    }
}
