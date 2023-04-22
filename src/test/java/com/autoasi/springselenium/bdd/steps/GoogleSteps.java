package com.autoasi.springselenium.bdd.steps;

import com.autoasi.springselenium.app.annotation.LazyAutowired;
import com.autoasi.springselenium.page.google.GooglePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

@CucumberContextConfiguration
@SpringBootTest
public class GoogleSteps {

    @LazyAutowired
    private GooglePage googlePage;

    @Given("I am on the google site")
    public void iAmOnTheGoogleSite() {
        this.googlePage.goTo();
        this.googlePage.getSettingsComponent().clickAcceptAll();
    }

    @When("I enter {string} as a keyword")
    public void iEnterAsAKeyword(String keyword) {
        this.googlePage.getSearchComponent().search(keyword);
    }

    @Then("I should see search results page")
    public void iShouldSeeSearchResultsPage() {
        Assert.assertTrue(this.googlePage.getSearchResults().isLoaded());
    }

    @And("I should see at least {int} results")
    public void iShouldSeeAtLeastResults(int count) {
        Assert.assertTrue(this.googlePage.getSearchResults().getCount() >= count);
        this.googlePage.close();
    }
}
