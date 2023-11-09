package leetcode.p1700.p1759;

public class Solution {
    public int countHomogenous(String s) {
        int res = 1;
        int cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) cur++;
            else cur = 1;
            res = (res + cur) % 1_000_000_007;
        }
        return res;
    }
}
