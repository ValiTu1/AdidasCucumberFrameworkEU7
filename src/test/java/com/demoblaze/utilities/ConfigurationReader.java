package com.demoblaze.utilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * reads the properties file configuration.properties
 */

public class ConfigurationReader {
    //#1- Create properties object
    private static Properties properties = new Properties();

    static {

        try {
            String path = "configuration.properties";
            //#2- Load the file into FileInputStream
            FileInputStream input = new FileInputStream(path);

            //#3- load properties object with the file (configuration.properties)
            properties.load(input);

            //close the file
            input.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static String get(String keyName) {
        return properties.getProperty(keyName);
    }
}
