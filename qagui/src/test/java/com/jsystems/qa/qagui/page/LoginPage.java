package com.jsystems.qa.qagui.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public static final String usernameOrEmailSelector = "usernameOrEmail";
    @FindBy(id = usernameOrEmailSelector)
    public WebElement usernameInput;

    public static  final String primaryButtonSelector = ".button.form-button.is-primary";
    @FindBy(css=primaryButtonSelector)
    public WebElement usernameButton;

    public static  final  String passwordInputSelector = "password";
    @FindBy(id=passwordInputSelector)
    public WebElement inputPassword;

    @FindBy(css=primaryButtonSelector)
    public WebElement buttonPassword;
}
