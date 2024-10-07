package com.loginTest.stepdefinitions;

import com.loginTest.pages.AdvanceSearchPage;
import com.loginTest.pages.LoginPage;
import com.loginTest.utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import com.loginTest.pages.patientDataPage;
import java.util.Map;

public class verifyPatientDataSteps {

    AdvanceSearchPage searchPage= new AdvanceSearchPage(DriverFactory.getDriver());
    patientDataPage patientDetailsPage= new patientDataPage(DriverFactory.getDriver());
    LoginPage login= new LoginPage(DriverFactory.getDriver());

    @Given("^User opened the Pharmacist portal$")
    public void userOpenedThePharmacistPortal() {
        login.openLoginPage();
    }

    @When("^User logged in with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void userLoggedInWithCredentials(String email, String password) {
        login.enterEmail(email);
        login.enterPassword(password);
        login.clickSignIn();
    }


    @Given("User navigates to the patient page")
    public void navigateToPatientPage() {
        searchPage.clickedOnPatient();
    }

    @When("User enters the patient ID {string}")
    public void enterPatientId(String patientId) {
        patientDetailsPage.enterPatientId(patientId);
    }

    @Then("The patient details should match the following:")
    public void verifyPatientDetails(io.cucumber.datatable.DataTable dataTable) {

        Map<String, String> expectedData = dataTable.asMaps(String.class, String.class).get(0);


        Assert.assertEquals(patientDetailsPage.getFirstName(), expectedData.get("First Name"));
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
