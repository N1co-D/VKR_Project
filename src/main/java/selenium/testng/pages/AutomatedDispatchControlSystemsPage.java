package selenium.testng.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import static selenium.testng.utilites.DriverSingleton.MANAGER;

public class AutomatedDispatchControlSystemsPage extends BasePage {
    private final By pageTitle = By.xpath("//h1[text()='Автоматизированные системы диспетчерского управления']");
    private final By startDate = By.xpath("//p[@class='edu-start-date']/span");
    private final WebDriverWait webDriverWait = new WebDriverWait(MANAGER.getDriver(), Duration.ofSeconds(10));

    @Step("Открытие страницы 'Автоматизированные системы диспетчерского управления'")
    public AutomatedDispatchControlSystemsPage checkIfCorrectPageOpen() {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
        } catch (NoSuchElementException noSuchElementException) {
            makeScreenshot();
            fail("Не удалось подтвердить открытие ожидаемой страницы. " +
                    "Уникальный элемент страницы 'pageTitle' не был найден в течение заданного времени.");
        }
        makeScreenshot();
        return this;
    }

    private String getStartDate() {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(startDate))
                .getText();
    }

    @Step("Сравнение фактической даты начала программы с ожидаемой = {expectedStartDate}")
    public AutomatedDispatchControlSystemsPage checkStartDate(String expectedStartDate) {
        String currentStartDate = getStartDate();
        assertEquals(expectedStartDate, currentStartDate,
                String.format("Фактическая дата начала программы = %s " +
                                "не соответствует ожидаемой = %s",
                        currentStartDate,
                        expectedStartDate));
        return this;
    }
}
//    private final String pageTitle = "//h1[text()='Автоматизированные системы диспетчерского управления']";
//    private final String startDate = "//p[@class='edu-start-date']/span";
//
//    @Step("Открытие страницы 'Автоматизированные системы диспетчерского управления'")
//    public AutomatedDispatchControlSystemsPage checkIfCorrectPageOpen() {
//        try {
//            $x(pageTitle).should(visible, WAITING_TIME);
//        } catch (UIAssertionError e) {
//            makeScreenshot();
//            fail("Не удалось подтвердить открытие ожидаемой страницы. " +
//                    "Уникальный элемент страницы 'pageTitle' не был найден в течение заданного времени.");
//        }
//        makeScreenshot();
//        return this;
//    }
//
//    private String getStartDate() {
//        return $x(startDate).should(visible, WAITING_TIME)
//                .getText();
//    }
//
//    @Step("Сравнение фактической даты начала программы с ожидаемой = {expectedStartDate}")
//    public AutomatedDispatchControlSystemsPage checkStartDate(String expectedStartDate) {
//        String currentStartDate = getStartDate();
//        assertEquals(expectedStartDate, currentStartDate,
//                String.format("Фактическое имя пары = %s " +
//                                " не соответствует ожидаемой = %s",
//                        currentStartDate,
//                        expectedStartDate));
//        return this;
//    }
//}