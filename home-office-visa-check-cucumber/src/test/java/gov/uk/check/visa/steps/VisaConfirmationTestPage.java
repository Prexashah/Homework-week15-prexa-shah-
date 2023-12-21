package gov.uk.check.visa.steps;

import gov.uk.check.visa.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VisaConfirmationTestPage {

    @Given("User has navigate to homepage")
    public void userHasNavigateToHomepage() {
    }

    @When("User clicks on start button")
    public void userClicksOnStartButton() {

        new StartPage().clickOnStartNowButton();
    }

    @And("User selects {string}, {string}")
    public void userSelects(String nationality, String reason) {
        new SelectNationalityPage().selectNationalityFromDropDown(nationality);
        new SelectNationalityPage().clickOnContinueButton();
        new ReasonForTravelPage().selectReasonForVisit(reason);
        new ReasonForTravelPage().clickOnContinueButton();
    }

    @Then("User can view visa requirement in {string}")
    public void userCanViewVisaRequirementIn(String requirementMessage) {

        new ResultPage().confirmResultMessage(requirementMessage);
    }

    @And("User selects intended stay for {string}")
    public void userSelectsIntendedStayFor(String duration) {

        new DurationOfStayPage().selectDurationRadioButton(duration);
        new DurationOfStayPage().clickOnContinueButton();
    }

    @And("User selects {string} for work type")
    public void userSelectsForWorkType(String workType) {
        new WorkTypePage().selectJobType(workType);
        new WorkTypePage().clickOnContinueButton();
    }

}
