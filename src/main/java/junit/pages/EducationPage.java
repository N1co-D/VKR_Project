package junit.pages;

import com.codeborne.selenide.ex.UIAssertionError;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.fail;

public class EducationPage extends BasePage {
    private final String pageTitle = "//h3[@class='title']/span[text()='Образование']";
    private final String masterDegreeProgramsDescriptions = "//h4[contains(text(),'реализуемых уровнях образования')]//following-sibling::div[@class='no-green-toggler']//a[text()='Магистратура']";
    private final String informationSystemsAndTechnologiesInTransportProgram = "//span[text()='Информационные системы и технологии на транспорте']";
    private final String informationSystemsAndTechnologiesInTransportEducationPlan = "//h7[text()=' Информационные системы и технологии']/ancestor::div[contains(@class,'education_card')]//td[text()='%s']/../td[@itemprop='educationPlan']/a[1]";

    @Step("Открытие страницы 'Образование'")
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

    @Step("Выбор раздела 'Магистратура'")
    public EducationPage masterDegreeProgramsDescriptionsClick() {
        jsClick($x(masterDegreeProgramsDescriptions));
        makeScreenshot();
        return this;
    }

    @Step("Выбор раздела 'Информационные системы и технологии на транспорте'")
    public EducationPage informationSystemsAndTechnologiesInTransportProgramClick() {
        $x(informationSystemsAndTechnologiesInTransportProgram).scrollTo();
        jsClick($x(informationSystemsAndTechnologiesInTransportProgram));
        makeScreenshot();
        return this;
    }

    @Step("Скачивание файла {fileName} в соответствии с годом = {year}")//todo
    public EducationPage informationSystemsAndTechnologiesInTransportEducationPlanClick(String year, String fileName) {
        File report = $x(String.format(informationSystemsAndTechnologiesInTransportEducationPlan, year)).download();
        checkIfFileExist(fileName);
        return this;
    }
}