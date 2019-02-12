package com.seniorlink.pageobjects;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
class BasePage {

    @FindBy(id = "spring19-einstein_base")
    private WebElement loader;
    WebDriver driver;

    private WebDriverWait wait;
    private static final int TIMEOUT = 5;
    private static final int POLLING = 100;


    BasePage(WebDriver driver){
        this.driver = driver;

        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
    }

    void initElements(BasePage page){
        PageFactory.initElements(driver, page);
    }

    boolean waitForElementToAppear(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        }catch (TimeoutException ex){
            return false;
        }
    }

    boolean waitForElementToDisappear(WebElement element){
        try {
            wait.until(ExpectedConditions.invisibilityOf(element));
            return true;
        }catch (TimeoutException ex){
            return false;
        }
    }

    public BasePage waitLoadingToBeCompleted(){
        waitForElementToAppear(loader);
        waitForElementToDisappear(loader);
        return this;
    }
}
