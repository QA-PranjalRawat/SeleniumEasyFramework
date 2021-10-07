package com.qtest.easy.automation.actions.basic;

import com.qtest.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckBoxActions extends GetPage {

    public CheckBoxActions(WebDriver driver) {
        super(driver, "basic/CheckBox");
    }


    public void clickOnCheckBox(){
        logInfo("Performing Click on Check Box Demo");

        wait.waitForElementToBeClickable(element("checkBoxClick"));
        element("checkBoxClick").click();

        logInfo("Successfully clicked on S1mple Form Demo");
        wait.hardWait(1);
    }

    public void verifyCheckBox(){
        logInfo("Verifying Check Box Page");

        String ExpectedTitle = "Checkbox";
        wait.waitForPageTitleToContain(ExpectedTitle);
        String ActualTitle = getPageTitle();


        Assert.assertTrue(ActualTitle.contains(ExpectedTitle));
        logInfo("Check Box Page Verified Successfully");
        wait.hardWait(1);
    }

    public void singleCheckBox(){
        logInfo("Identifying Checkbox and clicking");

        wait.waitForElementToBeClickable(element("singleCheckBox"));
        element("singleCheckBox").click();

        logInfo("Verifying Single CheckBox Click");
        String successMessage = element("singleSuccessMsg").getText();

        Assert.assertEquals(successMessage,"Success - Check box is checked");
        logInfo("CheckBox successfully Checked");
        wait.hardWait(1);
    }

    public void multipleCheckBox(){
        refreshPage();
        logInfo("Identifying Checkbox and Clicking");

        wait.waitForElementToBeClickable(element("checkAllBtn"));
        element("checkAllBtn").click();

        logInfo("Verifying value of the Checkbox Button");
        String btnValue = element("checkAllBtn").getAttribute("value");

        Assert.assertEquals(btnValue,"Uncheck All");
        logInfo("All Checkbox has been checked and button value verified");

        logInfo("Unchecking a single checkbox");
        element("option4").click();

        logInfo("Verifying value of the button");
        String btnValueAfterUncheck = element("checkAllBtn").getAttribute("value");

        Assert.assertEquals(btnValueAfterUncheck,"Check All");
        logInfo("Successfully Verified Checkbox Button Value");

        wait.hardWait(3);

    }

}
