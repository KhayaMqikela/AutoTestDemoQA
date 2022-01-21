//package testRunner;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.When;
//import io.cucumber.java.en.Then;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import testUtilities.BasePage;
//
//import static org.junit.Assert.*;
//
//    public class StepDefs extends BasePage {
//        private By RTFE_LINK = By.xpath("//LI[@id='divTop6']/A");
//        private By CUSTOMER_SEARCH_LINK = By.xpath("//LI[@id='divTop6']/UL/LI[2]/A");
//        private By BCN_INPUT_FIELD = By.xpath("//body/form/table[3]/tbody/tr[2]/td[2]/input");
//        private By SEARCH_BUTTON_CUSTOMER_SEARCH = By.xpath("//body/form/table[3]/tbody/tr[7]/td/input[1]");
//
//
//        BasePage basePageObject = new BasePage();
//
////        @Given("the RTFE page is open")
////        public void the_RTFE_page_is_open() throws InterruptedException {
//////            WebDriver driver = new ChromeDriver();
//////            driver.get("https://rdweb.pd4.investec.corp/servlet/com.x.skylite.servlet.MainFrameServlet?xyz=2152161361644");
////            basePageObject.navigateToRTFE("PD4");
////
////        }
////
////        @Given("that I have opened the RTFE page")
////        public void thatIHaveOpenedTheRTFEPage() throws InterruptedException {
////            basePageObject.navigateToRTFE("PD4");
////        }
////
//        @Given("that I navigated to the RTFE {string} page")
//        public void thatINavigatedToTheRTFEPage(String env) throws InterruptedException {
//            basePageObject.navigateToRTFE(env);
//        }
//
//        @When("I click on the Retail Treasury FE link")
//        public void iClickOnTheRetailTreasuryFELink() {
//            basePageObject.clickElement(RTFE_LINK);
//        }
//
//        @And("I click the customer search link under RTFE")
//        public void iClickTheCustomerSearchLinkUnderRTFE() {
//                basePageObject.clickElement(CUSTOMER_SEARCH_LINK);
//
//        }
//
//        @And("I input {string} on the BCN input field")
//        public void iInputOnTheBCNInputField(String bcnNumber) {
//            basePageObject.inputValue(BCN_INPUT_FIELD,bcnNumber);
//        }
//
//        @And("click the search button on customer search tab")
//        public void clickTheSearchButtonOnCustomerSearchTab() {
//            basePageObject.clickSearchButtonOnCustomerSearch(SEARCH_BUTTON_CUSTOMER_SEARCH);
//        }
//
//        @When("click the search button on customer search tab which is in the frame {string}")
//        public void clickTheSearchButtonOnCustomerSearchTabWhichIsInTheFrame(String frames) {
//            basePageObject.clickSearchButtonOnCustomerSearchFrames(SEARCH_BUTTON_CUSTOMER_SEARCH,frames);
//        }
//    }
