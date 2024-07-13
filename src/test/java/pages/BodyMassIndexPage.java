package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import supports.Browser;

public class BodyMassIndexPage {
    WebDriver driver;
    By metricUnitTab = By.xpath("//a[.='Metric Units']");
    By clearButton = By.cssSelector("input[value=Clear]");
    By ageTextBox = By.id("cage");
    By maleRadioButton = By.id("csex1");
    By femaleRadioButton = By.id("csex2");
    By heightTextBox = By.id("cheightmeter");
    By weightTextBox = By.id("ckg");
    By resultLabel = By.className("bigtext");

    public void open(){
        driver.get("https://www.calculator.net/bmi-calculator.html");
    }


    public void selectMetricTab(){
        driver.findElement(metricUnitTab).click();
    }

    public void clearForm(){
        driver.findElement(clearButton).click();
    }

    public void fillForm(String age, String gender, String height,String weight){
        driver.findElement(ageTextBox).sendKeys(age);

        if(gender.equalsIgnoreCase("male")) Browser.check(maleRadioButton);
        else Browser.check(femaleRadioButton);

        Browser.fill(heightTextBox,height);
        Browser.fill(weightTextBox,weight);
    }

    public String getResult(){
        return driver.findElement(resultLabel).getText();
    }
}
