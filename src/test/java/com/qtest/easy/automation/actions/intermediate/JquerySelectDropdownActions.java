package com.qtest.easy.automation.actions.intermediate;

import com.qtest.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class JquerySelectDropdownActions extends GetPage {

    public JquerySelectDropdownActions(WebDriver driver) {
        super(driver, "intermediate/JquerySelectDropdown");
    }

    public void clickOnJquerySelectDropdown(){
        logInfo("Clicking on Jquery Select Dropdown");

        wait.waitForElementToBeClickable(element("jqueryDropdownBtn"));
        element("jqueryDropdownBtn").click();

        logInfo("Successfully Clicked on Jquery Select Dropdown");
    }

    public void verifyJquerySelectDropdownPage(){
        logInfo("Verifying Jquery Select Dropdown Page");

        String expectedUrl = "jquery-dropdown-search-demo.html";
        String actualUrl = getCurrentURL();

        Assert.assertTrue(actualUrl.contains(expectedUrl));

        logInfo("Successfully Verified Jquery Select Dropdown Page");
    }

    public void dropdownWithSearchBox(){
        logInfo("Verifying Jquery dropdown with search box");

        wait.waitForElementToBeClickable(element("countryDropdownBtn"));
        element("countryDropdownBtn").click();

        logInfo("Selecting Denmark");
        wait.waitForElementToBeClickable(element("countryDenmark"));
        element("countryDenmark").click();

        logInfo("Successfully Selected Denmark");
        String expectedSelectedValue = "Denmark";
        String actualSelectedValue = element("selectedValue").getAttribute("title");

        Assert.assertTrue(actualSelectedValue.contentEquals(expectedSelectedValue));
        logInfo("Successfully Verified Jquery dropdown with search box");
        wait.hardWait(1);
    }

    public void multiSelectStateInput(){
        logInfo("Verifying Jquery Multi Select Input Field");

        wait.waitForElementToBeClickable(element("multiSelectInput"));
        element("multiSelectInput").click();

        logInfo("Selecting States");
        wait.waitForElementToBeClickable(element("multiSelectAlaska"));
        element("multiSelectAlaska").click();

        element("multiSelectInput").click();
        wait.waitForElementToBeClickable(element("multiSelectColorado"));
        element("multiSelectColorado").click();

        element("multiSelectInput").click();
        wait.waitForElementToBeClickable(element("multiSelectHawaii"));
        element("multiSelectHawaii").click();

        List<String> states = new ArrayList<>();
        int len = elements("selectedMultiValues").size();
        for(int i=0;i<len-1;i++){
            states.add((elements("selectedMultiValues").get(i).getText()).replace('\u00D7',' ').trim());
        }
        Assert.assertTrue(states.contains("Alaska"));
        Assert.assertTrue(states.contains("Colorado"));
        Assert.assertTrue(states.contains("Hawaii"));

        logInfo("Successfully Verified Jquery Multi Select Input Field");
        wait.hardWait(1);
    }

    public void dropdownWithDisabledValue(){
        logInfo("Verifying Jquery Dropdown With Disabled Value");

        wait.waitForElementToBeClickable(element("territoryDropdownBtn"));
        element("territoryDropdownBtn").click();

        logInfo("Selecting & Verifying Disabled Value");
        wait.waitForElementToBeVisible(element("territoryGuam"));
        String isDisabled = element("territoryGuam").getAttribute("aria-disabled");

        Assert.assertTrue(isDisabled.equals("true"));
        logInfo("Successfully Verified Disabled Value");
        wait.hardWait(1);

        logInfo("Selecting & Verifying UnDisabled Value");
        wait.waitForElementToBeClickable(element("territoryVirginIslands"));
        element("territoryVirginIslands").click();

        String selectedValue = element("territorySelected").getText();
        Assert.assertTrue(selectedValue.contentEquals("Virgin Islands"));
        logInfo("Successfully Verified UnDisabled Value");

        logInfo("Successfully Verified Jquery Dropdown With Disabled Value");
        wait.hardWait(1);
    }

    public void dropdownWithCategory(){
        logInfo("Verifying Jquery Dropdown with Category");

        Select lang = new Select(element("categoryDropdownBtn"));
        lang.selectByVisibleText("Ruby");

        WebElement selectedLang = element("categoryLangRuby");
        Assert.assertTrue(selectedLang.isSelected());

        logInfo("Successfully Verified Jquery Dropdown with Category");
        wait.hardWait(1);
    }
}
