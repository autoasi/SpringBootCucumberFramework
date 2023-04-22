package com.autoasi.springselenium.app.config;

import com.autoasi.springselenium.app.annotation.LazyConfiguration;
import com.autoasi.springselenium.app.annotation.ThreadScopeBean;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;

import java.net.URL;

@Profile("remote")  // Telling spring to activate this class only for 'remote' profile
@LazyConfiguration
public class RemoteWebDriverConfig {

    @Value("${selenium.grid.url}") // taken from application-remote.properties
    private URL url;

    @ThreadScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver remoteFirefoxDriver(){
        System.out.println("REMOTE - FirefoxDriver");
        return new RemoteWebDriver(this.url, new FirefoxOptions());
    }

    @ThreadScopeBean
    @ConditionalOnMissingBean
    public WebDriver remoteChromeDriver(){
        System.out.println("REMOTE - ChromeDriver");
        return new RemoteWebDriver(this.url, new ChromeOptions());
    }
}
