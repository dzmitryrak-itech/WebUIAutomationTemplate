package auto.ru.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CarsListPage extends BasePage {

    @AndroidFindBy(id = "ru.auto.ara:id/snippetContainer")
    private MobileElement carItemSnippet;

    public CarsListPage(AppiumDriver<MobileElement> driver){
        super(driver);
        initElements(this);
    }

    public CarsListPage carListShouldBeLoaded(){
        assertThat("List of cars is empty or haven't been loaded", waitForElementToAppear(carItemSnippet), equalTo(true));
        return this;
    }
}
