package com.qtest.easy.automation.actions.advanced;

import com.qtest.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.File;

public class TableDataDownloadActions extends GetPage {
    String filename = System.getProperty("user.dir")+ File.separator + "downloads"+ File.separator + "Selenium Easy - Download Table Data to CSV, Excel, PDF and Print";

    public TableDataDownloadActions(WebDriver driver) {
        super(driver, "advanced/TableDataDownload");
    }

    public void tableDataDownloadClick(){
        logInfo("Clicking on Table Data Download");
        wait.waitForElementToBeClickable(element("tableDataDownloadBtn"));
        element("tableDataDownloadBtn").click();
        logInfo("Successfully Clicked on Table Data Download");
    }

    public void verifyTableDataDownloadPage(){
        logInfo("Verifying Table Data Download Page");

        String expectedUrl = "table-data-download-demo.html";
        String actualUrl = getCurrentURL();

        Assert.assertTrue(actualUrl.contains(expectedUrl));
        logInfo("Successfully Verified Table Data Download Page");
    }

    public void tableDataFilter(){
        String office = "Tokyo";
        logInfo("Verifying the functionality of Table Data Filter");

        logInfo("Filtering the Records by Searching");
        element("inputSearch").sendKeys(office);
        wait.hardWait(1);
        int expectedResult = getElements("filteredRows").size();
        Assert.assertEquals(4,expectedResult);
        logInfo("Successfully Verified the Number of Filtered Records");
    }

    public void tableDataCopy(){

        logInfo("Verifying the working of Copy Button");
        wait.waitForElementToBeClickable(element("copyBtn"));
        element("copyBtn").click();

        String expectedCopyMessage = wait.waitForElementToBeVisible(element("copyPopUp")).getText();
        String actualCopyMessage = "Copied 4 rows to clipboard";
        Assert.assertEquals(actualCopyMessage,expectedCopyMessage);
        logInfo("Successfully Verified Working of Copy Button");
        wait.hardWait(1);
    }

    public void tableDataToCsv(){

        logInfo("Verifying the working of table csv Download");
        wait.waitForElementToBeClickable(element("csvBtn")).click();
        wait.waitForFileToDownload(filename+".csv");

        File csvFile = new File(filename+".csv");
        Assert.assertTrue(csvFile.exists());
        logInfo("Successfully Downloaded CSV File");
    }

    public void tableDataToXlsx(){

        logInfo("Verifying the working of table Xlsx Download");
        wait.waitForElementToBeClickable(element("excelBtn")).click();
        wait.waitForFileToDownload(filename+".xlsx");

        File xlsxFile = new File(filename+".xlsx");
        Assert.assertTrue(xlsxFile.exists());
        logInfo("Successfully Downloaded Xlsx File");
    }

    public void tableDataToPdf(){

        logInfo("Verifying the working of table Pdf Download");
        wait.waitForElementToBeClickable(element("pdfBtn")).click();
        wait.waitForFileToDownload(filename+".pdf");

        File pdfFile = new File(filename+".pdf");
        Assert.assertTrue(pdfFile.exists());
        logInfo("Successfully Downloaded Pdf File");
    }

}
