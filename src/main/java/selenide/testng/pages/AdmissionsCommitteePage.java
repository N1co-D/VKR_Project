package selenide.testng.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.ex.UIAssertionError;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.testng.Assert.fail;

public class AdmissionsCommitteePage extends BasePage {
    private final String pageTitle = "//span[text()='приемной комиссии']/ancestor::h3[text()='Новости ']";
    private final String receptionPlacesNumber = "//a[text()='Количество мест для приема']";
    private final String numberOfPaidPlacesForAdmissionDownloadButton = "//div[contains(text(),'Количество платных мест для приёма по программам бакалавриата, специалитета, магистратуры в 2024 году')]/..//a[text()='Скачать']";
    private final String masterDegreeModule = "//header[@id='header']//a[text()='Магистратура']";
    private final String tuitionFees = "//div[@class='tab-pane fade in active']//a[normalize-space(text())='СТОИМОСТЬ ОБУЧЕНИЯ']";

    @Step("Открытие страницы приемной комиссии")
    public AdmissionsCommitteePage checkIfCorrectPageOpen() {
        try {
            $x(pageTitle).should(visible, WAITING_TIME);
        } catch (UIAssertionError e) {
            makeScreenshot();
            fail("Не удалось подтвердить открытие ожидаемой страницы. " +
                    "Уникальный элемент страницы 'pageTitle' не был найден в течение заданного времени.");
        }
        makeScreenshot();
        return this;
    }

    @Step("Открытие раздела 'Количество мест для приема'")
    public AdmissionsCommitteePage receptionPlacesNumber() {
        jsClick($x(receptionPlacesNumber));
        makeScreenshot();
        return this;
    }

    @Step("Скачивание файла {fileName}")
    public AdmissionsCommitteePage numberOfPaidPlacesForAdmissionDownloadButtonClick(String fileName) {
        File report = $x(numberOfPaidPlacesForAdmissionDownloadButton).download();
        checkIfFileExist(fileName);
        return this;
    }

    @Step("Открытие модуля 'Магистратура'")
    public AdmissionsCommitteePage masterDegreeModuleClick() {
        jsClick($x(masterDegreeModule));
        Selenide.sleep(2000);
        makeScreenshot();
        return this;
    }

    @Step("Скачивание файла {fileName}")
    public AdmissionsCommitteePage tuitionFeesClick(String fileName) {
        File report = $x(tuitionFees).download();
        checkIfFileExist(fileName);
        return this;
    }
}