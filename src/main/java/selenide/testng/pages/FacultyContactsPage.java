package selenide.testng.pages;

import com.codeborne.selenide.ex.UIAssertionError;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.testng.Assert.fail;

public class FacultyContactsPage extends BasePage {
    private final String pageTitle = "//h3[@class='title']/span[text()='Контакты факультетов']";
    private final String aitModule = "//span[text()='Контакты факультетов']/../following-sibling::address//a[text()='Автоматизация и интеллектуальные технологии']";

    @Step("Открытие страницы 'Контакты факультетов'")
    public FacultyContactsPage checkIfCorrectPageOpen() {
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

    public FacultyContactsPage aitModuleClick() {
        jsClick($x(aitModule));
        return this;
    }
}