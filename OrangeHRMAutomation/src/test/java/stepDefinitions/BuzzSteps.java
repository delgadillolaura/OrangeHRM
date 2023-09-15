package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.BuzzPage;
import utilities.DriverManager;

public class BuzzSteps {
    BuzzPage buzzPage = new BuzzPage(DriverManager.getDriver().driver);

    @And("I fill the post text area with {string}")
    public void fillPostTextArea(String text){
        buzzPage.writePost(text);
    }

    @And("I click on the Post button")
    public void clickOnThePostButton() {
        buzzPage.clickOnPostButton();
    }

    @Then("I verify that the post {string} has been published")
    public void verifyPostHasBeenPublished(String text) {
        Assertions.assertTrue(buzzPage.verifyPostIsDisplayed(text));
    }
}
