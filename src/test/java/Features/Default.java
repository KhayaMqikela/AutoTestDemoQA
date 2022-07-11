package Features;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;
@RunWith(Cucumber.class)

@CucumberOptions(glue = "",plugin = {"pretty", "json:target/report.json", "de.monochromata.cucumber.report.PrettyReports:target/pretty-cucumber"}, features = {"src/test/java/Features"},tags = {"@PayTransfer"},strict = true)

public class Default extends AbstractTestNGCucumberTests {

    @Override
   // @DataProvider
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}



