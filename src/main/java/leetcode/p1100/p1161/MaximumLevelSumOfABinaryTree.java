package leetcode.p1100.p1161;

import java.util.Arrays;

public class MaximumLevelSumOfABinaryTree {
    public int maxLevelSum(TreeNode root) {
        Arrays.fill(sum, Long.MIN_VALUE);
        helper(root, 0);
        int res = 0;
        long max = Long.MIN_VALUE;

        for (int i = 0; i < 100; i++) {
            if (sum[i] > max) {
                max = sum[i];
                res = i;
            }
        }
        // System.out.println(Arrays.toString(sum));
        return res + 1;
    }

    long[] sum = new long[100];

    private void helper(TreeNode node, int level) {
        if (node == null) return;
        if (sum[level] == Long.MIN_VALUE) sum[level] = 0;
        sum[level] += node.val;
        helper(node.left, level + 1);
        helper(node.right, level + 1);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
