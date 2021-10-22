package com.qtest.easy.automation.actions.advanced;

import com.qtest.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Collections;
import java.util.List;

public class TableSortAndSearchActions extends GetPage {
    public TableSortAndSearchActions(WebDriver driver) {
        super(driver, "advanced/TableSortAndSearch");
    }

    public void tableSortAndSearchClick(){
        logInfo("Clicking on Table Sort and Search");

        wait.waitForElementToBeClickable(element("tableSortSearchBtn"));
        element("tableSortSearchBtn").click();
        logInfo("Successfully Clicked on Table Sort and Search");
    }

    public void verifyTableSortAndSearchPage(){
        logInfo("Verifying Table Sort And Search Page");

        String expectedUrl = "";
        String actualUrl = getCurrentURL();

        Assert.assertTrue(actualUrl.contains(expectedUrl));
        logInfo("Successfully Verified Table sort and Search Page");
    }

    public void tableFilterSort(){
        logInfo("Filtering number of data entries");

        Select range = new Select(element("selectField"));
        logInfo("Showing maximum 25 elements at once");
        range.selectByValue("25");

        int size = getElements("filteredRow").size();
        Assert.assertTrue(size<=25);
        logInfo("Successfully verified showing maximum 25 elements at once");

        logInfo("Showing maximum 50 elements at once");
        range.selectByValue("50");

        size = getElements("filteredRow").size();
        Assert.assertTrue(size<=50);
        logInfo("Successfully verified showing maximum 50 elements at once");

        logInfo("Showing maximum 100 elements at once");
        range.selectByValue("100");

        size = getElements("filteredRow").size();
        Assert.assertTrue(size<=100);
        logInfo("Successfully verified showing maximum 100 elements at once");

        logInfo("Successfully verified Filtering number of data entries");
        wait.hardWait(1);
    }

    public void tableSearchFilter(){
        String position = "chief";
        String officeLocation = "London";
        String age ="61";

        logInfo("Verifying Functionality of Table Search Filter");

        logInfo("Filtering data based on Position");
        element("searchInput").sendKeys(position);
        int expectedEntries = getElements("filteredRow").size();
        Assert.assertEquals(4,expectedEntries);
        logInfo("Successfully Filtered data based on Position");

        logInfo("Filtering data based on Office Location");
        element("searchInput").clear();
        element("searchInput").sendKeys(officeLocation);
        expectedEntries = getElements("filteredRow").size();
        Assert.assertEquals(7,expectedEntries);
        logInfo("Successfully Filtered data based on Office Location");

        logInfo("Filtering data based on AGE");
        element("searchInput").clear();
        element("searchInput").sendKeys(age);
        expectedEntries = getElements("filteredRow").size();
        Assert.assertEquals(2,expectedEntries);
        logInfo("Successfully Filtered data based on AGE");

        logInfo("Successfully Verified Functionality of Table Search Filter");
        wait.hardWait(1);
    }

    public void tableSortFilter(){
        refreshPage();
        logInfo("Verifying Functionality of Table Sort Filter");

        Select range = new Select(element("selectField"));
        range.selectByValue("50");
        element("searchInput").sendKeys("develop");

        logInfo("Filtering data based on Office");
        List verifySortedOffices = getElements("unsortedOffice");
        Collections.sort(verifySortedOffices, String.CASE_INSENSITIVE_ORDER);

        element("sortByOffice").click();
        List sortedOffices = getElements("sortedRow");
        Assert.assertEquals(sortedOffices,verifySortedOffices);
        logInfo("Successfully Verified filtering data based on Office Location");


        logInfo("Filtering data based on Names");
        List verifySortedNames = getElements("unsortedNames");
        Collections.sort(verifySortedNames, String.CASE_INSENSITIVE_ORDER);

        element("sortByName").click();
        List sortedNames = getElements("sortedRow");
        Assert.assertEquals(sortedNames,verifySortedNames);
        logInfo("Successfully Verified filtering data based on Names");

        logInfo("Successfully Verified Functionality of Table Sort Filter");
    }
}
