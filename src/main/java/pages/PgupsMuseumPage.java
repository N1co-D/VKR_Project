package pages;

import com.codeborne.selenide.ex.UIAssertionError;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.fail;

public class PgupsMuseumPage extends BasePage {
    private final String pageTitle = "//h3[@class='title']/span[text()='Музей ПГУПС']";//todo
    private final String applicationForGuidedTour = "//a[text()='Заявка на проведение экскурсии']";//todo

    @Step("Открытие страницы авторизации") //todo
    public PgupsMuseumPage checkIfCorrectPageOpen() {
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
    public PgupsMuseumPage planOfScientificEventsClick() {
        File report = $x(applicationForGuidedTour).download();
        return this;
    }
}