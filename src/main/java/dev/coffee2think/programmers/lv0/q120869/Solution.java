package dev.coffee2think.programmers.lv0.q120869;

public class Solution {

    public int solution(String[] spell, String[] dic) {
        for (String word : dic) {
            if (word.length() != spell.length) continue;

            boolean valid = true;

            for (String c : spell) {
                if (!word.contains(c)) {
                    valid = false;
                    break;
                }
            }

            if (valid) return 1;
        }

        return 2;
    }
}
