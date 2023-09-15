package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PIMPage {
    WebDriver driver;

    @FindBy(xpath = "//button[text()=' Add ']")
    WebElement addEmployeeButton;

    @FindBy(xpath = "//input[@name='firstName']")
    WebElement firstNameTextBox;

    @FindBy(xpath = "//input[@name='middleName']")
    WebElement middleNameTextBox;

    @FindBy(xpath = "//input[@name='lastName']")
    WebElement lastNameTextBox;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement saveButton;

    @FindBy(xpath = "//label[text()='Employee Name']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//input")
    WebElement employeeNameTextBox;

    @FindBy(xpath = "//a[text()='Employee List']")
    WebElement employeeListLink;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement searchButton;

    @FindBy(className = "oxd-table-cell")
    List<WebElement> employeeData;

    @FindBy(xpath = "//i[@class='oxd-icon bi-trash']/ancestor::button[@class='oxd-icon-button oxd-table-cell-action-space']")
    WebElement trashButton;

    @FindBy(xpath = "//i[@class='oxd-icon bi-trash oxd-button-icon']/ancestor::button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")
    WebElement confirmDeletionButton;

    @FindBy(xpath = "//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/span")
    WebElement recordsInformationText;

    public PIMPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Add employee
    public void clickOnAddEmployeeButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(addEmployeeButton));
        addEmployeeButton.click();
    }

    public void setFirstNameTextBox(String firstName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(firstNameTextBox));
        firstNameTextBox.sendKeys(firstName);
    }

    public void setMiddleNameTextBox(String middleName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(middleNameTextBox));
        middleNameTextBox.sendKeys(middleName);
    }

    public void setLastNameTextBox(String lastName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(lastNameTextBox));
        lastNameTextBox.sendKeys(lastName);
    }

    public void clickOnSaveButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(saveButton));
        saveButton.click();
    }

    //Go back
    public void clickOnEmployeesListLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(employeeListLink));
        employeeListLink.click();
    }

    //Search employee
    public void setEmployeeNameTextBox(String employeeName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(employeeNameTextBox));
        employeeNameTextBox.sendKeys(employeeName);
    }

    public void clickOnSearchButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        searchButton.click();
    }

    public boolean verifyEmployeeNameIsDisplayed(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("oxd-table-cell")));

        for (WebElement names : employeeData) {
            if (names.getText().equalsIgnoreCase(name)) {
                return true;
            }
        }

        return false;
    }

    //Delete employee
    public void clickOnTrashButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(trashButton));
        trashButton.click();
    }

    public void clickOnConfirmDeletionButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(confirmDeletionButton));
        confirmDeletionButton.click();
    }

    public boolean verifyRecordsMessage(String message) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(recordsInformationText));
        return recordsInformationText.getText().equals(message);
    }
}
