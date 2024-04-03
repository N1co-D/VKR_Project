package pages;

import com.codeborne.selenide.ex.UIAssertionError;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.fail;

public class FacultyContactsPage extends BasePage{
    private final String pageTitle = "//h3[@class='title']/span[text()='Контакты факультетов']";//todo
    private final String aitModule  = "//span[text()='Контакты факультетов']/../following-sibling::address//a[text()='Автоматизация и интеллектуальные технологии']";//todo

    @Step("Открытие страницы авторизации") //todo
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

    @Step("Ввод данных пользователя: электронная почта и пароль")//todo
    public FacultyContactsPage aitModuleClick() {
        jsClick($x(aitModule));
        return this;
    }
}