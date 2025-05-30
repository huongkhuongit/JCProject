package com.example.challengeproject.StepDefinitions;

import com.example.challengeproject.Utils.AppiumDriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Hooks {
    public static AndroidDriver driver;
    public static WebDriverWait wait;

    @Before
    public void beforeScenario() {
        System.out.println("==== Before scenario - setup driver and wait ====");
        driver = AppiumDriverManager.getDriver();
        wait = new WebDriverWait(driver, 30);
    }

    @After
    public void afterScenario() {
        System.out.println("==== After scenario - quit driver ====");
        if (driver != null) {
            driver.quit();
        }
    }
}
