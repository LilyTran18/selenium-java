package herokuapp;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.DynamicLoadingPage;
import supports.Browser;

public class DynamicLoadingTest extends TestBase {
    DynamicLoadingPage dynamicLoadingPage;

    @BeforeClass
    void openBrowser(){
        Browser.launchBrowser("chrome");
    }

    @BeforeMethod
    void openPage(){
        dynamicLoadingPage = new DynamicLoadingPage();
        dynamicLoadingPage.open();
    }

    @Test
    void waitUntilProcessCompleted() {
        dynamicLoadingPage.clickStartButton();
        Assert.assertEquals(dynamicLoadingPage.getResult(),"Hello World!");
    }

    @AfterClass
    void tearDown(){
        Browser.quit();
    }
}
