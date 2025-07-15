package com.example.utilities;

import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class CustomChromeDriver implements DriverSource {

    private static WebDriver driver;

    @Override
    public WebDriver newDriver() {
    	
    	if (driver == null) {
    		
       		System.setProperty("webdriver.chrome.driver","/Users/raghuram36/Downloads/chromedriver-mac-arm64/chromedriver");
       		
       		ChromeOptions options = new ChromeOptions();
       		options.addArguments("--disable-blink-features=AutomationControlled");
       		options.addArguments("--start-maximized");
            options.addArguments("--disable-gpu");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-infobars");
            options.addArguments("--headless"); 
       		
       		driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
        return driver;
        
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
    
}
