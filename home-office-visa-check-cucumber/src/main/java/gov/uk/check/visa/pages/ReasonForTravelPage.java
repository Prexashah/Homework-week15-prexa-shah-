package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ReasonForTravelPage extends Utility {
    //Elements
    @CacheLookup
    @FindBy(name = "response")
    List<WebElement> reasonForVisitRadioButtons;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Continue']")
    WebElement continueButton;

    //Methods
    public void selectReasonForVisit(String reason) {
        for (WebElement reasonRadioButton : reasonForVisitRadioButtons) {
            System.out.println(reasonRadioButton.getAttribute("value"));
            if (reason.toLowerCase().contains(reasonRadioButton.getAttribute("value"))){
                reasonRadioButton.click();
                break;
            }
        }
    }

    public void clickOnContinueButton() {
        continueButton.submit();
    }
}
