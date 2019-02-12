package com.seniorlink.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.seniorlink.other.Urls.MAIN_PAGE;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "Login")
    private WebElement loginButton;

    public LoginPage(WebDriver driver){
        super(driver);
        initElements(this);
    }

    public LoginPage login(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        waitLoadingToBeCompleted();
        return this;
    }

    public LoginPage openLoginPage(){
        driver.get(MAIN_PAGE);
        return this;
    }
}
