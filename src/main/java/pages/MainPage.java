package pages;

import com.codeborne.selenide.ex.UIAssertionError;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.fail;

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

    @Step("Открытие страницы авторизации")
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

    @Step("Ввод данных пользователя: электронная почта и пароль")//todo
    public MainPage priorityLogoClick() {
        jsClick($x(priorityLogo));
        makeScreenshot();
        return this;
    }

    @Step("Ввод данных пользователя: электронная почта и пароль")//todo
    public MainPage advancedEngineeringSchoolLogoClick() {
        jsClick($x(advancedEngineeringSchoolLogo));
        makeScreenshot();
        return this;
    }

    @Step("Ввод данных пользователя: электронная почта и пароль")//todo
    public MainPage pgupsResourcesClick() {
        jsClick($x(pgupsResources));
        makeScreenshot();
        return this;
    }

    @Step("Ввод данных пользователя: электронная почта и пароль")//todo
    public MainPage scheduleClick() {
        pgupsResourcesClick();
        jsClick($x(schedule));
        return this;
    }

    @Step("Ввод данных пользователя: электронная почта и пароль")//todo
    public MainPage dormitoriesClick() {
        jsClick($x(forStudents));
        jsClick($x(dormitories));
        makeScreenshot();
        return this;
    }

    @Step("Ввод данных пользователя: электронная почта и пароль")//todo
    public MainPage admissionsCommitteeWebsiteClick() {
        jsClick($x(forApplicants));
        jsClick($x(admissionsCommitteeWebsite));
        makeScreenshot();
        return this;
    }

    @Step("Ввод данных пользователя: электронная почта и пароль")//todo
    public MainPage directionsAndSpecialtiesClick() {
        jsClick($x(educationModule));
        jsClick($x(directionsAndSpecialties));
        makeScreenshot();
        return this;
    }

    @Step("Ввод данных пользователя: электронная почта и пароль")//todo
    public MainPage facultyContactsClick() {
        jsClick($x(contactsModule));
        jsClick($x(facultyContacts));
        makeScreenshot();
        return this;
    }

    @Step("Ввод данных пользователя: электронная почта и пароль")//todo
    public MainPage scientificConferencesClick() {
        jsClick($x(scienceModule));
        jsClick($x(scientificConferences));
        makeScreenshot();
        return this;
    }

    @Step("Ввод данных пользователя: электронная почта и пароль")//todo
    public MainPage admissionCommitteeModuleClick() {
        jsClick($x(admissionCommittee));
        jsClick($x(admissionsCommitteeWebsiteFromModule));
        makeScreenshot();
        return this;
    }

    @Step("Ввод данных пользователя: электронная почта и пароль")//todo
    public MainPage pgupsMuseumClick() {
        jsClick($x(cultureAndSportsModule));
        jsClick($x(pgupsMuseum));
        makeScreenshot();
        return this;
    }

//    @Step("Ввод запроса '{searchedProduct}' в поле поиска")
//    public MainPage inputBoxWriteText(String searchedProduct) {
//        jsClick($x(productSearchField));
//        $x(productSearchField).sendKeys(searchedProduct);
//        makeScreenshot();
//        return this;
//    }
//
//    @Step("Поиск товара '{searchedProduct}' через поле поиска")
//    public MainPage searchProductByInputBox(String searchedProduct) {
//        inputBoxWriteText(searchedProduct);
//        $x(productSearchField).should(visible, WAITING_TIME)
//                .pressEnter();
//        return this;
//    }
//
//    public ResultsPage productSearchExtraResultListClick(String gameName) {
//        $$x(searchDropDownList).shouldBe(sizeGreaterThan(0), WAITING_TIME)
//                .findBy(text(gameName)).click();
//        return new ResultsPage();
//    }
//
//    @Step("Открытие каталога товаров")
//    public MainPage productCatalogClick() {
//        jsClick($x(productCatalog));
//        makeScreenshot();
//        return this;
//    }
//
//    public boolean compareValueIsDisplayed() {
//        return $x(compareValue).shouldBe(visible, WAITING_TIME).isDisplayed();
//    }
//
//    public ComparePage compareButtonClick() {
//        $x(compareButton).shouldBe(visible, WAITING_TIME).click();
//        return new ComparePage();
//    }
//
//    public MainPage clickPopularCategoryTile(String nameCategory) {
//        $x(String.format(popularCategoryTile, nameCategory))
//                .scrollIntoView("{behavior: \"smooth\", block: \"center\", inline: \"nearest\"}")
//                .should(visible, WAITING_TIME)
//                .click();
//        return this;
//    }
//
//    @Step("Выбор категории 'Телевизоры, аудио-видео техника'")
//    public MainPage televisionsAndAudioVideoEquipmentCategoryClick() {
//        $x(televisionsAndAudioVideoEquipmentCategory).should(visible, WAITING_TIME);
//        actions().moveToElement($x(televisionsAndAudioVideoEquipmentCategory)).perform();
//        makeScreenshot();
//        return this;
//    }
//
//    @Step("Выбор подкатегории 'Телевизоры OLED'")
//    public MainPage oledTelevisionsCategoryClick() {
//        jsClick($x(oledTelevisionsCategory));
//        return this;
//    }
//
//    @Step("Выбор подсказки '{productFromDropDownList}' при вводе запроса в поле поиска")
//    public MainPage clickOnProductFromDropDownList(String productFromDropDownList) {
//        jsClick($x(searchCategoryInDropDownMenu + productFromDropDownList + "']"));
//        return this;
//    }
//
//    @Step("Переход на страницу корзины через верхнее меню")
//    public MainPage cartButtonClick() {
//        jsClick($x(cartButton));
//        return this;
//    }
//
//    public MainPage enterSearchProductInputLine(String nameProduct) {
//        $x(productSearchField)
//                .should(visible, WAITING_TIME)
//                .val(nameProduct).pressEnter();
//        return this;
//    }
//
//    public ResultsPage searchButtonClick() {
//        executeJavaScript("arguments[0].click()",
//                $x(searchButton).shouldBe(visible, WAITING_TIME));
//        return new ResultsPage();
//    }
//
//    public MainPage enterProductInputLineAndClickSearchButton(String nameProduct) {
//        $x(productSearchInputLine)
//                .should(visible, WAITING_TIME)
//                .sendKeys(nameProduct);
//        clickSearchButton();
//        return this;
//    }
//
//    private void clickSearchButton() {
//        $x(searchButton)
//                .should(visible, WAITING_TIME)
//                .click();
//    }
//
//    public MainPage clickCatalogMenuButton() {
//        $x(catalogMenuButton).shouldBe(visible, WAITING_TIME).click();
//        return this;
//    }
//
//    public MainPage clickCatalogCategoryButton(String nameCategory) {
//        $x(String.format(catalogCategoryButton, nameCategory))
//                .should(visible, WAITING_TIME)
//                .click();
//        return this;
//    }
}