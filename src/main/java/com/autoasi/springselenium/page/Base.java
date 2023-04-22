package com.autoasi.springselenium.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public abstract class Base {

    @Autowired
    protected WebDriver driver; // String boot will get the driver instance automatically

    @Autowired
    protected WebDriverWait wait; // String boot will get the webDriverWait instance automatically

    @PostConstruct
    private void init(){
        PageFactory.initElements(this.driver,this);
    }

    public abstract boolean isLoaded(); // All other page objects will have to implement this method
}
