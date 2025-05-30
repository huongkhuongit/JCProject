package com.example.challengeproject.core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class Base {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public Base(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement findElement(String element, String... value) {
        if (value != null && element.contains("%")) {
            element = String.format(element, (Object[]) value);
        }

        if (element.startsWith("/") || element.startsWith("(")) {
            return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
        } else {
            return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(element)));
        }
    }

    public void click(String element, String... value) {
        findElement(element, value).click();
    }

    public void sendKeys(String element, String text, String... value) {
        findElement(element, value).sendKeys(text);
    }

    public String getText(String element, String... value) {
        return findElement(element, value).getText().trim();
    }

    public void waitForElementVisible(String element, String... value) {
        if (value != null && value.length > 0)
            element = String.format(element, (Object[]) value);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
    }
}
