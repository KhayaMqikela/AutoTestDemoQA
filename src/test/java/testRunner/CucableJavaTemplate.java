package testRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import io.cucumber.testng.PickleWrapper;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.Pickle;
//@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "",
        features = {"src/test/java/Features"},
        tags = {"@NavigateToPaymentsPage"},
        plugin = {"json:target/cucumber-reports/CucumberTestReport.json"},
        strict = true
)
public class CucableJavaTemplate implements IRetryAnalyzer {
    private int count = 0;
    private static int maxTry = 3;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {  ;//Check if test not succeed
            if (count < maxTry) {                            //Check if maxtry count is reached
                count++;                                    //Increase the maxTry count by 1
                iTestResult.setStatus(ITestResult.FAILURE);  //Mark test as failed
                return true;                                 //Tells TestNG to re-run the test
            } else {
                iTestResult.setStatus(ITestResult.FAILURE);  //If maxCount reached,test marked as failed
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);      //If test passes, TestNG marks it as passed
        }
        return false;
    }
    private TestNGCucumberRunner testNGCucumberRunner;
    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        System.out.println("Before Scenario ****");
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios",retryAnalyzer = CucableJavaTemplate.class)
    public void scenario(PickleWrapper pickleEvent) throws Throwable {
        testNGCucumberRunner.runScenario(pickleEvent.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }


    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        System.out.println("After Scenario ****");
        testNGCucumberRunner.finish();
    }
}
