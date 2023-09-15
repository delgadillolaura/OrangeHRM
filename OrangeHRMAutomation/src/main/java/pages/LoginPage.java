package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    @FindBy(css = "input[name='username']")
    WebElement userNameTextBox;

    @FindBy(css = "input[name='password']")
    WebElement passwordTextBox;

    @FindBy(css = "button[type='submit']")
    WebElement loginButton;

    @FindBy(css = "p[class='oxd-text oxd-text--p oxd-alert-content-text']")
    WebElement loginErrorMessage;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUserNameTextBox(String userName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(userNameTextBox));
        userNameTextBox.sendKeys(userName);
    }

    public void setPasswordTextBox(String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(passwordTextBox));
        passwordTextBox.sendKeys(password);
    }

    public void clickOnLoginButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        loginButton.click();
    }

    public boolean isErrorTextDisplayed(String error){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(loginErrorMessage));
        String actualErrorMessage = loginErrorMessage.getText();
        return error.equalsIgnoreCase(actualErrorMessage);
    }
}
