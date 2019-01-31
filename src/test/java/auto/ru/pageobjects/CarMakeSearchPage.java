package auto.ru.pageobjects;

import auto.ru.model.Make;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

public class CarMakeSearchPage extends BasePage {

    @AndroidFindBy(id = "ru.auto.ara:id/search_btn")
    private MobileElement searchButton;

    @AndroidFindBy(id = "ru.auto.ara:id/do_search_btn")
    private MobileElement doSearchButton;

    public static final String MAKE_XPATH = "//android.widget.TextView[contains(@text, '%s')]";
    public static final String PARENT_MAKE_XPATH = "//android.widget.TextView[contains(@text, '%s')]/../../android.widget.ImageView";
    public static final String SEARCH_INPUT_ID= "ru.auto.ara:id/search_view";
    public static final String MAKE_LIST_ID= "ru.auto.ara:id/list";


    public CarMakeSearchPage(AppiumDriver<MobileElement> driver){
        super(driver);
        initElements(this);
    }

    public CarMakeSearchPage clickToMakeByText(Make make){
        if(StringUtils.isNotBlank(make.getParentCategory())){
            By parentMake = By.xpath(String.format(PARENT_MAKE_XPATH, make.getParentCategory()));
            scrollToElement(
                    By.id(MAKE_LIST_ID),
                    parentMake);
            driver.findElement(parentMake).click();
        }
        By makeElement = By.xpath(String.format(MAKE_XPATH, make.getName()));
        scrollToElement(
                By.id(MAKE_LIST_ID),
                makeElement);
        driver.findElement(makeElement).click();
        return this;
    }

    public CarMakeSearchPage searchForMake(String make){
        searchButton.click();
        driver.findElement(By.id(SEARCH_INPUT_ID)).sendKeys(make);
        return this;
    }
}
