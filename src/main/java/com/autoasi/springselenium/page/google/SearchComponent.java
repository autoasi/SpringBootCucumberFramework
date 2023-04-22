package com.autoasi.springselenium.page.google;

import com.autoasi.springselenium.app.annotation.PageFragment;
import com.autoasi.springselenium.page.Base;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageFragment
public class SearchComponent extends Base {

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private List<WebElement> searchBtns; // there are 2 search buttons elements in the GUI

    public void search(final String keyword){
        this.searchBox.sendKeys(keyword);
        this.searchBox.sendKeys(Keys.TAB); // To avoid the auto-complete feature in google search
        this.searchBtns
                .stream()
                .filter(e-> e.isDisplayed() && e.isEnabled())
                .findFirst()
                .ifPresent(WebElement::click);
    }

    @Override
    public boolean isLoaded() {
        return this.wait.until((d) -> this.searchBox.isDisplayed()); // this will wait for 30 sec for element
    }
}

