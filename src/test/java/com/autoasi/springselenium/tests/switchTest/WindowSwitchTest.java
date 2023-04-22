package com.autoasi.springselenium.tests.switchTest;

import com.autoasi.springselenium.SpringBaseTestNGTest;
import com.autoasi.springselenium.app.service.WindowSwitchService;
import com.autoasi.springselenium.page.switches.MainPage;
import com.autoasi.springselenium.page.switches.PageA;
import com.autoasi.springselenium.page.switches.PageB;
import com.autoasi.springselenium.page.switches.PageC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@TestPropertySource(properties = "browser=chrome")
public class WindowSwitchTest extends SpringBaseTestNGTest {

    @Autowired
    private MainPage mainPage;

    @Autowired
    private PageA pageA;

    @Autowired
    private PageB pageB;

    @Autowired
    private PageC pageC;

    @Autowired
    private WindowSwitchService windowSwitchService;

    @BeforeClass
    public void setup(){
        this.mainPage.goTo();
        this.mainPage.isLoaded();
        this.mainPage.launchAllWindows();
    }

    @Test
    public void switchWindowsTest(){
        this.windowSwitchService.switchByTitle("Page A");
        this.pageA.addToArea("Hi Page A");
        this.windowSwitchService.switchByIndex(2);
        this.pageB.addToArea("Hello Page B");
    }

    @Test(dataProvider = "getData")
    public void switchWindowsWithAspectTest(int index){
        this.pageA.addToArea(index + "\n");
        this.pageB.addToArea((index * 2) + "\n");
        this.pageC.addToArea((index * 3) + "\n");
    }

    @DataProvider
    public Object[][] getData(){
        return new Object[][] {
                {3},
                {4},
                {1},
                {5},
                {6},
                {2}
        };
    }
}
