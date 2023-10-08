package leetcode.p1400.p1458;

import java.util.Arrays;

public class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        var memo = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) Arrays.fill(memo[i], -1_000_000);
        for (int i = nums1.length - 1; i >= 0; i--) {
            for (int j = nums2.length - 1; j >= 0; j--) {
                memo[i][j] = nums1[i] * nums2[j];
                memo[i][j] = Math.max(memo[i][j], nums1[i] * nums2[j] + memo[i + 1][j + 1]);
                memo[i][j] = Math.max(memo[i][j], Math.max(memo[i + 1][j], memo[i][j + 1]));
            }
        }
        return memo[0][0];
    }
}
