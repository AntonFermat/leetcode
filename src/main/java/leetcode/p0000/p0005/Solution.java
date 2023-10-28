package leetcode.p0000.p0005;

public class Solution {
    public String longestPalindrome(String s) {
        int l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            int len = Math.max(helper(s, i, i), helper(s, i, i + 1));
            if (len > r - l) {
                l = i - (len - 1) / 2;
                r = i + len / 2;
            }
        }
        return s.substring(l, r + 1);
    }

    private int helper(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}
