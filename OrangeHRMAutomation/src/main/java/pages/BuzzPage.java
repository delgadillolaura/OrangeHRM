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

public class BuzzPage {

    WebDriver driver;

    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-buzz-post-body-text']")
    List<WebElement> publishedPosts;

    @FindBy(xpath = "//textarea")
    WebElement postText;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement postButton;

    public BuzzPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void writePost(String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(postText));
        postText.sendKeys(text);
    }

    public void clickOnPostButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(postButton));
        postButton.click();
    }

    public boolean verifyPostIsDisplayed(String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-buzz-post-body-text']")));

        if (publishedPosts.isEmpty()) {
            return false;
        }

        WebElement publishedPost = publishedPosts.get(0);
        wait.until(ExpectedConditions.visibilityOf(publishedPost));
        return publishedPost.getText().equals(text);
    }
}