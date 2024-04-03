package pages;

import com.codeborne.selenide.ex.UIAssertionError;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Страница "Расписание"
 */
public class SchedulePage extends BasePage {
    private final String scheduleLogo = "//div[@id='kt_header_menu_wrapper']//span[contains(text(),'Расписание')]";
    private final String inputBox = "//div[contains(@class,'d-md-block')]//input[@class='form-control']";
    private final String resultGroup = "//a[contains(text(),'%s')]";//todo
    private final String pairName = "//tr[td/h4[contains(., '%s')] and td[contains(., '%s пара')]]/td[@class='align-middle']//span[@class='mr-1']";//todo

    @Step("Открытие страницы авторизации") //todo
    public SchedulePage checkIfCorrectPageOpen() {
        try {
            $x(scheduleLogo).should(visible, WAITING_TIME);
        } catch (UIAssertionError e) {
            makeScreenshot();
            fail("Не удалось подтвердить открытие ожидаемой страницы. " +
                    "Уникальный элемент страницы 'scheduleLogo' не был найден в течение заданного времени.");
        }
        makeScreenshot();
        return this;
    }

    @Step("Ввод данных пользователя: электронная почта и пароль")//todo
    public SchedulePage searchByGroup(String searchedText) {
        jsClick($x(inputBox));
        $x(inputBox).sendKeys(searchedText);
        $x(inputBox).should(visible, WAITING_TIME)
                .pressEnter();
        makeScreenshot();
        return this;
    }

    @Step("Ввод данных пользователя: электронная почта и пароль")//todo
    public SchedulePage resultGroupClick(String searchedGroup) {
        jsClick($x(String.format(resultGroup, searchedGroup)));
        makeScreenshot();
        return this;
    }

    @Step("Ввод данных пользователя: электронная почта и пароль")//todo
    private String getPairName(String dayOfWeek, String pairNumber) {
        return $x(String.format(pairName, dayOfWeek, pairNumber)).should(visible, WAITING_TIME)
                .getText();
    }

    public SchedulePage checkPairName(String dayOfWeek, String pairNumber, String expectedPairtName) { //todo
        String currentPairName = getPairName(dayOfWeek, pairNumber);
        assertEquals(expectedPairtName, currentPairName,
                String.format("Фактическое имя пары = %s " +
                                " не соответствует ожидаемой = %s",
                        currentPairName,
                        expectedPairtName));
        return this;
    }
}
