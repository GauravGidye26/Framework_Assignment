package com.loginTest.stepdefinitions;

import com.loginTest.pages.LoginPage;
import com.loginTest.utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import static com.loginTest.utils.DriverFactory.getDriver;

public class LoginSteps{

    WebDriver driver;
    LoginPage loginPage;

    @Before
    public void setUp() {
        driver = getDriver();
        loginPage = new LoginPage(driver);
    }

    @Given("^User on the login page$")
    public void user_on_the_login_page() {
        loginPage.openLoginPage();
    }

    @When("^User login with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_login_with_credentials(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickSignIn();
    }

    @Then("^User should be redirected to the dashboard$")
    public void user_should_be_redirected_to_the_dashboard() {
        Assert.assertTrue(loginPage.isDashboardDisplayed(), "Dashboard is not displayed");
    }

    @Then("^User should see an error message \"([^\"]*)\"$")
    public void user_should_see_an_error_message(String expectedMessage) {
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "Error message does not match");
    }
    @After
    public void tearDown() {
        DriverFactory.closeDriver();
    }
}