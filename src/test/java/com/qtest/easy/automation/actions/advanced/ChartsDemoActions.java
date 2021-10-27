package com.qtest.easy.automation.actions.advanced;

import com.qtest.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ChartsDemoActions extends GetPage {
    public ChartsDemoActions(WebDriver driver) {
        super(driver, "advanced/ChartsDemo");
    }

    public void chartDemoClick(){
        logInfo("Clicking on Chart Demo");

        wait.waitForElementToBeClickable(element("chartDemoBtn"));
        element("chartDemoBtn").click();
        logInfo("Successfully Clicked on Chart Demo");
    }

    public void verifyChartDemoPage(){
        logInfo("Verifying Chart Demo Page");

        String expectedUrl = "charts-mouse-hover-demo.html";
        String actualUrl = getCurrentURL();

        Assert.assertTrue(actualUrl.contains(expectedUrl));
        logInfo("Successfully Verified Chart Demo Page");
    }

    public void chartDemo(){
        logInfo("Verifying the Functionality of Chart Demo");

        logInfo("The Chart Demo Page is unable to load some bootstrap css files due to which some content are unable to load thus a test regarding those object can't be created now.");

        logInfo("Verifying Name of the Stock");
        String expectedStockName = "VSYSQ INC.";
        String actualStockName = element("stockName").getText();

        Assert.assertEquals(actualStockName,expectedStockName);
        logInfo("Successfully Verified Stock Name");

        logInfo("Verifying Total Share Traded");
        String expectedShareTraded = "13.5 M";
        String actualShareTraded = element("shareTraded").getText();

        Assert.assertEquals(actualShareTraded,expectedShareTraded);
        logInfo("Successfully Verified Total Share Traded");

        logInfo("Verifying Total Market Cap");
        String expectedMktCap = "28.44 B";
        String actualMktCap = element("marketCap").getText();

        Assert.assertEquals(actualMktCap,expectedMktCap);
        logInfo("Successfully Verified Total Market Cap");

        logInfo("Successfully Verified the Functionality of Chart Demo but can't test some feature as the bootstrap file is unable to load");
    }
}
