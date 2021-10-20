package com.qtest.easy.automation.tests.advanced;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class TablePagination extends Advanced{

    @Test(priority = 1)
    public void TC_210_verify_table_pagination_click(){
        logger = extent.createTest("TC_210_verify_table_pagination_click");

        tablePaginationActions.tablePaginationClick();
        tablePaginationActions.verifyTablePaginationPage();
        logger.log(Status.PASS,"Test Case Passed");
    }

    @Test(priority = 2)
    public void TC_211_table_pagination_verification(){
        logger = extent.createTest("TC_211_table_pagination_verification");

        tablePaginationActions.tableRowNumber();
        logger.log(Status.PASS,"Test Case Passed");

    }
}
