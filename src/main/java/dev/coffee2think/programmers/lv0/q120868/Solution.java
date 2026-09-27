package dev.coffee2think.programmers.lv0.q120868;

public class Solution {

    public int solution(int[] sides) {
        /**
         *  a >= b
         *  i) c > a && c < a + b
         *     <=> a < c < a + b
         *     => 개수: (a + b) - a - 1 = b - 1
         *  ii) c <= a && a < b + c
         *     <=> a - b < c <= a
         *     => 개수: a - (a - b) = b
         *  i)과 ii)에 의해
         *    2b - 1
         */

        return 2 * Math.min(sides[0], sides[1]) - 1;
    }
}
