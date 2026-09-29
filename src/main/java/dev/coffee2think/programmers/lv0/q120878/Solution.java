package dev.coffee2think.programmers.lv0.q120878;

import java.util.*;

/**
 * date: 2026-09-29
 * source: https://school.programmers.co.kr/learn/courses/30/lessons/120878
 */
public class Solution {

    public int solutionGcd(int a, int b) {
        b = b / gcd(a, b);

        while (b % 2 == 0) b /= 2;
        while (b % 5 == 0) b /= 5;

        return b == 1 ? 1 : 2;
    }

    public int gcd(int n, int m) {
        while (m != 0) {
            int remainder = n % m;
            n = m;
            m = remainder;
        }

        return n;
    }

    public int gcdRecursive(int n, int m) {
        return m == 0 ? n : gcdRecursive(m, n % m);
    }

    // 3개 이상의 GCD
    public int gcd(int[] numbers) {
        int result = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            result = gcd(result, numbers[i]);
        }

        return result;
    }

    public int solutionReduction(int a, int b) {
        // 소인수분해
        Map<Integer, Integer> factorsOfA = factorize(a);
        Map<Integer, Integer> factorsOfB = factorize(b);

        // 약분
        Set<Integer> intersection = new HashSet<>(factorsOfA.keySet());
        intersection.retainAll(factorsOfB.keySet());

        for (Integer key : intersection) {
            factorsOfB.compute(key, (k, v) -> Math.max(v - factorsOfA.get(key), 0));

            if (factorsOfB.get(key) == 0) {
                factorsOfB.remove(key);
            }
        }

        factorsOfB.remove(2);
        factorsOfB.remove(5);

        if (factorsOfB.isEmpty()) {
            return 1;
        }

        return 2;
    }

    public Map<Integer, Integer> factorize(int n) {
        Map<Integer, Integer> factors = new HashMap<>();

        for (int d = 2; d <= n / d; d++) {
            int count = 0;

            while (n % d == 0) {
                count++;
                n /= d;
            }

            if (count > 0) {
                factors.put(d, count);
            }
        }

        if (n > 1) {
            factors.put(n, 1);
        }

        return factors;
    }

    public boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i <= n / i; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public boolean isPrime2(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        // 3보다 큰 소수는 6k-1, 6k+1 중 하나의 형태
        for (int i = 5; (long) i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                 return false;
            }
        }

        return true;
    }
}
