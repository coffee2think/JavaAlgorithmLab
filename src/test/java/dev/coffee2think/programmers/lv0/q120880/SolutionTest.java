package dev.coffee2think.programmers.lv0.q120880;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final Solution solution = new Solution();

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, 4, new int[]{4, 5, 3, 6, 2, 1}),
                Arguments.of(new int[]{10000,20,36,47,40,6,10,7000}, 30, new int[]{36, 40, 20, 47, 10, 6, 7000, 10000}),
                Arguments.of(new int[]{10000,25,36,47,40,6,10,7000}, 30, new int[]{25, 36, 40, 47, 10, 6, 7000, 10000})
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void solutionBinarySearch1Test(int[] numlist, int n, int[] expected) {
        assertArrayEquals(expected, solution.solutionBinarySearch1(numlist, n));
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void solutionBinarySearch2Test(int[] numlist, int n, int[] expected) {
        assertArrayEquals(expected, solution.solutionBinarySearch2(numlist, n));
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void solutionIntegerSortTest(int[] numlist, int n, int[] expected) {
        assertArrayEquals(expected, solution.solutionIntegerSort(numlist, n));
    }
}