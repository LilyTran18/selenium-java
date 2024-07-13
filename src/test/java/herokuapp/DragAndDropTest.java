package herokuapp;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DragDropPage;
import supports.Browser;

public class DragAndDropTest extends TestBase {
    @BeforeClass
    void openBrowser(){
        Browser.launchBrowser("chrome");
    }

    @Test
    void verifyDragDropSuccessfully(){
        DragDropPage dragDropPage = new DragDropPage();
        dragDropPage.open();
        Assert.assertEquals(dragDropPage.getTextInTheFirstColumn(),"A");

        dragDropPage.dragDropAction("B","A");
        Assert.assertEquals(dragDropPage.getTextInTheFirstColumn(),"B");
    }

    @AfterClass
    void tearDown(){
        Browser.quit();
    }
}
