package com.example.challengeproject.StepDefinitions;

import com.example.challengeproject.PageObject.LoginPage;
import io.cucumber.java.en.*;


public class LoginSteps {
    LoginPage loginPage = new LoginPage(Hooks.driver, Hooks.wait);

    @Given("the user logs in with username {string} and password {string}")
    public void login(String user, String pass) {
        loginPage.login(user, pass);
    }


}
