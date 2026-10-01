package dev.coffee2think.programmers.lv0.q120875;

public class Solution {
    public int solution(int[][] dots) {
        int answer = 0;

        int[][] vector = new int[6][2]; // C(4, 2)=6
        int idx = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                vector[idx][0] = dots[j][0] - dots[i][0];
                vector[idx][1] = dots[j][1] - dots[i][1];
                idx++;
            }
        }

        // 12 13 14 23 24 34
        // 12<->34, 13<->24, 14<->23
        // 외적 이용: |v1 X v2| = 0
        for (int i = 0; i < 3; i++) {
            int[] v1 = vector[i];
            int[] v2 = vector[5 - i];

            int crossProduct = v1[0] * v2[1] - v1[1] * v2[0];

            if (crossProduct == 0) {
                answer = 1;
                break;
            }
        }

        return answer;
    }
}
