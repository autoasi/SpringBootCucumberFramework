package com.autoasi.springselenium.app.aop;

import com.autoasi.springselenium.app.annotation.TakeScreenshot;
import com.autoasi.springselenium.app.service.ScreenshotService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Aspect
@Component
public class ScreenshotAspect {

    @Autowired
    private ScreenshotService screenshotService;

    @After("@annotation(takeScreenshot)") // run after every method that has the @TakeScreenshot annotation
    public void after(TakeScreenshot takeScreenshot) throws IOException {
        this.screenshotService.takeScreenShot("screenshot");
    }
}
