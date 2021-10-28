package com.qtest.easy.automation.tests.complete;

import com.aventstack.extentreports.Status;
import com.qtest.automation.TestSessionInitiator;
import org.testng.annotations.Test;

public class Complete extends TestSessionInitiator {

    @Test
    public void TC_300_verify_complete_btn_click(){
        logger = extent.createTest("TC_300_verify_complete_btn_click");
        completeActions.completeBtnClick();
        completeActions.verifyCompletePage();
        logger.log(Status.PASS,"Test Case Passed");
    }
}
