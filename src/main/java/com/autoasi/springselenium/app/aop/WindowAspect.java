package com.autoasi.springselenium.app.aop;

import com.autoasi.springselenium.app.annotation.Window;
import com.autoasi.springselenium.app.service.WindowSwitchService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WindowAspect {

    @Autowired
    private WindowSwitchService switchService;

    @Before("@target(window) && within(com.autoasi.spring.springselenium..*)") // PointCut expression
    public void before(Window window){
        this.switchService.switchByTitle(window.value());
    }

    @After("@target(window) && within(com.autoasi.spring.springselenium..*)") // PointCut expression
    public void after(Window window){
        this.switchService.switchByIndex(0);
    }
}
