package utils.driver;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * https://github.com/celikgumusdag/appium-driver-manager/tree/master/src/main/java/Driver
 */
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