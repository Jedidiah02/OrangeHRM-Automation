package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyInfoPage {

    WebDriver driver;
    WebDriverWait wait;

    // Locators (SAFER)
    By contactDetailsTab = By.xpath("//a[text()='Contact Details']");
    By street1Input = By.xpath("(//input[@class='oxd-input oxd-input--active'])[1]");
    By mobileInput = By.xpath("(//input[@class='oxd-input oxd-input--active'])[5]");
    By saveButton = By.xpath("//button[@type='submit']");

    public MyInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void updateContactDetails(String address, String mobile) {

        // Open Contact Details tab
        wait.until(ExpectedConditions.elementToBeClickable(contactDetailsTab)).click();

        // Scroll down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        // Wait for fields
        wait.until(ExpectedConditions.presenceOfElementLocated(street1Input));
        driver.findElement(street1Input).clear();
        driver.findElement(street1Input).sendKeys(address);

        driver.findElement(mobileInput).clear();
        driver.findElement(mobileInput).sendKeys(mobile);

        // 🔴 IMPORTANT: wait for loader to disappear
        By loader = By.className("oxd-form-loader");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

        // Wait until Save is clickable
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));

        // Click Save safely
        driver.findElement(saveButton).click();
    }

}
