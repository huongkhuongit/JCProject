package com.example.challengeproject.StepDefinitions;

import com.example.challengeproject.PageObject.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class NavigateSteps {
    HomePage homePage = new HomePage(Hooks.driver, Hooks.wait);
    @When("the user opens the profile screen")
    public void openProfile() {
        homePage.opensTheProfileScreen();
    }

    @When("the user taps on Tutorials")
    public void tapTutorials() {
        homePage.tapsTutorials();
    }

    @Then("the user should see sections:")
    public void verifySections(List<String> sections) {
        homePage.sees3section(sections);
    }

    @When("the user taps on Assigned Route")
    public void tapAssignedRoute() {
        homePage.tapsOnAssignedRoute();
    }

    @Then("the tutorial button should be displayed")
    public void tutorialButtonDisplayed() {
        homePage.verifyBtnTutorialIsDisplayed();
    }
}
