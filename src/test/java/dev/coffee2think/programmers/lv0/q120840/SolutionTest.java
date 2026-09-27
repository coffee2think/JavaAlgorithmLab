package dev.coffee2think.programmers.lv0.q120840;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void solution() {
        int[] balls = {3, 5};
        int[] share = {2, 3};
        int[] expected = {3, 10};

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], solution.solution(balls[i], share[i]));
        }
    }
}