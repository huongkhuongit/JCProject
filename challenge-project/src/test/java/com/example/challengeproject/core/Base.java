package com.example.challengeproject.core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
    public WebDriver driver;
    public WebDriverWait wait;

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


    public void click(String element, String... elementValue) {
        findElement(element, elementValue).click();
    }

    public String getText(String element, String... elementValue) {
        return findElement(element, elementValue).getText().trim();
    }

    public void sendKeys(String element, String value, String... elementValue) {
        findElement(element, elementValue).sendKeys(value);
    }

    public void waitForPageLoad() {
        wait.until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );
    }

    public void waitForElementVisible(String element, String... elementValue) {
        if (elementValue != null)
            element = String.format(element, elementValue);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));

    }
}
