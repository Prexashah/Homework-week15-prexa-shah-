package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ComputerPage extends Utility {


    @CacheLookup
    @FindBy(xpath = "//h1[text() = 'Computers']")
    WebElement computerTab;
    @CacheLookup
    @FindBy(xpath = "//ul[@class='sublist']//a[normalize-space()='Desktops']")
    WebElement clickDesktopTab;
    @CacheLookup
    @FindBy(xpath = "//h1[text() = 'Desktops']")
    WebElement verifyDesktopTxt;



    public String verifyComputerTab(){
        return getTextFromElement(computerTab);
    }
    public void clickOnDeskTopLink(){
        clickOnElement(clickDesktopTab);
    }
    public String verifyDesktopTxt(){
        return getTextFromElement(verifyDesktopTxt);

    }

}
