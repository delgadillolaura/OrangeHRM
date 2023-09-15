package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    WebDriver driver;

    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    WebElement pageTitle;

    @FindBy(xpath = "//span[text()='PIM']/ancestor::a")
    WebElement PIMLink;

    @FindBy(xpath = "//span[text()='Admin']/ancestor::a")
    WebElement AdminLink;

    @FindBy(xpath = "//span[text()='Buzz']/ancestor::a")
    WebElement BuzzLink;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean pageTitleIsDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        return pageTitle.isDisplayed();
    }

    public void clickOnPIM() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(PIMLink));
        PIMLink.click();
    }

    public void clickOnAdmin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(AdminLink));
        AdminLink.click();
    }

    public void clickOnBuzz() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(BuzzLink));
        BuzzLink.click();
    }
}
