package com.autoasi.springselenium.bdd.hooks;

import com.autoasi.springselenium.app.annotation.LazyAutowired;
import com.autoasi.springselenium.app.service.ScreenshotService;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;

public class CucumberHooks {

    @LazyAutowired
    private ScreenshotService screenshotService;

    @LazyAutowired
    private ApplicationContext applicationContext;

    @AfterStep
    public void afterStep(Scenario scenario){
        if(scenario.isFailed()){
            scenario.attach(this.screenshotService.getScreenshot(), "image/png", scenario.getName());
        }
    }

    @After // After scenario
    public void afterScenario(){
        this.applicationContext.getBean(WebDriver.class).quit();
    }
}
