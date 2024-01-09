package leetcode.p0100.p0129;

import leetcode.TreeNode;

public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        preorder(root, 0);
        return res;
    }

    private int res = 0;

    private void preorder(TreeNode node, int value) {
        value = 10 * value + node.val;
        if (node.left == null && node.right == null) res += value;
        if (node.left != null) preorder(node.left, value);
        if (node.right != null) preorder(node.right, value);
    }
}
