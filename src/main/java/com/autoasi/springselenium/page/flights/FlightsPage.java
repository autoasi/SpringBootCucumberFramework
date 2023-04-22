package com.autoasi.springselenium.page.flights;

import com.autoasi.springselenium.app.annotation.Page;
import com.autoasi.springselenium.app.annotation.TakeScreenshot;
import com.autoasi.springselenium.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@Page
public class FlightsPage extends Base {

    @FindBy(css = "nav.rlGvde a")
    private List<WebElement> elements;

    public void goTo(final String url){
        this.driver.get(url);
        this.driver.manage().window().maximize();
    }

    @TakeScreenshot
    public List<String> getLabels(){
        return this.elements
                .stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isLoaded() {
        return this.wait.until((d) -> !this.elements.isEmpty());
    }
}
