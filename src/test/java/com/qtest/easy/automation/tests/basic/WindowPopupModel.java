package com.qtest.easy.automation.tests.basic;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class WindowPopupModel extends Basic{

    @Test(priority = 1)
    public void TC_060_verify_window_popup_model_click(){
        logger = extent.createTest("TC_060_verify_window_popup_model_click");

        windowPopupModelActions.windowPopupModelClick();
        windowPopupModelActions.verifyWindowPopupModelPage();
        logger.log(Status.PASS,"Test Case Passed");
    }

    @Test(priority = 2)
    public void TC_061_verify_single_window_popup(){
        logger = extent.createTest("TC_061_verify_single_window_popup");
        windowPopupModelActions.singleWindowPopup();
        logger.log(Status.PASS,"Test Case Passed");
    }

    @Test(priority = 3)
    public void TC_062_verify_multi_window_modal(){
        logger = extent.createTest("TC_062_verify_multi_window_modal");
        windowPopupModelActions.multipleWindowModal();
        logger.log(Status.PASS,"Test Case Passed");
    }
}
