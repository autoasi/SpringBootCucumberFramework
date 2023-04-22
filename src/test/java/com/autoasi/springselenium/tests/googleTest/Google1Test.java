package com.autoasi.springselenium.tests.googleTest;

import com.autoasi.springselenium.SpringBaseTestNGTest;
import com.autoasi.springselenium.app.annotation.LazyAutowired;
import com.autoasi.springselenium.page.google.GooglePage;
import com.autoasi.springselenium.app.service.ScreenshotService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Google1Test extends SpringBaseTestNGTest {

    @LazyAutowired
    private GooglePage googlePage;

    //@Lazy // The component will only be created, and its dependencies injected, once they're needed.
    //@Autowired
    @LazyAutowired
    private ScreenshotService screenshotService;

    @Test
    public void googleSearchTest() throws IOException {
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isLoaded());
        this.googlePage.getSettingsComponent().clickAcceptAll();
        this.googlePage.getSearchComponent().search(" environment");
        Assert.assertTrue(this.googlePage.getSearchResults().isLoaded());
        Assert.assertTrue(this.googlePage.getSearchResults().getCount() > 2);
        this.screenshotService.takeScreenShot("SearchResult");
        this.googlePage.close();
    }
}
