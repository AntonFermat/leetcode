package leetcode.p0100.p0111;

import leetcode.TreeNode;

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
}
