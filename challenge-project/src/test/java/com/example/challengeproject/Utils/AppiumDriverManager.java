package com.example.challengeproject.Utils;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class AppiumDriverManager {
    public static AndroidDriver getDriver() {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "Android");
            caps.setCapability("appPackage", "com.axlehire.drive.staging");
            caps.setCapability("appActivity", "com.axlehire.drive.MainActivity");
            caps.setCapability("automationName", "UiAutomator2");
            caps.setCapability("udid", "R3CR2090NLK");
            caps.setCapability("newCommandTimeout", 300);
            caps.setCapability("autoGrantPermissions", true);

            return new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
        } catch (Exception e) {
            throw new RuntimeException("Failed to start AndroidDriver", e);
        }
    }
}
