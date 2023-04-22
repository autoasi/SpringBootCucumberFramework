package com.autoasi.springselenium.bdd.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.autoasi.springselenium.bdd.steps",
                "com.autoasi.springselenium.bdd.hooks"},
        tags = "@google or @visa",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/report.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
@RunWith(Cucumber.class)
public class CucumberJUnitTestRunner {
}
