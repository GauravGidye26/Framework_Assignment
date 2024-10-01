package com.loginTest.stepdefinitions;

import com.loginTest.pages.AdvanceSearchPage;
import com.loginTest.pages.LoginPage;
import com.loginTest.pages.conversionDatePage;
import com.loginTest.utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.loginTest.pages.patientDataPage;

import java.util.Map;

import static com.loginTest.utils.DriverFactory.getDriver;

public class verifyPatientDataSteps {

    WebDriver driver;
    AdvanceSearchPage searchPage;
    patientDataPage patientDetailsPage;
    LoginPage login;

    @Before
    public void setUp() {
        driver = getDriver();
//        datePage = new conversionDatePage(driver);
        login = new LoginPage(driver);
        searchPage = new AdvanceSearchPage(driver);
        patientDetailsPage = new patientDataPage(driver);
    }

    @After
    public void tearDown() {
        DriverFactory.closeDriver();
    }

//    public verifyPatientDataSteps(WebDriver driver) {
//        // Initialize the WebDriver and PatientDetailsPage in the constructor (Assuming WebDriver setup is already done)
//        this.patientDetailsPage = new patientDataPage(driver);
//    }


    @Given("^User opened the Pharmacist portal$")
    public void userOpenedThePharmacistPortal() {
        login.openLoginPage();  // Replace with the correct URL
    }

    @When("^User logged in with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void userLoggedInWithCredentials(String email, String password) {
        login.enterEmail(email);
        login.enterPassword(password);
        login.clickSignIn();
    }
//    @Given("User clicks on the Patient Field in the Navigation Bar")
//    public void userClickedOnPatientFieldInNavigationBar() {
//        searchPage.clickedOnPatient();
//    }

//    @Given("^User opens the Pharmacist portal$")
//    public void userIsOnThePharmacistPortal() {
//        login.openLoginPage();  // Replace with the correct URL
//    }

    @Given("User navigates to the patient page")
    public void navigateToPatientPage() {
        // Use the method from PatientDetailsPage to navigate to the page
        searchPage.clickedOnPatient(); // Replace with actual URL
    }

    @When("User enters the patient ID {string}")
    public void enterPatientId(String patientId) {
        // Use the method from PatientDetailsPage to enter the patient ID
        patientDetailsPage.enterPatientId(patientId);
//        patientDetailsPage.scrollToData();
    }

    @Then("The patient details should match the following:")
    public void verifyPatientDetails(io.cucumber.datatable.DataTable dataTable) {

        // Convert DataTable to a Map for easier access to column names and values
        Map<String, String> expectedData = dataTable.asMaps(String.class, String.class).get(0);


        // Verifying each field using methods from PatientDetailsPage
        Assert.assertEquals(patientDetailsPage.getFirstName(), expectedData.get("First Name"));
//        System.out.println(expectedData.get("First Name"));
        Assert.assertEquals(patientDetailsPage.getLastName(), expectedData.get("Last Name"));
        Assert.assertEquals(patientDetailsPage.getHosp30d(), expectedData.get("Hosp 30d"));
        Assert.assertEquals(patientDetailsPage.getDob(), expectedData.get("DOB"));
        Assert.assertEquals(patientDetailsPage.getSex(), expectedData.get("Sex"));
        Assert.assertEquals(patientDetailsPage.getAge(), expectedData.get("Age"));
        Assert.assertEquals(patientDetailsPage.getPatientLang(), expectedData.get("Pt. Lang."));
        Assert.assertEquals(patientDetailsPage.getInsuranceNum(), expectedData.get("Insurance #"));
        Assert.assertEquals(patientDetailsPage.getInsuranceCo(), expectedData.get("Insurance Co."));
    }
}
