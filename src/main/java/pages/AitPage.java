package pages;

import com.codeborne.selenide.ex.UIAssertionError;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class AitPage extends BasePage {
    private final String pageTitle = "//h3[@class='title']/span[text()='Автоматизация и интеллектуальные технологии']";
    private final String email = "//a[@itemprop='e-mail']";

    @Step("Открытие страницы факультета 'АИТ'")
    public AitPage checkIfCorrectPageOpen() {
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

    private String getEmail() {
        return $x(email).should(visible, WAITING_TIME)
                .getText();
    }

    @Step("Сравнение фактической электронной почты с ожидаемой = {expectedEmail}")
    public AitPage checkEmail(String expectedEmail) {
        String currentEmail = getEmail();
        assertEquals(expectedEmail, currentEmail,
                String.format("Фактическое имя пары = %s " +
                                " не соответствует ожидаемой = %s",
                        currentEmail,
                        expectedEmail));
        return this;
    }
}