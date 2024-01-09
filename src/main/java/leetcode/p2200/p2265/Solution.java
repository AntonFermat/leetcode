package leetcode.p2200.p2265;

import leetcode.TreeNode;

public class Solution {
    private int res = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return res;
    }

    int[] dfs(TreeNode node) {
        if (node == null) return new int[]{0, 0};
        var left = dfs(node.left);
        var right = dfs(node.right);
        var sum = node.val + left[0] + right[0];
        var count = 1 + left[1] + right[1];
        if (node.val == sum / count) res++;
        return new int[]{sum, count};
    }
}