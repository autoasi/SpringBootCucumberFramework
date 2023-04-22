package com.autoasi.springselenium.app.config;

import com.autoasi.springselenium.app.annotation.ThreadScopeBean;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.*;

@Profile("!remote") // Telling spring to activate this class only for non 'remote' profile
@Lazy // The bean will only be created, and its dependencies injected, once they're needed.
@Configuration
public class WebDriverConfig {

    @ThreadScopeBean
    @ConditionalOnMissingBean // will be the default bean in case invalid browser has been provided, i.e. Safari.
    @ConditionalOnProperty(name ="browser", havingValue = "chrome") // taken value from application.properties
    public WebDriver chromeDriver() {
        System.out.println("LOCAL - ChromeDriver");
        WebDriverManager.chromedriver().cachePath("drivers").setup(); // This will automatically get the correct chrome driver version
        return new ChromeDriver();
    }

    //@Primary // Spring will use this bean as the primary bean (and not the chrome driver)
    @ThreadScopeBean
    @ConditionalOnProperty(name ="browser", havingValue = "firefox") // taken value from application.properties
    public WebDriver firefoxDriver() {
        System.out.println("LOCAL - FirefoxDriver");
        WebDriverManager.firefoxdriver().cachePath("drivers").setup(); // This will automatically get the correct firefox driver version
        return new FirefoxDriver();
    }
}
