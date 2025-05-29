package com.example.challengeproject.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
    public WebDriver driver;
    public WebDriverWait wait;

    public WebElement findElement(String element) {
        if (element.startsWith("/") || element.startsWith("(")) {
            return driver.findElement(By.xpath(element));
        } else {
            return driver.findElement(By.cssSelector(element));
        }
    }

    public void click(String element) {
        findElement(element).click();
    }

    public String getText(String element) {
        return findElement(element).getText().trim();
    }
    public void sendKeys(String element, String value) {
        findElement(element).sendKeys(value);
    }
}
