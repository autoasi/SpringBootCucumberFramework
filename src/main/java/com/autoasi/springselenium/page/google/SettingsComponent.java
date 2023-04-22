package com.autoasi.springselenium.page.google;

import com.autoasi.springselenium.app.annotation.PageFragment;
import com.autoasi.springselenium.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageFragment
public class SettingsComponent extends Base {

    @FindBy(id = "L2AGLb")
    private WebElement acceptAllBtn;

    public void clickAcceptAll(){
        this.acceptAllBtn.click();
    }

    @Override
    public boolean isLoaded() {
        return this.wait.until((d) -> this.acceptAllBtn.isDisplayed()); // this will wait for 30 sec for element
    }
}
