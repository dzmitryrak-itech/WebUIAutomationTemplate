package com.seniorlink.tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;


public class LoginPageTest extends BaseTest {

    @Test
    @Description("Login into the app")
    public void loginByUser () {
        loginSteps.login("EMAIL", "PASSWORD");
    }
}