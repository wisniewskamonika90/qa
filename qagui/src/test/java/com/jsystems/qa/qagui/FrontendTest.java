package com.jsystems.qa.qagui;

import com.sun.xml.internal.ws.api.server.WebServiceContextDelegate;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FrontendTest extends ConfigFrontend{


   @Test
    public void frontTest(){
        driver.get("https://wordpress.com/");
        WebElement textElement1 = driver.findElement(By.cssSelector("h1.lpc-headline-title span:nth-child(1)"));
        String text1  = textElement1.getText();
        assertTrue(text1.equals("WordPress powers"));

       WebElement textElement2 = driver.findElement(By.cssSelector("h1.lpc-headline-title span:nth-child(2)"));
       String text2  = textElement2.getText();
       assertTrue(text2.contains("% of the internet."));
       assertTrue(text2.matches("\\d+(% of the internet.)"));
   }

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
}
