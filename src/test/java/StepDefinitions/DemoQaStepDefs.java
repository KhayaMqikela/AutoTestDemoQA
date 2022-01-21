package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import static testUtilities.Hooks.driver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import testUtilities.BasePage;

public class DemoQaStepDefs extends BasePage {
    private By FORM_LINK = By.xpath("//h5[text()='Forms']");
    private By FORM_TAB = By.xpath("//*[text()='Forms' and @class='header-text']");
    private By PRACTICE_TAB = By.xpath("//span[text()='Practice Form']");
    private By STUDENT_REGISTRATION_FORM = By.xpath("//h5[text()='Student Registration Form']");
    private By FIRST_NAME = By.xpath("//input[@id='firstName']");
    private By LAST_NAME = By.xpath("//input[@id='lastName']");
    private By EMAIL = By.xpath("//input[@id='userEmail']");
    private By GENDER_MALE = By.xpath("//label[@for='gender-radio-1']");
    private By GENDER_FEMALE = By.xpath("//label[@for='gender-radio-2']");
    private By GENDER_OTHER = By.xpath("//label[@for='gender-radio-3']");
    private By MOBILE = By.xpath("//input[@id='userNumber']");
    private By DATE_OF_BIRTH = By.xpath("//input[@id='dateOfBirthInput']");
    private By DATE_MONTH_SELECTOR = By.xpath("//select[@class='react-datepicker__month-select']");
    private By DATE_YEAR_SELECTOR = By.xpath("//select[@class='react-datepicker__year-select']");

    private By DATE_DAY_SELECTOR;

    private By SUBJECTS = By.xpath("//input[@id='subjectsInput']");
    private By HOBBY_SPORT = By.xpath("//label[@for='hobbies-checkbox-1']");
    private By HOBBY_READING = By.xpath("//label[@for='hobbies-checkbox-2']");
    private By HOBBY_MUSIC = By.xpath("//label[@for='hobbies-checkbox-3']");
    private By CURRENT_ADDRESS = By.xpath("//textarea[@id='currentAddress']");
    private By STATE = By.xpath("//input[@id='react-select-3-input']");
    private By CITY = By.xpath("//input[@id='react-select-4-input']");
    private By SUBMIT_BUTTON = By.xpath("//button[@id='submit']");

    BasePage basePageObject = new BasePage();

    @Given("I have navigated to DemoQA")
    public void iHaveNavigatedToDemoQA() {
        driver.navigate();
        basePageObject.validateObjectOnPage(FORM_LINK);
    }

    @When("the user clicks the Forms button")
    public void theUserClicksTheFormsButton() {
        basePageObject.clickAnElement(FORM_LINK);
    }

    @Then("the forms page is displayed")
    public void theFormsPageIsDisplayed() {
        basePageObject.validateObjectOnPage(FORM_TAB);
    }

    @When("the user clicks the forms tab")
    public void theUserClicksTheFormsTab() {
        basePageObject.clickAnElement(FORM_TAB);
    }

    @Then("the practice form tab is displayed")
    public void thePracticeFormTabIsDisplayed() {
        basePageObject.validateObjectOnPage(PRACTICE_TAB);
    }

    @When("the user clicks the practice form tab")
    public void theUserClicksThePracticeFormTab() {
        basePageObject.clickAnElement(PRACTICE_TAB);
    }

    @Then("the student registration form is displayed")
    public void theStudentRegistrationFormIsDisplayed() {
        basePageObject.validateObjectOnPage(STUDENT_REGISTRATION_FORM);
    }

    @When("the user enters {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void theUserEnters(String firstname, String lastname, String email, String gender, String mobile, String dob, String subjects, String hobbies, String currentaddress, String state, String city) {
        basePageObject.inputValue(FIRST_NAME,firstname);
        basePageObject.inputValue(LAST_NAME,lastname);
        basePageObject.inputValue(EMAIL,email);
        if(gender.equals("Male")){
            basePageObject.clickAnElement(GENDER_MALE);
        }
        else if (gender.equals("Female")){
            basePageObject.clickAnElement(GENDER_FEMALE);
        }
        else{
            basePageObject.clickAnElement(GENDER_OTHER);
        }

       // basePageObject.inputValue(MOBILE,mobile);

       basePageObject.inputValue(SUBJECTS,subjects);


        if(hobbies.equals("Sports")){
            basePageObject.clickAnElement(HOBBY_SPORT);
        }
        else if(hobbies.equals("Reading")){
            basePageObject.clickAnElement(HOBBY_READING);
        }
        else if(hobbies.equals("Music")){
            basePageObject.clickAnElement(HOBBY_MUSIC);
        }

        basePageObject.clickAnElement(MOBILE);
        basePageObject.inputValue(MOBILE,mobile);
        basePageObject.inputValue(CURRENT_ADDRESS,currentaddress);
        basePageObject.inputValueOnDropdown(STATE,state);
        basePageObject.inputValueOnDropdown(CITY,city);
        driver.findElement(DATE_OF_BIRTH).click();

        Select selectElement = new Select(driver.findElement(DATE_MONTH_SELECTOR));
        String[] arrOfStr = dob.split(" ");
        selectElement.selectByVisibleText(arrOfStr[1]);

        Select selectElementYear = new Select(driver.findElement(DATE_YEAR_SELECTOR));
        String[] arrOfStrings = dob.split(" ");
        selectElementYear.selectByVisibleText(arrOfStrings[2]);

        DATE_DAY_SELECTOR = By.xpath(String.format("//div[text()='%1s' and contains(@aria-label,'%2s')]", arrOfStrings[0],arrOfStr[1]));
        clickAnElement(DATE_DAY_SELECTOR);


    }

    @And("clicks the submit button")
    public void clicksTheSubmitButton() throws InterruptedException {
        basePageObject.clickAnElement(SUBMIT_BUTTON);
    }
}
