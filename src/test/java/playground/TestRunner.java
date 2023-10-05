package playground;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import io.cucumber.junit.CucumberOptions;
//import org.junit.runner.RunWith;

//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
//        features = {"src/test/java/playground/facebookLogin.feature", "src/test/resources/functionalTests/trips/BiddingTripCreate.feature"}
        features = "playground.random.feature"
//        , glue = {"playground", "stepDefinitions.trips"}
        , glue = "playground"
//        , tags = "@facebook or @google"
        , tags = "@bidding"
//        , useFileNameCompatibleName = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
//public class TestRunner {
//    public static void main(String[] args) {
//        System.out.println(System.getProperty("user.dir"));
//    }
}
