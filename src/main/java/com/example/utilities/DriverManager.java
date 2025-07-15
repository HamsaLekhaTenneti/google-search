package com.example.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
	
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
         // TODO Auto-generated method stub
    		System.setProperty("webdriver.chrome.driver","/Users/raghuram36/Downloads/chromedriver-mac-arm64/chromedriver");
    		
    		ChromeOptions options = new ChromeOptions();
    	 	options.addArguments("start-maximized");
    		options.addArguments("disable-infobars");
    		options.addArguments("--disable-extensions");
    		options.addArguments("--disable-blink-features=AutomationControlled");
    		
    		driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}