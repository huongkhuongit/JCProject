package com.example.challengeproject.PageObject;

import com.example.challengeproject.core.Base;
import io.appium.java_client.android.AndroidDriver;


public class LoginPage extends Base {
    private final String txtUsername = "(//android.widget.Button[@content-desc='Log in with phone number']/preceding-sibling::android.widget.EditText)[1]";
    private final String txtPassword = "(//android.widget.Button[@content-desc='Log in with phone number']/preceding-sibling::android.widget.EditText)[2]";
    private final String btnLogin = "//android.widget.Button[@content-desc='Log In']";

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        sendKeys(txtUsername, username);
        sendKeys(txtPassword, password);
        click(btnLogin);
    }
}