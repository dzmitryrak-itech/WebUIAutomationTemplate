package auto.ru.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FooterToolBar extends BasePage{

    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView[@resource-id='ru.auto.ara:id/lTab']//android.support.v7.app.ActionBar.Tab[1]")
    private MobileElement searchIcon;

    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView[@resource-id='ru.auto.ara:id/lTab']//android.support.v7.app.ActionBar.Tab[2]")
    private MobileElement bookmarksIcon;

    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView[@resource-id='ru.auto.ara:id/lTab']//android.support.v7.app.ActionBar.Tab[3]")
    private MobileElement advertisementsIcon;

    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView[@resource-id='ru.auto.ara:id/lTab']//android.support.v7.app.ActionBar.Tab[4]")
    private MobileElement messagesIcon;

    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView[@resource-id='ru.auto.ara:id/lTab']//android.support.v7.app.ActionBar.Tab[5]")
    private MobileElement moreIcon;

    public FooterToolBar(AppiumDriver<MobileElement> driver){
        super(driver);
        initElements(this);
    }

    public FooterToolBar navigateToAllTabs(){
        searchIcon.click();
        bookmarksIcon.click();
        advertisementsIcon.click();
        messagesIcon.click();
        moreIcon.click();
        return this;
    }
}
