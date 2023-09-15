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

public class AdminPage {
    WebDriver driver;

    @FindBy(xpath = "//label[text()='Username']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']/div/input[@class='oxd-input oxd-input--active']")
    WebElement userNameTextBox;

    @FindBy(xpath = "//div[@data-v-6c07a142='']")
    WebElement userNameText;

    @FindBy(xpath = "//label[text()='User Role']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']/div/div[@class='oxd-select-wrapper']")
    WebElement userRoleDropdown;

    @FindBy(xpath = "//label[text()='Status']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']/div/div[@class='oxd-select-wrapper']")
    WebElement statusDropdown;

    @FindBy(xpath = "//div[@class='header'][text()='User Role']/ancestor::div[@class='oxd-table-card-cell']/div[@class='data']")
    List<WebElement> userRoleFields;

    @FindBy(xpath = "//div[@class='header'][text()='Status']/ancestor::div[@class='oxd-table-card-cell']/div[@class='data']")
    List<WebElement> statusFields;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement searchButton;

    @FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
    WebElement userDropdown;

    @FindBy(xpath = "//a[text()='Logout']")
    WebElement logoutLink;

    public AdminPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUserNameTextBox(String userName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(userNameTextBox));
        userNameTextBox.sendKeys(userName);
    }

    public boolean verifyUserNameTextIsDisplayed(String userName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(userNameText));
        return userName.equals(userNameText.getText());
    }

    public void selectUserRole(String userRole) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(userRoleDropdown));
        userRoleDropdown.click();

        WebElement option = driver.findElement(By.xpath(String.format("//span[text()='%s']/ancestor::div[@class='oxd-select-option']", userRole)));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(option));
        option.click();
    }

    public void selectStatus(String status) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(statusDropdown));
        statusDropdown.click();

        WebElement option = driver.findElement(By.xpath(String.format("//span[text()='%s']/ancestor::div[@class='oxd-select-option']", status)));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(option));
        option.click();
    }

    public void clickOnSearchButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        searchButton.click();
    }

    public boolean verifyUserRole(String userRole) {
        for (WebElement element : userRoleFields) {
            if (!element.getText().equals(userRole)) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyStatus(String status) {
        for (WebElement element : statusFields) {
            if (!element.getText().equals(status)) {
                return false;
            }
        }
        return true;
    }

    public void clickOnUserDropdown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(userDropdown));
        userDropdown.click();
    }

    public void clickOnLogoutLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(logoutLink));
        logoutLink.click();
    }
}
