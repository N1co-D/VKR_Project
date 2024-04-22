package selenium.junit;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class PgupsTestData {
    static Stream<Arguments> test1TestData() {
        String inputText = "ИСМ-310";
        String searchedGroup = "ИСМ-310";
        String dayOfWeek = "Среда";
        String pairNumber = "6";
        String expectedPairName = "Управление разработкой ИС на транспорте";
        return Stream.of(Arguments.of(inputText, searchedGroup, dayOfWeek, pairNumber, expectedPairName));
    }

    static Stream<Arguments> test2TestData() {
        String dormitoryNumber = "1";
        String expectedDormitoryAddress = "г. Санкт Петербург, ул. 7-я Красноармейская, д.12";
        return Stream.of(Arguments.of(dormitoryNumber, expectedDormitoryAddress));
    }

    static Stream<Arguments> test3TestData() {
        String expectedUrl = "https://www.pgups.ru/upload/medialibrary/e15/bqk4ibxl0e5vocvg62nc3op7v0ml1rrm/plan_priema_pgups_bak_spec_mag_2024_platnoe.pdf";
        return Stream.of(Arguments.of(expectedUrl));
    }

    static Stream<Arguments> test4TestData() {
        String year = "2023";
        String expectedUrl = "https://www.pgups.ru/upload/medialibrary/5c3/qxr9wpnvxsy27y6nzqyb03bkxvrxiix3/ucheb_plan_ism_2023.pdf";
        return Stream.of(Arguments.of(year, expectedUrl));
    }

    static Stream<Arguments> test5TestData() {
        String expectedEmail = "ait@pgups.ru";
        return Stream.of(Arguments.of(expectedEmail));
    }

    static Stream<Arguments> test6TestData() {
        String expectedUrl = "https://prioritet2030.pgups.ru/pages/digital-department/digital-department/digital-department.html#program02";
        return Stream.of(Arguments.of(expectedUrl));
    }

    static Stream<Arguments> test7TestData() {
        String expectedUrl = "https://www.pgups.ru/upload/iblock/6b7/p7bep73wgwjlthuecon2rap3cs66ka6j/Plan-nauchnykh-meropriyatiy-na-2024-god.pdf";
        return Stream.of(Arguments.of(expectedUrl));
    }

    static Stream<Arguments> test8TestData() {
        String expectedUrl = "https://www.pgups.ru/upload/medialibrary/697/stoimost_obuch_1_kurs_18042022.pdf";
        return Stream.of(Arguments.of(expectedUrl));
    }

    static Stream<Arguments> test9TestData() {
        String expectedUrl = "https://www.pgups.ru/struct/muzey_pgups/";
        return Stream.of(Arguments.of(expectedUrl));
    }

    static Stream<Arguments> test10TestData() {
        String expectedStartDate = "01.09.2025";
        return Stream.of(Arguments.of(expectedStartDate));
    }
}