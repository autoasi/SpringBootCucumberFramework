package com.autoasi.springselenium.bdd.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.autoasi.springselenium.bdd.steps",
                "com.autoasi.springselenium.bdd.hooks"},
        tags = "@visa or @google",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/report.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class CucumberTestNGTestRunner extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }
}
