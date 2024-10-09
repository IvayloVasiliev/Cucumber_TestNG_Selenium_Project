package pages;

import helper.BrowserHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static browserConfig.Driver.driver;
import static browserConfig.Driver.wait;

public class CheckoutPage extends BasePage{

    private static Logger log = LogManager.getLogger(CheckoutPage.class);
    private BrowserHelpers helper = new BrowserHelpers();


    @FindBy(id = "react-burger-menu-btn")
    public WebElement burgerButton;
    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutLink;
    @FindBy(xpath = "//h3[@data-test='error']")
    public WebElement errorMessage;
    @FindBy(xpath = "//button[@class='error-button']")
    public WebElement clearErrorButton;
    @FindBy(xpath = "//div[@class='summary_total_label']")
    public WebElement totalPriceField;
    @FindBy(xpath = "//h2")
    public WebElement successMessage;

    public int checkNumberOfErrors(){
        List<WebElement> numberOfErrors = driver.findElements(By.xpath("//*[contains(@class, 'error_icon')]"));
        return numberOfErrors.size();
    }

    public String shownErrorMessage(){
        return errorMessage.getText();
    }

    public void clearErrors(){
        clearErrorButton.click();
    }

    public void loginWithCredentials(String arguments, String fieldName) {
        WebElement inputField = driver.findElement(By.xpath("//input[@placeholder='" + fieldName + "']"));
        helper.highlightElement(inputField);
        inputField.sendKeys(arguments);

        log.info( arguments + " are written in " + fieldName + " field.");
    }

    public void buttonIsDisplayed(String buttonName){
        WebElement button = driver.findElement(By.id(buttonName));
        button.isDisplayed();
        helper.highlightElement(button);
        log.info(buttonName + " is displayed!");
    }

    public String totalPrice() {
        String totalPriceAsString = totalPriceField.getText();
        log.info(totalPriceAsString + " is the total price!");

        return totalPriceAsString;
    }
    public String isSuccessMessageShown() {
        String successMessageText = successMessage.getText();
        log.info(successMessageText + " is shown!");

        return successMessageText;
    }

    public void logout(){
        helper.highlightElement(burgerButton);
        burgerButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
        helper.highlightElement(logoutLink);
        logoutLink.click();
        log.info("User is Logout!");
    }
}
