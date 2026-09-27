package dev.coffee2think.programmers.lv0.q120860;

/**
 * date: 2026-09-28
 * source: https://school.programmers.co.kr/learn/courses/30/lessons/120860
 */
public class Solution {

    public int solution(int[][] dots) {
        for (int i = 1; i < dots.length; i++) {
            if (dots[i][0] == dots[0][0] || dots[i][1] == dots[0][1]) continue;

            int width = Math.abs(dots[i][0] - dots[0][0]);
            int height = Math.abs(dots[i][1] - dots[0][1]);
            return width * height;
        }

        return -1;
    }
}
