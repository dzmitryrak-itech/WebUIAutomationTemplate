package auto.ru.tests;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class AutoRuSampleTest extends BaseTest{

    @Test
    @Description("Search for a make")
    public void basicTest () {
        //Переходим в меню выбора марки
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//android.widget.TextView[contains(@text, 'Выбрать марку и модель')]"))).click();

        //Переходим в конкретную марку
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//android.widget.TextView[contains(@text, 'Audi')]"))).click();

        //Переходим в конкретную модель, берем второго родителя (деда) элемента и тыкаем в чекбокс
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//android.widget.TextView[contains(@text, 'A3')]/../../android.widget.CheckBox"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//android.widget.TextView[contains(@text, 'A4')]/../../android.widget.CheckBox"))).click();

        //Ищем
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("ru.auto.ara:id/do_search_btn"))).click();

        //Ждем элемент
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("ru.auto.ara:id/snippetContainer"))).click();
    }
}