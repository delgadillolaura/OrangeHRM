package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.AdminPage;
import utilities.DriverManager;

public class AdminSteps {
    AdminPage adminPage = new AdminPage(DriverManager.getDriver().driver);

    @And("I fill the employee User Role field with {string}")
    public void fillUserRoleField(String userRole) {
        adminPage.selectUserRole(userRole);
    }

    @And("I fill the employee Status field with {string}")
    public void fillStatusField(String status) {
        adminPage.selectStatus(status);
    }

    @Then("the User Role should be {string}")
    public void verifyUserRole(String userRole) {
        Assertions.assertTrue(adminPage.verifyUserRole(userRole));
    }

    @And("the Status should be {string}")
    public void verifyStatus(String status) {
        Assertions.assertTrue(adminPage.verifyStatus(status));
    }

    @And("I click on the Search button")
    public void clickOnTheSearchButton() {
        adminPage.clickOnSearchButton();
    }

    @Then("I click on the User Dropdown")
    public void clickOnTheUserDropdown() {
        adminPage.clickOnUserDropdown();
    }

    @And("I click on the Logout Link")
    public void clickOnTheLogoutLink() {
        adminPage.clickOnLogoutLink();
    }
}
