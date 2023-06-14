package leetcode.p0500.p0530;

import java.util.*;

public class MinimumAbsoluteDifferenceInBST {
    public int getMinimumDifference(TreeNode root) {
        var q = new PriorityQueue<Integer>();
        add(root, q);
        Integer prev = null;
        int res = Integer.MAX_VALUE;
        while (q.size() > 0) {
            Integer curr = q.poll();
            if (prev != null && curr != null) {
                res = Math.min(res, curr - prev);
            }
            prev = curr;
        }
        return res;
    }


    private void add(TreeNode root, PriorityQueue<Integer> q) {
        if (root == null) return;
        q.add(root.val);
        add(root.left, q);
        add(root.right, q);
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
