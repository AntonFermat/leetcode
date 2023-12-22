package leetcode.p1400.p1422;

public class Solution {
    public int maxScore(String s) {
        int diff = Integer.MIN_VALUE, zeros = 0, ones = 0;
        for (int i = 0; i < s.length(); i++) {
            ones += s.charAt(i) - '0';
            zeros += 1 - (s.charAt(i) - '0');
            if (i != s.length() - 1) diff = Math.max(diff, zeros - ones);
        }
        return diff + ones;
    }
}
