package com.qtest.easy.automation.tests.intermediate;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class ProgressBarModel extends Intermediate{

    @Test(priority = 1)
    public void TC_170_verify_progress_bar_model(){
        logger = extent.createTest("TC_170_verify_progress_bar_model");
        progressBarModelActions.progressBarModelClick();
        progressBarModelActions.verifyProgressBarPage();

        logger.log(Status.PASS,"Test Case Passed");
    }

    @Test(priority = 2)
    public void TC_171_modal_dialog_with_progress_bar(){
        logger = extent.createTest("TC_171_modal_dialog_with_progress_bar");
        progressBarModelActions.dialogProgressBar();

        logger.log(Status.PASS,"Test Case Passed");
    }
}
