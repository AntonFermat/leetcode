package leetcode.p0800.p0863;

import leetcode.TreeNode;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        var map = new HashMap<TreeNode, Set<TreeNode>>();
        var q = new LinkedList<TreeNode[]>();
        q.add(new TreeNode[]{root, null});
        while (!q.isEmpty()) {
            var node = q.peek()[0];
            var par = q.poll()[1];

            if (par != null) map.computeIfAbsent(node, o -> new HashSet<>()).add(par);

            if (node.left != null) {
                q.add(new TreeNode[]{node.left, node});
                map.computeIfAbsent(node, o -> new HashSet<>()).add(node.left);
            }

            if (node.right != null) {
                q.add(new TreeNode[]{node.right, node});
                map.computeIfAbsent(node, o -> new HashSet<>()).add(node.right);
            }
        }

        var res = new ArrayList<Integer>();
        var q2 = new LinkedList<TreeNode>();
        q2.add(target);
        var v = new HashSet<TreeNode>();
        v.add(target);
        while (!q2.isEmpty()) {
            int size = q2.size();
            while (size-- > 0) {
                var cur = q2.poll();
                if (k == 0 && cur != null) res.add(cur.val);
                if (map.containsKey(cur))
                    for (var next : map.get(cur)) {
                        if (!v.contains(next)) {
                            q2.add(next);
                            v.add(next);
                        }
                    }
            }
            if (k == 0) break;
            k--;
        }
        return res;
    }
}
