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
        wait.hardWait(1);
        element("simpleFormClick").click();
        logInfo("Successfully clicked on S1mple Form Demo");
        wait.hardWait(1);
    }
    public void verifySimpleForm(){
        logInfo("Verifying S1mple Form Page");
        String ActualTitle = getPageTitle();
        String ExpectedTitle = "Simple Form";
        Assert.assertTrue(ActualTitle.contains(ExpectedTitle));
        logInfo("S1mple Form Page Verified Successfully");
    }

    public void singleInputField(String inputMessage){
        logInfo("Identifying Element and Entering Message");
        element("enterMessage").sendKeys(inputMessage);
        wait.hardWait(1);
        logInfo("Clicking Show Message Button");
        element("showMessage").click();

        logInfo("Verifying Message");
        String outputMessage = element("yourMessage").getText();
        wait.hardWait(1);
        Assert.assertEquals(inputMessage,outputMessage);
        logInfo("Message successfully Verified");
    }
}
