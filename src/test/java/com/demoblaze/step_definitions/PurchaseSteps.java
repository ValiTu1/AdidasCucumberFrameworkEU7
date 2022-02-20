package com.demoblaze.step_definitions;

import com.demoblaze.pages.PlaceOrderPage;
import com.demoblaze.pages.ProductPage;
import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.ConfigurationReader;
import com.demoblaze.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class PurchaseSteps {

    ProductPage page = new ProductPage();

    PlaceOrderPage placeOrderPage = new PlaceOrderPage();

    int expectedPurchaseAmount;

    @Given("User is on the home page")
    public void user_is_on_the_home_page() {
        Driver.get().get(ConfigurationReader.get("demoblaze.url"));

    }
    @When("User adds some {string} from {string}")
    public void user_adds_some_from(String product, String category) throws InterruptedException {
        page.nagigateTo(product, category);
        page.addToCart();
        Thread.sleep(1000);
        page.home.click();
    }

    @And("user navigates to cart and removes {string}")
    public void userNavigatesToCartAndRemoves(String productVariable) {
        BrowserUtils.sleep(1);
        page.cart.click();
        BrowserUtils.sleep(1);
        page.deleteProduct(productVariable);
    }

    @And("use clicks on place order")
    public void useClicksOnPlaceOrder() {
        BrowserUtils.sleep(1);
        page.cart.click();

        expectedPurchaseAmount = Integer.parseInt(page.totalPrice.getText());
        page.placeOrderBtn.click();
        BrowserUtils.sleep(2);
    }


    @And("User fills the form for order and clicks on pruchase button")
    public void userFillsTheFormForOrderAndClicksOnPruchaseButton() {

        BrowserUtils.sleep(1);
        placeOrderPage.fillForm();
        placeOrderPage.purchaseBtn.click();
    }

    @Then("Order Id and order amount should be as expected")
    public void orderIdAndOrderAmountShouldBeAsExpected() {

        String orderId = placeOrderPage.oderDetailsText.getText().split("\n")[0];
        System.out.println(orderId);

        int actualPriceAmount= Integer.parseInt(placeOrderPage.oderDetailsText.getText().split("\n")[1].split(" ")[1]);
        System.out.println("Price: " + actualPriceAmount);

        Assert.assertEquals("Price is not as expected", expectedPurchaseAmount, actualPriceAmount);


        /*String orderId = placeOrderPage.orderId.getText();
        System.out.println("Order id: " + orderId);

        Assert.assertTrue("Order id is not displayed", placeOrderPage.orderId.isDisplayed());
        Assert.assertTrue("Order amount is not displayed", placeOrderPage.actualPurchaseAmount.isDisplayed());*/


    }

}
