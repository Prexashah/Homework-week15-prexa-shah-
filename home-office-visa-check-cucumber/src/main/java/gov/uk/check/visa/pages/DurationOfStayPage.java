package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DurationOfStayPage extends Utility {
    @CacheLookup
    @FindBy(name = "response")
    List<WebElement> durationRadioButtons;
    @CacheLookup
    @FindBy(xpath = "//label[@class='gem-c-label govuk-label govuk-radios__label']")
    List<WebElement> durationRadioButtonsLabels;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Continue']")
    WebElement continueButton;

    //Methods
    public void selectDurationRadioButton(String duration){
        for(WebElement label:durationRadioButtonsLabels){
            System.out.println(label.getText());
            if(label.getText().contains(duration)){
                label.click();
                break;
            }
        }
    }

    public void clickOnContinueButton(){
        clickOnElement(continueButton);
    }
}
