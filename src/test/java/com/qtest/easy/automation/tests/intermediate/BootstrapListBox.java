package com.qtest.easy.automation.tests.intermediate;

import com.aventstack.extentreports.Status;

import org.testng.annotations.Test;

public class BootstrapListBox extends Intermediate{

    @Test(priority = 1)
    public void TC_140_verify_bootstrap_list_box_click(){
        logger = extent.createTest("TC_140_verify_bootstrap_list_box_click");

        bootstrapListBoxActions.bootstrapListClick();
        bootstrapListBoxActions.verifyBootstrapListClick();

        logger.log(Status.PASS, "Test Case Passed");
    }

    @Test(priority = 2)
    public void TC_141_verify_dual_list_box(){
        logger = extent.createTest("TC_141_verify_dual_list_box");

        bootstrapListBoxActions.dualListLeftBox();
        bootstrapListBoxActions.dualListRightBox();

        logger.log(Status.PASS, "Test Case Passed");
    }
    
}
