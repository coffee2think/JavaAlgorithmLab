package dev.coffee2think.programmers.lv0.q120861;

public class Solution {

    public int[] solution(String[] keyinput, int[] board) {
        int x = 0;
        int y = 0;
        int xRange = board[0] / 2;
        int yRange = board[1] / 2;

        for (String key : keyinput) {
            switch (key) {
                case "left":
                    x = Math.max(x - 1, -xRange);
                    break;
                case "right":
                    x = Math.min(x + 1, xRange);
                    break;
                case "up":
                    y = Math.min(y + 1, yRange);
                    break;
                case "down":
                    y = Math.max(y - 1, -yRange);
                    break;
            }
        }

        return new int[]{x, y};
    }
}
