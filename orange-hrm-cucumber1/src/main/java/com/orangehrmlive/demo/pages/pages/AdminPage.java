package com.orangehrmlive.demo.pages.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * 4.AdminPage - UserManagement, Job, Organization Tabs Locators and it's actions
 */

public class AdminPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//div[text() = 'Cheeku']")
    WebElement verifyNameOnList;

    public String verifyUserShouldBeInResultList() {
   return     getTextFromElement(verifyNameOnList);

    }

}
