package com.jsystems.qa.qagui.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage extends BasePage{

    public UserPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public static final String userAvatarSelector = ".masterbar__item.masterbar__item-me";
    @FindBy(css = userAvatarSelector)
    public WebElement userAvatar;

    public static final String userDisplayNameSelector = ".profile-gravatar__user-display-name";
    @FindBy(css = userDisplayNameSelector)
    public WebElement userDisplay;

    public static final String notificationSelection = "span[data-e2e-sidebar=\"Ustawienia powiadomień\"]";
    @FindBy(css = notificationSelection)
    public WebElement notificationSideLine;

    public static final String commentSelector = ".section-nav-tabs__list li:nth-child(2)";
    @FindBy(css = commentSelector)
    public WebElement comment;

    public static final String checkBoxSelector = "div.notification-settings-form .notification-settings-form__streams .notification-settings-form-stream:nth-child(2) ul li:nth-child(1) input";
    @FindBy(css = checkBoxSelector)
    public WebElement checkbox;
}
