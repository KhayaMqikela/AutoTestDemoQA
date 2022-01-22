package testUtilities;

import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Hooks {
    public static WebDriver driver;
    private static boolean beforeSuit = true;
    private static boolean afterSuit = true;
    private static String executablePath;
    static Properties prop;


    @Before
    public void beforeAll() throws IOException {
        if (beforeSuit) {


            ConfigFileReader configFileReader = new ConfigFileReader();

            //System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());

            //WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            //options.addArguments("--headless");


            //driver = new ChromeDriver(options);
            String pathToEnv = configFileReader.getEnvironmentPath("DemoTest");
            driver.get(pathToEnv);
            driver.manage().window().maximize();
            //driver.navigate().refresh();

        }

    }


    @BeforeStep
    public void beforeStep(Scenario scenario) {
        if(scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is " + driver.getCurrentUrl());
                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }

        }
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        if(scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is " + driver.getCurrentUrl());
                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }

        }
    }


    @After
    public void embedScreenshot(Scenario scenario) {

        if(scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is " + driver.getCurrentUrl());
                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }

        }
        driver.quit();
    }


}
