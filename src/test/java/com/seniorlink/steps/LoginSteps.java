package com.seniorlink.steps;

import com.seniorlink.pageobjects.LoginPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class LoginSteps {

    private LoginPage loginPage;

    public LoginSteps(WebDriver driver){
        loginPage = new LoginPage(driver);
    }

    @Step("Login into the system using credentials: {username}, {password}")
    public LoginSteps login(String username, String password){
        loginPage.openLoginPage();
        loginPage.login(username, password);
        return this;
    }
}
