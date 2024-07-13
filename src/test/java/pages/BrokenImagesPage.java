package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static supports.Browser.*;

public class BrokenImagesPage {
    public void open(){
        visit("https://the-internet.herokuapp.com/broken_images");
    }

    public boolean isBrokenImage(){
        List<WebElement> images = getElements(By.xpath("//div[@class='example']/img"));
        for (WebElement i : images){
            if (i.getDomProperty("naturalWidth").equals("0")){
                return true;
            }
        }
        return false;
    }
}
