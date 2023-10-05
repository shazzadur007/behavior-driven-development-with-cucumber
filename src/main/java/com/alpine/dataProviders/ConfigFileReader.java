package com.alpine.dataProviders;

import com.alpine.enums.DriverType;
import com.alpine.enums.EnvironmentType;
import com.alpine.enums.OperatingSystemType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    protected Properties properties;

    public ConfigFileReader() {
        BufferedReader reader;
        String propertyFilePath = "configs//configuration.properties";
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
            throw new RuntimeException("configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getDriverPath() {
        String driverPath = properties.getProperty("driverPath");
        if(driverPath != null) return driverPath;
        else throw new RuntimeException("driverPath not specified in the configuration.properties file.");
    }

    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("implicitlyWait not specified in the configuration.properties file.");
    }

    public String getRequestsUrl() {
        String url = properties.getProperty("requestsUrl");
        if(url != null) return url;
        else throw new RuntimeException("url not specified in the configuration.properties file.");
    }

    public DriverType getBrowser() {
        String browserName = properties.getProperty("browser");
        if(browserName == null || browserName.equals("chrome")) return DriverType.CHROME;
        else if(browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
        else if(browserName.equals("explorer")) return DriverType.INTERNETEXPLORER;
        else throw new RuntimeException("Browser Name Key value in configuration.properties is not matched : " + browserName);
    }

    public EnvironmentType getEnvironment() {
        String environmentName = properties.getProperty("environment");
        if(environmentName == null || environmentName.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
        else if(environmentName.equals("remote")) return EnvironmentType.REMOTE;
        else throw new RuntimeException("Environment Type Key value in configuration.properties is not matched : " + environmentName);
    }

    public OperatingSystemType getOperatingSystemType() {
        String operatingSystemName = properties.getProperty("operatingSystem");
        if (operatingSystemName == null || operatingSystemName.equalsIgnoreCase("linux")) return OperatingSystemType.LINUX;
        else if (operatingSystemName.equalsIgnoreCase("mac")) return OperatingSystemType.MAC;
        else if (operatingSystemName.equalsIgnoreCase("windows")) return OperatingSystemType.WINDOWS;
        else throw new RuntimeException("Operating system Type Key value in configuration.properties is not matched : " + operatingSystemName);
    }

    public Boolean getBrowserWindowSize() {
        String windowSize = properties.getProperty("windowMaximize");
        if(windowSize != null) return Boolean.valueOf(windowSize);
        return true;
    }

    public String getTestDataResourcePath() {
        String testDataResourcePath = properties.getProperty("testDataResourcePath");
        if(testDataResourcePath!= null) return testDataResourcePath;
        else throw new RuntimeException("Test Data Resource Path not specified in the configuration.properties file for the Key:testDataResourcePath");
    }

    public String getUserDataDirForChromeOptions() {
        String testDataResourcePath = properties.getProperty("userDataDirForChromeOptions");
        if(testDataResourcePath!= null) return testDataResourcePath;
        else throw new RuntimeException("Test Data Resource Path not specified in the configuration.properties file for the Key:testDataResourcePath");
    }

    public Boolean getHeadlessOption() {
        Boolean headless = properties.getProperty("headless").equalsIgnoreCase( "true" );
        return headless;
    }
}