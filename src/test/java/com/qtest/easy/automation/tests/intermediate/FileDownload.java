package com.qtest.easy.automation.tests.intermediate;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class FileDownload extends Intermediate{

    @Test(priority = 1)
    public void TC_180_verify_fle_download(){
        logger = extent.createTest("TC_180_verify_fle_download");
        fileDownloadActions.fileDownloadClick();
        fileDownloadActions.verifyFileDownloadPage();

        logger.log(Status.PASS,"Test Case Passed");
    }

    @Test(priority = 2)
    public void TC_181_file_download(){
        logger = extent.createTest("TC_181_file_download");
        fileDownloadActions.fileDownload();

        logger.log(Status.PASS,"Test Case Passed");
    }
}
