package auto.ru.steps;

import auto.ru.model.Model;
import auto.ru.model.Models;
import auto.ru.model.SearchCriteria;
import auto.ru.pageobjects.CarMakeSearchPage;
import auto.ru.pageobjects.CarModelSearchPage;
import auto.ru.pageobjects.CarsListPage;
import auto.ru.pageobjects.SearchPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class SearchSteps {

    private CarMakeSearchPage carMakeSearchPage;
    private SearchPage searchPage;
    private CarModelSearchPage carModelSearchPage;
    private CarsListPage carList;

    public SearchSteps(AppiumDriver <MobileElement> driver){
        searchPage = new SearchPage(driver);
        carMakeSearchPage = new CarMakeSearchPage(driver);
        carModelSearchPage = new CarModelSearchPage(driver);
        carList = new CarsListPage(driver);
    }

    public SearchSteps searchByCriteria(SearchCriteria searchCriteria){
        searchPage.clickToSelectMakeButton();
        carMakeSearchPage.clickToMakeByText(searchCriteria.getMake());
        if(searchCriteria.getModels() != null) {
            if (searchCriteria.getModels().contains(new Model(Models.ALL, ""))) {
                carModelSearchPage.selectAllModels();
            } else {
                carModelSearchPage.selectModelsByText(searchCriteria.getModels());
            }
        }
        carModelSearchPage.doSearch(searchCriteria.isSearchClickedAutomatically());
        carList.carListShouldBeLoaded();
        return this;
    }

    public SearchSteps searchByCriteriaUsingSearch(SearchCriteria searchCriteria){
        searchPage.clickToSelectMakeButton();
        carMakeSearchPage.searchForMake(searchCriteria.getMake().getName())
                .clickToMakeByText(searchCriteria.getMake());
        carModelSearchPage.searchForModel(searchCriteria.getModels().get(0).getName())
                .selectModelsByText(searchCriteria.getModels())
                .doSearch(searchCriteria.isSearchClickedAutomatically());
        carList.carListShouldBeLoaded();
        return this;
    }
}
