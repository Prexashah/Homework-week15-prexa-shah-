package gov.uk.check.visa.steps;

import gov.uk.check.visa.browserfactory.ManageBrowser;
import gov.uk.check.visa.pages.SelectNationalityPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CountryDropDownSteps {
    private static final Logger log = LogManager.getLogger(ManageBrowser.class);

    @Given("User is on the home page")
    public void userIsOnTheHomePage() {

    }

    @Then("User can see the following counties in the drop down")
    public void userCanSeeTheFollowingCountiesInTheDropDown(DataTable dataTable) {


        //Set of given countries to verify
        List<String> setOfCountriesToVerify = dataTable.asList(String.class);
        System.out.println("Countries to verify: " + setOfCountriesToVerify); //For debug purpose

        //Get all countries from nationality dropdown and store their names in arrayList<String>
        List<WebElement> allCountries = new SelectNationalityPage().getAllOptionsFromNationalityDropDown();
        List<String> nameOfAllCountries = new ArrayList<>();
        for (WebElement e : allCountries) {
            //Add country names after converting all to lower case and replacing space to required format for comparison
            nameOfAllCountries.add(e.getText().toLowerCase().replace(" ", "-"));
        }
        System.out.println("All countries: " + nameOfAllCountries); //For debug purpose

        //Verify if All counties list contains the required countries
        Assert.assertTrue(nameOfAllCountries.containsAll(setOfCountriesToVerify));


    }


}