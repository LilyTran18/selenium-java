package pages;

import org.openqa.selenium.By;

import static supports.Browser.*;

public class DynamicLoadingPage {
    public void open(){
        visit("https://the-internet.herokuapp.com/dynamic_loading/1");
    }
    public void clickStartButton(){
        click(By.xpath("//button[.='Start']"));
    }
    public String getResult(){
        waitDisplay(By.cssSelector("#finish h4"));
        return getText(By.cssSelector("#finish h4"));
    }
}
