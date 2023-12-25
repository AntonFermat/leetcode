package leetcode.p1700.p1758;

public class Solution {
    public int minOperations(String s) {
        int res1 = 0, res2 = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i % 2 == 0) {
                if (c == '1') res1++;
                else res2++;
            } else {
                if (c == '0') res1++;
                else res2++;
            }
        }
        return Math.min(res1, res2);
    }
}
