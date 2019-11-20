package com.jsystems.qa.qagui;

import com.jsystems.qa.qagui.page.LoginPage;
import com.jsystems.qa.qagui.page.MainWordpressPage;
import com.jsystems.qa.qagui.page.UserPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.google.common.truth.Truth.assertThat;
import static com.jsystems.qa.qagui.page.LoginPage.*;
import static com.jsystems.qa.qagui.page.UserPage.*;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("FrontTest")
public class FrontendTest extends ConfigFrontend{


   @Test
    public void frontTest(){
        driver.navigate().to(Configuration.BASE_URL);
       MainWordpressPage mainWordpressPage = new MainWordpressPage(driver);
     //   WebElement textElement1 = driver.findElement(By.cssSelector("h1.lpc-headline-title span:nth-child(1)"));
        String text1  = mainWordpressPage.textElement1.getText();
        assertTrue(text1.equals("WordPress powers"));

     //  WebElement textElement2 = driver.findElement(By.cssSelector("h1.lpc-headline-title span:nth-child(2)"));
       String text2  = mainWordpressPage.textElement2.getText();
       assertTrue(text2.contains("% of the internet."));
       assertTrue(text2.matches("\\d+(% of the internet.)"));
   }
/*
   @Test
    public void loginTest(){
       driver.get("https://wordpress.com/");
       try{
       sleep(2000);}
       catch(InterruptedException e){
          e.printStackTrace();
       }
       WebElement login = driver.findElement(By.xpath("//*[@id=\"lpc-header-nav\"]/div/div/div[1]/header/nav/ul[2]/li[1]/a"));
       assertTrue(login.isDisplayed());
       login.click();
       try{
           sleep(2000);}
       catch(InterruptedException e){
           e.printStackTrace();
       }
       WebElement login2 = driver.findElement(By.id("usernameOrEmail"));
       try{
           sleep(2000);}
       catch(InterruptedException e){
           e.printStackTrace();
       }
       login2.sendKeys("testautomation112019@wp.pl");
       try{
           sleep(2000);}
       catch(InterruptedException e){
           e.printStackTrace();
       }
       WebElement clickLogin = driver.findElement(By.cssSelector(".login__form-action button"));
       clickLogin.click();

       try{
           sleep(2000);}
       catch(InterruptedException e){
           e.printStackTrace();
       }

       WebElement password = driver.findElement(By.cssSelector(".form-password-input input"));
       password.sendKeys("12345678");

       try{
           sleep(2000);}
       catch(InterruptedException e){
           e.printStackTrace();
       }

       WebElement cliclLogin2 = driver.findElement(By.cssSelector(".login__form-action button"));
       cliclLogin2.click();
       try{
           sleep(2000);}
       catch(InterruptedException e){
           e.printStackTrace();
       }
   }
*/
    @Test
    public void loginTest2() {
        driver.navigate().to(Configuration.BASE_URL);
        MainWordpressPage mainWordpressPage = new MainWordpressPage(driver);

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(mainWordpressPage.loginIcon));

        mainWordpressPage.loginIcon.click();

        LoginPage loginPage = new LoginPage(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(usernameOrEmailSelector)));

        loginPage.usernameInput.clear();
        loginPage.usernameInput.sendKeys(Configuration.LOGIN);

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(primaryButtonSelector)));
        loginPage.usernameButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id(passwordInputSelector)));
        loginPage.inputPassword.clear();
        loginPage.inputPassword.sendKeys(Configuration.PASSWORD);

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(primaryButtonSelector)));
        loginPage.usernameButton.click();

        UserPage userPage = new UserPage(driver);

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(userAvatarSelector)));
        userPage.userAvatar.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(userDisplayNameSelector)));
        String userDisplayNameText = userPage.userDisplay.getText();

        assertThat(userDisplayNameText).isEqualTo("monikawisniewska90");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(primaryButtonSelector)));
        assertThat(!userPage.userDisplay.isDisplayed());
    }

    @Test
    public void notificationTest() {
        driver.navigate().to(Configuration.BASE_URL);
        MainWordpressPage mainWordpressPage = new MainWordpressPage(driver);

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(mainWordpressPage.loginIcon));
        mainWordpressPage.loginIcon.click();

        LoginPage loginPage = new LoginPage(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(usernameOrEmailSelector)));

        loginPage.usernameInput.clear();
        loginPage.usernameInput.sendKeys(Configuration.LOGIN);

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(primaryButtonSelector)));
        loginPage.usernameButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id(passwordInputSelector)));
        loginPage.inputPassword.clear();
        loginPage.inputPassword.sendKeys(Configuration.PASSWORD);

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(primaryButtonSelector)));
        loginPage.usernameButton.click();

        UserPage userPage = new UserPage(driver);

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(userAvatarSelector)));
        userPage.userAvatar.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(userDisplayNameSelector)));

        userPage.notificationSideLine.click();
        userPage.comment.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(checkBoxSelector)));
        assertTrue(userPage.checkbox.isSelected());

        userPage.checkbox.click();
        assertFalse(userPage.checkbox.isSelected());

        userPage.checkbox.click();

    }
}
