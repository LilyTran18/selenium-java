package pages;
import org.openqa.selenium.By;

import static supports.Browser.*;
public class CheckBoxesPage {
    public void open(){
        visit("https://the-internet.herokuapp.com/checkboxes");
    }

    public void selectCheckbox(String checkboxNumber){
        check(getCheckboxByIndex(checkboxNumber));
    }

    public boolean isCheckBoxChecked(String checkboxNumber){
        return isCheck(getCheckboxByIndex(checkboxNumber));
    }

    public void unselectCheckbox(String checkboxNumber){
        uncheck(getCheckboxByIndex(checkboxNumber));
    }

    private By getCheckboxByIndex(String index){
        String checkboxLocator = "//*[@id='checkboxes']/input[%s]";
        return By.xpath(String.format(checkboxLocator,index));
    }

}
