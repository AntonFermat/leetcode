package leetcode.p1300.p1372;


import leetcode.TreeNode;

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
}
