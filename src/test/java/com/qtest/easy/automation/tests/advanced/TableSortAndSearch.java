package com.qtest.easy.automation.tests.advanced;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class TableSortAndSearch extends Advanced{

    @Test(priority = 1)
    public void TC_240_verify_table_sort_and_search_click(){
        logger = extent.createTest("TC_240_verify_table_sort_and_search_click");

        tableSortAndSearchActions.tableSortAndSearchClick();
        tableSortAndSearchActions.verifyTableSortAndSearchPage();
        logger.log(Status.PASS,"Test Case Passed");
    }

    @Test(priority = 2)
    public void TC_241_table_data_range_filter(){
        logger = extent.createTest("TC_241_table_data_range_filter");

        tableSortAndSearchActions.tableFilterSort();
        logger.log(Status.PASS,"Test Case Passed");
    }

    @Test(priority = 3)
    public void TC_242_table_search_filter(){
        logger = extent.createTest("TC_242_table_search_filter");

        tableSortAndSearchActions.tableSearchFilter();
        logger.log(Status.PASS,"Test Case Passed");
    }

    @Test(priority = 4)
    public void TC_243_table_sort_filter(){
        logger = extent.createTest("TC_243_table_sort_filter");

        tableSortAndSearchActions.tableSortFilter();
        logger.log(Status.PASS,"Test Case Passed");
    }
}
