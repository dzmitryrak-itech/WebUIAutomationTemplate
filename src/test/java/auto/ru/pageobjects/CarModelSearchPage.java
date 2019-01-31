package auto.ru.pageobjects;

import auto.ru.model.Model;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class CarModelSearchPage extends BasePage{


    @AndroidFindBy(id = "ru.auto.ara:id/do_search_btn")
    private MobileElement doSearchButton;

    //TODO move to separate widget as it is duplicated as makes and models
    @AndroidFindBy(id = "ru.auto.ara:id/search_btn")
    private MobileElement searchButton;

    public static final String MODEL_CHECKBOX_XPATH = "//android.widget.TextView[contains(@text, '%s')]/../../android.widget.CheckBox";
    public static final String ALL_MODELS_CHECKBOX_XPATH = "//android.widget.TextView[contains(@text, 'Выбрать все')]/../android.widget.CheckBox";
    public static final String PARENT_MODEL_XPATH = "//android.widget.TextView[contains(@text, '%s')]/../../android.widget.ImageView";
    public static final String SEARCH_INPUT_ID= "ru.auto.ara:id/search_view";
    public static final String MODEL_LIST_ID= "ru.auto.ara:id/list";

    public CarModelSearchPage(AppiumDriver<MobileElement> driver){
        super(driver);
        initElements(this);
    }

    public CarModelSearchPage selectAllModels(){
        driver.findElement(By.xpath(ALL_MODELS_CHECKBOX_XPATH)).click();
        return this;
    }

    public CarModelSearchPage selectModelsByText(ArrayList<Model> models){
        for (Model model : models) {
            if(StringUtils.isNotBlank(model.getParentModel())){
                By parentModel = By.xpath(String.format(PARENT_MODEL_XPATH, model.getParentModel()));
                scrollToElement(
                        By.id(MODEL_LIST_ID),
                        parentModel);
                driver.findElement(parentModel).click();
            }
            By modelElement = By.xpath(String.format(MODEL_CHECKBOX_XPATH, model.getName()));
            scrollToElement(
                    By.id(MODEL_LIST_ID),
                    modelElement);
            driver.findElement(modelElement).click();
        }
        return this;
    }

    public CarModelSearchPage doSearch(boolean isSearchClickedAutomatically){
        if(!isSearchClickedAutomatically) {
            doSearchButton.click();
        }
        return this;
    }

    public CarModelSearchPage searchForModel(String make){
        searchButton.click();
        driver.findElement(By.id(SEARCH_INPUT_ID)).sendKeys(make);
        return this;
    }
}
