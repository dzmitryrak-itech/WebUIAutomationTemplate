package auto.ru.tests;

import auto.ru.model.Make;
import auto.ru.model.Model;
import auto.ru.model.Models;
import auto.ru.model.SearchCriteria;
import auto.ru.pageobjects.*;
import io.qameta.allure.Description;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Arrays;

public class AutoRuOtherTests extends BaseTest {

    @Parameters(value={"deviceName","udid", "platform", "version"})
    @BeforeClass
    public void setupDeviceParameters (@Optional("Pixel_2_Android_9") String deviceName, @Optional("emulator-5554") String udid,
                            @Optional("Android") String platform,@Optional("9.0") String version) {
        setCustomCapabilities(deviceName, udid, platform, version);
    }

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
    @Description("Search for All models of specific make")
    public void searchForAllModels () {
        SearchCriteria searchCriteria = SearchCriteria.builder()
                .make(new Make("Mercedes-Benz",""))
                .models(new ArrayList(Arrays.asList(
                        new Model(Models.ALL,""))))
                .build();
        searchSteps.searchByCriteria(searchCriteria);
    }
}