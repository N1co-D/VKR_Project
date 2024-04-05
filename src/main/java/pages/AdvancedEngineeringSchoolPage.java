package pages;

import com.codeborne.selenide.ex.UIAssertionError;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;
import static org.junit.jupiter.api.Assertions.fail;

public class AdvancedEngineeringSchoolPage extends BasePage {
    private final String pageTitle = "//a[@class='pish-logo']";
    private final String educationModule = "//a[normalize-space(text())='Образование']";
    private final String masterDegreeSection = "//a[@id='magistracy']";
    private final String automatedDispatchControlSystemsProgram = "//h3[text()='Автоматизированные системы диспетчерского управления']";
    private final String programDetails = "//h3[text()='Автоматизированные системы диспетчерского управления']/..//a[normalize-space(text())='Подробности']";

    @Step("Открытие страницы 'ПИШ'")
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

    @Step("Открытие модуля 'Образование'")
    public AdvancedEngineeringSchoolPage educationModuleClick() {
        jsClick($x(educationModule));
        makeScreenshot();
        return this;
    }

    @Step("Открытие раздела 'Магистратура'")
    public AdvancedEngineeringSchoolPage masterDegreeSectionClick() {
        jsClick($x(masterDegreeSection));
        makeScreenshot();
        return this;
    }

    @Step("Открытие подробностей программы 'Автоматизированные системы диспетчерского управления'")
    public AdvancedEngineeringSchoolPage programDetailsClick() {
        actions().moveToElement($x(automatedDispatchControlSystemsProgram)).perform();
        jsClick($x(programDetails));
        return this;
    }
}