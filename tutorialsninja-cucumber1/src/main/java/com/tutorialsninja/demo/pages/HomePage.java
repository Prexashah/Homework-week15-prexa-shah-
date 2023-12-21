package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * 2. HomePage - Store OrangeHRM logo, Admin, PIM, Leave,Dashboard, Welcome Text locators
 *  and create appropriate methods for it.
 */
public class HomePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "(//a[text() = 'Desktops'])[1]")
    WebElement desktopTab;
    @CacheLookup
    @FindBy(xpath = "//a[text() = 'Show AllDesktops']")
    WebElement showAllDesktop;

    @CacheLookup
    @FindBy(xpath = "//button[@class='btn btn-link dropdown-toggle']")
    WebElement currencyDropDown;

    @CacheLookup
    @FindAll({@FindBy(xpath = "//a[@class='see-all']")})
    List<WebElement> showAllOptions;

    @CacheLookup
    @FindBy(xpath = "(//li[@class ='dropdown'])[3]")
    WebElement mouseHoverToElementAndClick;

    @CacheLookup
    @FindBy(xpath = "(//li[@class ='dropdown'])[4]")
    WebElement mouseHoverOnComponentsAndClk;

    @CacheLookup
    @FindBy(xpath = "//a[text() = 'Show AllComponents']")
    WebElement showAllComponentTab;


    @CacheLookup
    @FindBy(xpath = "//a[text() = 'Show AllLaptops & Notebooks']")
    WebElement clickOnShowAllLaptopsAnNoteBooks;

    @CacheLookup
    @FindBy(xpath = "//span[text() = 'My Account']")
    WebElement myAccountLink;

    @FindAll({@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']/li")})
    List<WebElement> myAccountOptions;

    @CacheLookup
    @FindBy(xpath = "//button[text() = '£Pound Sterling']")
    WebElement clickOnSterlingPound;

    public void mouseHoverAndClickDesktopTab(){
        mouseHoverToElementAndClick(desktopTab);

    }
    public void clickOnShowAllDesktops(){
        clickOnElement(showAllDesktop);

    }
    public void clickOnSterlingPound() {
        mouseHoverToElementAndClick(clickOnSterlingPound);
    }
    public void mouseHoverOnCurrencyAndClick(){
        mouseHoverToElementAndClick(currencyDropDown);
    }
    public List<WebElement> showAllOptionsFromTopNav() {
        return showAllOptions;
    }
    public void mouseHoverOnLaptopsNoteBooksAndClick(){
        mouseHoverToElementAndClick(mouseHoverToElementAndClick);
    }
    public void mouseHoverOnComponentsTabAndClick(){
        mouseHoverToElementAndClick(mouseHoverOnComponentsAndClk);
    }
    public void clickOnShowAllComponentsTab(){
        clickOnElement(showAllComponentTab);
    }
    public void showAllLaptopsAndNoteBooks(){
        clickOnElement(clickOnShowAllLaptopsAnNoteBooks);

    }
    public List<WebElement> getMyAccountOptions() {
        return  myAccountOptions;
    }
    public void clickOnMyAccountLink() {
        mouseHoverToElementAndClick(myAccountLink);
    }


}
