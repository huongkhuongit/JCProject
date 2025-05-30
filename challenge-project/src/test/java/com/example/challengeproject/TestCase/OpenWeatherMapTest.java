package com.example.challengeproject.TestCase;

import com.example.challengeproject.PageObject.LoginPage;
import com.example.challengeproject.core.BaseTest;
import org.junit.jupiter.api.*;

public class OpenWeatherMapTest extends BaseTest {

    @Test
    void testSearch() {
        LoginPage loginPage = new LoginPage(driver);
        // Exercise
        String user = "auto_244332";
        String pass = "Testing1!";
        loginPage.login(user, pass);

    }
}
