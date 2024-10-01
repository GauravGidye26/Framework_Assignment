package com.loginTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class patientDataPage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor to initialize WebDriver and WebDriverWait
    public patientDataPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50)); // 10 seconds wait timeout
    }

    // Locators for the fields
    private By patientIdField = By.xpath("//div//div//div//input[@aria-haspopup='listbox']");
    private By searchButton = By.xpath("//div[@class='src-routes-PharmacistPortal-LandingPage-components-TabsGlobal-Patients-__searchIcon___2b8Nq']");
    private By firstNameField = By.xpath("//label[text()='First Name']/following-sibling::input");
    private By lastNameField = By.xpath("//label[text()='Last Name']/following-sibling::input");
    private By hosp30dField = By.xpath("//label[text()='Hosp 30d']/following-sibling::input");
    private By dobField = By.xpath("//label[text()='DOB']/following-sibling::div//div//div//input");
    private By sexField = By.xpath("//label[text()='Sex']/following-sibling::input");
    private By ageField = By.xpath("//label[text()='Age']/following-sibling::input");
    private By patientLangField = By.xpath("//label[text()='Pt. Lang.']/following-sibling::span//select");
    private By insuranceNumField = By.xpath("//label[text()='Insurance #']/following-sibling::span");
    private By insuranceCoField = By.xpath("//label[text()='Insurance Co.']/following-sibling::span");
    private By validationField = By.xpath("//div[@class='src-routes-PharmacistPortal-LandingPage-components-TabsGlobal-Patients-__patientNameCell___fjLk4']");

    // Method to navigate to the patient page
    public void navigateToPatientPage(String url) {
        driver.get(url);
    }

    // Method to enter patient ID and search, with explicit wait
    public void enterPatientId(String patientId) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(patientIdField)).sendKeys(patientId); // Wait for the patient ID field to be visible
//        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click(); // Wait for the search button to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(validationField)).click();
        scrollToData();
    }

    public void scrollToData(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='src-routes-PharmacistPortal-LandingPage-components-TabsGlobal-Patients-__tableWrapper___308I3']")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }

    // Methods to get text from each field, with explicit wait
    public String getFirstName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).getAttribute("value"); // Wait for the first name field to be visible
    }

    public String getLastName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField)).getAttribute("value"); // Wait for the last name field to be visible
//        System.out.println(valueLastName);
//        return valueLastName;
    }

    public String getHosp30d() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(hosp30dField)).getAttribute("value"); // Wait for the Hosp 30d field to be visible
    }

    public String getDob() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(dobField)).getAttribute("value"); // Wait for the DOB field to be visible
    }

    public String getSex() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(sexField)).getAttribute("value"); // Wait for the sex field to be visible
    }

    public String getAge() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ageField)).getAttribute("value"); // Wait for the age field to be visible
    }

    public String getPatientLang() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(patientLangField)).getAttribute("value"); // Wait for the patient language field to be visible
    }

    public String getInsuranceNum() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(insuranceNumField)).getText(); // Wait for the insurance number field to be visible
    }

    public String getInsuranceCo() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(insuranceCoField)).getText(); // Wait for the insurance company field to be visible
    }
}
