package dev.coffee2think.programmers.lv0.q120882;

import java.util.Arrays;

public class Solution {

    public int[] solution(int[][] score) {
        int[] sum = new int[score.length];
        for (int i = 0; i < score.length; i++) {
            sum[i] = score[i][0] + score[i][1];
        }

        // 정렬
        Arrays.sort(sum);

        // 순차탐색
        int[] rank = new int[sum.length];
        for (int i = 0; i < rank.length; i++) {
            int currentScore = score[i][0] + score[i][1];
            for (int j = sum.length - 1; j >= 0; j--) {
                if (currentScore == sum[j]) {
                    rank[i] = sum.length - j;
                    break;
                }
            }
        }

        return rank;
    }

    public int[] solution2(int[][] score) {
        int n = score.length;

        // {점수 합, 원래 인덱스}
        int[][] students = new int[n][2];

        for (int i = 0; i < n; i++) {
            students[i][0] = score[i][0] + score[i][1];
            students[i][1] = i;
        }

        Arrays.sort(students, (s1, s2) ->
                Integer.compare(s2[0], s1[0]));
        System.out.println("students: " + Arrays.deepToString(students));

        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            int r;

            // 이전 학생과 점수가 같으면 같은 등수
            if (i > 0 && students[i][0] == students[i - 1][0]) {
                r = rank[students[i - 1][1]];
            } else {
                r = i + 1;
            }

            System.out.printf("i: %d, idx: %d, 값: %d, rank: %d%n", i, students[i][1], students[i][0], r);

            // 원래 위치에 등수 저장
            rank[students[i][1]] = r;
        }

        return rank;
    }
}
