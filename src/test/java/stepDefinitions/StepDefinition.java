package stepDefinitions;

import helper.BrowserHelpers;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

public class StepDefinition {
    private LoginPage loginPage = new LoginPage();
    private ProductsPage productsPage = new ProductsPage();
    private CartPage cartPage = new CartPage();
    private CheckoutPage checkoutPage = new CheckoutPage();
    private BrowserHelpers helper = new BrowserHelpers();

    @Given("I navigate to {string} page")
    public void i_navigate_to_page(String page) {
        loginPage.openPage(page);
    }
    @When("I log in with username {string} and password {string}")
    public void i_log_in_with_username_and_password(String username, String password) {
        loginPage.loginWithCredentials(username, password);
    }
    @And("{string} page is open")
    public void page_is_open(String expectedPage) {
        String actualPage = productsPage.isPageOpen();
        Assert.assertEquals(actualPage, expectedPage);
    }

    @And("I add {string} item to cart")
    public void iAddItemToCart(String itemName) {
        productsPage.addItemToCart(itemName);
    }

    @And("I verify that {string} items are added to cart")
    public void iVerifyThatItemsAreAddedToCart(String expectedNumberOfItemsInCart) {
        String actualNumberOfItemsInCart = productsPage.numberOfItemsInCart();
        Assert.assertEquals(actualNumberOfItemsInCart, expectedNumberOfItemsInCart);
    }

    @And("I remove {string} item from cart")
    public void iRemoveItemFromCart(String itemName) {
        productsPage.removeItemFromCart(itemName);
    }

    @And("I verify that there are no items in cart")
    public void iVerifyThatThereAreNoItemsInCart() {
        Assert.assertFalse(productsPage.isAnyItemsInCart());
    }

    @And("I verify {string} item is displayed")
    public void iVerifyItemIsDisplayed(String itemName) {
        cartPage.itemIsDisplayed(itemName);
    }

    @And("I clear form from errors")
    public void iClearFormFromErrors() {
        checkoutPage.clearErrors();
    }

    @And("I fill {string} in {string} field")
    public void iFillInField(String arguments, String field) {
        checkoutPage.loginWithCredentials(arguments, field);
    }

    @And("I check if {string} error message is shown")
    public void iCheckIfErrorMessageIsShown(String expectedErrorMessage) {
        String actualErrorMessage = checkoutPage.shownErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    @And("I check if {int} errors are displayed")
    public void iCheckIfErrorsAreDisplayed(int expectedNumberOfErrors) {
        int actualnumberOfErrors = checkoutPage.checkNumberOfErrors();
        Assert.assertEquals(actualnumberOfErrors, expectedNumberOfErrors);
    }

    @And("I verify {string} button is displayed")
    public void iVerifyButtonIsDisplayed(String buttonName) {
        checkoutPage.buttonIsDisplayed(buttonName);
    }

    @And("I verify if total price is {string}")
    public void iVerifyIfTotalPriceIs(String expectedTotalPrice) {
        String actualTotalPrice = checkoutPage.totalPrice();
        Assert.assertEquals(actualTotalPrice, expectedTotalPrice);
    }

    @Then("I Logout")
    public void iLogout() {
        checkoutPage.logout();
    }

    @And("I verify {string} success message is shown")
    public void iVerifySuccessMessageIsShown(String expectedMessage) {
        String actualMessage = checkoutPage.isSuccessMessageShown();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @And("I click on {string} button")
    public void iClickOnButton(String buttonName) {
        helper.clickButton(buttonName);
    }
}
