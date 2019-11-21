package com.jsystems.qa.qagui.cucumber.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainWordpressPage extends BasePage {

    public MainWordpressPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "h1.lpc-headline-title span:nth-child(1)")
    public WebElement textElement1;
   // public WebElement textElement1 = driver.findElement(By.cssSelector("h1.lpc-headline-title span:nth-child(1)")); pierwsza wersja

    @FindBy(css = "h1.lpc-headline-title span:nth-child(2)")
    public WebElement textElement2;

    public static final String loginIconSelector = ".x-nav-item.x-nav-item--wide.x-nav-item--logged-in";
    @FindBy(css = loginIconSelector)
    public WebElement loginIcon;

}
