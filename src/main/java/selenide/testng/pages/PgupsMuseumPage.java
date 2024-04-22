package selenide.testng.pages;

import com.codeborne.selenide.ex.UIAssertionError;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.testng.Assert.fail;

public class PgupsMuseumPage extends BasePage {
    private final String pageTitle = "//h3[@class='title']/span[text()='Музей ПГУПС']";
    private final String applicationForGuidedTour = "//a[text()='Заявка на проведение экскурсии']";

    @Step("Открытие страницы музея ПГУПС")
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

    @Step("Скачивание файла {fileName}")
    public PgupsMuseumPage applicationForGuidedTourClick(String fileName) {
        File report = $x(applicationForGuidedTour).download();
        checkIfFileExist(fileName);
        return this;
    }
}