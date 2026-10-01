package dev.coffee2think.programmers.lv0.q120876;

/**
 * date: 2026-10-01
 * source: https://school.programmers.co.kr/learn/courses/30/lessons/120876
 */
public class Solution {
    public int solution(int[][] lines) {
        final int RANGE = 200;
        final int SHIFT = 100;

        int[] segments = new int[RANGE];

        for (int[] line : lines) {
            for (int i = line[0] + SHIFT; i < line[1] + SHIFT; i++) {
                segments[i]++;
            }
        }

        int count = 0;
        for (int segment : segments) {
            if (segment > 1) {
                count++;
            }
        }

        return count;
    }
}
