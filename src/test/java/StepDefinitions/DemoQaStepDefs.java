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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    private By CHOOSE_ACCOUNT_TO = By.xpath("//span[text()='Choose account, payee, or someone new']");
    private By ACCOUNTS_TAB = By.xpath("//*[text()='Accounts']");
    private By AMOUNT_INPUT = By.xpath("//input[@name='amount']");
    private By TRANSFER_BUTTON = By.xpath("//button[@data-monitoring-label='Transfer Form Submit']");

    private By ACCOUNT_BANK = By.xpath("//input[@id='apm-bank']");
    private By ACCOUNT_BRANCH = By.xpath("//input[@id='apm-branch']");
    private By ACCOUNT_ACCOUNT = By.xpath("//input[@id='apm-account']");
    private By ACCOUNT_SUFFIX = By.xpath("//input[@id='apm-suffix']");




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
    public void theUserSelectsFromTheListOfAccounts(String account) throws InterruptedException {
        Thread.sleep(2000);


        By CHOOSE_ACCOUNT = By.xpath(String.format("//p[contains(text(),'Everyday')]", account));

        clickAnElement(CHOOSE_ACCOUNT);
        By amountAvailable = By.xpath(String.format("//*[text()='Everyday']/following-sibling::p[1]"));
        String amountBalanceBrforeTransfer =  getText(amountAvailable).replace(",","").replace("$","").replace(" Avl.","");
        availableBalance = amountBalanceBrforeTransfer;
    }

    @When("the user clicks on the Choose Account to card")
    public void theUserClicksOnTheChooseAccountToCard() throws InterruptedException {
        Thread.sleep(1500);
        waitForElementToBeVisible(CHOOSE_ACCOUNT_TO);
        basePageObject.clickAnElement(CHOOSE_ACCOUNT_TO);
    }

    @And("the user selects the accounts tab")
    public void theUserSelectsTheAccountsTab() throws InterruptedException {
        //new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(ACCOUNTS_TAB));
        //Actions actions = new Actions(driver);
        //actions.moveToElement(driver.findElement(ACCOUNTS_TAB)).click().build().perform();
        //new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable((ACCOUNTS_TAB))).click();
        Thread.sleep(1500);
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
        DecimalFormat df = new DecimalFormat("0.00");
        Double amountSubstring = Double.parseDouble(availableBalance)-Double.parseDouble(amount);
        newBalance = df.format(amountSubstring);

        By AVAILABLE_AMOUNT = By.xpath(String.format("//*[text()='%1s']/ancestor::span/following-sibling::span[2]",account));
        String availableAmountFromAccount = getText(AVAILABLE_AMOUNT).replace(",","");
        if(availableAmountFromAccount.equals(newBalance)){
            Assert.assertEquals(newBalance, availableAmountFromAccount);
        }

    }

    @And("the user selects {string} from the list of accounts to pay to")
    public void theUserSelectsFromTheListOfAccountsToPayTo(String account) throws InterruptedException {
        Thread.sleep(2000);


        By CHOOSE_ACCOUNT = By.xpath(String.format("//p[contains(text(),'Bills ')]", account));

        clickAnElement(CHOOSE_ACCOUNT);
    }
}
