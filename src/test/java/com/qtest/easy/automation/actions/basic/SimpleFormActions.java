package com.qtest.easy.automation.actions.basic;

import com.qtest.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SimpleFormActions extends GetPage {

    public SimpleFormActions(WebDriver driver) {
        super(driver, "basic/SimpleForm");
    }

    public void clickOnSimpleForm(){
        logInfo("Performing Click on S1mple Form Demo");

        wait.waitForElementToBeClickable(element("simpleFormClick"));
        element("simpleFormClick").click();

        logInfo("Successfully clicked on S1mple Form Demo");
        wait.hardWait(1);
    }
    public void verifySimpleForm(){
        logInfo("Verifying S1mple Form Page");

        String ExpectedTitle = "Simple Form";
        wait.waitForPageTitleToContain(ExpectedTitle);
        String ActualTitle = getPageTitle();


        Assert.assertTrue(ActualTitle.contains(ExpectedTitle));
        logInfo("S1mple Form Page Verified Successfully");
        wait.hardWait(1);
    }

    public void singleInputField(String inputMessage){
        logInfo("Identifying Element and Entering Message");

        element("enterMessage").sendKeys(inputMessage);
        logInfo("Clicking Show Message Button");

        wait.waitForElementToBeClickable(element("showMessage"));
        element("showMessage").click();

        logInfo("Verifying Message");
        String outputMessage = element("yourMessage").getText();

        Assert.assertEquals(inputMessage,outputMessage);
        logInfo("Message successfully Verified");
        wait.hardWait(1);
    }

    public void twoInputField(String a, String b){
        logInfo("Identifying Input Fields");

        logInfo("Entering value of A");
        element("enterA").sendKeys(a);

        logInfo("Entering value of B");
        element("enterB").sendKeys(b);

        logInfo("Finding Total");
        wait.waitForElementToBeClickable(element("getTotal"));
        element("getTotal").click();

        logInfo("Verifying Total");
        String outputTotal = element("displayValue").getText();
        String vefTotal = Integer.toString(Integer.parseInt(a)+Integer.parseInt(b));

       Assert.assertEquals(outputTotal,vefTotal);
       logInfo("Total successfully Verified");
       wait.hardWait(1);
    }
}
