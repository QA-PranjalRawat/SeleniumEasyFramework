package com.qtest.easy.automation.tests.advanced;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class ChartsDemo extends Advanced{

    @Test(priority = 1)
    public void TC_2110_verify_chart_demo_click(){
        logger = extent.createTest("TC_2110_verify_chart_demo_click");
        chartsDemoActions.chartDemoClick();
        chartsDemoActions.verifyChartDemoPage();
        logger.log(Status.PASS,"Test Case Passed");
    }

    @Test(priority = 2)
    public void TC_2111_chart_demo(){
        logger = extent.createTest("TC_2111_chart_demo");
        chartsDemoActions.chartDemo();
        logger.log(Status.PASS,"Test Case Passed");
    }
}
