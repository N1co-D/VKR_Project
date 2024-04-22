package selenium.junit.pages;

import com.codeborne.selenide.ex.UIAssertionError;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static selenium.junit.utilites.DriverSingleton.MANAGER;

public class PgupsMuseumPage extends BasePage {
    private final By pageTitle = By.xpath("//h3[@class='title']/span[text()='Музей ПГУПС']");
    private final By applicationForGuidedTour = By.xpath("//a[text()='Заявка на проведение экскурсии']");
    private final WebDriverWait webDriverWait = new WebDriverWait(MANAGER.getDriver(), Duration.ofSeconds(10));

    @Step("Открытие страницы музея ПГУПС")
    public PgupsMuseumPage checkIfCorrectPageOpen() {
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

    @Step("Скачивание файла {fileName}")
    public PgupsMuseumPage applicationForGuidedTourClick(String expectedUrl) {
        WebElement report = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(applicationForGuidedTour));
        MANAGER.getDriver().navigate().to(report.getAttribute("href"));
        assertEquals(MANAGER.getDriver().getCurrentUrl(), expectedUrl);
        return this;
    }
}
//    private final String pageTitle = "//h3[@class='title']/span[text()='Музей ПГУПС']";
//    private final String applicationForGuidedTour = "//a[text()='Заявка на проведение экскурсии']";
//
//    @Step("Открытие страницы музея ПГУПС")
//    public PgupsMuseumPage checkIfCorrectPageOpen() {
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
//    @Step("Скачивание файла {fileName}")
//    public PgupsMuseumPage applicationForGuidedTourClick(String fileName) {
//        File report = $x(applicationForGuidedTour).download();
//        checkIfFileExist(fileName);
//        return this;
//    }
//}