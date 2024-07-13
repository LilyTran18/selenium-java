package herokuapp;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContextMenuPage;
import supports.Browser;

public class ContextMenuTest extends TestBase {
    ContextMenuPage contextMenuPage;

    @BeforeClass
    void openBrowser(){
        Browser.launchBrowser("chrome");
    }

    @BeforeMethod
    void openPage(){
        contextMenuPage = new ContextMenuPage();
        contextMenuPage.open();
    }

    @Test
    void verifyContextMenu(){
        contextMenuPage.contextClick();
        Assert.assertTrue(contextMenuPage.isDisplayAlert());

        contextMenuPage.clickAcceptAlert();
        Assert.assertFalse(contextMenuPage.isDisplayAlert());
    }

    @AfterClass
    void tearDown(){
        Browser.quit();
    }
}
