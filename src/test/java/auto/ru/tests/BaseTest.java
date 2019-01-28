package auto.ru.tests;

import auto.ru.steps.SearchSteps;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.driver.DriverManager;
import utils.driver.DriverManagerFactory;

public class BaseTest {

    AppiumDriver<MobileElement> driver;
    SearchSteps searchSteps;
    @BeforeMethod
    public void setup () {
        DriverManager manager = DriverManagerFactory.getManager();
        driver = manager.getDriver();

        searchSteps = new SearchSteps(driver);
    }

    @AfterMethod
    public void teardown(){
     driver.quit();
    }
}
