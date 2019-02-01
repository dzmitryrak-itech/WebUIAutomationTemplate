package auto.ru.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.NoSuchElementException;

@Log4j2
public class SearchPage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Выбрать марку и модель')]")
    private MobileElement selectMakeModelButton;


    public SearchPage(AppiumDriver<MobileElement> driver){
        super(driver);
        initElements(this);
    }

    public SearchPage clickToSelectMakeButton(){
        try {
            selectMakeModelButton.click();
        }catch (NoSuchElementException ex){
            log.error(String.format("Cannot find element by %s", selectMakeModelButton));
        }
        return this;
    }
}
