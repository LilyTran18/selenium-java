package pages;

import org.openqa.selenium.By;
import supports.Browser;

import static supports.Browser.*;

public class DropDownPage {
    public void open(){
        visit("https://the-internet.herokuapp.com/dropdown");
    }

    public void selectOption(String number){
        Browser.selectOption(String.format("Option %s",number));
    }

    public boolean isSelect(String option){
        return isCheck(By.xpath(String.format("//option[.='Option %s']",option)));
    }
}
