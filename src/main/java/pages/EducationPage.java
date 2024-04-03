package pages;

import com.codeborne.selenide.ex.UIAssertionError;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.fail;

public class EducationPage extends BasePage {
    private final String pageTitle = "//h3[@class='title']/span[text()='Образование']";//todo
    private final String masterDegreeProgramsDescriptions  = "//h4[contains(text(),'реализуемых уровнях образования')]//following-sibling::div[@class='no-green-toggler']//a[text()='Магистратура']";//todo
    private final String informationSystemsAndTechnologiesInTransportProgram = "//span[text()='Информационные системы и технологии на транспорте']";//todo
    private final String informationSystemsAndTechnologiesInTransportEducationPlan = "//h7[text()=' Информационные системы и технологии']/ancestor::div[contains(@class,'education_card')]//td[text()='%s']/../td[@itemprop='educationPlan']/a[1]";//todo

    @Step("Открытие страницы авторизации") //todo
    public EducationPage checkIfCorrectPageOpen() {
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
    public EducationPage masterDegreeProgramsDescriptionsClick() {
        jsClick($x(masterDegreeProgramsDescriptions));
        makeScreenshot();
        return this;
    }

    @Step("Ввод данных пользователя: электронная почта и пароль")//todo
    public EducationPage informationSystemsAndTechnologiesInTransportProgramClick() {
        jsClick($x(informationSystemsAndTechnologiesInTransportProgram));
        makeScreenshot();
        return this;
    }

    @Step("Ввод данных пользователя: электронная почта и пароль")//todo
    public EducationPage informationSystemsAndTechnologiesInTransportEducationPlanClick(String year) {
        jsClick($x(String.format(informationSystemsAndTechnologiesInTransportEducationPlan, year)));
        makeScreenshot();
        return this;
    }
}
