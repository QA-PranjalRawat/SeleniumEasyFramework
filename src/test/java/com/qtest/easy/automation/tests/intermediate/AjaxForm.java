package com.qtest.easy.automation.tests.intermediate;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class AjaxForm extends Intermediate{

    @Test(priority = 1)
    public void TC_120_verify_ajax_form_click(){
        logger = extent.createTest("TC_120_verify_ajax_form_click");

        ajaxFormActions.clickOnAjaxFormSubmit();
        ajaxFormActions.verifyAjaxFormPage();

        logger.log(Status.PASS,"Test Case Passed");
    }

    @Test(priority = 2)
    public void TC_121_ajax_form(){
        logger = extent.createTest("TC_121_ajax_form");

        ajaxFormActions.ajaxForm();

        logger.log(Status.PASS,"Test Case Passed");
    }
}
