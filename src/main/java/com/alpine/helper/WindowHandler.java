package com.alpine.helper;

import org.openqa.selenium.WebDriver;

import java.util.Objects;
import java.util.Set;

public class WindowHandler {
    public static void handOverTheHandlerToNextTab(WebDriver driver) {
        String oldHandle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for(String handle : handles) {
            if (!Objects.equals(handle, oldHandle)) {
                driver.switchTo().window(handle);
                driver.getCurrentUrl();
                break;
            }
        }
    }
}
