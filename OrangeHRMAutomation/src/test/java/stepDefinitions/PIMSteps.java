package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.PIMPage;
import utilities.DriverManager;

import java.util.List;

public class PIMSteps {
    PIMPage pimPage = new PIMPage(DriverManager.getDriver().driver);

    @And("I click on the Add button")
    public void clickOnAddEmployeeButton() {
        pimPage.clickOnAddEmployeeButton();
    }

    @And("I fill the employee information with")
    public void fillTheEmployeeInformation(DataTable employeeInformation) {
        List<String> data = employeeInformation.transpose().asList(String.class);
        pimPage.setFirstNameTextBox(data.get(0));
        pimPage.setMiddleNameTextBox(data.get(1));
        pimPage.setLastNameTextBox(data.get(2));

    }

    @And("I click on the Save button")
    public void clickOnTheSaveButton() {
        pimPage.clickOnSaveButton();
    }

    @Then("I fill the employee name with {string}")
    public void fillTheEmployeeName(String employeeName) {
        pimPage.setEmployeeNameTextBox(employeeName);
    }

    @And("I click on the Search button from PIM")
    public void clickOnTheSearchButtonFromPIM() throws InterruptedException {
        pimPage.clickOnSearchButton();
        Thread.sleep(5000);
    }

    @And("I verify that the employee {string} is displayed")
    public void verifyEmployeeIsDisplayed(String employeeName) {
        Assertions.assertTrue(pimPage.verifyEmployeeNameIsDisplayed(employeeName));
    }

    @And("I click on the Employee List Link")
    public void clickOnTheEmployeeListLink() throws InterruptedException {
        pimPage.clickOnEmployeesListLink();
    }
    
    @And("I delete the employee")
    public void deleteEmployee() {
        pimPage.clickOnTrashButton();
        pimPage.clickOnConfirmDeletionButton();
    }


    @Then("I verify the Records Message {string} is displayed")
    public void verifyRecordsMessageIsDisplayed(String message) {
        Assertions.assertTrue(pimPage.verifyRecordsMessage(message));
    }
}
