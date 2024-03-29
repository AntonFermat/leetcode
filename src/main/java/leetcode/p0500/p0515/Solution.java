package leetcode.p0500.p0515;

import leetcode.TreeNode;

import java.util.*;

public class Solution {

    public List<Integer> largestValues(TreeNode root) {
        var res = new ArrayList<Integer>();
        if (root == null) return res;
        var q = new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            while (size-- > 0) {
                var cur = q.poll();
                max = Math.max(max, cur.val);
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
            res.add(max);
        }
        return res;
    }
}
