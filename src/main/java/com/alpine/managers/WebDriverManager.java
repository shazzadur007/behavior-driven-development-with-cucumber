package com.alpine.managers;

import com.alpine.enums.DriverType;
import com.alpine.enums.EnvironmentType;
import com.alpine.enums.OperatingSystemType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    private WebDriver driver;
    private static DriverType driverType;
    private static EnvironmentType environmentType;

    private static OperatingSystemType operatingSystemType;
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    private static final String FIREFOX_DRIVER_PROPERTY = "webdriver.gecko.driver";

    private Boolean headless;

    public WebDriverManager() {
        driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
        environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
        operatingSystemType = FileReaderManager.getInstance().getConfigReader().getOperatingSystemType();
    }

    public WebDriver getDriver() {
        if(driver == null) driver = createDriver();
        return driver;
    }

    private WebDriver createDriver() {
        switch (environmentType) {
            case LOCAL : driver = createLocalDriver();
                break;
            case REMOTE : driver = createRemoteDriver();
                break;
        }
        return driver;
    }

    private WebDriver createRemoteDriver() {
        switch (driverType) {
            case FIREFOX:
                io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();

                FirefoxOptions firefoxOptions = new FirefoxOptions();
//                String profileDir = System.getProperty("user.dir") + "/" + "firefox_data_dir";
                String profileDir = "/tmp/firefox_data_dir";
                System.out.println(profileDir);
                firefoxOptions.addArguments("--profile");
                firefoxOptions.addArguments(profileDir);

//                driver = new FirefoxDriver(firefoxOptions);
                try {
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions);
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            default:
                throw new RuntimeException("Not Implemented Yet");
        }

        if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
        return driver;
    }

    private WebDriver createLocalDriver() {
        switch (driverType) {
            case FIREFOX :
                // Not Using DriverManager
//                System.setProperty(FIREFOX_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath() + "geckodriver");
//                System.setProperty(FIREFOX_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath() + "geckodriver_linux");

                // Using Driver Manager
                io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();

                // Options
                headless = FileReaderManager.getInstance().getConfigReader().getHeadlessOption();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                String profileDir = System.getProperty("user.dir") + "/" + "firefox_data_dir";
                firefoxOptions.addArguments("--profile");
                firefoxOptions.addArguments(profileDir);
                firefoxOptions.setHeadless(headless);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case CHROME :
                headless = FileReaderManager.getInstance().getConfigReader().getHeadlessOption();
                String user_data_dir = "--user-data-dir=" + System.getProperty("user.dir") + "/" + FileReaderManager.getInstance().getConfigReader().getUserDataDirForChromeOptions() + "";

                // Not using ChromeDriverManagerDependency
//                System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath() + "chromedriver_" + operatingSystemType.toString().toLowerCase());

                // Using ChromeDriverManagerDependency
                io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();

                // Chrome options
                ChromeOptions options = new ChromeOptions();
                options.addArguments(user_data_dir);
//                options.addArguments(profile_dir);
                options.setHeadless(headless);
                options.addArguments("enable-automation");
                options.addArguments("--no-sandbox");
//                options.addArguments("--incognito");
                options.addArguments("--disable-infobars");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-browser-side-navigation");
                options.addArguments("--disable-gpu");
                driver = new ChromeDriver(options);
                break;
            case INTERNETEXPLORER : driver = new InternetExplorerDriver();
                break;
        }

        if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
        return driver;
    }

    public void closeDriver() {
        driver.close();
        driver.quit();
    }
}
