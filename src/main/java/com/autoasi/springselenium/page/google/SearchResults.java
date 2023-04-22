package com.autoasi.springselenium.page.google;

import com.autoasi.springselenium.app.annotation.PageFragment;
import com.autoasi.springselenium.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageFragment
public class SearchResults extends Base {

    @FindBy(css = "div.g")
    private List<WebElement> results;

    public int getCount(){
        return this.results.size();
    }

    @Override
    public boolean isLoaded() {
        return this.wait.until((d) -> !this.results.isEmpty()); // wait for the results to find something
    }
}
