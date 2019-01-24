import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class AutoRuSampleTest {

    public AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;

    @BeforeTest
    public void setup () throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2_Android_9");
        caps.setCapability(MobileCapabilityType.UDID, "emulator-5554"); //DeviceId from "adb devices" command
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
        //caps.setCapability("skipUnlock","true");
        caps.setCapability("appPackage", "ru.auto.ara");
        caps.setCapability("appActivity","ru.auto.ara.MainActivity");
        //caps.setCapability("noReset","false");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    @Description("Test Description: Login test with wrong username and wrong password.")
    public void basicTest () {
        //Переходим в меню выбора марки
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//android.widget.TextView[contains(@text, 'Выбрать марку и модель')]"))).click();

        //Переходим в конкретную марку
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//android.widget.TextView[contains(@text, 'Audi')]"))).click();

        //Переходим в конкретную модель, берем второго родителя (деда) элемента и тыкаем в чекбокс
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//android.widget.TextView[contains(@text, 'A3')]/../../android.widget.CheckBox"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//android.widget.TextView[contains(@text, 'A4')]/../../android.widget.CheckBox"))).click();

        //Ищем
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("ru.auto.ara:id/do_search_btn"))).click();

        //Ждем элемент
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("ru.auto.ara:id/snippetContainer"))).click();
    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }

}