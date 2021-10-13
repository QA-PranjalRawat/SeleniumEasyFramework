package com.qtest.easy.automation.actions.intermediate;

import com.qtest.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class IntermediateActions extends GetPage {

    public IntermediateActions(WebDriver driver) {
        super(driver, "intermediate/intermediate");
    }

    public void clickOnIntermediate(){
        logInfo("Performing Click on Intermediate button action");
        popUpHandler("popUp_btn");

        wait.waitForElementToBeClickable(element("intermediateBtn"));
        element("intermediateBtn").click();

        logInfo("Intermediate button clicked successfully");
        wait.hardWait(1);
    }

    public void verifyActiveTab(){
        logInfo("Verifying Intermediate Section tab change");
        String activeTab;
        activeTab = element("active_text").getText();

        assertThat("Intermediate",equalToIgnoringCase(activeTab));
        logInfo("Successfully Verified Intermediate Active Tab");
    }
}
