package com.autoasi.springselenium.app.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.stereotype.Component;

// WebDriverFactory can be use directly from the test once it is @Autowired
// @Autowired
// private WebDriverFactory driverFactory;
// this.driverFactory.getDriver("chrome");
@Component
public class WebDriverFactory {

    public WebDriver getDriver(String browser){

        if("chrome".equals(browser)){
            WebDriverManager.chromedriver().cachePath("drivers").setup();
            return new ChromeDriver();
        }else if("firefox".equals(browser)){
            WebDriverManager.firefoxdriver().cachePath("drivers").setup();
            return new FirefoxDriver();
        }
        return null;
    }

}
