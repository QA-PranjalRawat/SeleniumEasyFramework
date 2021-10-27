package com.qtest.easy.automation.tests.advanced;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class DynamicDataLoading extends Advanced{

    @Test(priority = 1)
    public void TC_2100_verify_dynamic_data_loading(){
        logger = extent.createTest("TC_2100_verify_dynamic_data_loading");
        dynamicDataLoadingActions.dynamicDataLoadingClick();
        dynamicDataLoadingActions.verifyDynamicDataLoadingPage();
        logger.log(Status.PASS,"Test Case Passed");
    }

    @Test(priority = 2)
    public void TC_2101_dynamic_data_loading(){
        logger = extent.createTest("TC_2101_dynamic_data_loading");
        dynamicDataLoadingActions.dynamicDataLoading();
        logger.log(Status.PASS,"Test Case Passed");

    }
}
