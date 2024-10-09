package pages;

import helper.BrowserHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static browserConfig.Driver.driver;
import static browserConfig.Driver.wait;

public class LoginPage extends BasePage{
    private static Logger log = LogManager.getLogger(LoginPage.class);
    private BrowserHelpers helper = new BrowserHelpers();

    private static final String loginPage = "https://www.saucedemo.com/";

    @FindBy(id = "user-name")
    public WebElement usernameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "login-button")
    public WebElement loginButton;
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    public WebElement cartLinkButton;


    public void openPage(String page) {
        if (page.equals("login")) {
            driver.get(loginPage);
        } else if (page.equals("cart")){
            cartLinkButton.click();
        } else {
            driver.get(page);
        }
        log.info(page + " page is open");
    }

    public void loginWithCredentials(String username, String password) {
        wait.until(ExpectedConditions.visibilityOf(usernameField));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        helper.highlightElement(loginButton);
        loginButton.click();
        log.info("Login button is clicked for User with username " + username);
    }

}
