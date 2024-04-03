package pages;

import com.codeborne.selenide.ex.UIAssertionError;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;
import static org.junit.jupiter.api.Assertions.fail;

public class AdvancedEngineeringSchoolPage extends BasePage {
    private final String pageTitle = "//a[@class='pish-logo']";//todo
    private final String educationModule = "//a[normalize-space(text())='Образование']";//todo
    private final String masterDegreeSection = "//a[@id='magistracy']";//todo
    private final String automatedDispatchControlSystemsProgram = "//h3[text()='Автоматизированные системы диспетчерского управления']";//todo
    private final String programDetails = "//h3[text()='Автоматизированные системы диспетчерского управления']/..//a[normalize-space(text())='Подробности']";//todo

    @Step("Открытие страницы авторизации") //todo
    public AdvancedEngineeringSchoolPage checkIfCorrectPageOpen() {
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
    public AdvancedEngineeringSchoolPage educationModuleClick() {
        jsClick($x(educationModule));
        return this;
    }

    @Step("Ввод данных пользователя: электронная почта и пароль")//todo
    public AdvancedEngineeringSchoolPage masterDegreeSectionClick() {
        jsClick($x(masterDegreeSection));
        return this;
    }

    @Step("Ввод данных пользователя: электронная почта и пароль")//todo
    public AdvancedEngineeringSchoolPage programDetailsClick() {
        actions().moveToElement($x(automatedDispatchControlSystemsProgram)).perform();
        jsClick($x(programDetails));
        return this;
    }
}
