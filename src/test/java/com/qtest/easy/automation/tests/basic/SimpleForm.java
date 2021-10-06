package com.qtest.easy.automation.tests.basic;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class SimpleForm extends Basic{
    String message = "This is my message LMA0";

    @Test(priority = 1)
    public void TC_01_verify_simple_form_click(){
        logger = extent.createTest("TC_verify_simple_form_click");
        simpleFormActions.clickOnSimpleForm();
        simpleFormActions.verifySimpleForm();
        logger.log(Status.PASS, "Test Case Passed");
    }

    @Test(priority = 2)
    public void TC_011_verify_single_input_field(){
        logger = extent.createTest("TC_01_verify_single_input_field");
        simpleFormActions.singleInputField(message);
        logger.log(Status.PASS,"Test Case Passed");
    }
}
