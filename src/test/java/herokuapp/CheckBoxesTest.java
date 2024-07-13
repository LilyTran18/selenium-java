package herokuapp;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckBoxesPage;
import supports.Browser;

public class CheckBoxesTest extends TestBase {
    CheckBoxesPage checkBoxesPage;
    @BeforeClass
    void reloadPage(){
        Browser.launchBrowser("chrome");
    }

    @BeforeMethod
    void openCheckboxPage(){
        checkBoxesPage = new CheckBoxesPage();
        checkBoxesPage.open();
    }

    @Test
    void theCheckboxesShouldSelected(){
        checkBoxesPage.selectCheckbox("1");
        Assert.assertTrue(checkBoxesPage.isCheckBoxChecked("1"));

        checkBoxesPage.selectCheckbox("2");
        Assert.assertTrue(checkBoxesPage.isCheckBoxChecked("2"));
    }

    @Test
    void theCheckboxesShouldDeSelected(){
        checkBoxesPage.unselectCheckbox("1");
        Assert.assertFalse(checkBoxesPage.isCheckBoxChecked("1"));

        checkBoxesPage.unselectCheckbox("2");
        Assert.assertFalse(checkBoxesPage.isCheckBoxChecked("2"));
    }
    @AfterClass
    void tearDown(){
        Browser.quit();
    }
}
