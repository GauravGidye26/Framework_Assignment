package com.loginTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public By emailField = By.cssSelector("input[type='email']");
    public By passwordField = By.cssSelector("input[type='password']");
    public By signInButton = By.cssSelector("button[type='submit']");
    public By errorMessage = By.className("src-routes-User-Login-__textError___1dP6Q");


    public void openLoginPage() {
        driver.get("https://pharmacist-dev.arine.io/");
    }

    public void enterEmail(String email) {
        WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        emailElement.clear();
        emailElement.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    public void clickSignIn() {
        WebElement signInElement = wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInElement.click();
    }

    public String getErrorMessage() {
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return error.getText();
    }

    public boolean isDashboardDisplayed() {
        return wait.until(ExpectedConditions.urlContains("pharmacist-portal"));
    }
}
