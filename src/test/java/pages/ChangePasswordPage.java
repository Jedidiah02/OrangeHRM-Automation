package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ChangePasswordPage {

    WebDriver driver;
    WebDriverWait wait;

    // Safe locators
    By profileMenu = By.className("oxd-userdropdown-tab");
    By changePasswordLink = By.xpath("//a[text()='Change Password']");

    By currentPassword = By.xpath("(//input[@type='password'])[1]");
    By newPassword = By.xpath("(//input[@type='password'])[2]");
    By confirmPassword = By.xpath("(//input[@type='password'])[3]");

    By saveButton = By.xpath("//button[@type='submit']");

    public ChangePasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void changePassword(String oldPwd, String newPwd) {

        // Open profile menu
        wait.until(ExpectedConditions.elementToBeClickable(profileMenu)).click();

        // Click Change Password
        wait.until(ExpectedConditions.elementToBeClickable(changePasswordLink)).click();

        // Scroll (important)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");

        // Wait for password fields
        wait.until(ExpectedConditions.presenceOfElementLocated(currentPassword));

        driver.findElement(currentPassword).sendKeys(oldPwd);
        driver.findElement(newPassword).sendKeys(newPwd);
        driver.findElement(confirmPassword).sendKeys(newPwd);

        driver.findElement(saveButton).click();
    }
}
