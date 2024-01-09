package leetcode.p0100.p0101;

import leetcode.TreeNode;

import java.util.*;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        // return recursive(root.left, root.right);
        var q = new LinkedList<TreeNode>();
        q.add(root.left);
        q.add(root.right);
        while (!q.isEmpty()) {
            var node1 = q.poll();
            var node2 = q.poll();

            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null || node1.val != node2.val) return false;

            q.add(node1.left);
            q.add(node2.right);
            q.add(node1.right);
            q.add(node2.left);
        }
        return true;
    }

    public boolean recursive(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return (left.val == right.val) && recursive(left.left, right.right) && recursive(left.right, right.left);
    }
}
