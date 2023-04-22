package com.autoasi.springselenium.page.google;

import com.autoasi.springselenium.app.annotation.Page;
import com.autoasi.springselenium.page.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Page
public class GooglePage extends Base {

    @Autowired
    private SearchComponent searchComponent;

    @Autowired
    private SearchResults searchResults;

    @Autowired
    private SettingsComponent settingsComponent;

    @Value("${application.url}") // Get the url from application.properties file
    private String url;

    public void goTo(){
        this.driver.get(url);
    }

    public SearchComponent getSearchComponent() {
        return searchComponent;
    }

    public SearchResults getSearchResults() {
        return searchResults;
    }

    public SettingsComponent getSettingsComponent(){
        return settingsComponent;
    }

    @Override
    public boolean isLoaded() {
        return this.searchComponent.isLoaded();
    }

    public void close(){
        this.driver.quit();
    }
}
