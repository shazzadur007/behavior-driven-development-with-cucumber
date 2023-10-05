package com.alpine.dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class RoutesFileReader {
    protected Properties properties;
    public RoutesFileReader() {
        BufferedReader reader;
        String propertyFilePath = "configs//route.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("route.properties not found at " + propertyFilePath);
        }
    }
    public String getRequestsRoute() {
        String requestsRoute = properties.getProperty("requestsUrl");
        if (requestsRoute != null) return requestsRoute;
        else throw new RuntimeException("requestsRoute not specified in the route.properties file.");
    }
}
