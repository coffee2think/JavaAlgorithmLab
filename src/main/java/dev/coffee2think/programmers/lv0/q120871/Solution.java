package dev.coffee2think.programmers.lv0.q120871;

/**
 * date: 2026-09-29
 * source: https://school.programmers.co.kr/learn/courses/30/lessons/120871
 */
public class Solution {

    public int solution(int n) {
        int current = 1;

        for (int i = 0; i < n; i++) {
            while (current % 3 == 0 || containsThree(current)) {
                current++;
            }

            current++;
        }

        return current - 1;
    }

    public boolean containsThree(int number) {
        while (number > 0) {
            if (number % 10 == 3) {
                return true;
            }
            number /= 10;
        }

        return false;
    }


    // 숫자에 3이 포함됨을 String.contains를 이용하여 해결한 풀이
    public int referenceSolution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            answer++;
            if (answer % 3 == 0 || String.valueOf(answer).contains("3")) {
                i--;
            }
        }

        return answer;
    }


    public int solutionDp(int n) {
        int left = 1;
        int right = Integer.MAX_VALUE;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (countValid(mid) >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // 1 ~ limit 중
    // 1. 숫자 3을 포함하지 않고
    // 2. 3의 배수가 아닌
    // 숫자의 개수를 센다.
    private long countValid(int limit) {
        char[] digits = String.valueOf(limit).toCharArray();

        // dp[pos][remainder][started]
        Long[][][] memo = new Long[digits.length][3][2];

        return dfs(digits, 0, 0, false, true, memo);
    }

    private long dfs(
            char[] digits,
            int pos,
            int remainder,
            boolean started,
            boolean tight,
            Long[][][] memo
    ) {
        if (pos == digits.length) {
            // 0은 제외하고, 3의 배수도 제외
            return started && remainder != 0 ? 1 : 0;
        }

        int startedIndex = started ? 1 : 0;

        // tight == false일 때만 메모이제이션 가능
        if (!tight && memo[pos][remainder][startedIndex] != null) {
            return memo[pos][remainder][startedIndex];
        }

        int maxDigit = tight
                ? digits[pos] - '0'
                : 9;

        long count = 0;

        for (int digit = 0; digit <= maxDigit; digit++) {

            // 숫자 3이 들어가면 제외
            if (digit == 3) {
                continue;
            }

            boolean nextStarted = started || digit != 0;
            boolean nextTight =
                    tight && digit == maxDigit;

            int nextRemainder;

            if (!nextStarted) {
                nextRemainder = 0;
            } else {
                nextRemainder =
                        (remainder * 10 + digit) % 3;
            }

            count += dfs(
                    digits,
                    pos + 1,
                    nextRemainder,
                    nextStarted,
                    nextTight,
                    memo
            );
        }

        if (!tight) {
            memo[pos][remainder][startedIndex] = count;
        }

        return count;
    }
}
