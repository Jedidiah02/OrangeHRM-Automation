package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {

    WebDriver driver;

    @FindBy(className = "oxd-userdropdown-tab")
    WebElement profileMenu;

    @FindBy(xpath = "//a[text()='Logout']")
    WebElement logout;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void logout() {
        profileMenu.click();
        logout.click();
    }
}
