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

        	WebElement sdlc = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
            sdlc.sendKeys("sdlc", Keys.ENTER);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#search a h3")));

        
            List<WebElement> results = driver.findElements(By.cssSelector("div#search a h3"));

            if (!results.isEmpty()) {
                WebElement h3Element = results.get(0);
                WebElement anchor = h3Element.findElement(By.xpath("//div[@id='search']//a[h3[contains(text(),'SDLC')]]")); 
                anchor.click();

               
                wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

               
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

