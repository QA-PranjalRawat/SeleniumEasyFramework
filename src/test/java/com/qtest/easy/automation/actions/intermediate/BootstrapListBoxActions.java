package com.qtest.easy.automation.actions.intermediate;

import com.qtest.automation.getpageobjects.GetPage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BootstrapListBoxActions extends GetPage{

    String element1 = "Cras justo odio";
    String element2 = "bootstrap-duallist";

    public BootstrapListBoxActions(WebDriver driver) {
        super(driver, "intermediate/BootstrapListBox");
    }
    
    public void bootstrapListClick(){
        logInfo("Clicking on Bootstrap List Box");

        wait.waitForElementToBeClickable(element("BootstrapListBtn"));
        element("BootstrapListBtn").click();

        logInfo("Successfully Clicked on Bootstrap List Box");
    }

    public void verifyBootstrapListClick(){
        logInfo("Verifying Bootstrap List Click");

        String expectedUrl = "bootstrap-dual-list-box-demo.html";
        String actualUrl = getCurrentURL();

        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }


    public void dualListLeftBox(){

        logInfo("Verifying the Functionality of the Bootstrap Dual List Box");

        logInfo("Performing actions on the Left List Box");

        boolean isContain = contains("leftListLi",element1);

        logInfo("Verifying element1 in Left List");
        Assert.assertEquals(false,isContain);
        logInfo("Successfully Verified that the element1 is not present in the Left List");

        logInfo("Searching and sending the element1 from the Right list to the Left list");
        element("rightListInput").sendKeys("element1");
        element("rightListInput").clear();
        element("rightListInput").sendKeys(element1);
        element("rightListItems").click();
        element("moveLeftBtn").click();

        logInfo("Retrieving numbers of Highlighted item");
        isContain = contains("leftListLi",element1);
        logInfo("Verifying element1 in Left List");
        Assert.assertEquals(true,isContain);
        logInfo("Successfully Verified that the element1 is now present in the Left List");

        logInfo("Successfully verified the Working of the Left List and Move Left Arrow");
        wait.hardWait(1);
    }


    public void dualListRightBox(){
        refreshPage();
        logInfo("Performing actions on the Right List Box");

        boolean isContain = contains("rightListLi",element2);

        logInfo("Verifying element2 in Right List");
        Assert.assertEquals(false,isContain);
        logInfo("Successfully Verified that the element2 is not present in the Right List");

        logInfo("Searching and sending the element2 from the Left list to the Right list");
        element("leftListInput").sendKeys("element2");
        element("leftListInput").clear();
        element("leftListInput").sendKeys(element2);
        element("leftListItems").click();
        element("moveRightBtn").click();

        logInfo("Retrieving numbers of Highlighted item");
        isContain = contains("RightListLi",element2);
        logInfo("Verifying element2 in Right List");
        Assert.assertEquals(true,isContain);
        logInfo("Successfully Verified that the element2 is now present in the Right List");

        logInfo("Successfully verified the Working of the Right List and Move Right Arrow");
        wait.hardWait(1);
    }
}
