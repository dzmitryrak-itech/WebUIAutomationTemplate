package auto.ru.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CarsListPage extends BasePage {

    @AndroidFindBy(id = "ru.auto.ara:id/snippetContainer")
    private MobileElement carItemSnippet;

    public CarsListPage(AppiumDriver<MobileElement> driver){
        super(driver);
        initElements(this);
    }

    public CarsListPage carListShouldBeLoaded(){
        waitForElementToAppear(carItemSnippet);
        return this;
    }
}
