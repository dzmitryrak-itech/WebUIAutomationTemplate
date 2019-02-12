package utils.driver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.PropertyManager;

/**
 * Created by Alexandr Trostyanko
 * Class presents functionality for generation of {@link org.openqa.selenium.remote.DesiredCapabilities} object
 * need for some browsers start
 */
public class CapabilitiesGenerator {

    /**
     * getting {@link org.openqa.selenium.remote.DesiredCapabilities} object based on browser
     * ATTENTION: you should specify the path to chrome driver executable file to run tests on it(@see <a href="https://sites.google.com/a/chromium.org/chromedriver/getting-started">here for more info</a>)
     *
     * @param driverType {@link utils.driver.DriverType} object
     * @return driverType needed for some browsers start
     */
    public static DesiredCapabilities getDefaultCapabilities(DriverType driverType) {
        String driverPath = PropertyManager.getInstance().get("drivers.path");
        String os = System.getProperty("os.name").toLowerCase();
        switch (driverType) {
            case FIREFOX:
                if (os.contains("win")) {
                    System.setProperty("webdriver.gecko.driver", driverPath + "/geckodriver.exe");
                } else if (os.contains("mac")) {
                    System.setProperty("webdriver.gecko.driver", driverPath + "/geckodriver");
                } else {

                }
                if (System.getProperty("webdriver.gecko.driver") == null) {
                    throw new IllegalStateException("System variable 'webdriver.gecko.driver' should be set to path for executable driver");
                }
                return DesiredCapabilities.firefox();
            case CHROME:
                if (os.contains("win")) {
                    System.setProperty("webdriver.chrome.driver", driverPath + "/chromedriver.exe");
                } else if (os.contains("mac")) {
                    System.setProperty("webdriver.chrome.driver", driverPath + "/chromedriver");
                } else {

                }
                if (System.getProperty("webdriver.chrome.driver") == null) {
                    throw new IllegalStateException("System variable 'webdriver.chrome.driver' should be set to path for executable driver");
                }

                return DesiredCapabilities.chrome();
            case IE10:
                DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
                caps.setVersion("10");
                return caps;
            case SAFARI:
                return new DesiredCapabilities();
            default:
                throw new IllegalStateException("Browser is not supported");
        }
    }

    public static ChromeOptions getChromeOptions() {
        String driverPath = PropertyManager.getInstance().get("drivers.path");
        ChromeOptions options = new ChromeOptions();
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            System.setProperty("webdriver.chrome.driver", driverPath + "/chromedriver.exe");
        } else if (os.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", driverPath + "/chromedriver");
        }
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");

/*      //Performance Settings
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        cap.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

        //JavaScript Errors settings
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        cap.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

        options.merge(cap);
*/
        return options;
    }
    public static FirefoxOptions getFireFoxOptions() {
        String driverPath = PropertyManager.getInstance().get("drivers.path");
        FirefoxOptions options = new FirefoxOptions();
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            System.setProperty("webdriver.gecko.driver", driverPath + "/geckodriver.exe");
        } else if (os.contains("mac")) {
            System.setProperty("webdriver.gecko.driver", driverPath + "/geckodriver");
        } else {

        }
        if (System.getProperty("webdriver.gecko.driver") == null) {
            throw new IllegalStateException("System variable 'webdriver.gecko.driver' should be set to path for executable driver");
        }
        options.setCapability("marionette", true);
        return options;
    }
}

