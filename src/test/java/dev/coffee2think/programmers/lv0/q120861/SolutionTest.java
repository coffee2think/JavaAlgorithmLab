package dev.coffee2think.programmers.lv0.q120861;

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
                        new String[]{"left", "right", "up", "right", "right"},
                        new int[]{11, 11},
                        new int[]{2, 1}
                ),
                Arguments.of(
                        new String[]{"down", "down", "down", "down", "down"},
                        new int[]{7, 9},
                        new int[]{0, -4}
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void solutionTest(String[] keyinput, int[] board, int[] expected) {
        assertArrayEquals(expected, solution.solution(keyinput, board));
    }
}