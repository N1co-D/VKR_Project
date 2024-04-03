package pages;

import com.codeborne.selenide.ex.UIAssertionError;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class AutomatedDispatchControlSystemsPage extends BasePage {
    private final String pageTitle = "//h1[text()='Автоматизированные системы диспетчерского управления']";//todo
    private final String startDate = "//p[@class='edu-start-date']/span";//todo

    public AutomatedDispatchControlSystemsPage checkIfCorrectPageOpen() {
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
    private String getStartDate() {
        return $x(startDate).should(visible, WAITING_TIME)
                .getText();
    }

    public AutomatedDispatchControlSystemsPage checkStartDate(String expectedStartDate) { //todo
        String currentStartDate = getStartDate();
        assertEquals(expectedStartDate, currentStartDate,
                String.format("Фактическое имя пары = %s " +
                                " не соответствует ожидаемой = %s",
                        currentStartDate,
                        expectedStartDate));
        return this;
    }
}
