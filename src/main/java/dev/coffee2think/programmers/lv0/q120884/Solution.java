package dev.coffee2think.programmers.lv0.q120884;

/**
 * date: 2026-09-28
 * source: https://school.programmers.co.kr/learn/courses/30/lessons/120884
 */
public class Solution {

    public int solution(int chicken) {
        int coupon = chicken;
        int service = 0;

        while (coupon >= 10) {
            service += coupon / 10;
            coupon = coupon % 10 + coupon / 10;
        }

        return service;
    }

    public int mathematicSolution(int chicken) {
        return chicken == 0 ? 0 : (chicken - 1) / 9;
    }
}
