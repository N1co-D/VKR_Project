import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.*;
import utilites.ConfProperties;

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

    @AfterAll
    public static void cleanUp() throws IOException {
        File directory = new File("src/downloads");
        if (directory.exists() && directory.isDirectory()) {
            FileUtils.cleanDirectory(directory);
        }
    }

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
    @ParameterizedTest
    @MethodSource("PgupsTestData#test3TestData")
    public void test3(String fileName) {
        open(confProperties.getProperty("test-site"));

        mainPage.checkIfCorrectPageOpen()
                .admissionsCommitteeWebsiteClick();

        admissionsCommitteePage.checkIfCorrectPageOpen()
                .receptionPlacesNumber()
                .numberOfPaidPlacesForAdmissionDownloadButtonClick(fileName);
    }

    @Description("-----")
    @ParameterizedTest
    @MethodSource("PgupsTestData#test4TestData")
    public void test4(String year, String fileName) {
        open(confProperties.getProperty("test-site"));

        mainPage.checkIfCorrectPageOpen()
                .directionsAndSpecialtiesClick();

        educationPage.checkIfCorrectPageOpen()
                .masterDegreeProgramsDescriptionsClick()
                .informationSystemsAndTechnologiesInTransportProgramClick()
                .informationSystemsAndTechnologiesInTransportEducationPlanClick(year, fileName);
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
    @ParameterizedTest
    @MethodSource("PgupsTestData#test6TestData")
    public void test6(String expectedUrl) { //todo check
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

    @Description("-----")
    @ParameterizedTest
    @MethodSource("PgupsTestData#test7TestData")
    public void test7(String fileName) { //todo check
        open(confProperties.getProperty("test-site"));

        mainPage.checkIfCorrectPageOpen()
                .scientificConferencesClick();

        scientificConferencesPage.checkIfCorrectPageOpen()
                .planOfScientificEventsClick(fileName);
    }

    @Description("-----")
    @ParameterizedTest
    @MethodSource("PgupsTestData#test8TestData")
    public void test8(String fileName) { //todo check
        open(confProperties.getProperty("test-site"));

        mainPage.checkIfCorrectPageOpen()
                .admissionCommitteeModuleClick();

        admissionsCommitteePage.checkIfCorrectPageOpen()
                .masterDegreeModuleClick()
                .tuitionFeesClick(fileName);
    }

    @Description("-----")
    @ParameterizedTest
    @MethodSource("PgupsTestData#test9TestData")
    public void test9(String fileName) { //todo check
        open(confProperties.getProperty("test-site"));

        mainPage.checkIfCorrectPageOpen()
                .pgupsMuseumClick();

        pgupsMuseumPage.checkIfCorrectPageOpen()
                .planOfScientificEventsClick(fileName);
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