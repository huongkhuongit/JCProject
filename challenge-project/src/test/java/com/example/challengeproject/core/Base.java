package com.example.challengeproject.core;

import org.openqa.selenium.*;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class Base {
    protected AndroidDriver driver;

    public Base(AndroidDriver driver) {
        this.driver = driver;
    }

    public WebElement findElement(String locator, String... locatorValue) {
        if (locatorValue != null && locator.contains("%")) {
            locator = String.format(locator, (Object[]) locatorValue);
        }
        if (locator.startsWith("//") ||locator.startsWith("(") ) {
            return driver.findElement(By.xpath(locator));
        } else {
            return driver.findElement(By.id(locator));
        }
    }

    public void click(String locator, String... locatorValue) {
        findElement(locator, locatorValue).click();
    }

    public void sendKeys(String locator, String text, String... locatorValue) {
        findElement(locator, locatorValue).sendKeys(text);
    }

    public String getText(String locator, String... locatorValue) {
        return findElement(locator, locatorValue).getText();
    }
}