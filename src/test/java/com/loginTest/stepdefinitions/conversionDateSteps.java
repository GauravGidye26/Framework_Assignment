package com.loginTest.stepdefinitions;

//import com.loginTest.pages.AdvanceSearchPage;
import com.loginTest.pages.AdvanceSearchPage;
import com.loginTest.pages.LoginPage;
import com.loginTest.pages.conversionDatePage;
import com.loginTest.utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static com.loginTest.utils.DriverFactory.getDriver;

public class conversionDateSteps {
    WebDriver driver;
    AdvanceSearchPage searchPage;
    conversionDatePage datePage;
    LoginPage login;

    @Before
    public void setUp() {
        driver = getDriver();
        datePage = new conversionDatePage(driver);
        login = new LoginPage(driver);
        searchPage = new AdvanceSearchPage(driver);
    }

    @Given("^User opens the Pharmacist portal$")
    public void userIsOnThePharmacistPortal() {
        login.openLoginPage();  // Replace with the correct URL
    }

    @When("^User login with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void userLoginWithCredentials(String email, String password) {
        login.enterEmail(email);
        login.enterPassword(password);
        login.clickSignIn();
    }

    @Given("User clicks on the Patient Field in the Navigation Bar")
    public void userClickedOnPatientFieldInNavigationBar() {
        searchPage.clickedOnPatient();
    }


    @After
    public void tearDown() {
        DriverFactory.closeDriver();
    }


    @When("^User enters \"([^\"]*)\" in ID Field$")
    public void userEntersInIDField(String id) {
        datePage.enterId(id);
    }


    @And("Clicks on Report option")
    public void clicksOnReportOption() {
        datePage.clickedOnReport();
    }

    @Then("^User selects Date \"([^\"]*)\" days before current Date$")
    public void userSelectsDateDaysBeforeCurrentDate(String enterdays) {
        int days = Integer.parseInt(enterdays);
        datePage.selectDateBefore(days);
    }

    @And("User clicks on Conversation Date Button")
    public void userClicksOnConversationDateButton() {
        datePage.clickedConversationBtn();
    }
}
