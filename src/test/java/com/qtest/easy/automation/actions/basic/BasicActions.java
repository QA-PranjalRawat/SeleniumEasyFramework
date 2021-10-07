package com.qtest.easy.automation.actions.basic;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


import com.qtest.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;

public class BasicActions extends GetPage {

    public BasicActions(WebDriver driver) {
        super(driver,"basic/Basic");
    }

    public void popUpHandler(){
        logInfo("Activating pop up handler");
        try {
            element("popUp_btn").click();
            logInfo("Pop Up Successfully Handled");
        }
        catch(Exception e){
            logInfo("Pop Up didn't arise");
        }
    }

    public void clickOnBasic(){
        logInfo("Performing Click on Basic button action");
        popUpHandler();

        wait.waitForElementToBeClickable(element("basic_btn"));
        element("basic_btn").click();

        logInfo("Basic button clicked successfully");
        wait.hardWait(1);
    }
    public void verifyActiveTab(){
        logInfo("Verifying Basic Section tab change");
        String activeTab;
        activeTab = element("active_text").getText();

        assertThat("Basic",equalToIgnoringCase(activeTab));
        logInfo("Successfully Verified Basic Active Tab");
    }

}
