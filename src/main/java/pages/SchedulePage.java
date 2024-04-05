package pages;

import com.codeborne.selenide.ex.UIAssertionError;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Страница "Расписание"
 */
public class SchedulePage extends BasePage {
    private final String scheduleLogo = "//div[@id='kt_header_menu_wrapper']//span[contains(text(),'Расписание')]";
    private final String inputBox = "//div[contains(@class,'d-md-block')]//input[@class='form-control']";
    private final String resultGroup = "//a[contains(text(),'%s')]";
    private final String pairName = "//tr[td/h4[contains(., '%s')] and td[contains(., '%s пара')]]/td[@class='align-middle']//span[@class='mr-1']";

    @Step("Открытие страницы расписания")
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

    @Step("Поиск по группе = {searchedText} через текстовое поле")
    public SchedulePage searchByGroup(String searchedText) {
        jsClick($x(inputBox));
        $x(inputBox).sendKeys(searchedText);
        $x(inputBox).should(visible, WAITING_TIME)
                .pressEnter();
        return this;
    }

    @Step("Выбор группы = {searchedGroup} из результатов поиска")
    public SchedulePage resultGroupClick(String searchedGroup) {
        jsClick($x(String.format(resultGroup, searchedGroup)));
        makeScreenshot();
        return this;
    }

    private String getPairName(String dayOfWeek, String pairNumber) {
        return $x(String.format(pairName, dayOfWeek, pairNumber)).should(visible, WAITING_TIME)
                .getText();
    }

    @Step("Сравнение фактического имени пары по дню недели = {dayOfWeek} и порядку = {pairNumber} с ожидаемым = {expectedPairName}")
    public SchedulePage checkPairName(String dayOfWeek, String pairNumber, String expectedPairName) {
        String currentPairName = getPairName(dayOfWeek, pairNumber);
        assertEquals(expectedPairName, currentPairName,
                String.format("Фактическое имя пары = %s " +
                                " не соответствует ожидаемой = %s",
                        currentPairName,
                        expectedPairName));
        return this;
    }
}