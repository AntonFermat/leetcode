package leetcode.p0600.p0606;


public class Solution {
    public String tree2str(TreeNode root) {
        return root.val
                + (root.left == null ? "" : "(" + tree2str(root.left) + ")")
                + (root.right == null ? "" : ((root.left == null ? "()" : "") + "(" + tree2str(root.right) + ")"));

    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
