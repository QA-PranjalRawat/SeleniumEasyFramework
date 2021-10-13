package com.qtest.easy.automation.tests.intermediate;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class InputFormWithValidation extends Intermediate{

    @Test(priority = 1)
    public void TC_110_verify_input_form_with_validations(){
        logger = extent.createTest("TC_110_verify_input_form_with_validations");

        inputFormWithValidationActions.clickOnInputFormWithValidation();
        inputFormWithValidationActions.verifyInputFormWithValidationPage();

        logger.log(Status.PASS,"Test Case Passed");
    }

    @Test(priority = 2)
    public void TC_111_input_form_with_validation(){
        logger = extent.createTest("TC_111_input_form_with_validation");

        inputFormWithValidationActions.inputFormWithValidation();

        logger.log(Status.PASS,"Test Case Passed");
    }
}
