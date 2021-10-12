package com.qtest.easy.automation.tests.basic;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class BootstrapAlerts extends Basic{

    @Test(priority = 1)
    public void TC_070_verify_bootstrap_alert_click(){
        logger = extent.createTest("TC_070_verify_bootstrap_alert_click");

        bootstrapAlertsActions.bootstrapAlertClick();
        bootstrapAlertsActions.verifyBootstrapAlertPage();

        logger.log(Status.PASS,"Test Case Passed");
    }

    @Test(priority = 2)
    public void TC_071_verify_bootstrap_alert_messages(){
        logger = extent.createTest("TC_071_verify_bootstrap_alert_messages");

        bootstrapAlertsActions.autocloseableSuccessMessage();
        bootstrapAlertsActions.normalSuccessMessage();

        bootstrapAlertsActions.autocloseableWarningMessage();
        bootstrapAlertsActions.normalWarningMessage();

        bootstrapAlertsActions.autocloseableDangerMessage();
        bootstrapAlertsActions.normalDangerMessage();

        bootstrapAlertsActions.autocloseableInfoMessage();
        bootstrapAlertsActions.normalInfoMessage();

        logger.log(Status.PASS,"Test Case Passed");
    }
}
