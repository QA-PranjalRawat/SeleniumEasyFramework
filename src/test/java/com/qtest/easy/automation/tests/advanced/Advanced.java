package com.qtest.easy.automation.tests.advanced;

import com.aventstack.extentreports.Status;
import com.qtest.automation.TestSessionInitiator;
import org.testng.annotations.Test;

public class Advanced extends TestSessionInitiator {

    @Test
    public void TC_200_verify_advanced_btn_click(){
        logger = extent.createTest("TC_200_verify_advanced_btn_click");
        advancedActions.clickOnAdvanced();
        advancedActions.verifyAdvancedPage();

        logger.log(Status.PASS,"Test Case Passed");
    }
}
