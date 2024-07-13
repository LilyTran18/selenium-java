package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v125.emulation.Emulation;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ChromeTest{

    @Test
    void openChromeSuccessfully(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(),"Selenium");
        driver.quit();
    }

    @Test
    void openChromeHeadLessModeSuccessfully(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://selenium.dev");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.selenium.dev/");
        driver.quit();
    }

    @Test
    void openChromeMobileViewPortSuccessfully(){
        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width", 1024);
        deviceMetrics.put("height", 1366);
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);


        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(),"Selenium");
//        driver.quit();
    }
    @Test
    void fakeGeoLocation(){
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromeDriver");
        WebDriver driver = new ChromeDriver();
        DevTools devTools = ((HasDevTools) driver).getDevTools();
        devTools.createSession();
        devTools.send(Emulation.setGeolocationOverride(Optional.of(37.774929),
                Optional.of(-122.419416),
                Optional.of(1)));

        driver.get("https://oldnavy.gap.com/stores");
    }





}
