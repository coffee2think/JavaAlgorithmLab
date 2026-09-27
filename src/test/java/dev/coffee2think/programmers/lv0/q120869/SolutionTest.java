package dev.coffee2think.programmers.lv0.q120869;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final Solution solution = new Solution();

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(
                        new String[]{"p", "o", "s"},
                        new String[]{"sod", "eocd", "qixm", "adio", "soo"},
                        2
                ),
                Arguments.of(
                        new String[]{"z", "d", "x"},
                        new String[]{"def", "dww", "dzx", "loveaw"},
                        1
                ),
                Arguments.of(
                        new String[]{"s", "o", "m", "d"},
                        new String[]{"moos", "dzx", "smm", "sunmmo", "som"},
                        2
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void solutionTest(String[] spell, String[] dic, int expected) {
        assertEquals(expected, solution.solution(spell, dic));
    }
}