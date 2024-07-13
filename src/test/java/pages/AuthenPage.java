package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import supports.Browser;

import static supports.Browser.*;

public class AuthenPage {
    By usernameTextbox = By.id("username");
    By passwordTextbox = By.id("password");
    By saveButton = By.cssSelector("button[type=submit]");
    By resultLabel = By.cssSelector("#content h4");
    public void open(){
        visit("https://the-internet.herokuapp.com/login");
        //driver.get("https://the-internet.herokuapp.com/login");
    }

    public void fillForm(String username, String password){
        fill(usernameTextbox,username);
        //driver.findElement(usernameTextbox).sendKeys(username);
        fill(passwordTextbox,password);
        //driver.findElement(passwordTextbox).sendKeys(password);
        click(saveButton);
        //driver.findElement(saveButton).click();
    }

    public String getResult(){
        return getText(resultLabel);
        //return driver.findElement(resultLabel).getText();
    }


}
