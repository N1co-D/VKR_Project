import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.*;
import utilites.ConfProperties;

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

    @Description("-----")
    @ParameterizedTest
    @MethodSource("PgupsTestData#test1TestData")
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

    @Description("-----")
    @ParameterizedTest
    @MethodSource("PgupsTestData#test2TestData")
    public void test2(String dormitoryNumber,
                      String expectedDormitoryAddress) {
        open(confProperties.getProperty("test-site"));

        mainPage.checkIfCorrectPageOpen()
                .dormitoriesClick();

        habitationPage.checkIfCorrectPageOpen()
                .dormitoryClick(dormitoryNumber)
                .checkDormitoryAddress(expectedDormitoryAddress);
    }

    @Description("-----")
    @Test
    public void test3() {
        open(confProperties.getProperty("test-site"));

        mainPage.checkIfCorrectPageOpen()
                .admissionsCommitteeWebsiteClick();

        admissionsCommitteePage.checkIfCorrectPageOpen()
                .receptionPlacesNumber()
                .numberOfPaidPlacesForAdmissionDownloadButtonClick("plan_priema_pgups_bak_spec_mag_2024_platnoe.pdf");
    }

    @Description("-----")
    @ParameterizedTest
    @MethodSource("PgupsTestData#test4TestData")
    public void test4(String year) {
        open(confProperties.getProperty("test-site"));

        mainPage.checkIfCorrectPageOpen()
                .directionsAndSpecialtiesClick();

        educationPage.checkIfCorrectPageOpen()
                .masterDegreeProgramsDescriptionsClick()
                .informationSystemsAndTechnologiesInTransportProgramClick()
                .informationSystemsAndTechnologiesInTransportEducationPlanClick(year, "ucheb_plan_ism_2023.pdf");
    }

    @Description("-----")
    @ParameterizedTest
    @MethodSource("PgupsTestData#test5TestData")
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

    @Description("-----")
    @Test
    public void test6() { //todo check
        open(confProperties.getProperty("test-site"));

        mainPage.checkIfCorrectPageOpen()
                .priorityLogoClick();

        priorityPage.checkIfCorrectPageOpen()
                .digitalDepartmentButtonClick();

        digitalDepartmentPage.checkIfCorrectPageOpen()
                .freeProgramsButtonClick()
                .internetOfThingsTechnologiesButtonClick();

        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        String expectedUrl = "https://prioritet2030.pgups.ru/pages/digital-department/digital-department/digital-department.html#program02";
        assertEquals(expectedUrl, currentUrl,
                String.format("Фактический URL-адрес = %s " +
                                " не соответствует ожидаемому = %s",
                        currentUrl,
                        expectedUrl));
    }

    @Description("-----")
    @Test
    public void test7() { //todo check
        open(confProperties.getProperty("test-site"));

        mainPage.checkIfCorrectPageOpen()
                .scientificConferencesClick();

        scientificConferencesPage.checkIfCorrectPageOpen()
                .planOfScientificEventsClick("Plan-nauchnykh-meropriyatiy-na-2024-god.pdf");
    }

    @Description("-----")
    @Test
    public void test8() { //todo check
        open(confProperties.getProperty("test-site"));

        mainPage.checkIfCorrectPageOpen()
                .admissionCommitteeModuleClick();

        admissionsCommitteePage.checkIfCorrectPageOpen()
                .masterDegreeModuleClick()
                .tuitionFeesClick("stoimost_obuch_1_kurs_18042022.pdf");
    }

    @Description("-----")
    @Test
    public void test9() { //todo check
        open(confProperties.getProperty("test-site"));

        mainPage.checkIfCorrectPageOpen()
                .pgupsMuseumClick();

        pgupsMuseumPage.checkIfCorrectPageOpen()
                .planOfScientificEventsClick("sajavka_na_excursiju.doc");
    }

    @Description("-----")
    @ParameterizedTest
    @MethodSource("PgupsTestData#test10TestData")
    public void test10(String expectedStartDate) { //todo check
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