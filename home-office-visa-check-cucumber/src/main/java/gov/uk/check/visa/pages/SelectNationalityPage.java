package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectNationalityPage extends Utility {
    //Elements
    @CacheLookup
    @FindBy(id = "response")
    WebElement nationalityDropDown;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Continue']")
    WebElement continueButton;



    //Methods
    public void selectNationalityFromDropDown(String text){
        selectByVisibleTextFromDropDown(nationalityDropDown,text);
    }

    public List<WebElement> getAllOptionsFromNationalityDropDown(){
        return new Select(nationalityDropDown).getOptions();

    }

    public void clickOnContinueButton(){
        clickOnElement(continueButton);
    }
}
