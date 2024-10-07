package com.loginTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

public class conversionDatePage {
    WebDriver driver;
    WebDriverWait wait;


    public conversionDatePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(100));
    }

    By idField = By.xpath("//div//div//div//input[@aria-haspopup='listbox']");
    By reportOption = By.xpath("//div//div[normalize-space()='Reports']");
    By dateField = By.xpath("//input[@name='conversationDate']");
    By conversationBtn = By.xpath("//div//button[contains(@class, 'src-routes-PharmacistPortal-LandingPage-components-composites-ViewLetter-__buttonConversation___1tdUr')]");
    By setDate = By.xpath("//button[normalize-space()='OK']");

    public void enterId(String id) {
        WebElement idElement = wait.until(ExpectedConditions.visibilityOfElementLocated(idField));
        idElement.clear();
        idElement.sendKeys(id);
    }


    public void clickedOnReport() {
        wait.until(ExpectedConditions.elementToBeClickable(reportOption)).click();
    }

    public void selectDateBefore(int days){
        LocalDate currentDate = LocalDate.now();
        LocalDate targetDate = currentDate.minusDays(days);
        String targetMonthYear = targetDate.format(DateTimeFormatter.ofPattern("MMMM yyyy"));
//        System.out.println(targetDate);

        WebElement calendar = wait.until(ExpectedConditions.visibilityOfElementLocated(dateField));
        calendar.click();

        while (true) {
            WebElement currentMonthYearElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@class='react-datepicker__current-month']")));
            String currentMonthYear = currentMonthYearElement.getText();

            if (currentMonthYear.equals(targetMonthYear)) {
                break;
            }

            WebElement previousMonthButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")));
            previousMonthButton.click();
        }

        By dateLocator = By.xpath("//div[@aria-label='day-" + targetDate.getDayOfMonth() + "']");
        wait.until(ExpectedConditions.elementToBeClickable(dateLocator)).click();
    }

    public void clickedConversationBtn() {
        WebElement conBtn = wait.until(ExpectedConditions.elementToBeClickable(conversationBtn));
        conBtn.click();
        WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='swal2-content']")));
//        System.out.println(msg.getText());
        wait.until(ExpectedConditions.elementToBeClickable(setDate)).click();
    }
}
