package dev.coffee2think.programmers.lv0.q120863;

/**
 * date: 2026-10-01
 * source: https://school.programmers.co.kr/learn/courses/30/lessons/120863
 */
public class Solution {

    public String solution(String polynomial) {
        int[] a = new int[2]; // 계수 배열
        String[] terms = polynomial.replace(" ", "").split("\\+");

        for (String term : terms) {
            if (term.endsWith("x")) {
                a[1] += term.length() == 1
                        ? 1
                        : Integer.parseInt(term.substring(0, term.length() - 1));
            } else {
                a[0] += Integer.parseInt(term);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] == 0) continue;
            if (!sb.isEmpty()) sb.append(" + ");

            sb.append(i > 0 && a[i] == 1 ? "" : a[i])
                    .append(i > 0 ? "x" : "");
        }

        return sb.isEmpty() ? "0" : sb.toString();
    }
}
