package com.loginTest.stepdefinitions;

import com.loginTest.pages.LoginPage;
import com.loginTest.utils.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginSteps extends DriverFactory {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Given("User the login page")
    public void user_on_the_login_page() {
        loginPage.openLoginPage();
    }

    @When("User enter valid credentials")
    public void user_enter_valid_credentials() {
        loginPage.enterEmail("hardstop-pharmacist6@mailinator.com");
        loginPage.enterPassword("Password1#");
        loginPage.clickSignIn();
    }

    @When("User enter an invalid password")
    public void user_enter_an_invalid_password() {
        loginPage.enterEmail("hardstop-pharmacist6@mailinator.com");
        loginPage.enterPassword("Password");
        loginPage.clickSignIn();
    }

    @When("User enter an invalid email")
    public void user_enter_an_invalid_email() {
        loginPage.enterEmail("hardstop-pharmacist6@mailinator.co");
        loginPage.enterPassword("Password1#");
        loginPage.clickSignIn();
    }

    @Then("User should be redirected to the dashboard")
    public void user_should_be_redirected_to_the_dashboard() {
        Assert.assertTrue(loginPage.isDashboardDisplayed(), "Dashboard is not displayed");
    }

    @Then("User should see an error message {string}")
    public void user_should_see_an_error_message(String expectedMessage) {
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "Error message does not match");
    }
}
