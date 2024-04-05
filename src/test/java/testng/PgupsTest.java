package testng;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import testng.pages.*;
import junit.utilites.ConfProperties;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PgupsTest extends BaseTest {
    private final MainPage mainPage = new MainPage();
    private final SchedulePage schedulePage = new SchedulePage();
    private final HabitationPage habitationPage = new HabitationPage();
    private final AdmissionsCommitteePage admissionsCommitteePage = new AdmissionsCommitteePage();
    private final EducationPage educationPage = new EducationPage();
    private final FacultyContactsPage facultyContactsPage = new FacultyContactsPage();
    private final AitPage aitPage = new AitPage();
    private final PriorityPage priorityPage = new PriorityPage();
    private final DigitalDepartmentPage digitalDepartmentPage = new DigitalDepartmentPage();
    private final ScientificConferencesPage scientificConferencesPage = new ScientificConferencesPage();
    private final PgupsMuseumPage pgupsMuseumPage = new PgupsMuseumPage();
    private final AdvancedEngineeringSchoolPage advancedEngineeringSchoolPage = new AdvancedEngineeringSchoolPage();
    private final AutomatedDispatchControlSystemsPage automatedDispatchControlSystemsPage = new AutomatedDispatchControlSystemsPage();
    private final ConfProperties confProperties = new ConfProperties();

    @AfterSuite
    public static void cleanUp() throws IOException {
        FileUtils.deleteDirectory(new File("src/downloads"));
    }

    @Description("Проверка отражения названия ожидаемой пары в соответствии с её порядком и днем недели")
    @Test(dataProvider = "test1TestData", dataProviderClass = PgupsTestData.class)
    public void test1(String inputText,
                      String searchedGroup,
                      String dayOfWeek,
                      String pairNumber,
                      String expectedPairName) {
        open(confProperties.getProperty("test-site"));

        mainPage.checkIfCorrectPageOpen()
                .scheduleClick();

        List<String> allWindowHandles = new ArrayList<>(WebDriverRunner.getWebDriver().getWindowHandles());
        String windowToSwitch = allWindowHandles.get(allWindowHandles.size() - 1);
        WebDriverRunner.getWebDriver().switchTo().window(windowToSwitch);

        schedulePage.checkIfCorrectPageOpen()
                .searchByGroup(inputText)
                .resultGroupClick(searchedGroup)
                .checkPairName(dayOfWeek, pairNumber, expectedPairName);
    }

    @Description("Проверка соответствия ожидаемого и фактического адреса общежития")
    @Test(dataProvider = "test2TestData", dataProviderClass = PgupsTestData.class)
    public void test2(String dormitoryNumber,
                      String expectedDormitoryAddress) {
        open(confProperties.getProperty("test-site"));

        mainPage.checkIfCorrectPageOpen()
                .dormitoriesClick();

        habitationPage.checkIfCorrectPageOpen()
                .dormitoryClick(dormitoryNumber)
                .checkDormitoryAddress(expectedDormitoryAddress);
    }

    @Description("Скачивание документа с отражением количества платных мест")
    @Test(dataProvider = "test3TestData", dataProviderClass = PgupsTestData.class)
    public void test3(String fileName) {
        open(confProperties.getProperty("test-site"));

        mainPage.checkIfCorrectPageOpen()
                .admissionsCommitteeWebsiteClick();

        admissionsCommitteePage.checkIfCorrectPageOpen()
                .receptionPlacesNumber()
                .numberOfPaidPlacesForAdmissionDownloadButtonClick(fileName);
    }

    @Description("Скачивание файла учебного плана в соответствии наименованием направления и года")
    @Test(dataProvider = "test4TestData", dataProviderClass = PgupsTestData.class)
    public void test4(String year, String fileName) {
        open(confProperties.getProperty("test-site"));

        mainPage.checkIfCorrectPageOpen()
                .directionsAndSpecialtiesClick();

        educationPage.checkIfCorrectPageOpen()
                .masterDegreeProgramsDescriptionsClick()
                .informationSystemsAndTechnologiesInTransportProgramClick()
                .informationSystemsAndTechnologiesInTransportEducationPlanClick(year, fileName);
    }

    @Description("Проверка соответствия ожидаемого и фактического адреса электронной почты факультета")
    @Test(dataProvider = "test5TestData", dataProviderClass = PgupsTestData.class)
    public void test5(String expectedEmail) {
        open(confProperties.getProperty("test-site"));

        mainPage.checkIfCorrectPageOpen()
                .facultyContactsClick();

        facultyContactsPage.checkIfCorrectPageOpen()
                .aitModuleClick();

        List<String> allWindowHandles = new ArrayList<>(WebDriverRunner.getWebDriver().getWindowHandles());
        String windowToSwitch = allWindowHandles.get(allWindowHandles.size() - 1);
        WebDriverRunner.getWebDriver().switchTo().window(windowToSwitch);

        aitPage.checkIfCorrectPageOpen()
                .checkEmail(expectedEmail);
    }

    @Description("Проверка открытия программы в модуле 'Приоритет 2030'")
    @Test(dataProvider = "test6TestData", dataProviderClass = PgupsTestData.class)
    public void test6(String expectedUrl) {
        open(confProperties.getProperty("test-site"));

        mainPage.checkIfCorrectPageOpen()
                .priorityLogoClick();

        priorityPage.checkIfCorrectPageOpen()
                .digitalDepartmentButtonClick();

        digitalDepartmentPage.checkIfCorrectPageOpen()
                .freeProgramsButtonClick()
                .internetOfThingsTechnologiesButtonClick();

        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(expectedUrl, currentUrl,
                String.format("Фактический URL-адрес = %s " +
                                " не соответствует ожидаемому = %s",
                        currentUrl,
                        expectedUrl));
    }

    @Description("Скачивание документа с планом научных событий")
    @Test(dataProvider = "test7TestData", dataProviderClass = PgupsTestData.class)
    public void test7(String fileName) {
        open(confProperties.getProperty("test-site"));

        mainPage.checkIfCorrectPageOpen()
                .scientificConferencesClick();

        scientificConferencesPage.checkIfCorrectPageOpen()
                .planOfScientificEventsClick(fileName);
    }

    @Description("Скачивание файла со стоимостью обучения")
    @Test(dataProvider = "test8TestData", dataProviderClass = PgupsTestData.class)
    public void test8(String fileName) {
        open(confProperties.getProperty("test-site"));

        mainPage.checkIfCorrectPageOpen()
                .admissionCommitteeModuleClick();

        admissionsCommitteePage.checkIfCorrectPageOpen()
                .masterDegreeModuleClick()
                .tuitionFeesClick(fileName);
    }

    @Description("Скачивание файла с информацией об экскурсиях в Музей ПГУПС")
    @Test(dataProvider = "test9TestData", dataProviderClass = PgupsTestData.class)
    public void test9(String fileName) {
        open(confProperties.getProperty("test-site"));

        mainPage.checkIfCorrectPageOpen()
                .pgupsMuseumClick();

        pgupsMuseumPage.checkIfCorrectPageOpen()
                .applicationForGuidedTourClick(fileName);
    }

    @Description("Проверка соответствия даты начала программы из модуля 'ПИШ'")
    @Test(dataProvider = "test10TestData", dataProviderClass = PgupsTestData.class)
    public void test10(String expectedStartDate) {
        open(confProperties.getProperty("test-site"));

        mainPage.checkIfCorrectPageOpen()
                .advancedEngineeringSchoolLogoClick();

        advancedEngineeringSchoolPage.checkIfCorrectPageOpen()
                .educationModuleClick()
                .masterDegreeSectionClick()
                .programDetailsClick();

        List<String> allWindowHandles = new ArrayList<>(WebDriverRunner.getWebDriver().getWindowHandles());
        String windowToSwitch = allWindowHandles.get(allWindowHandles.size() - 1);
        WebDriverRunner.getWebDriver().switchTo().window(windowToSwitch);

        automatedDispatchControlSystemsPage.checkIfCorrectPageOpen()
                .checkStartDate(expectedStartDate);
    }
}