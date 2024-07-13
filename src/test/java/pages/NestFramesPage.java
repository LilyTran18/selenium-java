package pages;

import org.openqa.selenium.By;

import static supports.Browser.*;

public class NestFramesPage {
    public void open(){
        visit("https://the-internet.herokuapp.com/nested_frames");
    }

    public String checkDisplayOfTextLeft(){
        switchFrame("frame-top");
        switchFrame("frame-left");
        return getText(By.xpath("//html/body"));
    }

    public String checkDisplayOfTextMiddle(){
        switchToDefaultContent();
        switchFrame("frame-top");
        switchFrame("frame-middle");
        return getText(By.id("content"));
    }

    public String checkDisplayOfTextRight(){
        switchToDefaultContent();
        switchFrame("frame-top");
        switchFrame("frame-right");
        return getText(By.xpath("//html/body"));
    }

    public String checkDisplayOfTextRBottom(){
        switchToDefaultContent();
        switchFrame("frame-bottom");
        return getText(By.xpath("//html/body"));
    }
}
