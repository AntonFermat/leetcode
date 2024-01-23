package leetcode.p1200.p1239;

import java.util.*;

public class Solution {
    public int maxLength(List<String> arr) {
        return helper(arr, "", 0);
    }

    private int helper(List<String> arr, String str, int index) {
        if (index == arr.size()) return str.length();
        int res = str.length();
        for (int i = index; i < arr.size(); i++) {
            String newStr = str + arr.get(i);
            if (uniq(newStr)) {
                res = Math.max(res, helper(arr, newStr, i + 1));
            } else {
                res = Math.max(res, helper(arr, str, i + 1));
            }
        }
        return res;
    }

    private boolean uniq(String str) {
        var count = new int[26];
        for (char c : str.toCharArray()) {
            if (++count[c - 'a'] > 1) return false;
        }
        return true;
    }
}
