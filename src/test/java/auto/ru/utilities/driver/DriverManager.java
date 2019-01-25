package auto.ru.utilities.driver;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public abstract class DriverManager {

    AppiumDriver driver;
    DesiredCapabilities capabilities = new DesiredCapabilities();

    protected abstract void createDriver();

    public AppiumDriver getDriver() {
        if (null == driver) {
            createDriver();
        }
        return driver;
    }
}