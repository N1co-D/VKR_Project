package testng.pages;

import com.codeborne.selenide.ex.UIAssertionError;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.testng.Assert.fail;

/**
 * Главная страница сайта PGUPS
 */
public class MainPage extends BasePage {
    private final String centralBanner = "//div[contains(@class,'owl-carousel main-slider')]";
    private final String priorityLogo = "//a[@title='Приоритет 2030']";
    private final String advancedEngineeringSchoolLogo = "//a[@title='Передовая инженерная школа']";
    private final String pgupsResources = "//span[text()='Ресурсы ПГУПС']";
    private final String forStudents = "//a[text()='Студентам']/ancestor::div[@class='dropdown']/a";
    private final String forApplicants = "//a[text()='Абитуриентам']/ancestor::div[@class='dropdown']/a";
    private final String educationModule = "//a[text()='Образование']/ancestor::li[@data-for-menu='/education/']";
    private final String contactsModule = "//a[text()='Контакты']/ancestor::li[@data-for-menu='/contacts/']";
    private final String scienceModule = "//a[text()='Наука']/ancestor::li[@data-for-menu='/science/']";
    private final String admissionCommittee = "//a[text()='Приемная комиссия']/ancestor::li[contains(@data-for-menu,'priem')]";
    private final String cultureAndSportsModule = "//a[text()='Культура и спорт']/ancestor::li[@data-for-menu='/culture-and-sport/']";
    private final String schedule = "//span[text()='ПГУПС.Расписание']/..";
    private final String dormitories = "//a[text()='Общежития']";
    private final String admissionsCommitteeWebsite = "//a[text()='Сайт приемной комиссии']";
    private final String admissionsCommitteeWebsiteFromModule = "//div[@data-menu='/priem_2020/']//a[text()='Сайт приемной комиссии']";
    private final String directionsAndSpecialties = "//a[text()='Направления и специальности']";
    private final String facultyContacts = "//a[text()='Контакты факультетов']";
    private final String scientificConferences = "//a[text()='Научные конференции']";
    private final String pgupsMuseum = "//div[@data-menu='/culture-and-sport/']//a[text()='Музей ПГУПС']";

    @Step("Открытие главной страницы")
    public MainPage checkIfCorrectPageOpen() {
        try {
            $x(centralBanner).should(visible, WAITING_TIME);
        } catch (UIAssertionError e) {
            makeScreenshot();
            fail("Не удалось подтвердить открытие ожидаемой страницы. " +
                    "Уникальный элемент страницы 'centralBanner' не был найден в течение заданного времени.");
        }
        makeScreenshot();
        return this;
    }

    @Step("Выбор раздела 'Приоритет 2030'")
    public MainPage priorityLogoClick() {
        jsClick($x(priorityLogo));
        return this;
    }

    @Step("Выбор раздела 'ПИШ'")
    public MainPage advancedEngineeringSchoolLogoClick() {
        jsClick($x(advancedEngineeringSchoolLogo));
        return this;
    }

    private MainPage pgupsResourcesClick() {
        jsClick($x(pgupsResources));
        return this;
    }

    @Step("Выбор расписания")
    public MainPage scheduleClick() {
        pgupsResourcesClick();
        jsClick($x(schedule));
        return this;
    }

    @Step("Выбор раздела 'Общежития'")
    public MainPage dormitoriesClick() {
        jsClick($x(forStudents));
        jsClick($x(dormitories));
        return this;
    }

    @Step("Выбор раздела 'Сайт приемной комиссии'")
    public MainPage admissionsCommitteeWebsiteClick() {
        jsClick($x(forApplicants));
        jsClick($x(admissionsCommitteeWebsite));
        return this;
    }

    @Step("Выбор раздела 'Направления и специальности'")
    public MainPage directionsAndSpecialtiesClick() {
        jsClick($x(educationModule));
        jsClick($x(directionsAndSpecialties));
        return this;
    }

    @Step("Выбор раздела 'Контакты факультетов'")
    public MainPage facultyContactsClick() {
        jsClick($x(contactsModule));
        jsClick($x(facultyContacts));
        return this;
    }

    @Step("Выбор раздела 'Научные конференции'")
    public MainPage scientificConferencesClick() {
        jsClick($x(scienceModule));
        jsClick($x(scientificConferences));
        return this;
    }

    @Step("Выбор раздела 'Приемная комиссия' через верхнее меню")
    public MainPage admissionCommitteeModuleClick() {
        jsClick($x(admissionCommittee));
        jsClick($x(admissionsCommitteeWebsiteFromModule));
        return this;
    }

    @Step("Выбор раздела 'Музей ПГУПС'")
    public MainPage pgupsMuseumClick() {
        jsClick($x(cultureAndSportsModule));
        jsClick($x(pgupsMuseum));
        return this;
    }
}