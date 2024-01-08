package leetcode.p0900.p0938;


public class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        int val = root.val;
        return (val <= low ? 0 : rangeSumBST(root.left, low, high)) +
                (val >= high ? 0 : rangeSumBST(root.right, low, high)) +
                (val >= low && val <= high ? val : 0);
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
