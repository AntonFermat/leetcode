package leetcode.p2300.p2385;

import leetcode.TreeNode;

import java.util.*;

public class Solution {
    public int amountOfTime(TreeNode root, int start) {
        var map = new HashMap<Integer, Set<Integer>>();
        var q1 = new LinkedList<>(List.of(root));
        while (!q1.isEmpty()) {
            var cur = q1.poll();
            mapNode(map, q1, cur, cur.left);
            mapNode(map, q1, cur, cur.right);
        }
        var q2 = new LinkedList<>(List.of(start));
        var v = new HashSet<>(List.of(start));
        int res = -1;
        while (!q2.isEmpty()) {
            res++;
            int size = q2.size();
            while (size-- > 0) {
                var cur = q2.poll();
                if (map.containsKey(cur)) {
                    for (int next : map.get(cur)) {
                        if (v.contains(next)) continue;
                        q2.add(next);
                        v.add(next);
                    }
                }
            }
        }
        return res;
    }

    private void mapNode(HashMap<Integer, Set<Integer>> map, LinkedList<TreeNode> q1, TreeNode cur, TreeNode left) {
        if (left != null) {
            q1.add(left);
            map.computeIfAbsent(cur.val, o -> new HashSet<>()).add(left.val);
            map.computeIfAbsent(left.val, o -> new HashSet<>()).add(cur.val);
        }
    }
}
