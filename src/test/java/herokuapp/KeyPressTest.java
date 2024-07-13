package herokuapp;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.KeyPressPage;
import supports.Browser;

public class KeyPressTest extends TestBase {
    KeyPressPage keyPressPage;

    @BeforeClass
    void openBrowser(){
        Browser.launchBrowser("chrome");
    }

    @BeforeMethod
    void open(){
        keyPressPage = new KeyPressPage();
        keyPressPage.open();
    }

    @Test
    void verifyPressKey(){
        keyPressPage.pressKey("c");
        Assert.assertEquals(keyPressPage.getResult(),"You entered: C");
    }

    @AfterClass
    void tearDown(){
        Browser.quit();
    }
}
