package dev.coffee2think.programmers.lv0.q120883;

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
                        new String[]{"meosseugi", "1234"},
                        new String[][]{{"rardss", "123"}, {"yyoom", "1234"}, {"meosseugi", "1234"}},
                        "login"
                ),
                Arguments.of(
                        new String[]{"programmer01", "15789"},
                        new String[][]{{"programmer02", "111111"}, {"programmer00", "134"}, {"programmer01", "1145"}},
                        "wrong pw"
                ),
                Arguments.of(
                        new String[]{"rabbit04", "98761"},
                        new String[][]{{"jaja11", "98761"}, {"krong0313", "29440"}, {"rabbit00", "111333"}},
                        "fail"
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void solutionTest(String[] id_pw, String[][] db, String expected) {
        assertEquals(expected, solution.solution(id_pw, db));
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void mapSolutionTest(String[] id_pw, String[][] db, String expected) {
        assertEquals(expected, solution.mapSolution(id_pw, db));
    }
}