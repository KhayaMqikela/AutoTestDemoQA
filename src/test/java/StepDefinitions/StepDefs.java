package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import testUtilities.BasePage;

public class StepDefs extends BasePage {

    private By RTFE_LINK = By.xpath("//LI[@id='divTop6']/A");
    private By FORM_LINK = By.xpath("//h5[text()='Forms']");
    private By SEARCH_BUTTON_CUSTOMER_SEARCH = By.xpath("//body/form/table[3]/tbody/tr[7]/td/input[1]");
    private By CLIENT_SEARCH_LINK = By.xpath("//body/form/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/a/font");
    private By PRODUCT_SEARCH_LINK = By.xpath("//body/form/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/a/font");
    private By CLIENT_CONTACT_AND_WORKFLOW_LINK = By.xpath("//body/form/table/tbody/tr/td[1]/table/tbody/tr[2]/td[3]/a/font");
    private By MY_INBOX_LINK = By.xpath("//*[@id='inboxLink']/font");
    private By GROUP_INBOX = By.xpath("//*[@id='groupInboxLink']/font");


    BasePage basePageObject = new BasePage();

//        @Given("the RTFE page is open")
//        public void the_RTFE_page_is_open() throws InterruptedException {
////            WebDriver driver = new ChromeDriver();
////            driver.get("https://rdweb.pd4.investec.corp/servlet/com.x.skylite.servlet.MainFrameServlet?xyz=2152161361644");
//            basePageObject.navigateToRTFE("PD4");
//
//        }
//
//        @Given("that I have opened the RTFE page")
//        public void thatIHaveOpenedTheRTFEPage() throws InterruptedException {
//            basePageObject.navigateToRTFE("PD4");
//        }
//
    @Given("that I navigated to the RTFE {string} page")
    public void thatINavigatedToTheRTFEPage(String env) throws InterruptedException {
        basePageObject.navigateToRTFE(env);
    }

    @When("I click on the Retail Treasury FE link")
    public void iClickOnTheRetailTreasuryFELink() {
        basePageObject.clickElement(RTFE_LINK);
    }

    @And("I click the customer search link under RTFE")
    public void iClickTheCustomerSearchLinkUnderRTFE() {
        //try{
           // driver.switchTo().alert().dismiss();
            //basePageObject.clickElement(CUSTOMER_SEARCH_LINK);
       // }
        //catch(NoAlertPresentException exception){
            //basePageObject.clickElement(CUSTOMER_SEARCH_LINK);
        //}
       // basePageObject.clickElement(CUSTOMER_SEARCH_LINK);

    }

//    @And("I input {string} on the BCN input field")
//    public void iInputOnTheBCNInputField(String bcnNumber) {
//        basePageObject.inputValue(BCN_INPUT_FIELD,bcnNumber);
//    }

    @And("click the search button on customer search tab")
    public void clickTheSearchButtonOnCustomerSearchTab() {
        basePageObject.clickSearchButtonOnCustomerSearch(SEARCH_BUTTON_CUSTOMER_SEARCH);
    }

    @Given("I have navigated to Radar")
    public void iHaveNavigatedToRadar() {
        driver.navigate().refresh();
        basePageObject.validateObjectOnPage(FORM_LINK);

    }

//    @When("click the search button on customer search tab which is in the frame {string}")
//    public void clickTheSearchButtonOnCustomerSearchTabWhichIsInTheFrame(String frames) {
//        basePageObject.clickSearchButtonOnCustomerSearchFrames(SEARCH_BUTTON_CUSTOMER_SEARCH,frames);
//    }
}
