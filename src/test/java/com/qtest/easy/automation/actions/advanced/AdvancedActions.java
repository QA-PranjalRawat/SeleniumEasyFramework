package com.qtest.easy.automation.actions.advanced;

import com.qtest.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class AdvancedActions extends GetPage {
    public AdvancedActions(WebDriver driver) {
        super(driver, "advanced/Advanced");
    }

    public void clickOnAdvanced(){
        logInfo("Performing Click on Advanced");
        popUpHandler("popUp_btn");

        wait.waitForElementToBeClickable(element("advancedBtn"));
        element("advancedBtn").click();

        logInfo("Advanced button clicked successfully");
        wait.hardWait(1);
    }

    public void verifyAdvancedPage(){
        logInfo("Verifying Advanced Page");
        String activeTab;
        activeTab = element("active_text").getText();

        assertThat("Advanced",equalToIgnoringCase(activeTab));
        logInfo("Successfully Verified Advanced Active Tab");
    }

}
