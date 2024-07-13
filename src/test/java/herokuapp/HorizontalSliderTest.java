package herokuapp;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HorizontalSliderPage;
import supports.Browser;

public class HorizontalSliderTest extends TestBase {
    HorizontalSliderPage horizontalSliderPage;
    @BeforeClass
    public void openBrowser(){
        Browser.launchBrowser("chrome");
    }

    @BeforeMethod
    public void openPage(){
        horizontalSliderPage = new HorizontalSliderPage();
        horizontalSliderPage.open();
    }

    @Test
    public void verifySliderSuccessfully(){
        horizontalSliderPage.drag(1/5);
        Assert.assertEquals(horizontalSliderPage.getResult(),"0.5");
    }

    @AfterClass
    public void tearDown(){
        Browser.quit();
    }

}
