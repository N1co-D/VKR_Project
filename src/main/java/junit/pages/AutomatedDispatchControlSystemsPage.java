package junit.pages;

import com.codeborne.selenide.ex.UIAssertionError;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class AutomatedDispatchControlSystemsPage extends BasePage {
    private final String pageTitle = "//h1[text()='Автоматизированные системы диспетчерского управления']";
    private final String startDate = "//p[@class='edu-start-date']/span";

    @Step("Открытие страницы 'Автоматизированные системы диспетчерского управления'")
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

    private String getStartDate() {
        return $x(startDate).should(visible, WAITING_TIME)
                .getText();
    }

    @Step("Сравнение фактической даты начала программы с ожидаемой = {expectedStartDate}")
    public AutomatedDispatchControlSystemsPage checkStartDate(String expectedStartDate) {
        String currentStartDate = getStartDate();
        assertEquals(expectedStartDate, currentStartDate,
                String.format("Фактическое имя пары = %s " +
                                " не соответствует ожидаемой = %s",
                        currentStartDate,
                        expectedStartDate));
        return this;
    }
}