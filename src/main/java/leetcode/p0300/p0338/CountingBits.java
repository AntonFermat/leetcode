package leetcode.p0300.p0338;

public class CountingBits {
    /**
     * Brute force
     */
    public int[] countBits(int n) {
        var res = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            res[i] = Integer.bitCount(i);
        }
        return res;
    }

    /**
     * DP
     */
    public int[] countBits1(int num) {
        var res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }
}
