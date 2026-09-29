package dev.coffee2think.programmers.lv0.q120882;

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
                        new int[][]{{80, 70}, {90, 50}, {40, 70}, {50, 80}},
                        new int[]{1, 2, 4, 3}
                ),
                Arguments.of(
                        new int[][]{{80, 70}, {70, 80}, {30, 50}, {90, 100}, {100, 90}, {100, 100}, {10, 30}},
                        new int[]{4,  4, 6, 2, 2, 1, 7}
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void solutionTest(int[][] score, int[] expected) {
        assertArrayEquals(expected, solution.solution(score));
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void solution2Test(int[][] score, int[] expected) {
        assertArrayEquals(expected, solution.solution2(score));
    }
}