package com.orangehrmlive.demo.pages.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * 2. HomePage - Store OrangeHRM logo, Admin, PIM, Leave,Dashboard, Welcome Text locatores
 *  and create appropriate methods for it.
 */
public class HomePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//span[text()='Admin']")
    WebElement adminTab;

    @CacheLookup
    @FindBy(xpath = "//span/h6[text()='Dashboard']")
    WebElement dashboardTitle;

    @CacheLookup
    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
    WebElement userProfileLogo;
    @CacheLookup
    @FindAll
            ({@FindBy(xpath = "//ul[@class='oxd-dropdown-menu']/li")})
    List<WebElement> userProfileDropDownOptions;




    public void clickOnAdminTab() {
        clickOnElement(adminTab);
    }
    public void clickOnUserProfileLogo() {
        clickOnElement(userProfileLogo);
    }
    public String getDashboardTitleText() {
        return getTextFromElement(dashboardTitle);
    }
    public void clickOnDropDownOptions(String text) {

        for (WebElement e : userProfileDropDownOptions) {
            System.out.println(e.getText());
            if (e.getText().equals(text)) {
                e.click();
                break;
            }
        }

    }

}
