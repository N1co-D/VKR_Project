package pages;

import com.codeborne.selenide.ex.UIAssertionError;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class AitPage extends BasePage {
    private final String pageTitle = "//h3[@class='title']/span[text()='Автоматизация и интеллектуальные технологии']";//todo
    private final String email = "//a[@itemprop='e-mail']";//todo

    @Step("Открытие страницы авторизации") //todo
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

    @Step("Ввод данных пользователя: электронная почта и пароль")//todo
    private String getEmail() {
        return $x(email).should(visible, WAITING_TIME)
                .getText();
    }

    public AitPage checkEmail(String expectedEmail) { //todo
        String currentEmail = getEmail();
        assertEquals(expectedEmail, currentEmail,
                String.format("Фактическое имя пары = %s " +
                                " не соответствует ожидаемой = %s",
                        currentEmail,
                        expectedEmail));
        return this;
    }
}