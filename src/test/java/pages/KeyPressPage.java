package pages;

import org.openqa.selenium.By;

import static supports.Browser.*;

public class KeyPressPage {
    public void open(){
        visit("https://the-internet.herokuapp.com/key_presses");
    }
    public void pressKey(String key){
        sendKeyByKeyBoard(key);
    }

    public String getResult(){
        return getText(By.xpath("//p[@id='result']"));
    }
}
