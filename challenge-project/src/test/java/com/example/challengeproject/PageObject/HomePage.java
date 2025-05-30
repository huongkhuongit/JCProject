package com.example.challengeproject.PageObject;

import com.example.challengeproject.core.Base;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class HomePage extends Base {
    private final String btnProfile = "//android.widget.ImageView[contains(@content-desc,'Profile')]";
    private final String btnTutorials = "//android.view.View[@content-desc='Tutorials']";
    private final String itemByText = "//*[contains(@content-desc,'%s')]";
    private final String btnAssignedRoute = "//*[contains(@content-desc,'Assigned Route')]";
    private final String btnQuitTutorial = "//android.widget.Button[@content-desc='Quit tutorial']";

    public HomePage(AndroidDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void opensTheProfileScreen() {
        click(btnProfile);
        // co popup hien thi len
        sleepInSeconds(1);
    }
    public void tapsTutorials() {
        click(btnTutorials);
    }   public void tapsOnAssignedRoute() {
        click(btnAssignedRoute);
    }
    public void sees3section(List<String> sections) {
        for(String section : sections) {
           checkTrue(isDisplayed(itemByText,section),"Section not found: " + section);
        }
    }
    public void verifyBtnTutorialIsDisplayed() {
        checkTrue(isDisplayed(btnTutorials),btnTutorials + " is not displayed");
    }
}