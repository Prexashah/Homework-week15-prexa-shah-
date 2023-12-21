package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ComponentPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h2[text() = 'Components']")
    WebElement verifyComponentsTxt;

    public String verifyTheTextComponents(){
        return getTextFromElement(verifyComponentsTxt);

    }

}
