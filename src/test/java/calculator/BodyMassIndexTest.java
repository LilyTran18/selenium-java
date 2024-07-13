package calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BodyMassIndexPage;
import supports.Browser;

public class BodyMassIndexTest {
    @BeforeMethod
    void setUp(){
        Browser.launchBrowser("chrome");
    }

    @Test
    void tc01(){
        BodyMassIndexPage bodyMassIndexPage = new BodyMassIndexPage();
        bodyMassIndexPage.open();

        bodyMassIndexPage.selectMetricTab();
        bodyMassIndexPage.clearForm();

        bodyMassIndexPage.fillForm("37","male","173","65");
        Assert.assertEquals(bodyMassIndexPage.getResult(),"BMI = 20.1 kg/m2   (Normal)");
    }

    @AfterMethod
    void tearDown(){
        Browser.quit();
    }
}
