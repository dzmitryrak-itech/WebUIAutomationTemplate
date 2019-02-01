package auto.ru.tests;

import auto.ru.steps.SearchSteps;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.*;
import utils.appium.AppiumUtils;
import utils.driver.DriverManager;
import utils.driver.DriverManagerFactory;

@Listeners(TestListener.class)
public class BaseTest {
    private String deviceName = "Pixel 2 Android 9";
    private String udid = "emulator-5554";
    private String platform = "Android";
    private String version = "9.0";

    private AppiumDriverLocalService appiumService;
    AppiumDriver driver;
    SearchSteps searchSteps;

    void setCustomCapabilities(String _deviceName, String _udid, String _platform, String _version){
        deviceName = _deviceName;
        udid = _udid;
        platform = _platform;
        version = _version;
    }

    @BeforeClass
    void startAppiumServer(){
        appiumService = AppiumUtils.startAppiumDriverService();
    }

    @BeforeMethod
    public void startDriverAndApplication() {
        DriverManager manager = DriverManagerFactory.getManager(platform);
        driver = manager.getDriver(deviceName, udid, platform, version, appiumService);
        searchSteps = new SearchSteps(driver);
    }

    @AfterMethod
    void closeApplication() {
        driver.closeApp();
    }

    @AfterClass
    void stopAppiumServer(){
        driver.quit();
        appiumService.stop();
    }

    AppiumDriver getDriver(){
        return driver;
    }
}
