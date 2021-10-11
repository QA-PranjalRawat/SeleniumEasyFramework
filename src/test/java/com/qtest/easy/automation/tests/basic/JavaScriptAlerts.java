package com.qtest.easy.automation.tests.basic;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class JavaScriptAlerts extends Basic{

    @Test(priority = 1)
    public void TC_050_verify_javascript_alert_click(){
        logger = extent.createTest("TC_050_verify_javascript_alert_click");

        javaScriptAlertsActions.javaScriptAlertClick();
        javaScriptAlertsActions.verifyJavaScriptAlert();

        logger.log(Status.PASS,"Test Case Passed");
    }

    @Test(priority = 2)
    public void TC_051_verify_simple_alert_box(){
        logger = extent.createTest("TC_051_verify_simple_confirm_box");

        javaScriptAlertsActions.simpleAlertBox();

        logger.log(Status.PASS,"Test Case Passed");
    }

    @Test(priority = 3)
    public void TC_052_verify_confirm_alert_box(){
        logger = extent.createTest("TC_052_verify_confirm_alert_box");

        javaScriptAlertsActions.confirmAlertBox();

        logger.log(Status.PASS,"Test Case Passed");
    }

    @Test(priority = 4)
    public void TC_053_verify_prompt_alert_box(){
        logger = extent.createTest("TC_053_verify_prompt_alert_box");

        javaScriptAlertsActions.promptAlertBox();

        logger.log(Status.PASS,"Test Case Passed");
    }

}
