package dev.coffee2think.programmers.lv0.q120840;

public class Solution {

    public int solution(int balls, int share) {
        int n = balls;
        int r = Math.min(share, balls - share);

        // nCr
        System.out.printf(
                "Long.MAX_VALUE=%d, 자릿수=%d\n",
                Long.MAX_VALUE,
                (long) Math.log10(Long.MAX_VALUE) + 1
        );
        for (int i = 1; i <= 30; i++) {
            long factorial = factorial(i);
            System.out.printf(
                    "i=%d, i!=%d, 자릿수=%d\n",
                    i,
                    factorial,
                    (long) Math.log10(factorial)
            );
        }

        return (int) calcCombination(balls, share);
    }

    public long factorial(int n) {
        if (n < 2) return 1;

        long rtn = 1;

        for (int i = 2; i <= n; i++) {
            rtn *= i;
        }

        return rtn;
    }

    public long calcCombination(int n, int r) {
        if (r < 1) return 1;

        int s = Math.min(r, n - r);

        long result = 1L;
        for (int i = 0; i < s; i++) {
            result *= n - i;
        }
        for (int i = 0; i < s; i++) {
            result /= s - i;
        }

        return result;
    }
}
