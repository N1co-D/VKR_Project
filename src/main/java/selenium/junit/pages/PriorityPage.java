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
import static org.junit.jupiter.api.Assertions.fail;
import static selenium.junit.utilites.DriverSingleton.MANAGER;

public class PriorityPage extends BasePage {
    private final By pageLogo = By.xpath("//a[@class='logo-priority']");
    private final By digitalDepartmentButton = By.xpath("//a[text()='Подробнее']");
    private final WebDriverWait webDriverWait = new WebDriverWait(MANAGER.getDriver(), Duration.ofSeconds(10));

    @Step("Открытие страницы 'Приоритет 2030'")
    public PriorityPage checkIfCorrectPageOpen() {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(pageLogo));
        } catch (NoSuchElementException noSuchElementException) {
            makeScreenshot();
            fail("Не удалось подтвердить открытие ожидаемой страницы. " +
                    "Уникальный элемент страницы 'pageLogo' не был найден в течение заданного времени.");
        }
        makeScreenshot();
        return this;
    }

    @Step("Выбор раздела 'Цифровая кафедра'")
    public PriorityPage digitalDepartmentButtonClick() {
        jsClick(webDriverWait.until(ExpectedConditions.elementToBeClickable(digitalDepartmentButton)));
        return this;
    }
}
//    private final String pageLogo = "//a[@class='logo-priority']";
//    private final String digitalDepartmentButton = "//a[text()='Подробнее']";
//
//    @Step("Открытие страницы 'Приоритет 2030'")
//    public PriorityPage checkIfCorrectPageOpen() {
//        try {
//            $x(pageLogo).should(visible, WAITING_TIME);
//        } catch (UIAssertionError e) {
//            makeScreenshot();
//            fail("Не удалось подтвердить открытие ожидаемой страницы. " +
//                    "Уникальный элемент страницы 'pageLogo' не был найден в течение заданного времени.");
//        }
//        makeScreenshot();
//        return this;
//    }
//
//    @Step("Выбор раздела 'Цифровая кафедра'")
//    public PriorityPage digitalDepartmentButtonClick() {
//        jsClick($x(digitalDepartmentButton));
//        return this;
//    }
//}