package dev.coffee2think.programmers.lv0.q120876;

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
                Arguments.of(new int[][]{{0,1},{2,5},{3,9}}, 2),
                Arguments.of(new int[][]{{-1,1},{1,3},{3,9}}, 0),
                Arguments.of(new int[][]{{0,5},{3,9},{1,10}}, 8)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void solutionTest(int[][] lines, int expected) {
        assertEquals(expected, solution.solution(lines));
    }
}