package StepDefinitions;

import com.google.common.collect.Ordering;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import static testUtilities.Hooks.driver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.hpsf.Decimal;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import testUtilities.BasePage;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DemoQaStepDefs extends BasePage {
    private By MENU_BUTTON = By.xpath("//button[span='Menu']");
    private By PAYEES_MENU_OPTION = By.xpath("//span[text()='Payees']");
    private By PAYEES_SEARCH_BAR = By.xpath("//input[@placeholder='Search payees']");
    private By ADD_BUTTON = By.xpath("//button[span='Add']");
    private By ADD_BUTTON_PAYEE_FORM = By.xpath("//button[text()='Add']");
    private By PAYEE_NAME = By.xpath("//input[@id='ComboboxInput-apm-name']");
    private By NAME_TEXT_WRAP;
    private By PAYEE_ADDED_MESSAGE = By.xpath("//span[text()='Payee added' and @role='alert']");
    private By PAYEE_ADDED_LIST;
    private By ERROR_MESSAGE_ON_FORM;
    private By NAME_HEADER = By.xpath("//span[text()='Name']");
    private By PAYEE_LIST_ITEM;
    private By PAY_TRANSFER_MENU_ITEM = By.xpath("//span[text()='Pay or transfer']");
    private By CHOOSE_ACCOUNT_FROM = By.xpath("//span[text()='Choose account']");
    private By CHOOSE_ACCOUNT_TO = By.xpath("//*[text()='Choose account, payee, or someone new']");
    private By ACCOUNTS_TAB = By.xpath("//*[text()='Accounts']");
    private By AMOUNT_INPUT = By.xpath("//input[@name='amount']");
    private By TRANSFER_BUTTON = By.xpath("//button[@data-monitoring-label='Transfer Form Submit']");

    private By ACCOUNT_BANK = By.xpath("//input[@id='apm-bank']");
    private By ACCOUNT_BRANCH = By.xpath("//input[@id='apm-branch']");
    private By ACCOUNT_ACCOUNT = By.xpath("//input[@id='apm-account']");
    private By ACCOUNT_SUFFIX = By.xpath("//input[@id='apm-suffix']");

    private By ALERTS_FRAMES_WINDOWS = By.xpath("//h5[text()='Alerts, Frame & Windows']");
    private By ALERTS_FRAMES_WINDOWS_HEADER = By.xpath("//div[text()='Alerts, Frame & Windows' and @class='main-header']");
    private By ALERTS_FRAMES_WINDOWS_TAB = By.xpath("//div[text()='Alerts, Frame & Windows' and @class='header-text']");
    private By MODAL_BODY;
    private By CLOSE_MODAL = By.xpath("//button[@id='closeSmallModal']");
    private By ALERTS_LINK = By.xpath("//span[text()='Alerts']");
    private By ALERTS_CLICK_ME_BUTTON = By.xpath("//button[@id='alertButton']");
    private By SMALL_MODAL = By.xpath("//button[@id='showSmallModal']");

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
        basePageObject.validateObjectOnPage(MENU_BUTTON);
    }

    @When("the user clicks the Forms button")
    public void theUserClicksTheFormsButton() {
        basePageObject.clickAnElement(MENU_BUTTON);
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

    @When("the user clicks the alerts frames windows link")
    public void theUserClicksTheAlertsFramesWindowsLink() {
        clickAnElement(ALERTS_FRAMES_WINDOWS);
    }

    @Then("the alerts frames windows page is displayed")
    public void theAlertsFramesWindowsPageIsDisplayed() {
        validateObjectOnPage(ALERTS_FRAMES_WINDOWS_HEADER);
    }

    @When("the user clicks the alerts frames windows tab")
    public void theUserClicksTheAlertsFramesWindowsTab() {
        validateObjectOnPage(ALERTS_FRAMES_WINDOWS_TAB);
    }

    @And("the user clicks {string}")
    public void theUserClicks(String link) {
        //span[text()='link']
        ALERTS_LINK = By.xpath(String.format("//span[text()='%1s']", link));

        clickAnElement(ALERTS_LINK);
    }

    @Then("the alerts click me button is displayed as one of the options")
    public void theAlertsClickMeButtonIsDisplayedAsOneOfTheOptions() {
        validateObjectOnPage(ALERTS_CLICK_ME_BUTTON);
    }

    @When("the user clicks the click me button")
    public void theUserClicksTheClickMeButton() {
        clickAnElement(ALERTS_CLICK_ME_BUTTON);
    }

    @Then("the {string} is displayed")
    public void theIsDisplayed(String alertText) {
        driver.switchTo().alert().getText().equals(alertText);
    }

    @And("the user clicks OK on the alert")
    public void theUserClicksOKOnTheAlert() {
        driver.switchTo().alert().accept();
    }

    @Then("the small modal button is displayed")
    public void theSmallModalButtonIsDisplayed() {
        validateObjectOnPage(SMALL_MODAL);
    }

    @When("the user clicks the small modal button")
    public void theUserClicksTheSmallModalButton() {
        clickAnElement(SMALL_MODAL);
    }

    @Then("the {string} modal window is displayed")
    public void theModalWindowIsDisplayed(String modalText) {
        MODAL_BODY = By.xpath(String.format("//div[text()='%s' and @class='modal-body']", modalText));
        validateObjectOnPage(MODAL_BODY);
    }

    @And("the user closes the modal window")
    public void theUserClosesTheModalWindow() {
        clickAnElement(CLOSE_MODAL);
    }

    @When("the user clicks the Menu button")
    public void theUserClicksTheMenuButton() {
        basePageObject.clickAnElement(MENU_BUTTON);
    }

    @And("the user clicks the Payees link")
    public void theUserClicksThePayeesLink() {
        basePageObject.clickAnElement(PAYEES_MENU_OPTION);
    }

    @Then("the Payees page is loaded")
    public void thePayeesPageIsLoaded() {
        validateObjectOnPage(PAYEES_SEARCH_BAR);
    }

    @When("the user clicks the Add button on the payees page")
    public void theUserClicksTheAddButtonOnThePayeesPage() {
        basePageObject.clickAnElement(ADD_BUTTON);
    }

    @Then("the Add Payee pop up form is displayed")
    public void theAddPayeePopUpFormIsDisplayed() {
        validateObjectOnPage(PAYEE_NAME);
    }


    @When("the user enters the {string}")
    public void theUserEntersThe(String payeeName) {
        basePageObject.inputValue(PAYEE_NAME,payeeName);
    }



    @And("the user enters the {string} {string} {string} {string} number")
    public void theUserEntersTheNumber(String accountBank, String accountBranch, String accountAccount, String accountSuffix) throws InterruptedException {
        basePageObject.inputValue(ACCOUNT_BANK,accountBank);
        basePageObject.inputValue(ACCOUNT_BRANCH,accountBranch);
        basePageObject.inputValue(ACCOUNT_ACCOUNT,accountAccount);
        basePageObject.inputValue(ACCOUNT_SUFFIX,accountSuffix);
    }

    @And("the user clicks the text wrapper with text {string}")
    public void theUserClicksTheTextWrapperWithText(String name) {
        NAME_TEXT_WRAP = By.xpath(String.format("//*[contains(text(), '%1s')]", name));

        basePageObject.clickAnElement(NAME_TEXT_WRAP);
       // basePageObject.clickAnElement(NAME_TEXT_WRAP);
    }

    @And("the user clicks the Add button on the form")
    public void theUserClicksTheAddButtonOnTheForm() {
        basePageObject.clickAnElement(ADD_BUTTON_PAYEE_FORM);
    }

    @Then("the Payee Added mesage is displayed")
    public void thePayeeAddedMesageIsDisplayed() throws InterruptedException {
        basePageObject.validateObjectOnPage(PAYEE_ADDED_MESSAGE);
    }

    @And("the Payee with the name {string} is added in the list of payees")
    public void thePayeeWithTheNameIsAddedInTheListOfPayees(String payeeName) {
        PAYEE_ADDED_LIST = By.xpath(String.format("//span[@class='js-payee-name' and text()='%1s']", payeeName));
        basePageObject.validateObjectOnPage(PAYEE_ADDED_LIST);
    }

    @Then("the validation error {string} is displayed")
    public void theValidationErrorIsDisplayed(String errorMessage) {
        ERROR_MESSAGE_ON_FORM = By.xpath(String.format("//div[@class='error-header' and text()='%1s']", errorMessage));
        basePageObject.validateObjectOnPage(ERROR_MESSAGE_ON_FORM);
    }

    @Then("the validation error {string} is not displayed")
    public void theValidationErrorIsNotDisplayed(String errorMessage) {
        ERROR_MESSAGE_ON_FORM = By.xpath(String.format("//div[@class='error-header' and text()='%1s']", errorMessage));
       Assert.assertFalse(basePageObject.isElementPresent(ERROR_MESSAGE_ON_FORM));
    }

    @And("the list of Payees is sorted in Ascending order")
    public void theListOfPayeesIsSortedInAscendingOrder() {
        List<String> payees = new ArrayList<>();

        PAYEE_LIST_ITEM = By.xpath(String.format("//div[@class='Avatar-imageWrapper js-payee-avatar']/following-sibling::p[1]"));
        List<WebElement> myListToCheck=driver.findElements((PAYEE_LIST_ITEM));
        String textFromField;
        //int i = 0;
        for(int j=0;j<myListToCheck.size();j++){

            textFromField = myListToCheck.get(j).getText().trim();
             payees.add(textFromField);
             //i++;
    }
        boolean sorted = Ordering.natural().isOrdered(payees);
        Assert.assertTrue(sorted);
    }

    @When("the user clicks the Name header")
    public void theUserClicksTheNameHeader() {
        basePageObject.clickAnElement(NAME_HEADER);
    }

    @And("the list of Payees is sorted in Descending order")
    public void theListOfPayeesIsSortedInDescendingOrder() {
        List<String> payees = new ArrayList<>();

        PAYEE_LIST_ITEM = By.xpath(String.format("//div[@class='Avatar-imageWrapper js-payee-avatar']/following-sibling::p[1]"));
        List<WebElement> myListToCheck=driver.findElements((PAYEE_LIST_ITEM));
        String textFromField;
        //int i = 0;
        for(int j=0;j<myListToCheck.size();j++){

            textFromField = myListToCheck.get(j).getText().trim();
            payees.add(textFromField);
            //i++;
        }
        Collections.reverse(payees);
        boolean sorted = Ordering.natural().isOrdered(payees);
        Assert.assertTrue(sorted);
    }

    @And("the user clicks the Pay or Transfer link")
    public void theUserClicksThePayOrTransferLink() {
        basePageObject.clickAnElement(PAY_TRANSFER_MENU_ITEM);
    }

    @When("the user clicks on the Choose Account from list card")
    public void theUserClicksOnTheChooseAccountFromListCard() {
        basePageObject.clickAnElement(CHOOSE_ACCOUNT_FROM);
    }

    @And("the user selects {string} from the list of accounts")
    public void theUserSelectsFromTheListOfAccounts(String account) {
        By CHOOSE_ACCOUNT = By.xpath(String.format("//p[text()='%1s']", account));
        //P[text()='Everyday']/following-sibling::p[1]
        By availableAmount = By.xpath(String.format("//P[text()='%1s']/following-sibling::p[1]", account));
        String amount = getText(availableAmount);
        int len = amount.length();
        DecimalFormat df = new DecimalFormat("0.00");
        Double amountSubstring = Double.parseDouble(getText(availableAmount).substring(0,len-4).replace(",",""));
        availableBalance = df.format(amountSubstring);
        clickAnElement(CHOOSE_ACCOUNT);
    }

    @When("the user clicks on the Choose Account to card")
    public void theUserClicksOnTheChooseAccountToCard() {
        basePageObject.clickAnElement(CHOOSE_ACCOUNT_TO);
    }

    @And("the user selects the accounts tab")
    public void theUserSelectsTheAccountsTab() {
        basePageObject.clickAnElement(ACCOUNTS_TAB);
    }

    @And("the user inputs {string} for amount")
    public void theUserInputsForAmount(String amount) {
        basePageObject.inputValue(AMOUNT_INPUT,amount);
    }

    @Then("the user clicks the Transfer button")
    public void theUserClicksTheTransferButton() {
        basePageObject.clickAnElement(TRANSFER_BUTTON);

    }

    @And("the {string} account decreases by the {string}")
    public void theAccountDecreasesByThe(String account, String amount) {

        By AVAILABLE_AMOUNT = By.xpath(String.format("//*[text()='%1s']/ancestor::span/following-sibling::span[2]",account));
        String availableAmountFromAccount = getText(AVAILABLE_AMOUNT);
        DecimalFormat df = new DecimalFormat("0.00");
        Double amountSubstring = Double.parseDouble(availableBalance)-Double.parseDouble(availableAmountFromAccount);
        System.out.println(amountSubstring);
    }
}
