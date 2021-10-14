package com.qtest.automation;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.qtest.automation.utils.BaseDriver;

import com.qtest.easy.automation.actions.basic.*;
import com.qtest.easy.automation.actions.intermediate.*;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;


import java.util.Set;

import static com.qtest.automation.utils.DataReadWrite.getProperty;
import static com.qtest.automation.utils.YamlReader.setYamlFilePath;

public class TestSessionInitiator extends BaseDriver {


    public static ExtentReports extent;
    public static ExtentTest logger;
    public static String baseurl = getProperty("./Config.properties", "baseurl");


    /**
     * Initiating the page objects
     */
    public BasicActions basicActions;
    public SimpleFormActions simpleFormActions;
    public CheckBoxActions checkBoxActions;
    public RadioButttonActions radioButttonActions;
    public DropdownListActions dropdownListActions;
    public JavaScriptAlertsActions javaScriptAlertsActions;
    public WindowPopupModelActions windowPopupModelActions;
    public BootstrapAlertsActions bootstrapAlertsActions;
    public BootstrapModalsActions bootstrapModalsActions;


    public IntermediateActions intermediateActions;
    public InputFormWithValidationActions inputFormWithValidationActions;
    public AjaxFormActions ajaxFormActions;
    public JquerySelectDropdownActions jquerySelectDropdownActions;

    /**
     * Creating objects of Page Objects
     */

    private void _initPage() {
        basicActions = new BasicActions(driver);
        simpleFormActions = new SimpleFormActions(driver);
        checkBoxActions = new CheckBoxActions(driver);
        radioButttonActions = new RadioButttonActions(driver);
        dropdownListActions = new DropdownListActions(driver);
        javaScriptAlertsActions = new JavaScriptAlertsActions(driver);
        windowPopupModelActions = new WindowPopupModelActions(driver);
        bootstrapAlertsActions = new BootstrapAlertsActions(driver);
        bootstrapModalsActions = new BootstrapModalsActions(driver);


        intermediateActions = new IntermediateActions(driver);
        inputFormWithValidationActions = new InputFormWithValidationActions(driver);
        ajaxFormActions = new AjaxFormActions(driver);
        jquerySelectDropdownActions = new JquerySelectDropdownActions(driver);

    }



    // --------------- TestNg annotations ---------------

    /**
     * Method to be run at first before all test in the suite have run, thus having the highest priority
     * @priority = -4
     */
    @BeforeSuite(alwaysRun = true)
    public void TestSessionInitiators() {
        setYamlFilePath(); 						// Selecting tier, browser from Config.properties and selecting right test data for the tier
        Reporter.log("The application url is :- " + baseurl, true);		// Printing log in both html and console
    }

    /**
     * Method to be run before any test method belonging to the class inside, having the second-highest priority
     * @priority = -3
     */

    @BeforeSuite
    public static void startReport(){

        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") +"/test-output/ExtentReport.html");
        extent.attachReporter(spark);

    }

    /**
     * Method to be run before the execution of any test method in that class file, having the third-highest priority
     * @priority = -2
     */

    @BeforeClass
    public void launchMyApplication() {
        wdfactory = new WebDriverFactory();		// Creating object of WebDriverFactory
        testInitiator();						// Calling the testInitiator() to setYamlFilePath, configure browser and initializing page objects
        launchApplication(baseurl);				// Launching the application
    }




    /**
     * Method to be run after the execution of any test method in that class file
     */


    @AfterMethod
    public static void getResult(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            logger.log(Status.FAIL, "Test Case Failed is "+result.getName());
            logger.log(Status.FAIL, "Test Case Failed is "+result.getThrowable());
        }else if(result.getStatus() == ITestResult.SKIP){
            logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
        }

    }

    @AfterSuite
    public static void endReport(){
        extent.flush();
    }


    @AfterClass(alwaysRun = true)
    public void stop_test_session() { driver.close();
        driver.quit();
        //closeBrowserSession();
    }


// ----------- Private Methods -------------

    private void testInitiator() {
        _configureBrowser();
        _initPage();
    }





    /**
     * Launches the application found at provided URL
     *
     * @param appurl
     */
    private void launchApplication(String appurl) {
        Reporter.log("The application url is :- " + appurl, true);
        driver.get(appurl);
    }

    public void changeWindow(int i) {
        Set<String> windows = driver.getWindowHandles();
        String wins[] = windows.toArray(new String[windows.size()]);
        driver.switchTo().window(wins[i]);
    }

}
