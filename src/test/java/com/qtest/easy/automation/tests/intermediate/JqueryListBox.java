package com.qtest.easy.automation.tests.intermediate;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class JqueryListBox extends Intermediate{

    @Test(priority = 1)
    public void TC_150_verify_jquery_list_box(){
        logger = extent.createTest("TC_150_verify_jquery_list_box");
        jqueryListBoxActions.jqueryListBoxClick();
        jqueryListBoxActions.verifyJqueryListBoxPage();

        logger.log(Status.PASS,"Test Case Passed");
    }

    @Test(priority = 2)
    public void TC_151_verify_jquery_pick_list(){
        logger = extent.createTest("TC_151_verify_jquery_pick_list");
        jqueryListBoxActions.jqueryPickListAddSingle();
        jqueryListBoxActions.jqueryPickListRemoveSingle();
        jqueryListBoxActions.jqueryPickListAddAndRemoveAll();
        logger.log(Status.PASS,"Test Case Passed");
    }
}
