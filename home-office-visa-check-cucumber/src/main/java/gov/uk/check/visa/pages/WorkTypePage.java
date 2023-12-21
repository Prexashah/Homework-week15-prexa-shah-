package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WorkTypePage extends Utility {
    @CacheLookup
    @FindBy(name = "response")
    List<WebElement> workTypeRadioButtons;
    @CacheLookup
    @FindBy(xpath = "//button[text()='Continue']")
    WebElement continueButton;


    //Methods
    public void selectJobType(String job) {
        for (WebElement radioButton : workTypeRadioButtons) {
            if (job.toLowerCase().contains(radioButton.getAttribute("value"))) {
                radioButton.click();
                break;
            }
        }
    }

    public void clickOnContinueButton(){
        clickOnElement(continueButton);
    }


}
