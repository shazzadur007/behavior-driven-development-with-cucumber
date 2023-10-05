package playground;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

public class MyStepdefs {
//    private WebDriver driver;
    @Given("User is on google home page")
    public void userIsOnGoogleHomePage() {
        TestFacebook testFacebook = new TestFacebook();
        testFacebook.userNavigatesTo("https://www.google.com");
        System.out.println("HELLO");
    }

    @When("User search for facebook")
    public void userSearchForFacebook() {
        System.out.println("HELLO");
    }

    @And("click on the link containing facebook.com")
    public void clickOnTheLinkContainingFacebookCom() {
        System.out.println("HELLO");

    }

    @Then("User should be redirected to facebook.com")
    public void userShouldBeRedirectedToFacebookCom() {
        System.out.println("HELLO");

    }

    @Given("User is on facebook")
    public void userIsOn() {
        TestFacebook testFacebook = new TestFacebook();
        testFacebook.userNavigatesTo("https://www.facebook.com");
    }
}
