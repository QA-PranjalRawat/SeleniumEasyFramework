package com.qtest.easy.automation.tests.basic;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class DropdownList extends Basic{

    @Test(priority = 1)
    public void TC_040_verify_dropdown_list_click(){
        logger = extent.createTest("TC_040_verify_dropdown_list_click");

        dropdownListActions.clickOnDropdownList();
        dropdownListActions.verifyDropdownPage();
        logger.log(Status.PASS,"Test Case Passed");
    }

    @Test(priority = 2)
    public void TC_041_verify_single_select_list_demo(){
        logger = extent.createTest("TC_041_verify_single_select_list_demo");

        dropdownListActions.singleSelectList();
        logger.log(Status.PASS,"Test Case Passed");
    }

    @Test(priority = 3)
    public void TC_042_verify_multi_select_list_demo(){
        logger = extent.createTest("TC_042_verify_multi_select_list_demo");

        dropdownListActions.multiSelectList();
        logger.log(Status.PASS,"Test Case Passed");
    }
}
