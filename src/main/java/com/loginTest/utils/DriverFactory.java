package com.loginTest.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DriverFactory {
    public static WebDriver driver;

    @BeforeMethod
    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:/Users/gauravg/Documents/chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }

    @AfterMethod
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }

    }
}