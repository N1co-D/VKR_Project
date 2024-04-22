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

public class FacultyContactsPage extends BasePage {
    private final By pageTitle = By.xpath("//h3[@class='title']/span[text()='Контакты факультетов']");
    private final By aitModule = By.xpath("//span[text()='Контакты факультетов']/../following-sibling::address//a[text()='Автоматизация и интеллектуальные технологии']");
    private final WebDriverWait webDriverWait = new WebDriverWait(MANAGER.getDriver(), Duration.ofSeconds(10));

    @Step("Открытие страницы 'Контакты факультетов'")
    public FacultyContactsPage checkIfCorrectPageOpen() {
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

    @Step("Клик по модулю 'Автоматизация и интеллектуальные технологии'")
    public FacultyContactsPage aitModuleClick() {
        jsClick(webDriverWait.until(ExpectedConditions.elementToBeClickable(aitModule)));
        return this;
    }
}
//    private final String pageTitle = "//h3[@class='title']/span[text()='Контакты факультетов']";
//    private final String aitModule = "//span[text()='Контакты факультетов']/../following-sibling::address//a[text()='Автоматизация и интеллектуальные технологии']";
//
//    @Step("Открытие страницы 'Контакты факультетов'")
//    public FacultyContactsPage checkIfCorrectPageOpen() {
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
//    public FacultyContactsPage aitModuleClick() {
//        jsClick($x(aitModule));
//        return this;
//    }
//}