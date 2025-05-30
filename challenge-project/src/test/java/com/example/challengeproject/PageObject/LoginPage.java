package com.example.challengeproject.PageObject;

import com.example.challengeproject.core.Base;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends Base {
    private final String txtUsername = "(//android.widget.Button[@content-desc='Log in with phone number']/preceding-sibling::android.widget.EditText)[1]";
    private final String txtPassword = "(//android.widget.Button[@content-desc='Log in with phone number']/preceding-sibling::android.widget.EditText)[2]";
    private final String btnLogin = "//android.widget.Button[@content-desc='Log In']";
    private final String popupBanner = "//android.widget.TextView[@resource-id='com.axlehire.drive.staging:id/ib_bg_tv_title']";

    public LoginPage(AndroidDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void login(String username, String password) {
        clickThenSendKeys(txtUsername, username);
        clickThenSendKeys(txtPassword, password);
        click(btnLogin);
        if(isDisplayed(popupBanner)) {
            click(popupBanner);
        }
        sleepInSeconds(5);
    }
}