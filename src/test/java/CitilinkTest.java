import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.SchedulePage;
import utilites.ConfProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.codeborne.selenide.Selenide.open;

public class CitilinkTest extends BaseTest {
    private final MainPage mainPage = new MainPage();
    private final SchedulePage schedulePage = new SchedulePage();
    private final ConfProperties confProperties = new ConfProperties();


    //    @Description("-----")
    //    @ParameterizedTest
//    @MethodSource("ru.citilink.CitilinkTestData#checkIncreaseInQuantityWhenAddProductsToCartTestData")
//    public void checkIncreaseInQuantityWhenAddProductsToCart(String inputText,
//                                                             String rawMemoryRequiredParameter,
//                                                             String diskRequiredParameter,
//                                                             int amountOfProductsForIncrease,
//                                                             String expectedAmountOfProduct) {
    @Description("-----")
    @Test
    public void checkIncreaseInQuantityWhenAddProductsToCart() {
        open(confProperties.getProperty("test-site"));

        mainPage.checkIfCorrectPageOpen()
                .scheduleClick();

        List<String> allWindowHandles = new ArrayList<>(WebDriverRunner.getWebDriver().getWindowHandles());
        String windowToSwitch = allWindowHandles.get(allWindowHandles.size() - 1);
        WebDriverRunner.getWebDriver().switchTo().window(windowToSwitch);

        schedulePage.checkIfCorrectPageOpen()
                .searchByGroup("ИСМ-310")
                .resultGroupClick("ИСМ-310")
                .checkPairName("Среда", "6", "Модели информационных систем");
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
//    @MethodSource("ru.citilink.CitilinkTestData#dataForComparisonTest")
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
//    @MethodSource("ru.citilink.CitilinkTestData#checkFilterProductsByParametersTestData")
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
//    @MethodSource("ru.citilink.CitilinkTestData#checkIncreaseInQuantityWhenAddProductsToCartTestData")
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
//    @MethodSource("ru.citilink.CitilinkTestData#dataForComparisonTest")
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
//    @MethodSource("ru.citilink.CitilinkTestData#checkProductAddToCompareSectionTestData")
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
//    @MethodSource("ru.citilink.CitilinkTestData#checkProductAddToCartTestData")
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
//    @MethodSource("ru.citilink.CitilinkTestData#checkTheDeletingOfProductFromCartTestData")
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
//    @MethodSource("ru.citilink.CitilinkTestData#checkItemAddToCartTestData")
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
//    @MethodSource("ru.citilink.CitilinkTestData#dataForCheckCorrectReflection")
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
//    @MethodSource("ru.citilink.CitilinkTestData#checkProductNameAfterFilterParamDataTest")
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