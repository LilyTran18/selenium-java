package pages;

import org.openqa.selenium.By;

import static supports.Browser.*;

public class HorizontalSliderPage {
    By slider = By.cssSelector(".sliderContainer input");
    public void open(){
        visit("https://the-internet.herokuapp.com/horizontal_slider");
    }
    public void drag(double to){
        horizon(slider,to);
        hover(slider);
    }

    public String getResult(){
        return getText(By.id("range"));
    }

}
