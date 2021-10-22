package com.qtest.easy.automation.tests.advanced;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class TableDataDownload extends Advanced{

    @Test(priority = 1)
    public void TC_250_verify_table_data_download_click(){
        logger = extent.createTest("TC_250_verify_table_data_download_click");
        tableDataDownloadActions.tableDataDownloadClick();
        tableDataDownloadActions.verifyTableDataDownloadPage();
        logger.log(Status.PASS,"Test Case Passed");
    }

    @Test(priority = 2)
    public void TC_251_table_data_download(){
        logger = extent.createTest("TC_251_table_data_download");
        tableDataDownloadActions.tableDataFilter();
        tableDataDownloadActions.tableDataCopy();
        tableDataDownloadActions.tableDataToCsv();
        tableDataDownloadActions.tableDataToXlsx();
        tableDataDownloadActions.tableDataToPdf();
        logger.log(Status.PASS,"Test Case Passed");
    }
}
