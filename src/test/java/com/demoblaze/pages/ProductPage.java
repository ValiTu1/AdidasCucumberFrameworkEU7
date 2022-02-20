package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.Driver;
import com.github.dockerjava.api.model.Link;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage{

    @FindBy(xpath = "//a[.='Add to cart']")
    public WebElement addToCartElement;

    @FindBy(xpath = "//tbody//td[contains(.,'Dell i7 8gb')]/../td[4]/a")
    public WebElement sonyVaio5Delete;

    @FindBy(id = "totalp")
    public WebElement totalPrice;

    public void deleteProduct(String product){
        String locator = "//tbody//td[contains(.,'" +product+ "')]/../td[4]/a";
        Driver.get().findElement(By.xpath(locator)).click();
        BrowserUtils.sleep(1);
    }

    @FindBy(xpath = "//button[text()='Place Order']")
    public WebElement placeOrderBtn;


    public void nagigateTo(String productName, String categoryName) throws InterruptedException {
        Thread.sleep(1000);
        Driver.get().findElement(By.linkText(categoryName)).click();
        Driver.get().findElement(By.linkText(productName)).click();
    }

    public void addToCart() throws InterruptedException {
        Thread.sleep(1000);
        addToCartElement.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = Driver.get().switchTo().alert();
        alert.accept();
    }


}
