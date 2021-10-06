package com.qtest.automation.getpageobjects;

import com.aventstack.extentreports.Status;
import com.qtest.automation.TestSessionInitiator;
import com.qtest.automation.utils.SeleniumWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import static com.qtest.automation.utils.DataReadWrite.getProperty;

public class BaseUi {
    WebDriver driver;
    protected SeleniumWait wait;
    private String pageName;

    protected BaseUi(WebDriver driver, String pageName) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.pageName = pageName;
        this.wait = new SeleniumWait(driver, Integer.parseInt(getProperty("Config.properties", "timeout")));
    }

    public static void logInfo(String message){
        TestSessionInitiator.logger.log(Status.INFO, message);
    }

    public static void logSkip(String message){
        TestSessionInitiator.logger.log(Status.SKIP, message);
    }

    public static void logPass(String message){
        TestSessionInitiator.logger.log(Status.PASS, message);
    }

    public static void logFail(String message){
        TestSessionInitiator.logger.log(Status.FAIL, message);
    }


    protected String getPageTitle() {
        return driver.getTitle();
    }

    public void logMessage(String message) {
        Reporter.log(message, true);
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }


}
