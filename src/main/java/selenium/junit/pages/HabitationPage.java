package selenium.junit.pages;

import com.codeborne.selenide.ex.UIAssertionError;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static selenium.junit.utilites.DriverSingleton.MANAGER;

public class HabitationPage extends BasePage {
    private final By pageTitle = By.xpath("//span[text()='Проживание в общежитии']");
    private final String dormitory = "//a[contains(text(),'Общежитие № %s')]";
    private final By dormitoryAddress = By.xpath("//i[contains(@class,'map')]/../following-sibling::div");
    private final WebDriverWait webDriverWait = new WebDriverWait(MANAGER.getDriver(), Duration.ofSeconds(10));

    @Step("Открытие страницы 'Проживание в общежитии'")
    public HabitationPage checkIfCorrectPageOpen() {
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

    @Step("Выбор общежития по номеру = {dormitoryNumber}")
    public HabitationPage dormitoryClick(String dormitoryNumber) {
        By dormitoryLocator = By.xpath(String.format(dormitory, dormitoryNumber));
        jsClick(webDriverWait.until(ExpectedConditions.elementToBeClickable(dormitoryLocator)));
        makeScreenshot();
        return this;
    }

    private String getDormitoryAddress() {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(dormitoryAddress))
                .getText();
    }

    @Step("Сравнение фактического адреса общежития в сравнении с ожидаемым = {expectedDormitoryAddress}")
    public HabitationPage checkDormitoryAddress(String expectedDormitoryAddress) {
        String dormitoryAddress = getDormitoryAddress();
        assertEquals(expectedDormitoryAddress, dormitoryAddress,
                String.format("Фактический адрес = %s " +
                                " не соответствует ожидаемому = %s",
                        dormitoryAddress,
                        expectedDormitoryAddress));
        return this;
    }
}
//    private final String pageTitle = "//span[text()='Проживание в общежитии']";
//    private final String dormitory = "//a[contains(text(),'Общежитие № %s')]";
//    private final String dormitoryAddress = "//i[contains(@class,'map')]/../following-sibling::div";
//
//    @Step("Открытие страницы 'Проживание в общежитии'")
//    public HabitationPage checkIfCorrectPageOpen() {
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
//    @Step("Выбор общежития по номеру = {dormitoryNumber}")
//    public HabitationPage dormitoryClick(String dormitoryNumber) {
//        jsClick($x(String.format(dormitory, dormitoryNumber)));
//        makeScreenshot();
//        return this;
//    }
//
//    private String getDormitoryAddress() {
//        return $x(dormitoryAddress).should(visible, WAITING_TIME)
//                .getText();
//    }
//
//    @Step("Сравнение фактического адреса общежития в сравнении с ожидаемым = {expectedDormitoryAddress}")
//    public HabitationPage checkDormitoryAddress(String expectedDormitoryAddress) {
//        String dormitoryAddress = getDormitoryAddress();
//        assertEquals(expectedDormitoryAddress, dormitoryAddress,
//                String.format("Фактический адрес = %s " +
//                                " не соответствует ожидаемому = %s",
//                        dormitoryAddress,
//                        expectedDormitoryAddress));
//        return this;
//    }
//}