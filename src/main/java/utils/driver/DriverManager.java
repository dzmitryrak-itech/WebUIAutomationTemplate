package utils.driver;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.PropertyManager;

@Log4j2
public class DriverManager {

    private WebDriver driver;

    public WebDriver getDriver() {
        String browserType = PropertyManager.getInstance().get("browser");
        if (null == driver) {
            DriverType browser = DriverType.valueOf(browserType.toUpperCase());
            switch (browser) {
                case FIREFOX:
                    driver = new FirefoxDriver(CapabilitiesGenerator.getFireFoxOptions());
                    break;
                case CHROME:
                    driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
                    break;
                default:
                    throw new IllegalStateException(String.format("Unsupported browser type: %s", browserType));
            }
        }
        return driver;
    }
}