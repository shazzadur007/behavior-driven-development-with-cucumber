package com.alpine.pageObjects;

import com.alpine.helper.WindowHandler;
import com.alpine.selenium.Wait;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class Page {
    private WebDriver driver;
    private JavascriptExecutor js;

    public Page(WebDriver webDriver) {
        driver = webDriver;
        js = (JavascriptExecutor) driver;
    }

    public void handOverTheWindowHandler() {
        WindowHandler.handOverTheHandlerToNextTab(driver);
        Wait.untilPageLoadComplete(driver);
        Wait.untilJqueryIsDone(driver);
    }

    public void takeScreenShot(WebElement el, String fileName) {
        try {
            File x = el.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(x, new File("target/screenshots/" + fileName));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void scrollToBottom() {
        js.executeScript("window.scrollBy(0,document.body.scrollHeight + 10000)");
    }

    public void scrollToBottom(WebElement element) {
        js.executeScript("arguments[0].scrollBy(0, arguments[0].scrollHeight)", element);
    }
}
