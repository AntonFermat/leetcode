package leetcode.p0600.p0652;

import leetcode.TreeNode;

import java.util.*;

public class FindDuplicateSubtrees {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        var res = new ArrayList<TreeNode>();
        dfs(root, new HashMap<>(), res);
        return res;
    }

    private String dfs(TreeNode node, Map<String, Integer> map, List<TreeNode> res) {
        if (node == null) return "x";
        String serial = node.val + "(" + dfs(node.left, map, res) + " " + dfs(node.right, map, res) + ")";
        int count = map.getOrDefault(serial, 0);
        if (count == 1) res.add(node);
        if (count < 2) map.put(serial, count + 1);
        return serial;
    }
}
