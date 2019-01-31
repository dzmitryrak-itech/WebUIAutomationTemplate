package utils.appium;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.AndroidServerFlag;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import utils.IOUtils;

import java.io.File;

public final class AppiumUtils {

    public static AppiumDriverLocalService startAppiumDriverService(){
        AppiumDriverLocalService service = AppiumDriverLocalService.buildService(
                new AppiumServiceBuilder()
                        .usingPort(IOUtils.nextFreePort())
                        //TODO move URL to peroperties
                        .withIPAddress( "127.0.0.1" )
                        .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                        .withArgument(GeneralServerFlag.LOG_LEVEL, "warn")
                        .withArgument(AndroidServerFlag.BOOTSTRAP_PORT_NUMBER, String.valueOf(IOUtils.nextFreePort()))
                        //TODO read from property
                        .withAppiumJS(new File("C:\\Users\\Dzmitry.Rak\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js")));
        service.start();
        return service;
    }
}
