package com.qtest.automation.utils;

import static com.qtest.automation.utils.DataReadWrite.getProperty;

public class YamlReader {
    String yamlFilePath;
    public static void setYamlFilePath(){
        /**
         * Setting the browser
         */

        String browser =null;
        if(System.getProperty("env")==null){
            browser = getProperty("Config.properties", "browser").trim();
        }else{
            browser = System.getProperty("env");
        }


    }

}
