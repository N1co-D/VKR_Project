package selenium.testng.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.fail;
import static selenium.testng.utilites.DriverSingleton.MANAGER;

public class AdvancedEngineeringSchoolPage extends BasePage {
    private final By pageTitle = By.xpath("//a[@class='pish-logo']");
    private final By educationModule = By.xpath("//a[normalize-space(text())='Образование']");
    private final By masterDegreeSection = By.xpath("//a[@id='magistracy']");
    private final By automatedDispatchControlSystemsProgram = By.xpath("//h3[text()='Автоматизированные системы диспетчерского управления']");
    private final By programDetails = By.xpath("//h3[text()='Автоматизированные системы диспетчерского управления']/..//a[normalize-space(text())='Подробности']");
    private final WebDriverWait webDriverWait = new WebDriverWait(MANAGER.getDriver(), Duration.ofSeconds(10));

    @Step("Открытие страницы 'ПИШ'")
    public AdvancedEngineeringSchoolPage checkIfCorrectPageOpen() {
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

    @Step("Открытие модуля 'Образование'")
    public AdvancedEngineeringSchoolPage educationModuleClick() {
        try {
            WebElement element = webDriverWait.until(ExpectedConditions.elementToBeClickable(educationModule));
            new Actions(MANAGER.getDriver()).moveToElement(element).click().perform();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Элемент 'educationModule' не был найден в течение заданного времени.");
            throw noSuchElementException;
        }
        makeScreenshot();
        return this;
    }

    @Step("Открытие раздела 'Магистратура'")
    public AdvancedEngineeringSchoolPage masterDegreeSectionClick() {
        try {
            jsClick(webDriverWait.until(ExpectedConditions.elementToBeClickable(masterDegreeSection)));
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Элемент 'masterDegreeSection' не был найден в течение заданного времени.");
            throw noSuchElementException;
        }
        makeScreenshot();
        return this;
    }

    @Step("Открытие подробностей программы 'Автоматизированные системы диспетчерского управления'")
    public AdvancedEngineeringSchoolPage programDetailsClick() {
        try {
            WebElement program = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(automatedDispatchControlSystemsProgram));
            new Actions(MANAGER.getDriver()).moveToElement(program).perform();
            jsClick(webDriverWait.until(ExpectedConditions.elementToBeClickable(programDetails)));
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Элемент 'programDetails' не был найден в течение заданного времени.");
            throw noSuchElementException;
        }
        return this;
    }
}


//    private final String pageTitle = "//a[@class='pish-logo']";
//    private final String educationModule = "//a[normalize-space(text())='Образование']";
//    private final String masterDegreeSection = "//a[@id='magistracy']";
//    private final String automatedDispatchControlSystemsProgram = "//h3[text()='Автоматизированные системы диспетчерского управления']";
//    private final String programDetails = "//h3[text()='Автоматизированные системы диспетчерского управления']/..//a[normalize-space(text())='Подробности']";
//
//    @Step("Открытие страницы 'ПИШ'")
//    public AdvancedEngineeringSchoolPage checkIfCorrectPageOpen() {
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
//    @Step("Открытие модуля 'Образование'")
//    public AdvancedEngineeringSchoolPage educationModuleClick() {
//        jsClick($x(educationModule));
//        makeScreenshot();
//        return this;
//    }
//
//    @Step("Открытие раздела 'Магистратура'")
//    public AdvancedEngineeringSchoolPage masterDegreeSectionClick() {
//        jsClick($x(masterDegreeSection));
//        makeScreenshot();
//        return this;
//    }
//
//    @Step("Открытие подробностей программы 'Автоматизированные системы диспетчерского управления'")
//    public AdvancedEngineeringSchoolPage programDetailsClick() {
//        actions().moveToElement($x(automatedDispatchControlSystemsProgram)).perform();
//        jsClick($x(programDetails));
//        return this;
//    }
//}