package herokuapp;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BrokenImagesPage;
import supports.Browser;

public class BrokenImagesTest extends TestBase {
    BrokenImagesPage brokenImagesPage;
    @BeforeClass
    void openBrowser(){
        Browser.launchBrowser("chrome");
    }
    @BeforeMethod
    void open(){
        brokenImagesPage = new BrokenImagesPage();
        brokenImagesPage.open();
    }
    @Test
    void verifyBrokenImage(){
        Assert.assertTrue(brokenImagesPage.isBrokenImage());
    }

    @AfterClass
    void tearDown(){
        Browser.quit();
    }
}
