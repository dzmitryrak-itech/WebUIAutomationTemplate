package auto.ru.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * https://github.com/appium/java-client/blob/master/docs/Page-objects.md
 */
@Log4j2
class BasePage {
    AppiumDriver<MobileElement> driver;

    private WebDriverWait wait;
    private static final int TIMEOUT = 5;
    private static final int POLLING = 100;

    BasePage(AppiumDriver<MobileElement> driver){
        this.driver = driver;

        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
    }

    void initElements(BasePage page){
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), page);
    }

    void waitForElementToAppear(MobileElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     *
     * @param locatorForScrollableElement - element where user can swipe
     * @param elementToBeDisplayed - search for required element each time after the scroll
     */
    boolean scrollToElement(By locatorForScrollableElement, By elementToBeDisplayed){
        boolean isElementFound;
        MobileElement scrollingElement = driver.findElement(locatorForScrollableElement);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        try {
            while (true) {
                if (driver.findElements(elementToBeDisplayed).size() > 0) {
                    isElementFound = true;
                    break;
                }
                TouchAction action = new TouchAction(driver);
                int scrollingToStartFromX = scrollingElement.getLocation().getX() + scrollingElement.getSize().width/2;
                int scrollingToStartFromY = scrollingElement.getLocation().getY() + scrollingElement.getSize().height - 20;
                int scrollingToStartToX = scrollingElement.getLocation().getX() + scrollingElement.getSize().width/2;
                int scrollingToStartToY = scrollingElement.getLocation().getY() + 20;
                action.longPress(PointOption.point(scrollingToStartFromX,scrollingToStartFromY))
                        .moveTo(PointOption.point(scrollingToStartToX,scrollingToStartToY))
                        .release()
                        .perform();
            }
            return isElementFound;
        }catch (Exception ex){
            return false;
        }finally {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }
}
