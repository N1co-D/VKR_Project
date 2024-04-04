import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class PgupsTestData {
    static Stream<Arguments> test1TestData() {
        String inputText = "ИСМ-310";
        String searchedGroup = "ИСМ-310";
        String dayOfWeek = "Среда";
        String pairNumber = "6";
        String expectedPairName = "Модели информационных систем";
        return Stream.of(Arguments.of(inputText, searchedGroup, dayOfWeek, pairNumber, expectedPairName));
    }

    static Stream<Arguments> test2TestData() {
        String dormitoryNumber = "1";
        String expectedDormitoryAddress = "г. Санкт Петербург, ул. 7-я Красноармейская, д.12";
        return Stream.of(Arguments.of(dormitoryNumber, expectedDormitoryAddress));
    }

    static Stream<Arguments> test3TestData() {
        String fileName = "plan_priema_pgups_bak_spec_mag_2024_platnoe.pdf";
        return Stream.of(Arguments.of(fileName));
    }

    static Stream<Arguments> test4TestData() {
        String year = "2023";
        String fileName = "ucheb_plan_ism_2023.pdf";
        return Stream.of(Arguments.of(year, fileName));
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
        String fileName = "Plan-nauchnykh-meropriyatiy-na-2024-god.pdf";
        return Stream.of(Arguments.of(fileName));
    }

    static Stream<Arguments> test8TestData() {
        String fileName = "stoimost_obuch_1_kurs_18042022.pdf";
        return Stream.of(Arguments.of(fileName));
    }

    static Stream<Arguments> test9TestData() {
        String fileName = "sajavka_na_excursiju.doc";
        return Stream.of(Arguments.of(fileName));
    }

    static Stream<Arguments> test10TestData() {
        String expectedStartDate = "01.09.2025";
        return Stream.of(Arguments.of(expectedStartDate));
    }
}