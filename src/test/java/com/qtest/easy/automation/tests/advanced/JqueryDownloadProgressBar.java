package com.qtest.easy.automation.tests.advanced;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class JqueryDownloadProgressBar extends Advanced{

    @Test(priority = 1)
    public void TC_260_verify_jquery_download_progress_bar_click(){
        logger = extent.createTest("TC_260_verify_jquery_download_progress_bar_click");
        jqueryDownloadProgressBarActions.jqueryDownloadProgressBarClick();
        jqueryDownloadProgressBarActions.verifyJqueryDownloadPage();
        logger.log(Status.PASS,"Test Case Passed");
    }

    @Test(priority = 2)
    public void TC_261_jquery_download_progress_bar(){
        logger = extent.createTest("TC_261_jquery_download_progress_bar");
        jqueryDownloadProgressBarActions.jqueryDownloadProgressBar();
        logger.log(Status.PASS,"Test Case Passed");
    }
}
