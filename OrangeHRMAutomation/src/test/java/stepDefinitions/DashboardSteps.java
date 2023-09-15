package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.DashboardPage;
import utilities.DriverManager;

public class DashboardSteps {
    DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver().driver);

    @Then("The Dashboard page should be displayed")
    public void verifyDashboardPageIsDisplayed(){
        Assertions.assertTrue(dashboardPage.pageTitleIsDisplayed());
    }

    @Given("I click on the PIM link")
    public void clickOnThePIMLink() {
        dashboardPage.clickOnPIM();
    }

    @Given("I click on the Admin link")
    public void clickOnAdminLink() {
        dashboardPage.clickOnAdmin();
    }

    @Given("I click on the Buzz link")
    public void clickOnTheBuzzLink() {
        dashboardPage.clickOnBuzz();
    }
}
