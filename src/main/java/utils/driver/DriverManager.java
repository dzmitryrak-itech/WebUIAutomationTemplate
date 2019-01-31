package utils.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.PropertyManager;

/**
 * https://github.com/celikgumusdag/appium-driver-manager/tree/master/src/main/java/Driver
 */
public abstract class DriverManager {

    AppiumDriver driver;
    DesiredCapabilities capabilities = new DesiredCapabilities();

    protected abstract AppiumDriver createDriver(AppiumDriverLocalService service);

    public AppiumDriver getDriver(String deviceName, String udid, String platform, String version, AppiumDriverLocalService service) {
        if (null == driver) {
            capabilities.setCapability("appPackage", PropertyManager.getInstance().get("application.package.name"));
            capabilities.setCapability("appActivity", PropertyManager.getInstance().get("application.activity.name"));

            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platform);
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
            capabilities.setCapability(MobileCapabilityType.UDID, udid); //DeviceId from "adb devices" command
            driver = createDriver(service);
        }
        return driver;
    }
}