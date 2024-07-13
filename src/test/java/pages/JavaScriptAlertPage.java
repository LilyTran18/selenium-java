package pages;

import org.openqa.selenium.By;

import java.security.PublicKey;

import static supports.Browser.*;

public class JavaScriptAlertPage {
    public void open(){
        visit("https://the-internet.herokuapp.com/javascript_alerts");
    }

    public void clickJsAlertButton(){
        click(By.xpath("//button[.='Click for JS Alert']"));
    }

    public void clickJsConfirmButton(){
        click(By.xpath("//button[.='Click for JS Confirm']"));
    }

    public void clickJsPromptButton(){
        click(By.xpath("//button[.='Click for JS Prompt']"));
    }

    public boolean isDisplayPopup(){
        try {
            return getAlert()!=null;
        }catch (Exception e){
            return false;
        }
    }


}
