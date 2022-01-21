//package testRunner;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import io.cucumber.testng.CucumberOptions;
//import io.cucumber.testng.TestNGCucumberRunner;
//import io.cucumber.testng.PickleWrapper;
//import cucumber.runtime.groovy.GroovySnippet;
//
//@CucumberOptions(
//        features = "src/main/java/Features",
//        glue = {"stepDefinitions"},
//        tags = {"~@Ignore"}
//        ,plugin = "json:target/cucumber-reports/CucumberTestReport.json",
//        strict = true)
//
//
//
//public class TestRunner {
//    private TestNGCucumberRunner testNGCucumberRunner;
//
//    @BeforeClass(alwaysRun = true)
//    public void setUpClass() throws Exception {
//        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
//    }
//
//    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
//    public void feature(CucumberFea) {
//        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
//        testNGCucumberRunner.runScenario(scenario());
//        testNGCucumberRunner.runScenario(scenario(););
//        testNGCucumberRunner.
//    }
//
//    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios",retryAnalyzer = CucableJavaTemplate.class)
//    public void scenario(PickleWrapper pickleEvent) throws Throwable {
//        testNGCucumberRunner.runScenario(pickleEvent.getPickle());
//    }
//
//    @DataProvider
//    public Object[][] features() {
//        return testNGCucumberRunner.provideScenarios();
//    }
//
//    @AfterClass(alwaysRun = true)
//    public void tearDownClass() throws Exception {
//        testNGCucumberRunner.finish();
//    }
//}