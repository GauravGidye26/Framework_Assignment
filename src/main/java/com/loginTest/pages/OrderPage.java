package com.loginTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OrderPage {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public By taskField = By.xpath("//button[normalize-space()='Tasks']");
    public By tableHeader = By.xpath("//th//div//div//div[@class='mantine-TableHeadCell-Content-Wrapper mantine-11ygs7i']");
    public By threeDot = By.xpath("//button[contains(@class,'mantine-4nqhrt')]");
    public By showColList = By.xpath("//button[@aria-label='Show/Hide columns']");
    public By resetBtn = By.xpath("(//button[contains(@class,'mantine-Button-root')])[2]");


    public void clickTask() {
        wait.until(ExpectedConditions.elementToBeClickable(taskField)).click();
    }

    public String[] getCurrentColumnOrder() {
        List<WebElement> columns = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(tableHeader));
        String[] columnOrder = new String[columns.size()];
        for (int i = 0; i < columns.size(); i++) {
            columnOrder[i] = columns.get(i).getText();
        }
        return columnOrder;
    }

    public void dragAndDropColumn(String sourceColumn, String targetColumn) throws InterruptedException {
        Actions actions = new Actions(driver);

        WebElement sourceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='" + sourceColumn + "']/parent::div/following-sibling::div/child::button[1]")));
        WebElement targetElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='" + targetColumn + "']/parent::div/following-sibling::div/child::button[1]")));

        actions.dragAndDrop(sourceElement,targetElement).perform();
    }

    public void clickOnThreeDot(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(threeDot)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(showColList)).click();
    }

    public void dragAndDropColumnInList(String sourceColumn, String targetColumn) {
        Actions actions = new Actions(driver);

        WebElement sourceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='" + sourceColumn + "']/parent::div/parent::div/parent::div/preceding-sibling::button")));
        WebElement targetElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='" + targetColumn + "']/parent::div/parent::div/parent::div/preceding-sibling::button")));

        actions.dragAndDrop(sourceElement,targetElement).perform();
    }

    public void clickOnReset() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(resetBtn)).click();
    }
}
