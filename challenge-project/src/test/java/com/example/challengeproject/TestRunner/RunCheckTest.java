package com.example.challengeproject.TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@check",
        features = "src/test/resources/features"
        ,glue={"com.example.challengeproject.StepDefinitions"}
)
public class RunCheckTest {
}
