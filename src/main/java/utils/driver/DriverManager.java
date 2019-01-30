package utils.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * https://github.com/celikgumusdag/appium-driver-manager/tree/master/src/main/java/Driver
 */
public abstract class DriverManager {

    AppiumDriver driver;
    DesiredCapabilities capabilities = new DesiredCapabilities();

    protected abstract void createDriver(AppiumDriverLocalService service);

    public AppiumDriver getDriver(String deviceName, String udid, String platform, String version, AppiumDriverLocalService service) {
        if (null == driver) {
            //TODO read app name from properties
            capabilities.setCapability("appPackage", "ru.auto.ara");
            capabilities.setCapability("appActivity","ru.auto.ara.MainActivity");

            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platform);
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
            capabilities.setCapability(MobileCapabilityType.UDID, udid); //DeviceId from "adb devices" command
            createDriver(service);
        }
        return driver;
    }
}