package dev.coffee2think.programmers.lv0.q120875;

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
                Arguments.of(new int[][]{{1,4},{9,2},{3,8},{11,6}}, 1),
                Arguments.of(new int[][]{{3,5},{4,1},{2,4},{5,10}}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void solutionTest(int[][] dots, int expected) {
        assertEquals(expected, solution.solution(dots));
    }
}