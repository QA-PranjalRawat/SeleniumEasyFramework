package com.qtest.easy.automation.tests.basic;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class RadioButton extends Basic{

    @Test(priority = 1)
    public void TC_030_verify_radio_button_click(){
        logger = extent.createTest("TC_030_verify_radio_button_click");

        radioButttonActions.clickOnRadioButton();
        radioButttonActions.verifyRadioButton();

        logger.log(Status.PASS, "Test Case Passed");
    }

    @Test(priority = 2)
    public void TC_031_verify_radio_button_demo(){
        logger = extent.createTest("TC_031_verify_radio_button_demo");

        radioButttonActions.radioButtonDemo();
        logger.log(Status.PASS,"Test Case Passed");
    }

    @Test(priority = 3)
    public void TC_032_verify_group_radio_buttons_demo(){

        logger = extent.createTest("TC_032_verify_group_radio_buttons_demo");

        radioButttonActions.groupRadioButtonDemo();
        logger.log(Status.PASS,"Test Case Passed");
    }
}
