package leetcode.p2100.p2147;

public class Solution {
    public int numberOfWays(String corridor) {
        long res = 1;
        int count = 0;
        int mod = 1_000_000_007;
        for (int r = 0, l = 0; r < corridor.length(); r++) {
            if (corridor.charAt(r) == 'S') {
                count++;
                if (count % 2 == 1 && count > 1) res = res * (r - l) % mod;
                else if (count % 2 == 0) l = r;
            }
        }
        return (count % 2 == 1 || count < 2) ? 0 : (int) res;
    }
}
