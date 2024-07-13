package herokuapp;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DropDownPage;
import supports.Browser;

public class DropDownTest {
    DropDownPage dropDownPage;

    @BeforeClass
    void openBrowser(){
        Browser.launchBrowser("chrome");
    }

    @BeforeMethod
    void openPage(){
        dropDownPage = new DropDownPage();
        dropDownPage.open();
    }

    @Test
    void selectOption(){
        dropDownPage.selectOption("2");
        Assert.assertTrue(dropDownPage.isSelect("2"));
    }

    @AfterClass
    void tearDown(){
        Browser.quit();
    }
}
