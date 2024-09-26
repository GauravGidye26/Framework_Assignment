package com.loginTest.stepdefinitions;

import com.loginTest.pages.AdvanceSearchPage;
import com.loginTest.pages.LoginPage;
import com.loginTest.utils.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.loginTest.utils.DriverFactory.getDriver;

public class AdvanceSearchSteps {
    WebDriver driver;
    AdvanceSearchPage searchPage;
    LoginPage login;

    @Before
    public void setUp() {
        driver = getDriver();
        searchPage = new AdvanceSearchPage(driver);
        login = new LoginPage(driver);
    }

    @Given("^User is on the Pharmacist portal$")
    public void userIsOnThePharmacistPortal() {
        login.openLoginPage();  // Replace with the correct URL
    }

    @When("^User logs in with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void userLoginWithCredentials(String email, String password) {
            login.enterEmail(email);
            login.enterPassword(password);
            login.clickSignIn();
    }

    @Given("User clicked on the Patient Field in the Navigation Bar")
    public void userClickedOnPatientFieldInNavigationBar() {
        searchPage.clickedOnPatient();
    }

    @When("^User opens the Advanced Search popup$")
    public void userOpensAdvancedSearch() {
        searchPage.openAdvancedSearch();
    }

    @Then("^Verify that the Advanced Search popup is displayed$")
    public void verifyAdvancedSearchPopupDisplayed() {
        Assert.assertTrue("Advanced Search popup is not displayed", searchPage.isAdvancedSearchPopupDisplayed());
    }

    @When("^User enters \"([^\"]*)\" as First Name$")
    public void userEntersAsFirstName(String firstName) {
        searchPage.enterFirstName(firstName);
    }

    @When("^User enters \"([^\"]*)\" as Last Name$")
    public void userEntersAsLastName(String lastName) {
        searchPage.enterLastName(lastName);
    }

    @When("^User enters \"([^\"]*)\" as City$")
    public void userEntersAsCity(String city) {
        searchPage.enterCity(city);
    }

    @When("^User selects \"([^\"]*)\" as State$")
    public void userSelectsAsState(String state) {
        searchPage.selectState(state);
    }

    @And("^User performs a search$")
    public void userPerformsASearch() {
        searchPage.clickSearch();
    }

    @Then("^Verify that the search results table is displayed$")
    public void verifySearchResultsAreDisplayed() {
        Assert.assertTrue("Search results table is not displayed", searchPage.isSearchResultsDisplayed());
    }

    @And("^Verify that search results contain \"([^\"]*)\"$")
    public void resultsAreDisplayedFor(String word) {
        Assert.assertTrue("Search text does not contain expected word", searchPage.isSearchTextDisplayed(word));
    }

    @Then("^Verify that error message \"([^\"]*)\" is displayed$")
    public void verifyErrorMessageDisplayed(String expectedMessage) {
        String actualMessage = searchPage.getErrorMessage();
        Assert.assertEquals("Error message did not match", expectedMessage, actualMessage);
    }


    @And("^User enters \"([^\"]*)\" as Zip Code$")
    public void userEntersAsZipCode(String zipCode) {
        searchPage.enterZipCode(zipCode);
    }

    @And("^User enters \"([^\"]*)\" as Phone$")
    public void userEntersAsPhone(String phone) {
        searchPage.enterPhone(phone);
    }

    @And("^User enters \"([^\"]*)\" as Birth Date$")
    public void userEntersAsBirthDate(String dob) {
        searchPage.enterDOB(dob);
    }

    @And("^User enters \"([^\"]*)\" as HPID$")
    public void userEntersAsHPID(String hpid) {
        searchPage.enterHPID(hpid);
    }

    @Then("^Tooltip error message: \"([^\"]*)\" should display for Birth Date$")
    public void tooltipErrorMessageForDOBShouldDisplay(String expectedErrMsg) {
        String actualErrMsg = searchPage.getTooltipErrorMessage(searchPage.dobField);
        Assert.assertEquals("Tooltip message did not match!", expectedErrMsg, actualErrMsg);
    }

    @Then("^Tooltip error message: \"([^\"]*)\" should display for Phone$")
    public void tooltipErrorMessageForPhoneShouldDisplay(String expectedErrMsg) {
        String actualErrMsg = searchPage.getTooltipErrorMessage(searchPage.phoneField);
        Assert.assertEquals("Tooltip message did not match!", expectedErrMsg, actualErrMsg);
    }

    @Then("^Tooltip error message: \"([^\"]*)\" should display for Zip Code$")
    public void tooltipErrorMessageForZipCodeShouldDisplay(String expectedErrMsg) {
        String actualErrMsg = searchPage.getTooltipErrorMessage(searchPage.zipCodeField);
        Assert.assertEquals("Tooltip message did not match!", expectedErrMsg, actualErrMsg);
    }

    @After
    public void tearDown() {
        DriverFactory.closeDriver();
    }
}
