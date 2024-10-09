package pages;

import helper.BrowserHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static browserConfig.Driver.driver;

public class CartPage extends BasePage{

    private static Logger log = LogManager.getLogger(CartPage.class);
    private BrowserHelpers helper = new BrowserHelpers();

    public void itemIsDisplayed(String itemName){
        WebElement itemField = driver.findElement(By.xpath("//div[text()='" + itemName + "']"));
        itemField.isDisplayed();
        helper.highlightElement(itemField);
        log.info(itemName + " is displayed!");
    }
}
