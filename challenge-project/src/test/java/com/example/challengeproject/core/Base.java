package com.example.challengeproject.core;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
    protected AndroidDriver driver;
    protected WebDriverWait wait;

    public Base(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void sleepInSeconds(long sec) {
        try {
            Thread.sleep((sec * 1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
        public WebElement findElement(String locator, String... locatorValue) {
        if (locatorValue != null && locator.contains("%")) {
            locator = String.format(locator, (Object[]) locatorValue);
        }
        if (locator.startsWith("/") || locator.startsWith("(")) {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        } else {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
        }
    }
    public boolean isDisplayed(String locator, String... locatorValue) {
        try {
            return findElement(locator, locatorValue).isDisplayed();
        } catch (Exception e) {
            return false; // Không tìm thấy hoặc không hiển thị thì trả về false
        }
    }
    public void checkTrue(boolean actual, String message) {
        Assertions.assertTrue(actual, message);
    }
    public void checkEqual(Object expect, Object actual, String message) {
        org.junit.jupiter.api.Assertions.assertEquals(expect, actual, message);
    }
    public void click(String locator, String... locatorValue) {
        findElement(locator, locatorValue).click();
    }

    public void sendKeys(String locator, String text, String... locatorValue) {
        findElement(locator, locatorValue).sendKeys(text);
    }
    public void clickThenSendKeys(String locator, String text, String... locatorValue) {
        click(locator,locatorValue);
        sendKeys(locator,text,locatorValue);
    }

    public String getText(String locator, String... locatorValue) {
        return findElement(locator, locatorValue).getText();
    }
}