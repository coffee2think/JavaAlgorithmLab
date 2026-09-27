package dev.coffee2think.programmers.lv0.q120883;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String solution(String[] id_pw, String[][] db) {
        for (String[] data : db) {
            if (data[0].equals(id_pw[0])) {
                return data[1].equals(id_pw[1])
                        ? "login"
                        : "wrong pw";
            }
        }

        return "fail";
    }

    public String mapSolution(String[] id_pw, String[][] db) {
        Map<String, String> dbMap = new HashMap<>();

        for (String[] data : db) {
            dbMap.putIfAbsent(data[0], data[1]);
        }

        if (!dbMap.containsKey(id_pw[0])) {
            return "fail";
        } else if (!id_pw[1].equals(dbMap.get(id_pw[0]))) {
            return "wrong pw";
        } else {
            return "login";
        }
    }
}
