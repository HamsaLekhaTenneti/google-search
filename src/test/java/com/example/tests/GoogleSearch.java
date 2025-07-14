package com.example.tests;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import com.example.utilities.DriverManager;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class GoogleSearch {
	
    WebDriver driver;
    WebDriverWait wait;
	
	@BeforeMethod
    public void setUp() {
        driver = DriverManager.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
        driver.get("https://www.google.com");
    }

    @Test
    public void testGoogleSearch() {
        try {
            // Search for "sdlc"
            WebElement sdlc = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
            sdlc.sendKeys("sdlc", Keys.ENTER);

            // Wait for search results
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#search a h3")));

            // Find all <h3> elements inside anchor tags
            List<WebElement> results = driver.findElements(By.cssSelector("div#search a h3"));

            if (!results.isEmpty()) {
                WebElement h3Element = results.get(0);
                WebElement anchor = h3Element.findElement(By.xpath("ancestor::a")); // Get parent anchor
                anchor.click();

                // ✅ Wait for the new page to load
                wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

                // Get page source and check for keyword
                String pageSource = driver.getPageSource().toLowerCase();

                if (pageSource.contains("software development lifecycle")) {
                    System.out.println("Redirected to page related to SDLC");
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }
            } else {
                System.out.println("No links found.");
            }

        } catch (ElementClickInterceptedException e) {
            System.out.println("Element not clickable: " + e.getMessage());
        } catch (TimeoutException e) {
            System.out.println("Timed out waiting for elements: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }

}

