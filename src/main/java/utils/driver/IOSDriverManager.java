package utils.driver;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.util.concurrent.TimeUnit;

public class IOSDriverManager extends DriverManager {

    /**https://github.com/appium/java-client/blob/master/docs/The-starting-of-an-app-using-Appium-node-server-started-programmatically.md#fyi
     *
     * @param service - Appium server to be bind with the driver
     */
    @Override
    public void createDriver(AppiumDriverLocalService service){

        driver = new IOSDriver(service, capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
}