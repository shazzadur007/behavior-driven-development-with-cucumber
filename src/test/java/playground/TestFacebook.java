package playground;

import com.alpine.helper.WaitExplicit;
import org.openqa.selenium.WebDriver;

public class TestFacebook extends Driver {
    WebDriver driver;
//    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver", "bin/chromedriver_linux");
//        WebDriver driver = new ChromeDriver();
//
//        driver.get("https://google.com");
//        driver.quit();
//    }
    public TestFacebook() {
        driver = this.getDriver();
    }

    public void userNavigatesTo(String url) {
        driver.get(url.toString());
        WaitExplicit.wait(2000);
    }
}