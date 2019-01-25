package auto.ru.tests;

import auto.ru.utilities.driver.DriverManager;
import auto.ru.utilities.driver.DriverManagerFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

//TODO move driver to PageObjects?
public class BaseTest {
    public AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;

    @BeforeTest
    public void setup () {
        DriverManager manager = DriverManagerFactory.getManager();
        driver = manager.getDriver();

        wait = new WebDriverWait(driver, 10);
    }


    @AfterTest
    public void teardown(){
        driver.quit();
    }
}
