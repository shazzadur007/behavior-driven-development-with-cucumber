package playground;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RawSelenium extends Driver {
    public RawSelenium() {
        super();
    }
    @Test
    public void main(String []args) {
        WebDriver webDriver = getDriver();
        webDriver.get("https://google.com");
    }
}
