package herokuapp;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TablePage;
import supports.Browser;

import java.util.List;

public class TableTest extends TestBase {
    TablePage tablePage;

    @BeforeClass
    void setup(){
        Browser.launchBrowser("chrome");
    }

    @BeforeMethod
    void openPage(){
        tablePage = new TablePage();
        tablePage.open();
    }

    @Test
    void largestDuePerson(){
        Assert.assertEquals(tablePage.getMaxDuePersonInTable1(), List.of("Doe Jason"));
    }

    @Test
    void getMinDuePerson(){
        Assert.assertEquals(tablePage.getMinDuePersonInTable1(), List.of("Smith John","Conway Tim"));
    }

    @AfterClass
    void tearDown(){
        Browser.quit();
    }
}
