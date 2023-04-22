package com.autoasi.springselenium.tests.multiBrowserTest;

import com.autoasi.springselenium.SpringBaseTestNGTest;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.testng.annotations.Test;

public class MultiBrowserTest extends SpringBaseTestNGTest {

    @Autowired
    private ApplicationContext ctx;

    @Test // For this test to pass - remove @ConditionalOnProperty from WebDriverConfig methods
    public void browserTest(){
        // chromeDriver and firefoxDriver names are taken from the WebDriverConfig
        this.ctx.getBean("chromeDriver", WebDriver.class).get("https://www.google.com");
        this.ctx.getBean("firefoxDriver", WebDriver.class).get("https://www.yahoo.com");
    }
}
