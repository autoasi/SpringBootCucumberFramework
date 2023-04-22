package com.autoasi.springselenium.tests.visaTest;

import com.autoasi.springselenium.SpringBaseTestNGTest;
import com.autoasi.springselenium.entity.Customer;
import com.autoasi.springselenium.page.visa.VisaRegistrationPage;
import com.autoasi.springselenium.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerVisaTest extends SpringBaseTestNGTest {

    // Initialize logger
    private static final Logger logger = LoggerFactory.getLogger(CustomerVisaTest.class);

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private VisaRegistrationPage visaRegistrationPage;

    @Test
    public void shouldBeAbleToRegister3CustomersWithDobBetweenTest() {
        List<Customer> customers = this.repository.findByDobBetween(Date.valueOf("1995-01-01"), Date.valueOf("1999-01-01"))
                .stream()
                .limit(3)
                .collect(Collectors.toList());

        for (Customer c : customers) {
            this.visaRegistrationPage.goTo();
            this.visaRegistrationPage.setNames(c.getFirstName(), c.getLastName());
            this.visaRegistrationPage.setFromCountryAndToCountry(c.getFromCountry(), c.getToCountry());
            this.visaRegistrationPage.setBirthDate(c.getDob().toLocalDate());
            this.visaRegistrationPage.setContactDetails(c.getEmail(), c.getPhone());
            this.visaRegistrationPage.setComments(c.getComments());
            this.visaRegistrationPage.submit();
            Assert.assertNotNull(this.visaRegistrationPage.getConfirmationNumber());
            System.out.println(c.getDob() + " - " + this.visaRegistrationPage.getConfirmationNumber());
        }
    }

    @Test
    public void shouldBeAbleToRegister3CustomersWithFirstNameStartsWithTest() {
        List<Customer> customers = this.repository.findByFirstNameStartingWith("Mi")
                .stream()
                .limit(3)
                .collect(Collectors.toList());

        for (Customer c : customers) {
            this.visaRegistrationPage.goTo();
            this.visaRegistrationPage.setNames(c.getFirstName(), c.getLastName());
            this.visaRegistrationPage.setFromCountryAndToCountry(c.getFromCountry(), c.getToCountry());
            this.visaRegistrationPage.setBirthDate(c.getDob().toLocalDate());
            this.visaRegistrationPage.setContactDetails(c.getEmail(), c.getPhone());
            this.visaRegistrationPage.setComments(c.getComments());
            this.visaRegistrationPage.submit();
            Assert.assertNotNull(this.visaRegistrationPage.getConfirmationNumber());

            logger.info("INFO: " + c.getFirstName() + " - " + this.visaRegistrationPage.getConfirmationNumber());
            logger.warn("WARN: " + c.getFirstName() + " - " + this.visaRegistrationPage.getConfirmationNumber());
        }
    }

    @Test
    public void shouldBeAbleToRegister3CustomersTest() {
        List<Customer> customers = this.repository.findAll()
                .stream()
                .limit(3)
                .collect(Collectors.toList());

        for (Customer c : customers) {
            this.visaRegistrationPage.goTo();
            this.visaRegistrationPage.setNames(c.getFirstName(), c.getLastName());
            this.visaRegistrationPage.setFromCountryAndToCountry(c.getFromCountry(), c.getToCountry());
            this.visaRegistrationPage.setBirthDate(c.getDob().toLocalDate());
            this.visaRegistrationPage.setContactDetails(c.getEmail(), c.getPhone());
            this.visaRegistrationPage.setComments(c.getComments());
            this.visaRegistrationPage.submit();
            Assert.assertNotNull(this.visaRegistrationPage.getConfirmationNumber());
            System.out.println(this.visaRegistrationPage.getConfirmationNumber());
        }
    }

    @Test
    public void shouldHave100CustomersTest() {
        Assert.assertEquals(repository.findAll().size(), 100);
    }

    @Test
    public void shouldFindCustomerFirstNameTest() {
        this.repository.findById(85)
                .ifPresent(u -> Assert.assertEquals(u.getFirstName(), "Andrea"));
    }

    @Test(dataProvider = "getData")
    public void shouldBeAbleToRegister3CustomersWithDobBetweenDataProviderTest(Customer c) {
        this.visaRegistrationPage.goTo();
        this.visaRegistrationPage.setNames(c.getFirstName(), c.getLastName());
        this.visaRegistrationPage.setFromCountryAndToCountry(c.getFromCountry(), c.getToCountry());
        this.visaRegistrationPage.setBirthDate(c.getDob().toLocalDate());
        this.visaRegistrationPage.setContactDetails(c.getEmail(), c.getPhone());
        this.visaRegistrationPage.setComments(c.getComments());
        this.visaRegistrationPage.submit();
        Assert.assertNotNull(this.visaRegistrationPage.getConfirmationNumber());
        System.out.println(c.getDob() + " - " + this.visaRegistrationPage.getConfirmationNumber());
    }

    @DataProvider
    public Object[][] getData(ITestContext context) {
        return this.repository.findByDobBetween(
                        Date.valueOf(context.getCurrentXmlTest().getParameter("dobFrom")),
                        Date.valueOf(context.getCurrentXmlTest().getParameter("dobTo"))
                )
                .stream()
                .limit(3)
                .map(o -> new Customer[]{o})
                .toArray(Object[][]::new);
    }

    /*@DataProvider // DataProvider with hard coded values
    public Object[][] getData() {
        return this.repository.findByDobBetween(Date.valueOf("1995-01-01"), Date.valueOf("1999-01-01"))
                .stream()
                .limit(3)
                .map(o -> new Customer[]{o})
                .toArray(Object[][]::new);
    }*/

}
