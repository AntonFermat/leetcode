package leetcode.p0100.p0111;

import java.util.LinkedList;

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        var q = new LinkedList<TreeNode>();
        q.add(root);
        int res = 0;
        while (!q.isEmpty()) {
            res++;
            int size = q.size();
            while (size-- > 0) {
                var cur = q.poll();
                if (cur.left == null && cur.right == null) return res;
                if (cur.right != null) q.add(cur.right);
                if (cur.left != null) q.add(cur.left);
            }
        }
        return -1;
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
