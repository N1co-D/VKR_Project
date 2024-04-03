package pages;

import com.codeborne.selenide.ex.UIAssertionError;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.fail;

public class PriorityPage extends BasePage {
    private final String pageLogo = "//a[@class='logo-priority']";//todo
    private final String digitalDepartmentButton = "//a[text()='Подробнее']";//todo

    @Step("Открытие страницы авторизации") //todo
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

    @Step("Ввод данных пользователя: электронная почта и пароль")//todo
    public PriorityPage digitalDepartmentButtonClick() {
        jsClick($x(digitalDepartmentButton));
        return this;
    }
}
