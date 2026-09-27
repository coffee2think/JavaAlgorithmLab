package dev.coffee2think.programmers.lv0.q120860;

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
                        new int[][]{{1, 1}, {2, 1}, {2, 2}, {1, 2}},
                        1
                ),
                Arguments.of(
                        new int[][]{{-1, -1}, {1, 1}, {1, -1}, {-1, 1}},
                        4
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void solutionTest(int[][] dots, int expected) {
        assertEquals(expected, solution.solution(dots));
    }
}