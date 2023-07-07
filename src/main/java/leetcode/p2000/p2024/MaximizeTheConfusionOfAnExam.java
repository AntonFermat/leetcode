package leetcode.p2000.p2024;

import java.util.*;

public class MaximizeTheConfusionOfAnExam {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int res = 0;
        int len = answerKey.length();
        int countT = 0, countF = 0;
        var t = new HashMap<Integer, Integer>();
        var f = new HashMap<Integer, Integer>();
        for (int i = 0; i < len; i++) {
            var c = answerKey.charAt(i);
            if (c == 'T') {
                t.put(++countT, i);
                res = Math.max(res, i - t.getOrDefault(countT - k - 1, -1) - 1);
            } else {
                f.put(++countF, i);
                res = Math.max(res, i - f.getOrDefault(countF - k - 1, -1) - 1);
            }
        }

        res = Math.max(res, len - f.getOrDefault(countF - k, -1) - 1);
        res = Math.max(res, len - t.getOrDefault(countT - k, -1) - 1);

        return res;
    }
}
