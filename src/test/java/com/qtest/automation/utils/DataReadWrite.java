package com.qtest.automation.utils;

import java.util.Properties;

public class DataReadWrite {
    public static String getProperty(String PropFile, String Property){
        try{
            Properties prop = ResourceLoader.loadPropoerties(PropFile);
            return prop.getProperty(Property);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
