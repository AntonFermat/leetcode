package leetcode.p1600.p1624;

import java.util.*;

public class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        var map = new HashMap<Character, Integer>();
        int res = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                res = Math.max(res, i - map.get(c) - 1);
            } else map.put(c, i);
        }
        return res;
    }
}