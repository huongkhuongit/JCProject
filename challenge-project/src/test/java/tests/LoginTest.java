package tests;

import api.LoginAPI;
import config.ConfigLoader;
import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CommandPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testCreateSuccess() {
        //API
        LoginAPI loginAPI = new LoginAPI();
        loginAPI.login();
        //API Tạo thông tin nhân viên với data tự chuyền

        CommandPage commandPage = new CommandPage(driver);
        commandPage.openEmployeePage();

        //UI tìm nhân viên đã tạo, verify
        Assert.assertTrue(driver.getCurrentUrl().contains("/Employee"));
    }
}
