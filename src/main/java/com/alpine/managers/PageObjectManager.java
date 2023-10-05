package com.alpine.managers;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    protected WebDriver driver;

    // trips
    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }
}