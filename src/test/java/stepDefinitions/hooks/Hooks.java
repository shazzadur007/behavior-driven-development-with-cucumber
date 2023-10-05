package stepDefinitions.hooks;

import com.alpine.cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;

public class Hooks {
    static TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @BeforeAll
    public static void beforeAll() {
//        org.javalite.activejdbc.connection_config.DBConfiguration.loadConfiguration("configs/database.properties");
//        new DB("default").open();
        System.out.println("BEFORE ALL STARTED");


//        Shipper s = Shipper.findFirst("id = ?", "1");
//        if (s != null) {
//            s.set("number", "01819616939").saveIt();
//            List<Shipper> shipperList = Shipper.where("id = 1");
//            System.out.println( shipperList.get(0).get("number") );
//        } else {
//        Shipper sp = new Shipper();
//            sp.insert();
//        sp.set("number", "01819616939");
//        sp.set("balance", 10);
//        sp.saveIt();
//        List<Shipper> shipperList = Shipper.findAll();
//        System.out.println( shipperList.get(0).get("number") );
//            Shipper.deleteAll();
//        }
    }

    @Before
    public void BeforeSteps() {
    }

    @After
    public void AfterSteps() {
//        testContext.getWebDriverManager().closeDriver();
    }

    @AfterAll
    public static void before_or_after_all() {
//        new DB("default").close();
        System.out.println("F IN IS ED");
        WebDriver driver = testContext.getWebDriverManager().getDriver();
        if (!driver.toString().contains("null")) {
            testContext.getWebDriverManager().closeDriver();
        } else {
            System.out.println("QUIT EARLIER");
        }
    }
}
