package com.autoasi.springselenium.tests.flightsTest;

import com.autoasi.springselenium.SpringBaseTestNGTest;
import com.autoasi.springselenium.page.flights.FlightsPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightsTest extends SpringBaseTestNGTest {

    @Autowired
    private FlightsPage flightsPage;

    @Autowired
    private FlightAppDetails appDetails;

    @Test
    public void flightsPageMenuBarLabelsTest(){
        this.flightsPage.goTo(appDetails.getUrl());
        Assert.assertTrue(this.flightsPage.isLoaded());
        Assert.assertEquals(this.flightsPage.getLabels(), this.appDetails.getLabels());
    }
}

