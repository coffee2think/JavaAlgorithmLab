package dev.coffee2think.programmers.lv0.q120866;

import dev.coffee2think.common.ExecutionTimeExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ExecutionTimeExtension.class)
class SolutionTest {

    private final Solution solution = new Solution();

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                {0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0},
                                {0, 0, 1, 0, 0},
                                {0, 0, 0, 0, 0}
                        }, 16),
                Arguments.of(
                        new int[][]{
                                {0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0},
                                {0, 0, 1, 1, 0},
                                {0, 0, 0, 0, 0}
                        }, 13),
                Arguments.of(
                        new int[][]{
                                {1, 1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1, 1}
                        }, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void solutionTest(int[][] board, int expected) {
        assertEquals(expected, solution.solution(board));
    }
}