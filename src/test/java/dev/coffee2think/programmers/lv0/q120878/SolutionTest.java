package dev.coffee2think.programmers.lv0.q120878;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.function.IntPredicate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final Solution solution = new Solution();

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(7, 20, 1),
                Arguments.of(11, 22, 1),
                Arguments.of(12, 21, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void solutionReductionTest(int a, int b, int expected) {
        assertEquals(expected, solution.solutionReduction(a, b));
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void solutionGcdTest(int a, int b, int expected) {
        assertEquals(expected, solution.solutionGcd(a, b));
    }

    @Nested
    @DisplayName("isPrime 소수 판별 테스트")
    class IsPrimeTest {
        IntPredicate isPrime = solution::isPrime2;


        @ParameterizedTest
        @ValueSource(ints = {-10, -1, 0, 1})
        @DisplayName("2보다 작은 수는 소수가 아니다")
        void lessThanTwo(int n) {
            assertFalse(isPrime.test(n));
        }

        @ParameterizedTest
        @ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 23, 29})
        @DisplayName("소수는 true를 반환한다")
        void primeNumbers(int n) {
            assertTrue(isPrime.test(n));
        }

        @ParameterizedTest
        @ValueSource(ints = {4, 6, 8, 9, 10, 12, 15, 21, 25, 49})
        @DisplayName("합성수는 false를 반환한다")
        void compositeNumbers(int n) {
            assertFalse(isPrime.test(n));
        }

        @ParameterizedTest
        @ValueSource(ints = {97, 997, 7919, 104729})
        @DisplayName("큰 소수 판별")
        void largePrimeNumbers(int n) {
            assertTrue(isPrime.test(n));
        }
    }
}