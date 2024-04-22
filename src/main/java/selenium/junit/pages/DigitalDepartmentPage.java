package selenium.junit.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.ex.UIAssertionError;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.fail;
import static selenium.junit.utilites.DriverSingleton.MANAGER;

public class DigitalDepartmentPage extends BasePage {
    private final By pageLogo = By.xpath("//img[@class='priority']");
    private final By learningConditionsSection = By.xpath("//section[@id='terms']");
    private final By freePrograms = By.xpath("//a[text()='бесплатные программы']");
    private final By programListSection = By.xpath("//section[@id='programs-list']");
    private final By internetOfThingsTechnologiesButton = By.xpath("//a[@class='programs-link' and contains(text(),'Технологии интернета вещей')]");
    private final WebDriverWait webDriverWait = new WebDriverWait(MANAGER.getDriver(), Duration.ofSeconds(10));

    @Step("Открытие страницы 'Приоритет 2030'")
    public DigitalDepartmentPage checkIfCorrectPageOpen() {
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

    @Step("Открытие бесплатных программ")
    public DigitalDepartmentPage freeProgramsButtonClick() {
        WebElement section = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(learningConditionsSection));
        ((JavascriptExecutor) MANAGER.getDriver()).executeScript("arguments[0].scrollIntoView(true);", section);
        jsClick(webDriverWait.until(ExpectedConditions.elementToBeClickable(freePrograms)));
        makeScreenshot();
        return this;
    }

    @Step("Открытие программы 'Технологии интернета вещей'")
    public DigitalDepartmentPage internetOfThingsTechnologiesButtonClick() {
        WebElement section = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(programListSection));
        ((JavascriptExecutor) MANAGER.getDriver()).executeScript("arguments[0].scrollIntoView(true);", section);
        jsClick(webDriverWait.until(ExpectedConditions.elementToBeClickable(internetOfThingsTechnologiesButton)));
        makeScreenshot();
        return this;
    }
}


//    private final String pageLogo = "//img[@class='priority']";
//    private final String learningConditionsSection = "//section[@id='terms']";
//    private final String freePrograms = "//a[text()='бесплатные программы']";
//    private final String programListSection = "//section[@id='programs-list']";
//    private final String internetOfThingsTechnologiesButton = "//a[@class='programs-link' and contains(text(),'Технологии интернета вещей')]";//todo
//
//    @Step("Открытие страницы 'Приоритет 2030'")
//    public DigitalDepartmentPage checkIfCorrectPageOpen() {
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
//    @Step("Открытие бесплатных программ")
//    public DigitalDepartmentPage freeProgramsButtonClick() {
//        $x(learningConditionsSection).scrollTo();
//        jsClick($x(freePrograms));
//        Selenide.sleep(2000);
//        makeScreenshot();
//        return this;
//    }
//
//    @Step("Открытие программы 'Технологии интернета вещей'")
//    public DigitalDepartmentPage internetOfThingsTechnologiesButtonClick() {
//        $x(programListSection).scrollTo();
//        Selenide.sleep(2000);
//        jsClick($x(internetOfThingsTechnologiesButton));
//        Selenide.sleep(2000);
//        makeScreenshot();
//        return this;
//    }
//}