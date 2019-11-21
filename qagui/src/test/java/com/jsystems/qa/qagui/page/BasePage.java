package com.jsystems.qa.qagui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    public void waitForElementToBeClicable(By by, int time){
        wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitForElementToBeClicable(By by){
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitForElementToBeClicable(WebElement by){
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public void waitForElementToBeClicable(WebElement by, int time){
        wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitForElementToBeVisibility(By by, int time){
        wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForElementToBeVisibility(By by){
        wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForElementToBeVisibility(WebElement by){
        wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(by));
    }

    public void waitForElementToBeVisibility(WebElement by, int time){
        wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.visibilityOf(by));
    }
}
