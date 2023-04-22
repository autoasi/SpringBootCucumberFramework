package com.autoasi.springselenium.bdd.steps;

import com.autoasi.springselenium.app.annotation.LazyAutowired;
import com.autoasi.springselenium.page.visa.VisaRegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;
import org.testng.Assert;

import java.time.LocalDate;

public class VisaSteps {

    @LazyAutowired
    private VisaRegistrationPage visaRegistrationPage;

    @Given("I am on VISA registration form")
    public void iAmOnVISARegistrationForm() {
        this.visaRegistrationPage.goTo();
        Assert.assertTrue(this.visaRegistrationPage.isLoaded());
    }

    @When("I select my from country {string} and to country {string}")
    public void iSelectMyFromCountryAndToCountry(String from, String to) {
        this.visaRegistrationPage.setFromCountryAndToCountry(from, to);
    }

    @And("I enter my dob as {string}")
    public void iEnterMyDobAs(String dob) {
        this.visaRegistrationPage.setBirthDate(LocalDate.parse(dob));
    }

    @And("I enter my name as {string} and {string}")
    public void iEnterMyNameAsAnd(String firstName, String lastName) {
        this.visaRegistrationPage.setNames(firstName, lastName);
    }

    @And("I enter my contact details as {string} and {string}")
    public void iEnterMyContactDetailsAsAnd(String email, String phone) {
        this.visaRegistrationPage.setContactDetails(email, phone);
    }

    @And("I enter the comment {string}")
    public void iEnterTheComment(String comment) {
        this.visaRegistrationPage.setComments(comment);
    }

    @And("I submit the form")
    public void iSubmitTheForm() {
        this.visaRegistrationPage.submit();
    }

    @Then("I should see get the confirmation number")
    public void iShouldSeeGetTheConfirmationNumber() {
        boolean isEmpty = StringUtils.isEmpty(this.visaRegistrationPage.getConfirmationNumber().trim());
        Assert.assertFalse(isEmpty);
    }
}
