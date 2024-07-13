package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static supports.Browser.*;

public class DragDropPage {
    public void open(){
        visit("https://the-internet.herokuapp.com/drag_and_drop");
    }

    public String getTextInTheFirstColumn(){
        return getText(By.cssSelector("#column-a header"));
    }

    public void dragDropAction(String from, String to){
        dragDrop(getLocator(from),getLocator(to));
    }
    public By getLocator(String columnName){
        return By.id(String.format("column-%s",columnName.toLowerCase()));
    }


}
