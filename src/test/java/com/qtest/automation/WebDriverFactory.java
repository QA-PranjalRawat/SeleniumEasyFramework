package com.qtest.automation;

import com.google.common.base.Strings;
import org.apache.commons.lang3.StringUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.Map;

public class WebDriverFactory {

    private static String browser;
    private static DesiredCapabilities capabilities = new DesiredCapabilities();

    public WebDriver getDriver(Map<String, String> seleniumconfig) {
        if(!Strings.isNullOrEmpty(System.getProperty("browser"))){
            browser = System.getProperty("browser");
        }else{
            browser = seleniumconfig.get("browser").toString();
        }


        System.out.println("browser="+ browser);


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
        capabilities.setJavascriptEnabled(true);
        return new ChromeDriver(capabilities);
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
        capabilities.setJavascriptEnabled(true);
        return new FirefoxDriver(capabilities);
    }

}
