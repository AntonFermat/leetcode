package leetcode.p1600.p1688;

public class Solution {
    public int numberOfMatches(int n) {
        int res = 0;
        while (n > 1) {
            int a = n % 2;
            n = n / 2;
            res += n;
            n += a;
        }
        return res;
    }
}
