/*package com.example.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class sample {


public void testGoogleSearch() throws Exception {
	WebElement sdlc=driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
	sdlc.sendKeys("sdlc", Keys.ENTER);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#search a h3")));

	    	
    System.out.println("Page title is: " + driver.getTitle());
    ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1000);");
    
    List<WebElement> results = driver.findElements(By.cssSelector("div#search a h3"));
    
    if (!results.isEmpty()) {
    	try {
    	results.get(0).click(); 
    	
    	} catch (ElementClickInterceptedException e) {
    		System.out.println("Element not clickable: \" + e.getMessage()");
    	}
    	}
     else {
        System.out.println("No links found.");
    }	
    	
    String pageSource = driver.getPageSource();

    if (pageSource.toLowerCase().contains("Software Development Life Cycle")) {
        System.out.println("Redirected to page related to SDLC");
        System.out.println("True");
    } else {
        System.out.println("False");
    }

}
}*/