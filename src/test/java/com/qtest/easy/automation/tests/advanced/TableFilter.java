package com.qtest.easy.automation.tests.advanced;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class TableFilter extends Advanced{

    @Test(priority = 1)
    public void TC_230_verify_table_filter_click(){
        logger = extent.createTest("TC_230_verify_table_filter_click");
        tableFilterActions.tableFilterClick();
        tableFilterActions.verifyTableFilterPage();
        logger.log(Status.PASS,"Test Case Passed");
    }

    @Test(priority = 2)
    public void TC_231_table_record_filter(){
        logger = extent.createTest("TC_231_table_record_filter");
        tableFilterActions.tableRecordsFilter();
        logger.log(Status.PASS,"Test Case Passed");
    }
}
