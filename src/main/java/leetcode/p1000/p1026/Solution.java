package leetcode.p1000.p1026;

import leetcode.TreeNode;

public class Solution {
    public int maxAncestorDiff(TreeNode root) {
        helper(root.left, root.val, root.val);
        helper(root.right, root.val, root.val);
        return res;
    }

    int res = Integer.MIN_VALUE;

    private void helper(TreeNode node, int max, int min) {
        if (node == null) return;
        res = Math.max(res, Math.abs(max - node.val));
        res = Math.max(res, Math.abs(min - node.val));

        max = Math.max(max, node.val);
        min = Math.min(min, node.val);

        helper(node.left, max, min);
        helper(node.right, max, min);
    }
}
