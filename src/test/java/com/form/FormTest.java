package com.form;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormTest {
    
    private WebDriver driver;
    private DriverFactory setUp;
    private Main chrome;

    @BeforeEach
    public void setUpChrome() {
        setUp = new DriverFactory(driver);
        driver = setUp.initiateDriver();
        chrome = new Main(driver);
        chrome.implicitlyWait(10);
    }

    @AfterEach
    public void closeChrome() {
        driver.quit();
    }

    // SF-20 - TC-1 - Verify that you can succesfully submit valid data
    @Test
    public void happyPath_FormSubmit() {

        chrome.navigateToForm();
        String titleForm = driver.getTitle();

        chrome.sendStrings(By.id("name"), "example");
        chrome.sendStrings(By.id("email"), "example@example.com");
        chrome.sendStrings(By.id("number"), "18");

        chrome.click(By.id("submit"));

        String titleConfirmationPage = driver.getTitle();

        assertNotEquals(titleForm, titleConfirmationPage);
    }

    // SF-20 - TC-2 - Verify age boundaries
    @ParameterizedTest
    @CsvFileSource(resources = "resources/csv/ageBoundaries.csv", numLinesToSkip = 1)
    void happyPath_ageBoundaries(Integer number) {

        chrome.navigateToForm();
        String titleForm = driver.getTitle();

        chrome.sendStrings(By.id("name"), "example");
        chrome.sendStrings(By.id("email"), "example@example.com");
        chrome.sendStrings(By.id("number"), number.toString());

        chrome.click(By.id("submit"));

        String titleConfirmationPage = driver.getTitle();

        assertNotEquals(titleForm, titleConfirmationPage);
    }


}
