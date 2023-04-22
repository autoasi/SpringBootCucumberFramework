package com.autoasi.springselenium.page.switches;

import com.autoasi.springselenium.app.annotation.Window;
import com.autoasi.springselenium.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Window("Page B")
public class PageB extends Base {

    @FindBy(id = "area")
    private WebElement textArea;

    public void addToArea(final String msg){
        this.textArea.sendKeys(msg);
    }

    @Override
    public boolean isLoaded() {
        return this.wait.until((d) -> this.textArea.isDisplayed());
    }
}
