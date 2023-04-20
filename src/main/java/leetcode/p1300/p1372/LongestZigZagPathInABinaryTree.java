package leetcode.p1300.p1372;


public class LongestZigZagPathInABinaryTree {
    public int longestZigZag(TreeNode root) {
        dfs(root, 0, 0);
        return res;
    }

    private int res = 0;

    private void dfs(TreeNode node, int dir, int path) {
        if (node == null) {
            res = Math.max(res, path);
        } else if (dir == -1) {
            dfs(node.left, -1, 0);
            dfs(node.right, 1, path + 1);
        } else if (dir == 1) {
            dfs(node.left, -1, path + 1);
            dfs(node.right, 1, 0);
        } else {
            dfs(node.left, -1, 0);
            dfs(node.right, 1, 0);
        }
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
