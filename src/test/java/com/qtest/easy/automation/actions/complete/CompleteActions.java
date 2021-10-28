package com.qtest.easy.automation.actions.complete;

import com.qtest.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class CompleteActions extends GetPage {
    public CompleteActions(WebDriver driver) {
        super(driver, "complete/Complete");
    }

    public void completeBtnClick(){
        logInfo("Clicking on Complete Btn Click");
        popUpHandler("popUp_btn");

        wait.waitForElementToBeClickable(element("completeBtn"));
        element("completeBtn").click();

        logInfo("Complete Btn Successfully Clicked");
        wait.hardWait(1);
    }
    public void verifyCompletePage(){
        logInfo("Verifying Complete Section tab change");
        String activeTab;
        activeTab = element("active_text").getText();

        assertThat("THANKS FOR STAYING TUNED! WE ARE DONE",equalToIgnoringCase(activeTab));
        logInfo("Successfully Verified Complete Active Tab");
    }
}
