package com.qtest.easy.automation.actions.intermediate;

import com.qtest.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.File;

public class FileDownloadActions extends GetPage {
    public FileDownloadActions(WebDriver driver) {
        super(driver, "intermediate/FileDownload");
    }

    public void fileDownloadClick(){
        logInfo("Clicking on the File Download");

        wait.waitForElementToBeClickable(element("fileDownloadBtn"));
        element("fileDownloadBtn").click();
        logInfo("Successfully clicked on File Download");
    }

    public void verifyFileDownloadPage(){
        logInfo("Verifying File Download Page");

        String expectedUrl = "";
        String actualUrl = getCurrentURL();
        Assert.assertTrue(actualUrl.contains(expectedUrl));

        logInfo("Successfully Verified File Download Page");
    }

    public void fileDownload(){
        String text = "Hi there this is for the Testing file download. Lorem Ipsum is simply dummy text of the printing" +
                      " and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s," +
                      " when an unknown printer took a galley of type and scrambled it to make a type specimen book.";

        logInfo("Verifying Functionality of File Download");
        logInfo("Entering data to the Input Field");

        element("inputDataField").sendKeys(text);
        logInfo("Generating File to download");
        wait.waitForElementToBeClickable(element("generateFileBtn"));
        element("generateFileBtn").click();

        logInfo("Downloading File");
        wait.waitForElementToBeClickable(element("downloadBtn"));
        element("downloadBtn").click();


        String fileUrl = System.getProperty("user.dir")+ File.separator + "downloads" + File.separator +"easyinfo.txt";
        wait.waitForFileToDownload(fileUrl);

        File easyInfo = new File(fileUrl);

        Assert.assertTrue(easyInfo.exists());
        logInfo("Successfully Downloaded File");
        wait.hardWait(1);
    }
}
