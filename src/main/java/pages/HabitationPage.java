package pages;

import com.codeborne.selenide.ex.UIAssertionError;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class HabitationPage extends BasePage {
    private final String pageTitle = "//span[text()='Проживание в общежитии']";
    private final String dormitory = "//a[contains(text(),'Общежитие № %s')]";
    private final String dormitoryAddress = "//i[contains(@class,'map')]/../following-sibling::div";

    @Step("Открытие страницы авторизации")
    public HabitationPage checkIfCorrectPageOpen() {
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
    public HabitationPage dormitoryClick(String dormitoryNumber) {
        jsClick($x(String.format(dormitory, dormitoryNumber)));
        makeScreenshot();
        return this;
    }

    @Step("Ввод данных пользователя: электронная почта и пароль")//todo
    private String getDormitoryAddress() {
        return $x(dormitoryAddress).should(visible, WAITING_TIME)
                .getText();
    }

    public HabitationPage checkDormitoryAddress(String expectedDormitoryAddress) { //todo
        String dormitoryAddress = getDormitoryAddress();
        assertEquals(expectedDormitoryAddress, dormitoryAddress,
                String.format("Фактический адрес = %s " +
                                " не соответствует ожидаемому = %s",
                        dormitoryAddress,
                        expectedDormitoryAddress));
        return this;
    }
}
