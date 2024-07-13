package herokuapp;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.JavaScriptAlertPage;
import supports.Browser;

public class JavaScriptAlertTest extends TestBase {
    JavaScriptAlertPage javaScriptAlertPage;

    @BeforeClass
    void openBrowser(){
        Browser.launchBrowser("chrome");
    }

    @BeforeMethod
    void open(){
        javaScriptAlertPage = new JavaScriptAlertPage();
        javaScriptAlertPage.open();
    }

    @Test
    void clickOnJSAlertSuccessfully(){
        javaScriptAlertPage.clickJsAlertButton();
        Assert.assertTrue(javaScriptAlertPage.isDisplayPopup());
    }

    @Test
    void clickOnJsConfirmSuccessfully(){
        javaScriptAlertPage.clickJsConfirmButton();
        Assert.assertTrue(javaScriptAlertPage.isDisplayPopup());
    }

    @Test
    void clickOnJsCPromptSuccessfully(){
        javaScriptAlertPage.clickJsPromptButton();
        Assert.assertTrue(javaScriptAlertPage.isDisplayPopup());
    }

    @AfterMethod
    void closePopup(){
        Browser.acceptAlert();
    }

    @AfterClass
    void tearDown(){
        Browser.quit();
    }
}
