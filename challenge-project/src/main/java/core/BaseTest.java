package core;

import config.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        ConfigLoader.storeData();
        driver = DriverFactory.initDriver();
        driver.get(ConfigLoader.getBaseUrl());

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginManager(ConfigLoader.getRetailer(), ConfigLoader.getUserName(), ConfigLoader.getPassword());
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
