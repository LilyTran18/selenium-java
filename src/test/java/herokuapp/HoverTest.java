package herokuapp;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HoverPage;
import supports.Browser;

public class HoverTest extends TestBase {
    HoverPage hoverPage;

    @BeforeClass
    void setup(){
        Browser.launchBrowser("chrome");
    }

    @BeforeMethod
    void open(){
        hoverPage = new HoverPage();
        hoverPage.open();
    }

    @Test
    public void hoverOnImage(){
        hoverPage.hoverOnImage("1");
        Assert.assertEquals(hoverPage.checkInfo("1"),"name: user1");
    }

    @AfterClass
    void tearDown(){
        Browser.quit();
    }
}
