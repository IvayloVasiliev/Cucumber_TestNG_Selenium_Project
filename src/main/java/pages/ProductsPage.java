package pages;

import helper.BrowserHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static browserConfig.Driver.driver;
import static browserConfig.Driver.wait;

public class ProductsPage extends BasePage{

    private static Logger log = LogManager.getLogger(ProductsPage.class);
    private BrowserHelpers helper = new BrowserHelpers();

    @FindBy(xpath = "//span[@class='title']")
    public WebElement pageName;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    public WebElement numberOfItems;

    public String isPageOpen() {
        wait.until(ExpectedConditions.visibilityOf(pageName));
        String headerPageName = pageName.getText();
        log.info(headerPageName + " page is open!");

        return headerPageName;
    }

    public void addItemToCart(String itemName) {
        WebElement item = driver.findElement(By.xpath("//div[text()='" + itemName + "']/../../..//button"));
        helper.highlightElement(item);
        item.click();
        log.info(itemName + " is added to cart!");
    }

    public String numberOfItemsInCart() {
        String itemsNumber = numberOfItems.getText();
        log.info(itemsNumber + " items are in cart!");

        return itemsNumber;
    }

    public void removeItemFromCart(String itemName) {
        WebElement item = driver.findElement(By.xpath("//div[text()='" + itemName + "']/../../..//button"));
        helper.highlightElement(item);
        item.click();
        log.info(itemName + " item is removed from cart!");
    }

    public boolean isAnyItemsInCart() {
        try{
            numberOfItems.getText();
            log.info(numberOfItems + " items are in cart!");
            return true;
        } catch (NoSuchElementException e){
            log.info("There are no items in cart!");
            return false;
        }
    }
}
