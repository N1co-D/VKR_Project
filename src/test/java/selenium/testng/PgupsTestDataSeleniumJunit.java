package selenium.testng;

import org.testng.annotations.DataProvider;

public class PgupsTestDataSeleniumJunit {

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
        String expectedUrl = "https://www.pgups.ru/upload/medialibrary/e15/bqk4ibxl0e5vocvg62nc3op7v0ml1rrm/plan_priema_pgups_bak_spec_mag_2024_platnoe.pdf";
        return new Object[][]{{expectedUrl}};
    }

    @DataProvider(name = "test4TestData")
    static Object[][] test4TestData() {
        String year = "2023";
        String expectedUrl = "https://www.pgups.ru/upload/medialibrary/5c3/qxr9wpnvxsy27y6nzqyb03bkxvrxiix3/ucheb_plan_ism_2023.pdf";
        return new Object[][]{{year, expectedUrl}};
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
        String expectedUrl = "https://www.pgups.ru/upload/iblock/6b7/p7bep73wgwjlthuecon2rap3cs66ka6j/Plan-nauchnykh-meropriyatiy-na-2024-god.pdf";
        return new Object[][]{{expectedUrl}};
    }

    @DataProvider(name = "test8TestData")
    static Object[][] test8TestData() {
        String expectedUrl = "https://www.pgups.ru/upload/medialibrary/697/stoimost_obuch_1_kurs_18042022.pdf";
        return new Object[][]{{expectedUrl}};
    }

    @DataProvider(name = "test9TestData")
    static Object[][] test9TestData() {
        String expectedUrl = "https://www.pgups.ru/struct/muzey_pgups/";
        return new Object[][]{{expectedUrl}};
    }

    @DataProvider(name = "test10TestData")
    static Object[][] test10TestData() {
        String expectedStartDate = "01.09.2025";
        return new Object[][]{{expectedStartDate}};
    }
}