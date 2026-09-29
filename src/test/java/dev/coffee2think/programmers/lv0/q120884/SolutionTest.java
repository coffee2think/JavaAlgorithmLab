package dev.coffee2think.programmers.lv0.q120884;

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
                        100,
                        11
                ),
                Arguments.of(
                        1081,
                        120
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void solutionTest(int n, int expected) {
        assertEquals(expected, solution.solution(n));
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void mathematicSolutionTest(int n, int expected) {
        assertEquals(expected, solution.mathematicSolution(n));
    }
}