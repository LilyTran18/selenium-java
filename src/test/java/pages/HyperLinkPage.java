package pages;

import org.openqa.selenium.By;

import static supports.Browser.*;

public class HyperLinkPage {
    public void open(){
        visit("https://the-internet.herokuapp.com/status_codes");
    }

    public void clickButton(String button){
        click(By.xpath(String.format("//a[.='%s']",button)));
    }

    public void clickButtonGoHere(){
        click(By.xpath("//a[.='here']"));
    }

    public String getCurrentUrlInPage(){
        return getCurrentUrl();
    }

    public String page(String page){
        return String.format("https://the-internet.herokuapp.com/status_codes/%s",page);
    }
}
