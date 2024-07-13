package supports;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Browser {
    private static WebDriver driver;
    private static int MAX_TIME_OUT_SECONDS = 30;
    public  static WebDriverWait wait;
    public static Actions actions;
    public static Select select;

    public static void launchBrowser(String name){
        switch (name){
            case "chrome":{
                driver= new ChromeDriver();
                break;
            }
            case "firefox": {
                driver= new FirefoxDriver();
                break;
            }
            case "safari": {
                driver= new SafariDriver();
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + name);
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIME_OUT_SECONDS));
        actions = new Actions(driver);
        //select = new Select(driver);
    }

    public static void visit(String url){
        driver.get(url);
    }

    public static void click(By locator){
        driver.findElement(locator).click();
    }

    public static void fill(By locator, CharSequence... keyToSend){
        driver.findElement(locator).sendKeys(keyToSend);
    }

    public static String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public static void check(By locator){
        if(!driver.findElement(locator).isSelected()){
            click(locator);
        }
    }

    public static void uncheck(By locator){
        if(driver.findElement(locator).isSelected()){
            click(locator);
        }
    }

    public static boolean isCheck(By locator){
        return driver.findElement(locator).isSelected();
    }

    public static void dragDrop(By from, By to){
        WebElement originItem = driver.findElement(from);
        WebElement targetItem = driver.findElement(to);
        actions.dragAndDrop(originItem,targetItem).perform();
    }
    public static List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    public static void horizon(By locator, double to){
        actions.clickAndHold(driver.findElement(locator))
                .moveByOffset((int) (driver.findElement(locator).getSize().width*to),0)
                .perform();
    }

    public static void hover(By locator){
        actions.moveToElement(driver.findElement(locator))
                .perform();
    }

    public static void contextClick(By locator){
        actions.contextClick(driver.findElement(locator)).perform();
    }

    public static String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public static void selectOption(String number){
        select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByVisibleText(number);
    }

    public static void takeScreenShot(String name){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        File destFile = new File(String.format("target/screenshot-%s-%s.png", name, System.currentTimeMillis()));
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Alert getAlert(){
        return driver.switchTo().alert();
    }
    public static void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    public static void waitDisplay(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void sendKeyByKeyBoard(String key){
        actions.sendKeys(key).perform();
    }

    public static void switchFrame(String nameOrId){
        driver.switchTo().frame(nameOrId);
    }

    public static void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }

    public static void switchToDefaultContent(){
        driver.switchTo().defaultContent();
    }

    public static List<WebElement> getElements(By locator){
        return driver.findElements(locator);
    }
    public static void quit(){
        if(driver!=null){
            driver.quit();
        }
    }
}
