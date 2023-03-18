package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties = new Properties();

    static{
        FileInputStream file = null;
        try {
            file = new FileInputStream("configuration.properties");

            properties.load(file);

            file.close();
        } catch (IOException e) {
            System.out.println("File not found in the configuration.feature");
            e.printStackTrace();
        }

        ;
    }

    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }



}
