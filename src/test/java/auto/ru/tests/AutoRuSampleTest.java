package auto.ru.tests;

import auto.ru.model.Make;
import auto.ru.model.Model;
import auto.ru.model.Models;
import auto.ru.model.SearchCriteria;
import auto.ru.pageobjects.*;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class AutoRuSampleTest extends BaseTest{

    @Test
    @Description("Check Navigation")
    public void navigationTest () {
        FooterToolBar navigationMenu = new FooterToolBar(driver);
        navigationMenu.navigateToAllTabs();
    }

    @Test
    @Description("Search for separate models and models that have parent")
    public void searchForSeveralModels () {
        SearchCriteria searchCriteria = SearchCriteria.builder()
                .make(new Make("Audi",""))
                .models(new ArrayList(Arrays.asList(
                        new Model(Models.AUDI_40,"TT"),
                        new Model(Models.AUDI_TT_RS, ""))))
                .build();
        searchSteps.searchByCriteria(searchCriteria);
    }

    @Test
    @Description("Search for ALl models of specific make")
    public void searchForAllModels () {
        SearchCriteria searchCriteria = SearchCriteria.builder()
                .make(new Make("Mercedes-Benz",""))
                .models(new ArrayList(Arrays.asList(
                        new Model(Models.ALL,""))))
                .build();
        searchSteps.searchByCriteria(searchCriteria);
    }

    @Test
    @Description("Search for predefined filter across makes:  'Отечесвенные'")
    public void searchForLocalMakes () {
        SearchCriteria searchCriteria = SearchCriteria.builder()
                .make(new Make("Отечественные",""))
                .searchClickedAutomatically(true)
                .build();
        searchSteps.searchByCriteria(searchCriteria);
    }

    @Test
    @Description("Search for predefined filter across makes: 'Иномарки'")
    public void searchForForeignMakes () {
        SearchCriteria searchCriteria = SearchCriteria.builder()
                .make(new Make("Японские","Иномарки"))
                .searchClickedAutomatically(true)
                .build();
        searchSteps.searchByCriteria(searchCriteria);
    }

    @Test
    @Description("Search for a specific Make and Model using search windows, e.g. Mercedes Citan")
    public void searchForSpecificMakeAndModel () {
        SearchCriteria searchCriteria = SearchCriteria.builder()
                .make(new Make("Mercedes-Benz",""))
                .models(new ArrayList(Arrays.asList(
                new Model(Models.CITAN,""))))
                .build();
        searchSteps.searchByCriteriaUsingSearch(searchCriteria);
    }
}