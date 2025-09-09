package tests;

import api.LoginAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

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
