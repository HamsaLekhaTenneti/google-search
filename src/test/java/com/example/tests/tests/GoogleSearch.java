package com.example.tests.tests;

import com.example.tests.steps.GoogleSteps;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Steps;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

@ExtendWith(SerenityJUnit5Extension.class)
public class GoogleSearch {

	WebDriver driver;
    WebDriverWait wait;
    
    @Steps
    GoogleSteps googleSteps;
    
    @Test
    public void shouldGoogleSDLC() {
        googleSteps.openGooglePage();
        googleSteps.searchFor("sdlc");
        googleSteps.clickFirstResult();
        googleSteps.verifySdlc();
        googleSteps.closeBrowser();
        
    }
    
    
}