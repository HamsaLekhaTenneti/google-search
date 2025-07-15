package com.example.tests.steps;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

import com.example.utilities.DriverManager;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;

public class GoogleSteps extends PageObject{

    WebDriver driver;
    WebDriverWait wait;

    @Step("User opens Google")
    public void openGooglePage() {
    	driver = DriverManager.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	driver.get("https://www.google.com");
    }
    
    
    @Step("Search for keyword: SDLC")
    public void searchFor(String keyword) {
    	WebElement sdlc = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        sdlc.sendKeys("sdlc", Keys.ENTER);
    }
    
    @Step("click page ")
    public void clickFirstResult() {
    	try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#search a h3")));
            List<WebElement> results = driver.findElements(By.cssSelector("div#search a h3"));

            if (!results.isEmpty()) {
            	WebElement h3Element = results.get(0);
                WebElement anchor = h3Element.findElement(By.xpath("//div[@id='search']//a[h3[contains(text(),'SDLC')]]")); 
                anchor.click();
                wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
            } else {
                System.out.println("No links found.");
            }
        } catch (ElementClickInterceptedException e) {
            System.out.println("Element not clickable: " + e.getMessage());
        } catch (TimeoutException e) {
            System.out.println("Timeout waiting for elements: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
         
      @Step("verify")
      public void verifySdlc() {
    	  String pageSource = driver.getPageSource().toLowerCase();
          if (pageSource.contains("software development lifecycle")) {
              System.out.println("Redirected to SDLC-related page.");
              System.out.println("True");
          } else {
              System.out.println(" Content not found.");
              System.out.println("False");
          }
      }
 
      @AfterEach
      public void closeBrowser() {
          driver.quit();
      }
}