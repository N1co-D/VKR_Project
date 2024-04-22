package selenide.testng.pages;

import com.codeborne.selenide.ex.UIAssertionError;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.testng.Assert.fail;

public class PriorityPage extends BasePage {
    private final String pageLogo = "//a[@class='logo-priority']";
    private final String digitalDepartmentButton = "//a[text()='Подробнее']";

    @Step("Открытие страницы 'Приоритет 2030'")
    public PriorityPage checkIfCorrectPageOpen() {
        try {
            $x(pageLogo).should(visible, WAITING_TIME);
        } catch (UIAssertionError e) {
            makeScreenshot();
            fail("Не удалось подтвердить открытие ожидаемой страницы. " +
                    "Уникальный элемент страницы 'pageLogo' не был найден в течение заданного времени.");
        }
        makeScreenshot();
        return this;
    }

    @Step("Выбор раздела 'Цифровая кафедра'")
    public PriorityPage digitalDepartmentButtonClick() {
        jsClick($x(digitalDepartmentButton));
        return this;
    }
}