package com.qtest.easy.automation.tests.basic;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class BootstrapModals extends Basic{

    @Test(priority = 1)
    public void TC_080_verify_bootstrap_modal_click(){
        logger = extent.createTest("TC_080_verify_bootstrap_modal_click");

        bootstrapModalsActions.bootstrapModalClick();
        bootstrapModalsActions.verifyBootstrapModalPage();

        logger.log(Status.PASS,"Test Case Passed");
    }

    @Test(priority = 2)
    public void TC_081_verify_single_bootstrap_modal(){
        logger = extent.createTest("TC_081_verify_single_bootstrap_modal");

        bootstrapModalsActions.singleBootstrapModal();

        logger.log(Status.PASS,"Test Case Passed");
    }

    @Test(priority = 3)
    public void TC_082_verify_multi_bootstrap_modal(){
        logger = extent.createTest("TC_082_verify_multi_bootstrap_modal");

        bootstrapModalsActions.MultiBootstrapModal();

        logger.log(Status.PASS,"Test Case Passed");
    }
}
