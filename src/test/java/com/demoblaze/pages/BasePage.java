package com.demoblaze.pages;

import com.demoblaze.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.List;

public abstract class BasePage {

    WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
    Actions actions = new Actions(Driver.get());

    @FindBy(xpath = "//a[contains(.,\"Home\")]")
    public WebElement home;

    @FindBy(xpath = "//a[contains(.,\"Cart\")]")
    public WebElement cart;

    @FindBy(css = ".hrefch")
    public List<WebElement> products;

    public BasePage(){
        PageFactory.initElements(Driver.get(), this);
    }
}
