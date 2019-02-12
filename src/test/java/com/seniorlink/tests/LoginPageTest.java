package com.seniorlink.tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;


public class LoginPageTest extends BaseTest {

    @Test
    @Description("Search for All models of specific make")
    public void loginByUser () {
        loginSteps.login("EMAIL", "PASSWORD");
    }
}