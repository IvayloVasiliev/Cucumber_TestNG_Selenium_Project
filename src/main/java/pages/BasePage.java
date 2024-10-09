package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static browserConfig.Driver.driver;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(driver,this);
    }

}
