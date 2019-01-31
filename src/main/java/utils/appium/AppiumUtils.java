package utils.appium;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.AndroidServerFlag;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import utils.IOUtils;
import utils.PropertyManager;

import java.io.File;

public final class AppiumUtils {

    public static AppiumDriverLocalService startAppiumDriverService(){
        AppiumDriverLocalService service = AppiumDriverLocalService.buildService(
                new AppiumServiceBuilder()
                        .usingPort(IOUtils.nextFreePort())
                        .withIPAddress(PropertyManager.getInstance().get("appium.server.url"))
                        .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                        .withArgument(GeneralServerFlag.LOG_LEVEL, "warn")
                        .withArgument(AndroidServerFlag.BOOTSTRAP_PORT_NUMBER, String.valueOf(IOUtils.nextFreePort()))
                        .withAppiumJS(new File(PropertyManager.getInstance().get("appium.server.js.path"))));
        service.start();
        return service;
    }
}
