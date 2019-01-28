package utils.driver;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class IOSDriverManager extends DriverManager {

    @Override
    public void createDriver(){
        //TODO set right capabilities related to IOS only
        capabilities.setCapability("appPackage", "ru.auto.ara");
        capabilities.setCapability("appActivity","ru.auto.ara.MainActivity");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2_Android_9");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554"); //DeviceId from "adb devices" command
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");

        //TODO read from property
        try {
            driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
}