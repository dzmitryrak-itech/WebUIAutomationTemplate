package auto.ru.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SearchPage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Выбрать марку и модель')]")
    private MobileElement selectMakeModelButton;


    public SearchPage(AppiumDriver<MobileElement> driver){
        super(driver);
        initElements(this);
    }

    public SearchPage clickToSelectMakeButton(){
        selectMakeModelButton.click();
        return this;
    }
}
