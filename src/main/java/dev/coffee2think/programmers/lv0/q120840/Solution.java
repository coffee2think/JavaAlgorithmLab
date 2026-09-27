package dev.coffee2think.programmers.lv0.q120840;

public class Solution {

    // 반복문 풀이
    // 직접 조합 계산
    // 시간복잡도: O(min(r, n-r))
    // 공간복잡도: O(1)
    public int solution(int balls, int share) {
        int answer = 1;
        int r = Math.min(share, balls - share);

        for (int i = 1; i <= r; i++) {
            answer = answer * (balls - i + 1) / i;
        }

        return answer;
    }

    // DP 풀이
    // C(n,r) = C(n-1,r-1) + C(n-1,r) 점화식 이용
    // 시간복잡도: O(nr)
    // 공간복잡도: O(r)
    public int dpSolution(int balls, int share) {
        int r = Math.min(share, balls - share);
        int[] dp = new int[r + 1];

        dp[0] = 1; // C(n, 0) = 1

        for (int n = 1; n <= balls; n++) {
            for (int k = Math.min(n, r); k >= 1; k--) {
                dp[k] += dp[k - 1];
            }
        }

        return dp[r];
    }

    // 재귀 풀이 - 참고
    // C(n, r) = C(n - 1, r - 1) * n / r 점화식 이용
    // 시간복잡도: O(min(r, n-r))
    // 공간복잡도: O(min(r, n-r))
    public long recursiveSolution(int balls, int share) {
        share = Math.min(share, balls - share);

        if (share == 0) {
            return 1;
        }

        return recursiveSolution(balls - 1, share - 1) * balls / share;
    }
}
