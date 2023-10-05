package stepDefinitions.hooks;

import com.alpine.cucumber.TestContext;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventHandler;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestRunFinished;
import io.cucumber.plugin.event.TestRunStarted;
import org.javalite.activejdbc.DB;

public class GlobalHook implements ConcurrentEventListener {
    static TestContext testContext;

//    public GlobalHook(TestContext context) {
//        testContext = context;
//    }

    public GlobalHook() {}

    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestRunStarted.class, setup);
        eventPublisher.registerHandlerFor(TestRunFinished.class, teardown);
    }

    private EventHandler<TestRunStarted> setup = event -> {
        beforeAll();
    };

    private void beforeAll() {
        org.javalite.activejdbc.connection_config.DBConfiguration.loadConfiguration("configs/database.properties");
        new DB("default").open();
        System.out.println("BEFORE ALL");
    }

    private EventHandler<TestRunFinished> teardown = event -> {
        afterAll();
    };

    private void afterAll() {
        new DB("default").close();
        System.out.println("AFTER ALL");
//        testContext = new TestContestProvider().getTestContext();
//        System.out.println(testContext.getWebDriverManager().getDriver().toString());
//        testContext.getWebDriverManager().closeDriver();
//        System.out.println(testContext.getWebDriverManager().getDriver().toString());
    }
//    @Before
//    public void BeforeSteps() {
//    }
//
//    @After
//    public void AfterSteps() {
////        testContext.getWebDriverManager().closeDriver();
//    }
//
//    @AfterAll
//    public static void before_or_after_all() {
////        System.out.println("F IN IS ED");
//        testContext.getWebDriverManager().closeDriver();
//    }
}