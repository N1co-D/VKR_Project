package selenide.testng;

import org.testng.annotations.DataProvider;

public class PgupsTestData {

    @DataProvider(name = "test1TestData")
    static Object[][] test1TestData() {
        String inputText = "ИСМ-310";
        String searchedGroup = "ИСМ-310";
        String dayOfWeek = "Среда";
        String pairNumber = "6";
        String expectedPairName = "Управление разработкой ИС на транспорте";
        return new Object[][]{{inputText, searchedGroup, dayOfWeek, pairNumber, expectedPairName}};
    }

    @DataProvider(name = "test2TestData")
    static Object[][] test2TestData() {
        String dormitoryNumber = "1";
        String expectedDormitoryAddress = "г. Санкт Петербург, ул. 7-я Красноармейская, д.12";
        return new Object[][]{{dormitoryNumber, expectedDormitoryAddress}};
    }

    @DataProvider(name = "test3TestData")
    static Object[][] test3TestData() {
        String fileName = "plan_priema_pgups_bak_spec_mag_2024_platnoe.pdf";
        return new Object[][]{{fileName}};
    }

    @DataProvider(name = "test4TestData")
    static Object[][] test4TestData() {
        String year = "2023";
        String fileName = "ucheb_plan_ism_2023.pdf";
        return new Object[][]{{year, fileName}};
    }

    @DataProvider(name = "test5TestData")
    static Object[][] test5TestData() {
        String expectedEmail = "ait@pgups.ru";
        return new Object[][]{{expectedEmail}};
    }

    @DataProvider(name = "test6TestData")
    static Object[][] test6TestData() {
        String expectedUrl = "https://prioritet2030.pgups.ru/pages/digital-department/digital-department/digital-department.html#program02";
        return new Object[][]{{expectedUrl}};
    }

    @DataProvider(name = "test7TestData")
    static Object[][] test7TestData() {
        String fileName = "Plan-nauchnykh-meropriyatiy-na-2024-god.pdf";
        return new Object[][]{{fileName}};
    }

    @DataProvider(name = "test8TestData")
    static Object[][] test8TestData() {
        String fileName = "Prikaz-setevye-programmy-TGEU-2023_2024.pdf";
        return new Object[][]{{fileName}};
    }

    @DataProvider(name = "test9TestData")
    static Object[][] test9TestData() {
        String fileName = "sajavka_na_excursiju.doc";
        return new Object[][]{{fileName}};
    }

    @DataProvider(name = "test10TestData")
    static Object[][] test10TestData() {
        String expectedStartDate = "01.09.2025";
        return new Object[][]{{expectedStartDate}};
    }
}