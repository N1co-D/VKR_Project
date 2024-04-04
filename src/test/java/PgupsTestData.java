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

    static Stream<Arguments> test4TestData() {
        String year = "2023";
        return Stream.of(Arguments.of(year));
    }

    static Stream<Arguments> test5TestData() {
        String expectedEmail = "ait@pgups.ru";
        return Stream.of(Arguments.of(expectedEmail));
    }

    static Stream<Arguments> test10TestData() {
        String expectedStartDate = "01.09.2025";
        return Stream.of(Arguments.of(expectedStartDate));
    }
}