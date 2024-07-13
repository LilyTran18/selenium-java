package pages;

import org.openqa.selenium.By;

import static supports.Browser.*;

public class HoverPage {
    public void open(){
        visit("https://the-internet.herokuapp.com/hovers");
    }

    public void hoverOnImage(String number){
        hover(By.xpath(String.format("//div[@class='figure'][%s]",number)));
    }

    public String checkInfo(String number){
        return getText(By.xpath(String.format("//div[@class='figure'][%s]//h5",number)));
    }


}
