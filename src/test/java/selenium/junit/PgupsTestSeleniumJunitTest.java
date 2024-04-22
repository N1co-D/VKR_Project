package selenium.junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import selenium.junit.pages.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PgupsTestSeleniumJunitTest extends BaseTest {

    @DisplayName("Проверка отражения названия ожидаемой пары в соответствии с её порядком и днем недели")
    @ParameterizedTest
    @MethodSource("selenium.junit.PgupsTestData#test1TestData")
    public void test1(String inputText,
                      String searchedGroup,
                      String dayOfWeek,
                      String pairNumber,
                      String expectedPairName) {
        driver.manage().window().maximize();
        driver.get("https://www.pgups.ru/");

        MainPage mainPage = new MainPage();

        mainPage.checkIfCorrectPageOpen()
                .scheduleClick();

        List<String> allWindowHandles = new ArrayList<>(driver.getWindowHandles());
        String windowToSwitch = allWindowHandles.get(allWindowHandles.size() - 1);
        driver.switchTo().window(windowToSwitch);

        SchedulePage schedulePage = new SchedulePage();

        schedulePage.checkIfCorrectPageOpen()
                .searchByGroup(inputText)
                .resultGroupClick(searchedGroup)
                .checkPairName(dayOfWeek, pairNumber, expectedPairName);
    }

    @DisplayName("Проверка соответствия ожидаемого и фактического адреса общежития")
    @ParameterizedTest
    @MethodSource("selenium.junit.PgupsTestData#test2TestData")
    public void test2(String dormitoryNumber,
                      String expectedDormitoryAddress) {
        driver.manage().window().maximize();
        driver.get("https://www.pgups.ru/");

        MainPage mainPage = new MainPage();

        mainPage.checkIfCorrectPageOpen()
                .dormitoriesClick();

        HabitationPage habitationPage = new HabitationPage();

        habitationPage.checkIfCorrectPageOpen()
                .dormitoryClick(dormitoryNumber)
                .checkDormitoryAddress(expectedDormitoryAddress);
    }

    @DisplayName("Скачивание документа с отражением количества платных мест")
    @ParameterizedTest
    @MethodSource("selenium.junit.PgupsTestData#test3TestData")
    public void test3(String expectedUrl) {
        driver.manage().window().maximize();
        driver.get("https://www.pgups.ru/");

        MainPage mainPage = new MainPage();

        mainPage.checkIfCorrectPageOpen()
                .admissionsCommitteeWebsiteClick();

        AdmissionsCommitteePage admissionsCommitteePage = new AdmissionsCommitteePage();

        admissionsCommitteePage.checkIfCorrectPageOpen()
                .receptionPlacesNumber()
                .numberOfPaidPlacesForAdmissionDownloadButtonClick(expectedUrl);
    }

    @DisplayName("Скачивание файла учебного плана в соответствии наименованием направления и года")
    @ParameterizedTest
    @MethodSource("selenium.junit.PgupsTestData#test4TestData")
    public void test4(String year, String expectedUrl) {
        driver.manage().window().maximize();
        driver.get("https://www.pgups.ru/");

        MainPage mainPage = new MainPage();

        mainPage.checkIfCorrectPageOpen()
                .directionsAndSpecialtiesClick();

        EducationPage educationPage = new EducationPage();

        educationPage.checkIfCorrectPageOpen()
                .masterDegreeProgramsDescriptionsClick()
                .informationSystemsAndTechnologiesInTransportProgramClick()
                .informationSystemsAndTechnologiesInTransportEducationPlanClick(year, expectedUrl);
    }

    @DisplayName("Проверка соответствия ожидаемого и фактического адреса электронной почты факультета")
    @ParameterizedTest
    @MethodSource("selenium.junit.PgupsTestData#test5TestData")
    public void test5(String expectedEmail) {
        driver.manage().window().maximize();
        driver.get("https://www.pgups.ru/");

        MainPage mainPage = new MainPage();

        mainPage.checkIfCorrectPageOpen()
                .facultyContactsClick();

        FacultyContactsPage facultyContactsPage = new FacultyContactsPage();

        facultyContactsPage.checkIfCorrectPageOpen()
                .aitModuleClick();

        List<String> allWindowHandles = new ArrayList<>(driver.getWindowHandles());
        String windowToSwitch = allWindowHandles.get(allWindowHandles.size() - 1);
        driver.switchTo().window(windowToSwitch);

        AitPage aitPage = new AitPage();

        aitPage.checkIfCorrectPageOpen()
                .checkEmail(expectedEmail);
    }

    @DisplayName("Проверка открытия программы в модуле 'Приоритет 2030'")
    @ParameterizedTest
    @MethodSource("selenium.junit.PgupsTestData#test6TestData")
    public void test6(String expectedUrl) {
        driver.manage().window().maximize();
        driver.get("https://www.pgups.ru/");

        MainPage mainPage = new MainPage();

        mainPage.checkIfCorrectPageOpen()
                .priorityLogoClick();

        PriorityPage priorityPage = new PriorityPage();

        priorityPage.checkIfCorrectPageOpen()
                .digitalDepartmentButtonClick();

        DigitalDepartmentPage digitalDepartmentPage = new DigitalDepartmentPage();

        digitalDepartmentPage.checkIfCorrectPageOpen()
                .freeProgramsButtonClick()
                .internetOfThingsTechnologiesButtonClick();

        String currentUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, currentUrl,
                String.format("Фактический URL-адрес = %s " +
                                " не соответствует ожидаемому = %s",
                        currentUrl,
                        expectedUrl));
    }

    @DisplayName("Скачивание документа с планом научных событий")
    @ParameterizedTest
    @MethodSource("selenium.junit.PgupsTestData#test7TestData")
    public void test7(String expectedUrl) {
        driver.manage().window().maximize();
        driver.get("https://www.pgups.ru/");

        MainPage mainPage = new MainPage();

        mainPage.checkIfCorrectPageOpen()
                .scientificConferencesClick();

        ScientificConferencesPage scientificConferencesPage = new ScientificConferencesPage();

        scientificConferencesPage.checkIfCorrectPageOpen()
                .planOfScientificEventsClick(expectedUrl);
    }

    @DisplayName("Скачивание файла со стоимостью обучения")
    @ParameterizedTest
    @MethodSource("selenium.junit.PgupsTestData#test8TestData")
    public void test8(String expectedUrl) throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.pgups.ru/");

        MainPage mainPage = new MainPage();

        mainPage.checkIfCorrectPageOpen()
                .admissionCommitteeModuleClick();

        AdmissionsCommitteePage admissionsCommitteePage = new AdmissionsCommitteePage();

        admissionsCommitteePage.checkIfCorrectPageOpen()
                .masterDegreeModuleClick()
                .tuitionFeesClick(expectedUrl);
    }

    @DisplayName("Скачивание файла с информацией об экскурсиях в Музей ПГУПС")
    @ParameterizedTest
    @MethodSource("selenium.junit.PgupsTestData#test9TestData")
    public void test9(String expectedUrl) {
        driver.manage().window().maximize();
        driver.get("https://www.pgups.ru/");

        MainPage mainPage = new MainPage();

        mainPage.checkIfCorrectPageOpen()
                .pgupsMuseumClick();

        PgupsMuseumPage pgupsMuseumPage = new PgupsMuseumPage();

        pgupsMuseumPage.checkIfCorrectPageOpen()
                .applicationForGuidedTourClick(expectedUrl);
    }

    @DisplayName("Проверка соответствия даты начала программы из модуля 'ПИШ'")
    @ParameterizedTest
    @MethodSource("selenium.junit.PgupsTestData#test10TestData")
    public void test10(String expectedStartDate) {
        driver.manage().window().maximize();
        driver.get("https://www.pgups.ru/");

        MainPage mainPage = new MainPage();

        mainPage.checkIfCorrectPageOpen()
                .advancedEngineeringSchoolLogoClick();

        AdvancedEngineeringSchoolPage advancedEngineeringSchoolPage = new AdvancedEngineeringSchoolPage();

        advancedEngineeringSchoolPage.checkIfCorrectPageOpen()
                .educationModuleClick()
                .masterDegreeSectionClick()
                .programDetailsClick();

        List<String> allWindowHandles = new ArrayList<>(driver.getWindowHandles());
        String windowToSwitch = allWindowHandles.get(allWindowHandles.size() - 1);
        driver.switchTo().window(windowToSwitch);

        AutomatedDispatchControlSystemsPage automatedDispatchControlSystemsPage = new AutomatedDispatchControlSystemsPage();

        automatedDispatchControlSystemsPage.checkIfCorrectPageOpen()
                .checkStartDate(expectedStartDate);
    }
}
//    private final MainPage mainPage = new MainPage();
//    private final SchedulePage schedulePage = new SchedulePage();
//    private final HabitationPage habitationPage = new HabitationPage();
//    private final AdmissionsCommitteePage admissionsCommitteePage = new AdmissionsCommitteePage();
//    private final EducationPage educationPage = new EducationPage();
//    private final FacultyContactsPage facultyContactsPage = new FacultyContactsPage();
//    private final AitPage aitPage = new AitPage();
//    private final PriorityPage priorityPage = new PriorityPage();
//    private final DigitalDepartmentPage digitalDepartmentPage = new DigitalDepartmentPage();
//    private final ScientificConferencesPage scientificConferencesPage = new ScientificConferencesPage();
//    private final PgupsMuseumPage pgupsMuseumPage = new PgupsMuseumPage();
//    private final AdvancedEngineeringSchoolPage advancedEngineeringSchoolPage = new AdvancedEngineeringSchoolPage();
//    private final AutomatedDispatchControlSystemsPage automatedDispatchControlSystemsPage = new AutomatedDispatchControlSystemsPage();
//    private final ConfProperties confProperties = new ConfProperties();
//
//    @AfterAll
//    public static void cleanUp() throws IOException {
//        FileUtils.deleteDirectory(new File("src/downloads"));
//    }
//
//    @Description("Проверка отражения названия ожидаемой пары в соответствии с её порядком и днем недели")
//    @ParameterizedTest
//    @MethodSource("junit.PgupsTestDataSeleniumJunit#test1TestData")
//    public void test1(String inputText,
//                      String searchedGroup,
//                      String dayOfWeek,
//                      String pairNumber,
//                      String expectedPairName) {
//        open(confProperties.getProperty("test-site"));
//
//        mainPage.checkIfCorrectPageOpen()
//                .scheduleClick();
//
//        List<String> allWindowHandles = new ArrayList<>(WebDriverRunner.getWebDriver().getWindowHandles());
//        String windowToSwitch = allWindowHandles.get(allWindowHandles.size() - 1);
//        WebDriverRunner.getWebDriver().switchTo().window(windowToSwitch);
//
//        schedulePage.checkIfCorrectPageOpen()
//                .searchByGroup(inputText)
//                .resultGroupClick(searchedGroup)
//                .checkPairName(dayOfWeek, pairNumber, expectedPairName);
//    }
//
//    @Description("Проверка соответствия ожидаемого и фактического адреса общежития")
//    @ParameterizedTest
//    @MethodSource("junit.PgupsTestDataSeleniumJunit#test2TestData")
//    public void test2(String dormitoryNumber,
//                      String expectedDormitoryAddress) {
//        open(confProperties.getProperty("test-site"));
//
//        mainPage.checkIfCorrectPageOpen()
//                .dormitoriesClick();
//
//        habitationPage.checkIfCorrectPageOpen()
//                .dormitoryClick(dormitoryNumber)
//                .checkDormitoryAddress(expectedDormitoryAddress);
//    }
//
//    @Description("Скачивание документа с отражением количества платных мест")
//    @ParameterizedTest
//    @MethodSource("junit.PgupsTestDataSeleniumJunit#test3TestData")
//    public void test3(String fileName) {
//        open(confProperties.getProperty("test-site"));
//
//        mainPage.checkIfCorrectPageOpen()
//                .admissionsCommitteeWebsiteClick();
//
//        admissionsCommitteePage.checkIfCorrectPageOpen()
//                .receptionPlacesNumber()
//                .numberOfPaidPlacesForAdmissionDownloadButtonClick(fileName);
//    }
//
//    @Description("Скачивание файла учебного плана в соответствии наименованием направления и года")
//    @ParameterizedTest
//    @MethodSource("junit.PgupsTestDataSeleniumJunit#test4TestData")
//    public void test4(String year, String fileName) {
//        open(confProperties.getProperty("test-site"));
//
//        mainPage.checkIfCorrectPageOpen()
//                .directionsAndSpecialtiesClick();
//
//        educationPage.checkIfCorrectPageOpen()
//                .masterDegreeProgramsDescriptionsClick()
//                .informationSystemsAndTechnologiesInTransportProgramClick()
//                .informationSystemsAndTechnologiesInTransportEducationPlanClick(year, fileName);
//    }
//
//    @Description("Проверка соответствия ожидаемого и фактического адреса электронной почты факультета")
//    @ParameterizedTest
//    @MethodSource("junit.PgupsTestDataSeleniumJunit#test5TestData")
//    public void test5(String expectedEmail) {
//        open(confProperties.getProperty("test-site"));
//
//        mainPage.checkIfCorrectPageOpen()
//                .facultyContactsClick();
//
//        facultyContactsPage.checkIfCorrectPageOpen()
//                .aitModuleClick();
//
//        List<String> allWindowHandles = new ArrayList<>(WebDriverRunner.getWebDriver().getWindowHandles());
//        String windowToSwitch = allWindowHandles.get(allWindowHandles.size() - 1);
//        WebDriverRunner.getWebDriver().switchTo().window(windowToSwitch);
//
//        aitPage.checkIfCorrectPageOpen()
//                .checkEmail(expectedEmail);
//    }
//
//    @Description("Проверка открытия программы в модуле 'Приоритет 2030'")
//    @ParameterizedTest
//    @MethodSource("junit.PgupsTestDataSeleniumJunit#test6TestData")
//    public void test6(String expectedUrl) {
//        open(confProperties.getProperty("test-site"));
//
//        mainPage.checkIfCorrectPageOpen()
//                .priorityLogoClick();
//
//        priorityPage.checkIfCorrectPageOpen()
//                .digitalDepartmentButtonClick();
//
//        digitalDepartmentPage.checkIfCorrectPageOpen()
//                .freeProgramsButtonClick()
//                .internetOfThingsTechnologiesButtonClick();
//
//        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
//        assertEquals(expectedUrl, currentUrl,
//                String.format("Фактический URL-адрес = %s " +
//                                " не соответствует ожидаемому = %s",
//                        currentUrl,
//                        expectedUrl));
//    }
//
//    @Description("Скачивание документа с планом научных событий")
//    @ParameterizedTest
//    @MethodSource("junit.PgupsTestDataSeleniumJunit#test7TestData")
//    public void test7(String fileName) {
//        open(confProperties.getProperty("test-site"));
//
//        mainPage.checkIfCorrectPageOpen()
//                .scientificConferencesClick();
//
//        scientificConferencesPage.checkIfCorrectPageOpen()
//                .planOfScientificEventsClick(fileName);
//    }
//
//    @Description("Скачивание файла со стоимостью обучения")
//    @ParameterizedTest
//    @MethodSource("junit.PgupsTestDataSeleniumJunit#test8TestData")
//    public void test8(String fileName) {
//        open(confProperties.getProperty("test-site"));
//
//        mainPage.checkIfCorrectPageOpen()
//                .admissionCommitteeModuleClick();
//
//        admissionsCommitteePage.checkIfCorrectPageOpen()
//                .masterDegreeModuleClick()
//                .tuitionFeesClick(fileName);
//    }
//
//    @Description("Скачивание файла с информацией об экскурсиях в Музей ПГУПС")
//    @ParameterizedTest
//    @MethodSource("junit.PgupsTestDataSeleniumJunit#test9TestData")
//    public void test9(String fileName) {
//        open(confProperties.getProperty("test-site"));
//
//        mainPage.checkIfCorrectPageOpen()
//                .pgupsMuseumClick();
//
//        pgupsMuseumPage.checkIfCorrectPageOpen()
//                .applicationForGuidedTourClick(fileName);
//    }
//
//    @Description("Проверка соответствия даты начала программы из модуля 'ПИШ'")
//    @ParameterizedTest
//    @MethodSource("junit.PgupsTestDataSeleniumJunit#test10TestData")
//    public void test10(String expectedStartDate) {
//        open(confProperties.getProperty("test-site"));
//
//        mainPage.checkIfCorrectPageOpen()
//                .advancedEngineeringSchoolLogoClick();
//
//        advancedEngineeringSchoolPage.checkIfCorrectPageOpen()
//                .educationModuleClick()
//                .masterDegreeSectionClick()
//                .programDetailsClick();
//
//        List<String> allWindowHandles = new ArrayList<>(WebDriverRunner.getWebDriver().getWindowHandles());
//        String windowToSwitch = allWindowHandles.get(allWindowHandles.size() - 1);
//        WebDriverRunner.getWebDriver().switchTo().window(windowToSwitch);
//
//        automatedDispatchControlSystemsPage.checkIfCorrectPageOpen()
//                .checkStartDate(expectedStartDate);
//    }
//}