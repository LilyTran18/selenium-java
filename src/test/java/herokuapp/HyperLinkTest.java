package herokuapp;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HyperLinkPage;
import supports.Browser;

public class HyperLinkTest extends TestBase {
    HyperLinkPage hyperLinkPage;

    @BeforeClass
    void openBrowser(){
        Browser.launchBrowser("chrome");
    }

    @BeforeMethod
    void openPage(){
        hyperLinkPage = new HyperLinkPage();
        hyperLinkPage.open();
    }

    @Test
    void tc_01(){
        hyperLinkPage.clickButton("200");
        Assert.assertEquals(hyperLinkPage.getCurrentUrlInPage(),hyperLinkPage.page("200"));

        hyperLinkPage.clickButtonGoHere();
        hyperLinkPage.clickButton("301");
        Assert.assertEquals(hyperLinkPage.getCurrentUrlInPage(),hyperLinkPage.page("301"));

        hyperLinkPage.clickButtonGoHere();
        hyperLinkPage.clickButton("404");
        Assert.assertEquals(hyperLinkPage.getCurrentUrlInPage(),hyperLinkPage.page("404"));

        hyperLinkPage.clickButtonGoHere();
        hyperLinkPage.clickButton("500");
        Assert.assertEquals(hyperLinkPage.getCurrentUrlInPage(),hyperLinkPage.page("500"));

        hyperLinkPage.clickButtonGoHere();

    }

    @AfterClass
    void tearDown(){
        Browser.quit();
    }
}
