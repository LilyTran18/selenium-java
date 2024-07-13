package pages;

import org.openqa.selenium.By;
import supports.Browser;

import static supports.Browser.*;

public class ContextMenuPage {
    public void open(){
        visit("https://the-internet.herokuapp.com/context_menu");
    }

    public void contextClick(){
        Browser.contextClick(By.id("hot-spot"));
    }

    public boolean isDisplayAlert(){
        try {
            return getAlert() != null;
        } catch (Exception e){
            return false;
        }

    }

    public void clickAcceptAlert(){
        getAlert().accept();
    }
}
