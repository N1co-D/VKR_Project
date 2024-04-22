package selenide.junit.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.ex.UIAssertionError;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.fail;

public class DigitalDepartmentPage extends BasePage {
    private final String pageLogo = "//img[@class='priority']";
    private final String learningConditionsSection = "//section[@id='terms']";
    private final String freePrograms = "//a[text()='бесплатные программы']";
    private final String programListSection = "//section[@id='programs-list']";
    private final String internetOfThingsTechnologiesButton = "//a[@class='programs-link' and contains(text(),'Технологии интернета вещей')]";//todo

    @Step("Открытие страницы 'Приоритет 2030'")
    public DigitalDepartmentPage checkIfCorrectPageOpen() {
        try {
            $x(pageLogo).should(visible, WAITING_TIME);
        } catch (UIAssertionError e) {
            makeScreenshot();
            fail("Не удалось подтвердить открытие ожидаемой страницы. " +
                    "Уникальный элемент страницы 'pageLogo' не был найден в течение заданного времени.");
        }
        makeScreenshot();
        return this;
    }

    @Step("Открытие бесплатных программ")
    public DigitalDepartmentPage freeProgramsButtonClick() {
        $x(learningConditionsSection).scrollTo();
        jsClick($x(freePrograms));
        Selenide.sleep(2000);
        makeScreenshot();
        return this;
    }

    @Step("Открытие программы 'Технологии интернета вещей'")
    public DigitalDepartmentPage internetOfThingsTechnologiesButtonClick() {
        $x(programListSection).scrollTo();
        Selenide.sleep(2000);
        jsClick($x(internetOfThingsTechnologiesButton));
        Selenide.sleep(2000);
        makeScreenshot();
        return this;
    }
}