package utils.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import utils.IOUtils;

import java.util.concurrent.TimeUnit;

public class AndroidDriverManager extends DriverManager {

    /**https://github.com/appium/java-client/blob/master/docs/The-starting-of-an-app-using-Appium-node-server-started-programmatically.md#fyi
     *
     * @param service
     */
    @Override
    public void createDriver(AppiumDriverLocalService service){
        //https://stackoverflow.com/questions/50326760/unable-to-launch-chrome-browser-appium1-8-android7-0
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        //http://appium.io/docs/en/advanced-concepts/parallel-tests/
        capabilities.setCapability("systemPort", IOUtils.nextFreePort());

        driver = new AndroidDriver(service, capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
}
