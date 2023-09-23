package leetcode.p1000.p1048;

import java.util.*;

public class LongestStringChain {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int res = 0;
        var memo = new HashMap<String, Integer>();
        for (String w : words) {
            int cur = 0;
            for (int j = 0; j < w.length(); j++) {
                String w2 = new StringBuilder(w).deleteCharAt(j).toString();
                cur = Math.max(cur, 1 + memo.getOrDefault(w2, 0));
            }
            res = Math.max(res, cur);
            memo.put(w, cur);
        }
        return res;
    }
}
