package com.seniorlink.tests;

import com.seniorlink.steps.LoginSteps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utils.driver.DriverManager;

@Listeners(TestListener.class)
public class BaseTest {

    private WebDriver driver;
    LoginSteps loginSteps;


    @BeforeMethod
    public void startBrowser() {
        DriverManager manager = new DriverManager();
        driver = manager.getDriver();
        loginSteps = new LoginSteps(driver);
    }

    @AfterClass
    void stopBrowser(){
        driver.quit();
    }

    WebDriver getDriver(){
        return driver;
    }
}
