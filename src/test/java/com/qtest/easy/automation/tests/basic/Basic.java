package com.qtest.easy.automation.tests.basic;

import com.aventstack.extentreports.Status;
import com.qtest.automation.TestSessionInitiator;
import org.testng.annotations.Test;

public class Basic extends TestSessionInitiator {

    @Test
    public void TC_000_verify_basic_btn_click(){
        logger = extent.createTest("TC_000_verify_basic_btn_click");
        basicActions.clickOnBasic();
        basicActions.verifyActiveTab();
        logger.log(Status.PASS, "Test Case Passed");

    }
}
