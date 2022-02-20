package com.demoblaze.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlaceOrderPage extends BasePage{


    @FindBy(id = "name")
    public WebElement name;
    @FindBy(id = "country")
    public WebElement country;
    @FindBy(id = "city")
    public WebElement city;
    @FindBy(id = "card")
    public WebElement card;
    @FindBy(id = "month")
    public WebElement month;
    @FindBy(id = "year")
    public WebElement year;

    @FindBy(xpath = "//button[contains(.,'Purchase')]")
    public WebElement purchaseBtn;

    @FindBy(xpath = "//p[@class='lead text-muted ']/text()[1]")
    public WebElement orderId;

    @FindBy(xpath = "//p[@class='lead text-muted ']/text()[2]")
    public WebElement actualPurchaseAmount;

    @FindBy(xpath = "//p[contains(.,'Id')]")
    public WebElement oderDetailsText;

    public void fillForm(){
        Faker faker = new Faker();
        name.sendKeys(faker.name().fullName());
        country.sendKeys(faker.country().name());
        city.sendKeys(faker.country().capital());
        card.sendKeys(faker.finance().creditCard());
        month.sendKeys("" + faker.number().numberBetween(1,12));
        year.sendKeys("" + faker.number().numberBetween(2020,2025));
        purchaseBtn.click();
    }

}
