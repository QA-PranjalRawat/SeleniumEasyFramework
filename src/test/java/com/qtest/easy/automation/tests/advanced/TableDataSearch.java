package com.qtest.easy.automation.tests.advanced;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class TableDataSearch extends Advanced{

    @Test(priority = 1)
    public void TC_220_verify_table_data_search(){
        logger = extent.createTest("TC_220_verify_table_data_search");

        tableDataSearchActions.tableDataSearchClick();
        tableDataSearchActions.verifyTableDataSearchPage();

        logger.log(Status.PASS,"Test Case Passed");
    }

    @Test(priority = 2)
    public void TC_221_single_table_row_filter(){
        logger = extent.createTest("TC_221_single_table_row_filter");

        tableDataSearchActions.singleTableRowFilter();
        logger.log(Status.PASS,"Test Case Passed");
    }

    @Test(priority = 3)
    public void TC_222_multi_table_column_filter(){
        logger = extent.createTest("TC_222_multi_table_column_filter");

        tableDataSearchActions.multiTableColumnFilter();
        logger.log(Status.PASS,"Test Case Passed");
    }
}
