package com.qtest.automation.utils;

import com.qtest.automation.WebDriverFactory;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.qtest.automation.utils.DataReadWrite.getProperty;

public class BaseDriver {

    public static WebDriver driver;
    protected WebDriverFactory wdfactory;

    protected void _configureBrowser() {
        driver = wdfactory.getDriver(_getSessionConfig());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(_getSessionConfig().get("timeout")),
                TimeUnit.SECONDS);
    }
    private Map<String, String> _getSessionConfig() {
        String[] configKeys = {"browser","timeout", "driverpath", "take-screenshot", "screenshot-path" };
        Map<String, String> config = new HashMap<String, String>();
        for (String string : configKeys) {
            config.put(string, getProperty("./Config.properties", string));
        }
        return config;
    }
}
