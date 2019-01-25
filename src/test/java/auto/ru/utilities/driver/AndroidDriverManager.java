package auto.ru.utilities.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidDriverManager extends DriverManager {

    @Override
    public void createDriver(){

        //TODO leave only capabilities related to Android
        capabilities.setCapability("appPackage", "ru.auto.ara");
        capabilities.setCapability("appActivity","ru.auto.ara.MainActivity");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2_Android_9");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554"); //DeviceId from "adb devices" command
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");

        //TODO move URL to properties
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
}
