package selenium.testng.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.testng.utilites.DriverSingleton;

import java.time.Duration;
import java.util.NoSuchElementException;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import static selenium.testng.utilites.DriverSingleton.MANAGER;

public class AdmissionsCommitteePage extends BasePage {
    private final By pageTitle = By.xpath("//span[text()='приемной комиссии']/ancestor::h3[text()='Новости ']");
    private final By receptionPlacesNumber = By.xpath("//a[text()='Количество мест для приема']");
    private final By numberOfPaidPlacesForAdmissionDownloadButton = By.xpath("//div[contains(text(),'Количество платных мест для приёма по программам бакалавриата, специалитета, магистратуры в 2024 году')]/..//a[text()='Скачать']");
    private final By masterDegreeModule = By.xpath("//header[@id='header']//a[text()='Магистратура']");
    private final By tuitionFees = By.xpath("//div[@class='tab-pane fade in active']//a[normalize-space(text())='СТОИМОСТЬ ОБУЧЕНИЯ']");
    private final By paymentOrder = By.xpath("//a[contains(text(),'12.09.2023') and contains(text(),'449/К «Об оплате образовательных услуг иностранными обучающимися, зачисленными по сетевой форме реализации образовательных программ в 2023/2024 учебном году')]");
    private final WebDriverWait webDriverWait = new WebDriverWait(MANAGER.getDriver(), Duration.ofSeconds(10));

    @Step("Открытие страницы приемной комиссии")
    public AdmissionsCommitteePage checkIfCorrectPageOpen() {
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

    @Step("Открытие раздела 'Количество мест для приема'")
    public AdmissionsCommitteePage receptionPlacesNumber() {
        try {
            jsClick(webDriverWait.until(visibilityOfElementLocated(receptionPlacesNumber)));
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Элемент 'receptionPlacesNumber' не был найден в течение заданного времени.");
            throw noSuchElementException;
        }
        makeScreenshot();
        return this;
    }

    @Step("Скачивание файла {fileName}")
    public AdmissionsCommitteePage numberOfPaidPlacesForAdmissionDownloadButtonClick(String expectedUrl) {
        try {
            jsClick(webDriverWait.until(visibilityOfElementLocated(numberOfPaidPlacesForAdmissionDownloadButton)));
            assertEquals(MANAGER.getDriver().getCurrentUrl(), expectedUrl);
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Элемент 'numberOfPaidPlacesForAdmissionDownloadButton' не был найден в течение заданного времени.");
            throw noSuchElementException;
        }
        return this;
    }

    @Step("Открытие модуля 'Магистратура'")
    public AdmissionsCommitteePage masterDegreeModuleClick() throws InterruptedException {
        try {
            jsClick(webDriverWait.until(visibilityOfElementLocated(masterDegreeModule)));
            Thread.sleep(2000);
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Элемент 'masterDegreeModule' не был найден в течение заданного времени.");
            throw noSuchElementException;
        }
        makeScreenshot();
        return this;
    }

    @Step("Открытие раздела 'Стоимость обучения'")
    public AdmissionsCommitteePage educationCostClick() {
        try {
            jsClick(webDriverWait.until(visibilityOfElementLocated(tuitionFees)));
            jsClick(webDriverWait.until(visibilityOfElementLocated(paymentOrder)));
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Элемент 'tuitionFees' не был найден в течение заданного времени.");
            throw noSuchElementException;
        }
        makeScreenshot();
        return this;
    }

    @Step("Скачивание файла {fileName}")
    public AdmissionsCommitteePage checkOpenTuitionFeesClick(String expectedUrl) {
        assertEquals(DriverSingleton.MANAGER.getDriver().getCurrentUrl(), expectedUrl);
        return this;
    }
}
//    private final String pageTitle = "//span[text()='приемной комиссии']/ancestor::h3[text()='Новости ']";
//    private final String receptionPlacesNumber = "//a[text()='Количество мест для приема']";
//    private final String numberOfPaidPlacesForAdmissionDownloadButton = "//div[contains(text(),'Количество платных мест для приёма по программам бакалавриата, специалитета, магистратуры в 2024 году')]/..//a[text()='Скачать']";
//    private final String masterDegreeModule = "//header[@id='header']//a[text()='Магистратура']";
//    private final String tuitionFees = "//div[@class='tab-pane fade in active']//a[normalize-space(text())='СТОИМОСТЬ ОБУЧЕНИЯ']";
//
//    @Step("Открытие страницы приемной комиссии")
//    public AdmissionsCommitteePage checkIfCorrectPageOpen() {
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
//    @Step("Открытие раздела 'Количество мест для приема'")
//    public AdmissionsCommitteePage receptionPlacesNumber() {
//        jsClick($x(receptionPlacesNumber));
//        makeScreenshot();
//        return this;
//    }
//
//    @Step("Скачивание файла {fileName}")
//    public AdmissionsCommitteePage numberOfPaidPlacesForAdmissionDownloadButtonClick(String fileName) {
//        File report = $x(numberOfPaidPlacesForAdmissionDownloadButton).download();
//        checkIfFileExist(fileName);
//        return this;
//    }
//
//    @Step("Открытие модуля 'Магистратура'")
//    public AdmissionsCommitteePage masterDegreeModuleClick() {
//        jsClick($x(masterDegreeModule));
//        Selenide.sleep(2000);
//        makeScreenshot();
//        return this;
//    }
//
//    @Step("Скачивание файла {fileName}")
//    public AdmissionsCommitteePage tuitionFeesClick(String fileName) {
//        File report = $x(tuitionFees).download();
//        checkIfFileExist(fileName);
//        return this;
//    }