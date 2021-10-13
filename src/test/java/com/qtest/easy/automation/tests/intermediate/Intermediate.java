package com.qtest.easy.automation.tests.intermediate;

import com.aventstack.extentreports.Status;
import com.qtest.automation.TestSessionInitiator;
import org.testng.annotations.Test;

public class Intermediate extends TestSessionInitiator {

    @Test
    public void TC_100_verify_intermediate_btn_click(){
        logger = extent.createTest("TC_100_verify_intermediate_btn_click");
        intermediateActions.clickOnIntermediate();
        intermediateActions.verifyActiveTab();
        logger.log(Status.PASS, "Test Case Passed");

    }
}
