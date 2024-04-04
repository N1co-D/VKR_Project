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
                .numberOfPaidPlacesForAdmissionDownloadButtonClick();
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
                .informationSystemsAndTechnologiesInTransportEducationPlanClick(year);
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
                .planOfScientificEventsClick();
    }

    @Description("-----")
    @Test
    public void test8() { //todo check
        open(confProperties.getProperty("test-site"));

        mainPage.checkIfCorrectPageOpen()
                .admissionCommitteeModuleClick();

        admissionsCommitteePage.checkIfCorrectPageOpen()
                .masterDegreeModuleClick()
                .tuitionFeesClick();
    }

    @Description("-----")
    @Test
    public void test9() { //todo check
        open(confProperties.getProperty("test-site"));

        mainPage.checkIfCorrectPageOpen()
                .pgupsMuseumClick();

        pgupsMuseumPage.checkIfCorrectPageOpen()
                .planOfScientificEventsClick();
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
//                    .searchProductByInputBox(inputText);

//        resultsPage.checkIfCorrectPageOpen()
//                .enableDetailedCatalogMode()
//                .requiredProductWithParametersBuyingClick(rawMemoryRequiredParameter, diskRequiredParameter)
//                .checkAppearWindowWithAddedProductInCartStatus()
//                .closeWindowWithAddedProductInCartStatusClick()
//                .checkDisappearWindowWithAddedProductInCartStatus()
//                .cartButtonClick();
//
//        cartPage.checkIfCorrectPageOpen()
//                .increaseTheAmountOfProductInCartButtonClick(amountOfProductsForIncrease)
//                .checkAmountOfProductInCart(expectedAmountOfProduct);
//}

//    @ParameterizedTest
//    @MethodSource("ru.citilink.PgupsTestData#dataForComparisonTest")
//    public void checkAddProductToCompare(String testLaptop, String productCategory) {
//        open(confProperties.getProperty("test-site"));
//        mainPage.inputBoxWriteText("lenovo").productSearchExtraResultListClick(productCategory);
//        assertEquals(productCategory, resultsPage.getSubcategoryPageTitle(),
//                String.format("Указан заголовок некорректной страницы. Ожидаем = %s, факт = %s",
//                        productCategory, resultsPage.getSubcategoryPageTitle()));
//
//        resultsPage.detailedCatalogModeButtonClick().comparingCurrentProductButtonClick(testLaptop);
//        assertTrue(mainPage.compareValueIsDisplayed(), "Товар не добавлен в сравнение");
//        String priceOfCurrentProduct = resultsPage.getPriceOfCurrentProduct(testLaptop);
//        mainPage.compareButtonClick();
//
//        assertAll(
//                () -> assertEquals("Сравнение товаров", comparePage.getComparePageTitle(),
//                        String.format("Указан заголовок некорректной страницы. Ожидаем = Сравнение товаров, факт = %s",
//                                comparePage.getComparePageTitle())),
//                () -> assertEquals(testLaptop, comparePage.getProductTitle(),
//                        String.format("Товар для сравнения не корректный. Ожидаем = %s, факт = %s",
//                                testLaptop, comparePage.getComparePageTitle())),
//                () -> assertEquals(priceOfCurrentProduct, comparePage.getProductPrice(),
//                        String.format("Цена товара указанна не корректно. Ожидаем = %s, факт = %s",
//                                priceOfCurrentProduct, comparePage.getComparePageTitle())));
//    }
//
//    @ParameterizedTest
//    @MethodSource("ru.citilink.PgupsTestData#checkFilterProductsByParametersTestData")
//    public void checkFilterProductsByParameters(String categoryName,
//                                                String brandFilterCategory,
//                                                String screenDiagonalFilterCategory,
//                                                String processorSeriesFilterCategory,
//                                                String brandName,
//                                                String diagonalValue,
//                                                String cpuValue) {
//
//        open(confProperties.getProperty("test-site"));
//
//        mainPage.clickPopularCategoryTile(categoryName);
//
//        resultsPage.clickFilterDropDownCategoryAndValue(brandFilterCategory, brandName)
//                .clickFilterDropDownCategoryAndValue(screenDiagonalFilterCategory, diagonalValue)
//                .clickFilterDropDownCategoryAndValue(processorSeriesFilterCategory, cpuValue)
//                .clickDetailCatalogModeButton()
//                .checkProductsAfterFiltration(brandName, diagonalValue, cpuValue);
//    }
//
//    @Description("TC-ID7 Проверка увеличения количества добавленных в корзину товаров")
//    @ParameterizedTest
//    @MethodSource("ru.citilink.PgupsTestData#checkIncreaseInQuantityWhenAddProductsToCartTestData")
//    public void checkIncreaseInQuantityWhenAddProductsToCart(String inputText,
//                                                             String rawMemoryRequiredParameter,
//                                                             String diskRequiredParameter,
//                                                             int amountOfProductsForIncrease,
//                                                             String expectedAmountOfProduct) {
//        open(confProperties.getProperty("test-site"));
//
//        mainPage.checkIfCorrectPageOpen()
//                .searchProductByInputBox(inputText);
//
//        resultsPage.checkIfCorrectPageOpen()
//                .enableDetailedCatalogMode()
//                .requiredProductWithParametersBuyingClick(rawMemoryRequiredParameter, diskRequiredParameter)
//                .checkAppearWindowWithAddedProductInCartStatus()
//                .closeWindowWithAddedProductInCartStatusClick()
//                .checkDisappearWindowWithAddedProductInCartStatus()
//                .cartButtonClick();
//
//        cartPage.checkIfCorrectPageOpen()
//                .increaseTheAmountOfProductInCartButtonClick(amountOfProductsForIncrease)
//                .checkAmountOfProductInCart(expectedAmountOfProduct);
//    }
//
//    @ParameterizedTest
//    @MethodSource("ru.citilink.PgupsTestData#dataForComparisonTest")
//    public void checkRemoveProductFromComparison(String testLaptop, String productCategory) {
//        open(confProperties.getProperty("test-site"));
//        mainPage.inputBoxWriteText("lenovo")
//                .productSearchExtraResultListClick(productCategory);
//        assertEquals(productCategory, resultsPage.getSubcategoryPageTitle(),
//                String.format("Указан заголовок некорректной страницы. Ожидаем = %s, факт = %s",
//                        productCategory, resultsPage.getSubcategoryPageTitle()));
//
//        resultsPage.detailedCatalogModeButtonClick()
//                .comparingCurrentProductButtonClick(testLaptop);
//        assertTrue(mainPage.compareValueIsDisplayed(), "Товар не добавлен в сравнение");
//        mainPage.compareButtonClick();
//        assertAll(
//                () -> assertEquals("Сравнение товаров", comparePage.getComparePageTitle(),
//                        String.format("Указан заголовок некорректной страницы. Ожидаем = Сравнение товаров, факт = %s",
//                                comparePage.getComparePageTitle())),
//                () -> assertEquals(testLaptop, comparePage.getProductTitle(),
//                        String.format("Товар для сравнения не корректный. Ожидаем = %s, факт = %s",
//                                testLaptop, comparePage.getComparePageTitle())));
//
//        comparePage.deleteProductButtonClick();
//        assertAll(
//                () -> assertFalse(comparePage.compareValueIsDisplayed(), "Товар не удалён из сравнение"),
//                () -> assertTrue(comparePage.noProductsForCompareIsDisplayed(), "Отсутствует уведомление Нет товаров для сравнения"));
//    }
//
//    @Description("TC-ID8 Проверка добавления товаров в список сравнения")
//    @ParameterizedTest
//    @MethodSource("ru.citilink.PgupsTestData#checkProductAddToCompareSectionTestData")
//    public void checkProductAddToCompareSection(int amountOfProductsForAdding) {
//        open(confProperties.getProperty("test-site"));
//
//        mainPage.checkIfCorrectPageOpen()
//                .productCatalogClick()
//                .televisionsAndAudioVideoEquipmentCategoryClick()
//                .oledTelevisionsCategoryClick();
//
//        resultsPage.checkIfCorrectPageOpen()
//                .enableDetailedCatalogMode()
//                .someProductAddToComparingClick(amountOfProductsForAdding)
//                .checkAmountOfAddedProductsToCompare(amountOfProductsForAdding)
//                .comparingButtonClick();
//
//        comparePage.checkIfCorrectPageOpen()
//                .checkAmountOfAddedProductsToCompare(amountOfProductsForAdding);
//    }
//
//    @Description("TC-ID1 Проверка добавления товаров в корзину")
//    @ParameterizedTest
//    @MethodSource("ru.citilink.PgupsTestData#checkProductAddToCartTestData")
//    public void checkProductAddToCart(String inputText,
//                                      String productFromDropDownList,
//                                      String observedProduct,
//                                      String expectedProductCode) {
//        open(confProperties.getProperty("test-site"));
//
//        mainPage.checkIfCorrectPageOpen()
//                .inputBoxWriteText(inputText)
//                .clickOnProductFromDropDownList(productFromDropDownList);
//
//        resultsPage.checkIfCorrectPageOpen()
//                .enableDetailedCatalogMode()
//                .requiredProductBuyingClick(observedProduct)
//                .checkAppearWindowWithAddedProductInCartStatus()
//                .goToCartButtonClickWithPopupWindow();
//
//        cartPage.checkIfCorrectPageOpen()
//                .checkIsCorrectCodeNumberOfProductInCart(expectedProductCode);
//    }
//
//    @Description("TC-ID2 Проверка удаления товара из корзины")
//    @ParameterizedTest
//    @MethodSource("ru.citilink.PgupsTestData#checkTheDeletingOfProductFromCartTestData")
//    public void checkTheDeletingOfProductFromCart(String inputText,
//                                                  String productFromDropDownList,
//                                                  String observedProduct) {
//        open(confProperties.getProperty("test-site"));
//
//        mainPage.checkIfCorrectPageOpen()
//                .inputBoxWriteText(inputText)
//                .clickOnProductFromDropDownList(productFromDropDownList);
//
//        resultsPage.checkIfCorrectPageOpen()
//                .enableDetailedCatalogMode()
//                .requiredProductBuyingClick(observedProduct)
//                .checkAppearWindowWithAddedProductInCartStatus()
//                .closeWindowWithAddedProductInCartStatusClick()
//                .checkDisappearWindowWithAddedProductInCartStatus()
//                .returnToMainPage();
//
//        mainPage.checkIfCorrectPageOpen()
//                .cartButtonClick();
//
//        cartPage.checkIfCorrectPageOpen()
//                .deleteRequiredProductInCartButtonClick(observedProduct)
//                .checkIsVisibleStatusOfMissingProductsInCart()
//                .goBackToShoppingButtonClick();
//
//        mainPage.checkIfCorrectPageOpen();
//    }
//
//    @ParameterizedTest
//    @MethodSource("ru.citilink.PgupsTestData#checkItemAddToCartTestData")
//    public void checkItemAddToCart(String productName) {
//        open(confProperties.getProperty("test-site"));
//
//        mainPage.enterSearchProductInputLine(productName);
//        resultsPage
//                .clickAddItemToBasketButton(productName)
//                .clickCloseUpSaleBasketLayoutButton()
//                .clickBasketFresnelContainerButton();
//
//        assertEquals(productName, cartPage.getNameProductFromBasketSnippet());
//    }
//
//    @ParameterizedTest
//    @MethodSource("ru.citilink.PgupsTestData#dataForCheckCorrectReflection")
//    public void checkCorrectReflectionProductNameInAccordanceWithFilterParameters(String searchedProduct,
//                                                                                  String sortingParameter,
//                                                                                  String rating,
//                                                                                  String observedProduct,
//                                                                                  String category) {
//        open(confProperties.getProperty("test-site"));
//        mainPage.inputBoxWriteText(searchedProduct).searchButtonClick();
//        assertEquals(String.format("Результаты для «%s»", searchedProduct), resultsPage.getSearchTitle(),
//                String.format("Указан заголовок некорректной страницы. Ожидаем = Результаты для «%s», факт = %s",
//                        searchedProduct, resultsPage.getSearchTitle()));
//
//        resultsPage.detailedCatalogModeButtonClick()
//                .laptopCategoryButtonClick();
//        assertEquals(category, resultsPage.getCategoryTitle(),
//                String.format("Указана не верная категория. Ожидаем = %s, факт = %s",
//                        category, resultsPage.getCategoryTitle()));
//
//        resultsPage.sortingItemClick(sortingParameter)
//                .sortingItemStatus(sortingParameter);
//        assertTrue(resultsPage.sortingPriceResult(), "Цена в списке идёт не по возрастанию");
//
//        resultsPage.feedbackFilterClick(rating)
//                .feedbackFilterStatus(rating);
//
//        resultsPage.buyFirstProductFromList()
//                .checkAppearWindowWithAddedProductInCartStatus()
//                .goToCartButtonClickWithPopupWindow();
//
//        cartPage.checkProductTitleCart(observedProduct);
//    }
//
//    @ParameterizedTest
//    @MethodSource("ru.citilink.PgupsTestData#checkProductNameAfterFilterParamDataTest")
//    public void checkProductNameAfterFilterParam(String categoryName,
//                                                 String subcategoryName,
//                                                 String brandName,
//                                                 String seriesFilterCategory,
//                                                 String seriesValue,
//                                                 String productName,
//                                                 String productAvailFilterCategory,
//                                                 String productAvailValue) {
//
//        open(confProperties.getProperty("test-site"));
//
//        mainPage.clickCatalogMenuButton()
//                .clickCatalogCategoryButton(categoryName);
//
//        resultsPage.clickDropDownlistShowMoreButton(subcategoryName)
//                .clickUnderSubcategoryButton(subcategoryName, brandName)
//                .clickFilterDropDownCategoryAndValue(seriesFilterCategory, seriesValue)
//                .clickFilterDropDownCategoryAndValue(productAvailFilterCategory, productAvailValue)
//                .clickAddFirstItemToBasketButton()
//                .clickUpsaleBasketBlockGoShopCartButton();
//
//        assertEquals(productName,
//                cartPage.getNameProductFromBasketSnippet());
//    }