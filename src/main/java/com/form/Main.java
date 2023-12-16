package com.form;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Main {
    
    private WebDriver driver;

    public Main(WebDriver driver) {
        this.driver = driver;
    }

    public void implicitlyWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    // Navigate to Form website
    public void navigateToForm() {
        driver.get("https://mstilde.github.io/BasicFormProject/");
    }

    // Send string
    public void sendStrings(By locator, String string) {
        driver.findElement(locator).sendKeys(string);
    }

    // Click element
    public void click(By locator) {
        driver.findElement(locator).click();
    }

    // Get page title
    public String getPageTitle() {
        String title = driver.getTitle();
        return title;
    }
}
