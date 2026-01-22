package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.*;

public class OrangeHRMTest extends BaseTest {

    @Test
    public void completeFlow() {

        LoginPage login = new LoginPage(driver);
        login.login("Admin", "admin123");

        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.clickMyInfo();

        MyInfoPage myInfo = new MyInfoPage(driver);
        myInfo.updateContactDetails("Hyderabad", "9876543210");

        ChangePasswordPage cp = new ChangePasswordPage(driver);
        cp.changePassword("admin123", "Admin@123");

        ProfilePage profile = new ProfilePage(driver);
        profile.logout();
    }
}
