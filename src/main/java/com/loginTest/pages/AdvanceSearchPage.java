package com.loginTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdvanceSearchPage {
    WebDriver driver;
    WebDriverWait wait;


    public AdvanceSearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public By advancesrchbtn = By.cssSelector(".src-routes-PharmacistPortal-LandingPage-components-TabsGlobal-Patients-__advancedSearchIndicator___2ckHf");
    public By advancesrchpopup = By.xpath("//div[contains(@class, 'SearchPatient-__wrapper___2VRxI') and contains(@class, '__popUp___1ABAd')]");
    public By firstNameField = By.name("firstname");
    public By lastNameField = By.name("lastname");
    public By cityField = By.name("city");
    public By stateDropdown = By.name("state");
    public By searchButton = By.cssSelector("button[aria-label='search button']");
    public By errorMessagePopup = By.xpath("//div[@id='swal2-content']");
    public By srchTable = By.cssSelector("div[class*='SearchPatient-__drugSelectContainer___2eR2Q'] table");
    public By srchText = By.xpath("//h3[contains(text(),'*Showing')]");
    public By patienBtn = By.xpath("//button[normalize-space()='Patient']");
    public By zipCodeField = By.name("zip_code");
    public By phoneField = By.name("phone");
    public By dobField = By.name("dob");
    public By hpidField = By.name("hpid");

    public void openAdvancedSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(advancesrchbtn)).click();
    }


    public void enterFirstName(String firstName) {
        WebElement firstNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        firstNameElement.clear();
        firstNameElement.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        WebElement lastNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField));
        lastNameElement.clear();
        lastNameElement.sendKeys(lastName);
    }


    public void enterCity(String city) {
        WebElement cityElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cityField));
        cityElement.clear();
        cityElement.sendKeys(city);
    }


    public void selectState(String state) {
        WebElement stateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(stateDropdown));
        stateInput.click();
        stateInput.clear();
        stateInput.sendKeys(state);
    }

    public void clickSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }


    public String getErrorMessage() {
        WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessagePopup));
        return errorMessageElement.getText();
    }


    public boolean isAdvancedSearchPopupDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(advancesrchpopup)).isDisplayed();
    }


    public boolean isSearchResultsDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(srchTable)).isDisplayed();
    }


    public boolean isSearchTextDisplayed(String word) {
        WebElement searchTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(srchText));
        String text = searchTextElement.getText();
        return text.contains(word);
    }

    public void clickedOnPatient() {
        wait.until(ExpectedConditions.elementToBeClickable(patienBtn)).click();
    }

    public void enterZipCode(String zipCode) {
        WebElement zipcodeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(zipCodeField));
        zipcodeElement.clear();
        zipcodeElement.sendKeys(zipCode);
    }

    public void enterPhone(String phone) {
        WebElement phoneElement = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneField));
        phoneElement.clear();
        phoneElement.sendKeys(phone);
    }

    public void enterDOB(String dob) {
        WebElement dobElement = wait.until(ExpectedConditions.visibilityOfElementLocated(dobField));
        dobElement.clear();
        dobElement.sendKeys(dob);
    }

    public void enterHPID(String hpid) {
        WebElement hpidElement = wait.until(ExpectedConditions.visibilityOfElementLocated(hpidField));
        hpidElement.clear();
        hpidElement.sendKeys(hpid);
    }
}
