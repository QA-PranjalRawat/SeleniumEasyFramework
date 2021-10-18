package com.qtest.easy.automation.actions.intermediate;

import com.qtest.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class JqueryListBoxActions extends GetPage {
    public JqueryListBoxActions(WebDriver driver) {
        super(driver, "intermediate/JqueryListBox");
    }

    public void jqueryListBoxClick(){
        logInfo("Clicking on JQuery List Box");

        wait.waitForElementToBeClickable(element("jqueryListBtn"));
        element("jqueryListBtn").click();

        logInfo("Successfully Clicked on JQuery List Box");
    }

    public void verifyJqueryListBoxPage(){
        logInfo("Verifying JQuery List Page");

        String expectedUrl = "jquery-dual-list-box-demo.html";
        String actualUrl = getCurrentURL();

        Assert.assertTrue(actualUrl.contains(expectedUrl));
        logInfo("Successfully Verified JQuery List Box Page");
    }

    public void jqueryPickListAddSingle(){

        String item1 = "Isis";

        logInfo("Verifying Functionality of the Pick List");

        logInfo("Adding Single item to the list");
        Select add= new Select(element("pickDataBox"));
        add.selectByVisibleText(item1);

        element("addBtn").click();
        boolean isContain = contains("resultDataBox",item1);

        Assert.assertEquals(true,isContain);
        logInfo("Successfully Added item1 to the list");

        wait.hardWait(1);
    }

    public void jqueryPickListRemoveSingle(){

        String item1 = "Isis";

        logInfo("Removing Single item to the list");
        Select remove = new Select(element("resultDataBox"));
        remove.selectByVisibleText(item1);

        element("removeBtn").click();
        boolean isContain = contains("resultDataBox",item1);

        Assert.assertEquals(false,isContain);
        logInfo("Successfully Removed item1 to the list");

        wait.hardWait(1);
    }

    public void jqueryPickListAddAndRemoveAll(){
        List items = getElements("pickDataBox");

        logInfo("Verifying the Functionality of AddAll");
        wait.waitForElementToBeClickable(element("addAllBtn"));
        element("addAllBtn").click();
        for(Object item : items){
            Assert.assertEquals(true,contains("resultDataBox",item));
        }
        logInfo("Successfully Verified the Functionality of AddAll");


        logInfo("Verifying the Functionality of RemoveAll");
        wait.waitForElementToBeClickable(element("removeAllBtn"));
        element("removeAllBtn").click();
        for(Object item : items){
            Assert.assertEquals(false,contains("resultDataBox",item));
        }
        logInfo("Successfully Verified the Functionality of RemoveAll");

        logInfo("Successfully Verified the Functionality of the Pick List");
        wait.hardWait(1);
    }
}
