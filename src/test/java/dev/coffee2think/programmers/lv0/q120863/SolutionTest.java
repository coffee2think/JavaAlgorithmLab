package dev.coffee2think.programmers.lv0.q120863;

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
                Arguments.of("3x + 7 + x", "4x + 7"),
                Arguments.of("x + x + x", "3x"),
                Arguments.of("0", "0"),
                Arguments.of("3 + 1", "4"),
                Arguments.of("x", "x")
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void solutionTest(String polynomial, String expected) {
        assertEquals(expected, solution.solution(polynomial));
    }
}