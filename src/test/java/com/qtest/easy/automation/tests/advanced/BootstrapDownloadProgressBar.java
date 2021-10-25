package com.qtest.easy.automation.tests.advanced;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class BootstrapDownloadProgressBar extends Advanced{

    @Test(priority = 1)
    public void TC_270_verify_bootstrap_download_click(){
        logger = extent.createTest("TC_270_verify_bootstrap_download_click");
        bootstrapDownloadProgressBarActions.bootstrapDownloadProgressBarClick();
        bootstrapDownloadProgressBarActions.verifyBootstrapDownloadProgressBarPage();

        logger.log(Status.PASS,"Test Case Passed");
    }

    @Test(priority = 2)
    public void TC_271_bootstrap_download_progress_bar(){
        logger = extent.createTest("TC_271_bootstrap_download_progress_bar");
        bootstrapDownloadProgressBarActions.bootstrapDownloadProgressBar();
        logger.log(Status.PASS,"Test Case Passed");

    }
}
