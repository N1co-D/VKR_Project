package selenide.junit.pages;

import com.codeborne.selenide.ex.UIAssertionError;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.fail;

public class ScientificConferencesPage extends BasePage {
    private final String pageTitle = "//h3[@class='title']//span[text()='Научные конференции']";
    private final String planOfScientificEvents = "//a[contains(@title,'План научных мероприятий')]";

    @Step("Открытие страницы 'Научные конференции'")
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

    @Step("Скачивание файла {fileName}")
    public ScientificConferencesPage planOfScientificEventsClick(String fileName) {
        File report = $x(planOfScientificEvents).download();
        checkIfFileExist(fileName);
        return this;
    }
}