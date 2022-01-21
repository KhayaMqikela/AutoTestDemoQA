package testRunner;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(glue = "",plugin = {"pretty", "json:target/report.json", "de.monochromata.cucumber.report.PrettyReports:target/pretty-cucumber"}, features = {"src/test/java/Features"},tags = {"@DemoTest"},strict = true)

public class Default extends AbstractTestNGCucumberTests {


    @Override
   // @DataProvider
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}


