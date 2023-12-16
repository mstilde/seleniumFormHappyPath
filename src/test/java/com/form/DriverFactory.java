package com.form;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    
    private WebDriver driver;

    public DriverFactory(WebDriver driver) {
        this.driver = driver;
    }

    // Initialize and configure the WebDriver
    public WebDriver initiateDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
