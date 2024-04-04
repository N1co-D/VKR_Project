package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.ex.UIAssertionError;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.fail;

public class ScientificConferencesPage extends BasePage {
    private final String pageTitle = "//h3[@class='title']//span[text()='Научные конференции']";//todo
    private final String planOfScientificEvents = "//a[contains(@title,'План научных мероприятий')]";//todo

    @Step("Открытие страницы авторизации") //todo
    public ScientificConferencesPage checkIfCorrectPageOpen() {
        try {
            $x(pageTitle).should(visible, WAITING_TIME);
        } catch (UIAssertionError e) {
            makeScreenshot();
            fail("Не удалось подтвердить открытие ожидаемой страницы. " +
                    "Уникальный элемент страницы 'pageTitle' не был найден в течение заданного времени.");
        }
        makeScreenshot();
        return this;
    }

    @Step("Ввод данных пользователя: электронная почта и пароль")//todo
    public ScientificConferencesPage planOfScientificEventsClick() {
        File report = $x(planOfScientificEvents).download();
        return this;
    }
}
