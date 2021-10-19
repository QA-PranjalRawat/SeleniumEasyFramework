package com.qtest.easy.automation.tests.intermediate;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class DataListFilter extends Intermediate{

    @Test(priority = 1)
    public void TC_160_verify_data_list_filter(){
        logger = extent.createTest("TC_160_verify_data_list_filter");
        dataListFilterActions.dataListFilterClick();
        dataListFilterActions.verifyDataListPage();

        logger.log(Status.PASS,"Test Case Passed");
    }

    @Test(priority = 2)
    public void TC_161_data_list_filter_search_input(){
        logger = extent.createTest("TC_161_data_list_filter_search_input");
        dataListFilterActions.searchDataList();

        logger.log(Status.PASS,"Test Case Passed");
    }
}
