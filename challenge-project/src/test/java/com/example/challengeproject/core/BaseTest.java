package com.example.challengeproject.core;


import com.example.challengeproject.Utils.AppiumDriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.time.Duration;
import java.util.logging.Level;

public class BaseTest {
    protected AndroidDriver driver;


    @BeforeEach
    public void setup() {
        driver = AppiumDriverManager.getDriver();
        sleepInSeconds(5);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected static void sleepInSeconds(long sec) {
        try {
            Thread.sleep((sec * 1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}