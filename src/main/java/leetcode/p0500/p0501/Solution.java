package leetcode.p0500.p0501;

import leetcode.TreeNode;

import java.util.*;

public class Solution {

    public int[] findMode(TreeNode root) {
        var map = new HashMap<Integer, Integer>();
        var q = new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            var cur = q.poll();
            map.put(cur.val, map.getOrDefault(cur.val, 0) + 1);
            if (cur.left != null) q.add(cur.left);
            if (cur.right != null) q.add(cur.right);
        }
        var list = new ArrayList<Integer>();
        int max = 0;
        for (var e : map.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                list.clear();
                list.add(e.getKey());
            } else if (e.getValue() == max) list.add(e.getKey());
        }
        var res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) res[i] = list.get(i);
        return res;
    }
}
