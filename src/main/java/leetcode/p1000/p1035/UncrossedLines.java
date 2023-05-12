package leetcode.p1000.p1035;

public class UncrossedLines {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        var memo = new int[l1 + 1][l2 + 1];
        int res = 0;
        for (int i = l1 - 1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                if (nums1[i] == nums2[j]) memo[i][j] = 1 + memo[i + 1][j + 1];
                else memo[i][j] = Math.max(memo[i][j + 1], memo[i + 1][j]);
            }
        }
        return memo[0][0];
    }
}
