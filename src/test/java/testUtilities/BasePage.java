package testUtilities;

import StepDefinitions.ScenarioContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;


public class BasePage extends ScenarioContext {
    ConfigFileReader configFileReader = new ConfigFileReader();
    //WebDriver driver = new InternetExplorerDriver();

    public WebDriver driver;

    public BasePage() {

        driver = Hooks.driver;
    }


    public void navigateToRTFE(String environment){
        ConfigFileReader configFileReader= new ConfigFileReader();
        String pathToEnv = configFileReader.getEnvironmentPath(environment);
        driver.get(pathToEnv);
        driver.manage().window().maximize();
        driver.navigate().refresh();

    }

    public void clickElement(By element){


        waitForElementToBeVisible(element);
        driver.findElement(element).click();
    }

    public void clickAnElement(By element){
        waitForElementToBeVisible(element);
        driver.findElement(element).click();
    }

    public void clickElementByFrame(By element){
        waitForElementToBeVisible(element);
        driver.findElement(element).click();

    }

    public void doubleClickElementByFrame(By element,String frames){
        driverSwitchMethod(frames);
        waitForElementToBeVisible(element);
        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(element)).perform();
    }

    public void clickSearchButtonOnCustomerSearch(By element){
        waitForElementToBeVisible(element);
        driver.findElement(element).click();

    }

    public void driverSwitchMethod(String frames){
        String[] frameArray = frames.split(",");
        driver.switchTo().defaultContent();
        for(int i=0;i<frameArray.length;i++){
            driver.switchTo().frame(frameArray[i]);
        }

    }

    public void inputValue(By element,String inputValue){

        waitForElementToBeVisible(element);
        driver.findElement(element).click();

        driver.findElement(element).sendKeys(inputValue);
        driver.findElement(element).sendKeys(Keys.TAB);
       // driver.findElement(element).sendKeys(Keys.ENTER);
    }

    public void pressKeyEnter(By element){
        waitForElementToBeVisible(element);
        //driver.findElement(element).sendKeys(Keys.ENTER);
        driver.findElement(element).sendKeys(Keys.TAB);
    }

    public void inputValueOnDropdown(By element,String inputValue){

        waitForElementToBeVisible(element);
        driver.findElement(element).sendKeys(inputValue);
        driver.findElement(element).sendKeys(Keys.ENTER);
    }

    public void inputValueByFrame(By element,String frames,String inputValue){
        driverSwitchMethod(frames);

        waitForElementToBeVisible(element);
        driver.findElement(element).click();
        driver.findElement(element).sendKeys(inputValue);
    }

    public void selectItemFromDropdown(By element,String optionToSelect){

        waitForElementToBeVisible(element);
        //clickElementByFrame(element,frames);

        //By OPTION_ON_DROPDOWN = By.xpath(String.format("//option[text()='%s']",optionToSelect));
        inputValueOnDropdown(element,optionToSelect);
    }

    public void clickSearchButtonOnCustomerSearchFrames(By element,String frames){
        driverSwitchMethod(frames);

        waitForElementToBeVisible(element);
        driver.findElement(element).click();

    }

    public void validateObjectOnPage(By element){
        waitForElementToBeVisible(element);
        //Assert.assertTrue(driver.findElement(element).isDisplayed()==true);

    }
    public boolean validateObjectNotOnPage(By element){
        return driver.findElement(element).isDisplayed();

    }

    public void setBalance(String balance){
        availableBalance = balance;

    }

    public String getBalance(){
        return availableBalance;

    }

    public boolean isElementPresent(By locatorKey) {
        try {
            driver.findElement(locatorKey);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void validateText(By element,String text){
        waitForElementToBeVisible(element);
        Assert.assertTrue(driver.findElement(element).isDisplayed()==true);

    }

    public String getText(By element){
        waitForElementToBeVisible(element);
       return driver.findElement(element).getText();
    }

    public void validateObjectOnFrame(By element,String frames){
        driverSwitchMethod(frames);

        //waitForElementToBeVisible(element);
        Assert.assertTrue(driver.findElement(element).isDisplayed()==true);

    }

    public void validateValueOnFrame(By element,String valueToBeValidated,String frames){
        driverSwitchMethod(frames);

        waitForElementToBeVisible(element);
        Assert.assertTrue(driver.findElement(element).getAttribute("value").equals(valueToBeValidated));

    }

    public void waitForElementToBeVisible(By element){
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated((element)));
    }

    public void isAlertPresent(By element){
        new WebDriverWait(driver, 20).until(ExpectedConditions.alertIsPresent());
    }

}
