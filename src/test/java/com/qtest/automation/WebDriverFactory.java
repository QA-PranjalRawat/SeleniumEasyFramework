package com.qtest.automation;

import com.google.common.base.Strings;
import org.apache.commons.lang3.StringUtils;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class WebDriverFactory {

    private static String browser;
    private static DesiredCapabilities capabilities = new DesiredCapabilities();
    private static String headless = "False";
    public static Map<String, Object> prefs = new HashMap<String, Object>();


    public WebDriver getDriver(Map<String, String> seleniumconfig) {
        if(!Strings.isNullOrEmpty(System.getProperty("browser"))){
            browser = System.getProperty("browser");
        }else{
            browser = seleniumconfig.get("browser").toString();
        }


        // Checking for Headless parameter in Config properties
        if(seleniumconfig.get("headless").toString().equalsIgnoreCase("True")){
            headless = "True";
        }

        System.out.println("browser="+ browser);
        System.out.println("headless="+ headless);

        prefs.put("download.default_directory",System.getProperty("user.dir") + File.separator + "downloads");

        // Calling suitable browser method
        if (browser.equalsIgnoreCase("chrome")) {
            return getChromeDriver(seleniumconfig.get("driverpath").toString());
        }
        else if (browser.equalsIgnoreCase("edge")){
            return getEdgeDriver(seleniumconfig.get("driverpath").toString());
        }
        else if (browser.equalsIgnoreCase("firefox")){
            return getFirefoxDriver(seleniumconfig.get("driverpath").toString());
        }


        return new ChromeDriver();
    }


    private static WebDriver getChromeDriver(String driverpath) {

        String chromeDriverPath = driverpath+ "chromedriver";
        if (StringUtils.containsIgnoreCase(System.getProperty("os.name"), "window")) {
            chromeDriverPath = chromeDriverPath + ".exe";
        }
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        ChromeOptions options = new ChromeOptions();
        if(headless.equalsIgnoreCase("True")){
            options.addArguments("--headless");
        }


        


        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        capabilities.setJavascriptEnabled(true);
        options.merge(capabilities);

        return new ChromeDriver(options);
    }

    private static WebDriver getEdgeDriver(String driverpath){
        String edgeDriverPath = driverpath+ "msedgedriver.exe";
        System.setProperty("webdriver.edge.driver", edgeDriverPath);
        return new EdgeDriver();
    }

    private static WebDriver getFirefoxDriver(String driverpath) {
        String firefoxDriverPath = driverpath+ "geckodriver";
        if (StringUtils.containsIgnoreCase(System.getProperty("os.name"), "window")) {
            firefoxDriverPath = firefoxDriverPath + ".exe";
        }
        System.setProperty("webdriver.gecko.driver", firefoxDriverPath);

        FirefoxOptions options = new FirefoxOptions();
        if(headless.equalsIgnoreCase("True")){
            options.setHeadless(true);
        }

        capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
        capabilities.setJavascriptEnabled(true);
        options.merge(capabilities);

        return new FirefoxDriver(capabilities);
    }

}
