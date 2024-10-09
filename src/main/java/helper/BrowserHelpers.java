package helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import pages.CheckoutPage;

import java.util.Locale;

import static browserConfig.Driver.driver;

public class BrowserHelpers {
    private static Logger log = LogManager.getLogger(BrowserHelpers.class);
    public void highlightElement(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].setAttribute('style', 'background: lightGreen; border: 3px solid red;');", element);
        jse.executeScript("arguments[0].value = '';", element);
    }

    public void clickButton(String buttonName){
        WebElement button;
        try{
             button = driver.findElement(By.xpath("//button[text() = '" + buttonName + "']"));
        } catch (NoSuchElementException e){

             button = driver.findElement(By.id(buttonName.toLowerCase(Locale.ROOT)));
        }
        highlightElement(button);
        button.click();
        log.info(buttonName +" button is clicked!");
    }

}
