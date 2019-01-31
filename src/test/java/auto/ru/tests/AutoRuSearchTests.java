package auto.ru.tests;

import auto.ru.model.Make;
import auto.ru.model.Model;
import auto.ru.model.Models;
import auto.ru.model.SearchCriteria;
import io.qameta.allure.Description;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://interworks.com.mk/selenium-grid-for-mobile-automated-testing-with-appium-part-i/
 */
public class AutoRuSearchTests extends BaseTest {

    @Parameters(value={"deviceName","udid", "platform", "version"})
    @BeforeClass
    public void setupDeviceParameters (@Optional("Pixel_2_Android_9") String deviceName, @Optional("emulator-5554") String udid,
                            @Optional("Android") String platform,@Optional("9.0") String version) {
        setCustomCapabilities(deviceName, udid, platform, version);
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