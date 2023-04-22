package com.autoasi.springselenium.app.service;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

@Lazy // The component will only be created, and its dependencies injected, once they're needed.
@Service
public class ScreenshotService {

    //@Autowired
    //private TakesScreenshot driver; // Spring automatically Converts the driver to TakesScreenshot

    @Autowired
    private ApplicationContext ctx;

    @Value("${screenshots.path}")
    private Path path;

    //@Autowired
    //Private JavascriptExecutor js; // Spring can automatically wire for us JavascriptExecutor object

    public void takeScreenShot(final String fileName) throws IOException {
        //js.executeScript("");
        File sourceFile = this.ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);
        FileCopyUtils.copy(sourceFile, this.path.resolve(fileName + ".png").toFile());
    }

    public byte[] getScreenshot(){
        return this.ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.BYTES);
    }
}

