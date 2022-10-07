package com.testautomation.api.runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = "src/test/resources/features",
        //register_successful.feature
        //glue = {"com.testautomation.api.stepdefinitions"}
        tags = "@GetSingle"
)

public class GetRunners {
}
