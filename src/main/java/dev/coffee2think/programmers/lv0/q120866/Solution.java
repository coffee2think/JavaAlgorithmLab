package dev.coffee2think.programmers.lv0.q120866;

/**
 * date: 2026-10-01
 * source: https://school.programmers.co.kr/learn/courses/30/lessons/120866
 */
public class Solution {

    public int solution(int[][] board) {
        int n = board.length;
        boolean[][] dangerous = new boolean[n][n];
        int safe = n * n;

        int[] d = {-1, 0, 1};

        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (board[y][x] != 1) continue;

                for (int dy : d) {
                    for (int dx : d) {
                        int ny = y + dy;
                        int nx = x + dx;

                        if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
                            continue;
                        }

                        if (!dangerous[ny][nx]) {
                            dangerous[ny][nx] = true;
                            safe--;
                        }
                    }
                }
            }
        }

        return safe;
    }
}
