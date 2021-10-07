package com.qtest.easy.automation.tests.basic;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class CheckBox extends Basic{


    @Test(priority = 1)
    public void TC_020_verify_check_box_click(){
        logger = extent.createTest("TC_020_verify_check_box_click");

        checkBoxActions.clickOnCheckBox();
        checkBoxActions.verifyCheckBox();

        logger.log(Status.PASS, "Test Case Passed");
    }

    @Test(priority = 2)
    public void TC_021_verify_single_check_box(){
        logger = extent.createTest("TC_021_verify_single_check_box");

        checkBoxActions.singleCheckBox();
        logger.log(Status.PASS,"Test Case Passed");
    }

    @Test(priority = 3)
    public void TC_022_verify_multiple_check_box(){
        logger = extent.createTest("TC_022_verify_multiple_check_box");

        checkBoxActions.multipleCheckBox();
        logger.log(Status.PASS,"Test Case Passed");
    }
}
