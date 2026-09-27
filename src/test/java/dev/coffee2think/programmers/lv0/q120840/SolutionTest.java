package dev.coffee2think.programmers.lv0.q120840;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final Solution solution = new Solution();

    private final long[] factorialArray = new long[21];

    // 프로그래머스 문제의 solution 검증
    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(3, 2, 3),
                Arguments.of(5, 3, 10)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void solutionTest(int balls, int share, int expected) {
        assertEquals(expected, solution.solution(balls, share));
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void dpSolutionTest(int balls, int share, int expected) {
        assertEquals(expected, solution.dpSolution(balls, share));
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void recursiveSolutionTest(int balls, int share, int expected) {
        assertEquals(expected, solution.recursiveSolution(balls, share));
    }

    // long으로 몇 팩토리얼까지 표현 가능한지 확인
    // Java에서 long 타입으로 factorial은 20!까지 밖에 저장할 수 없다.
    // 문제에서 balls > 20이므로, factorial을 이용하여 조합을 계산하는 것은 할 수 없다
    @Test
    void factorialRangeTest() {
        System.out.printf(
                "Long.MAX_VALUE=%,d, 자릿수=%d%n",
                Long.MAX_VALUE,
                (long) Math.log10(Long.MAX_VALUE) + 1
        );

        factorialArray[0] = 1;

        for (int i = 1; i < factorialArray.length; i++) {
            factorialArray[i] = factorialArray[i - 1] * i;

            System.out.printf(
                    "i=%d, i!=%,d, 자릿수=%d%n",
                    i,
                    factorialArray[i],
                    (long) Math.log10(factorialArray[i]) + 1
            );
        }
    }

    // n <= 30에서 조합의 최댓값 확인
    @Test
    void combinationRangeTest() {
        int maxCombination = 1;
        int maxN = 0;
        int maxR = 0;

        for (int n = 1; n <= 30; n++) {
            for (int r = 0; r <= n; r++) {
                int combination = calcCombination(n, r);

                if (combination > maxCombination) {
                    maxCombination = combination;
                    maxN = n;
                    maxR = r;
                }
            }
        }

        System.out.printf(
                "최댓값: C(%d %d)=%,d%n",
                maxN, maxR, maxCombination
        );

        assertEquals(155_117_520, maxCombination);
        assertEquals(30, maxN);
        assertEquals(15, maxR);
    }

    private int calcCombination(int n, int r) {
        int s = Math.min(r, n - r);
        long result = 1;

        for (int i = 1; i <= s; i++) {
            result = result * (n - i + 1) / i;

            if (result > Integer.MAX_VALUE) {
                throw new ArithmeticException(
                        "조합 계산 결과가 Integer.MAX_VALUE를 초과했습니다."
                );
            }
        }

        return (int) result;
    }
}