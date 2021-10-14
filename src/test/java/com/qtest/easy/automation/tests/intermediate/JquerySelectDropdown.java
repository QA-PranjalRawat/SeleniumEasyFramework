package com.qtest.easy.automation.tests.intermediate;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class JquerySelectDropdown extends Intermediate{

    @Test(priority = 1)
    public void TC_130_verify_jquery_dropdown_click(){
        logger = extent.createTest("TC_130_verify_jquery_dropdown_click");

        jquerySelectDropdownActions.clickOnJquerySelectDropdown();
        jquerySelectDropdownActions.verifyJquerySelectDropdownPage();

        logger.log(Status.PASS,"Test Case Passed");
    }

    @Test(priority = 2)
    public void TC_131_verify_dropdown_with_searchbox(){
        logger = extent.createTest("TC_131_verify_dropdown_with_searchbox");

        jquerySelectDropdownActions.dropdownWithSearchBox();
        logger.log(Status.PASS,"Test Case Passed");
    }

    @Test(priority = 3)
    public void TC_132_verify_jquery_multi_select(){
        logger = extent.createTest("TC_132_verify_jquery_multi_select");

        jquerySelectDropdownActions.multiSelectStateInput();
        logger.log(Status.PASS,"Test Case Passed");
    }

    @Test(priority = 4)
    public void TC_133_verify_dropdown_with_disabled(){
        logger = extent.createTest("TC_133_verify_dropdown_with_disabled");

        jquerySelectDropdownActions.dropdownWithDisabledValue();
        logger.log(Status.PASS,"Test Case Passed");
    }

    @Test(priority = 5)
    public void TC_134_verify_dropdown_with_category(){
        logger = extent.createTest("TC_134_verify_dropdown_with_category");

        jquerySelectDropdownActions.dropdownWithCategory();
        logger.log(Status.PASS,"Test Case Passed");
    }
}
