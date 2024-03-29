package leetcode.p0600.p0662;

import leetcode.TreeNode;

import java.util.*;

public class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 0, 0);
        return (int) res;
    }

    private long res = 0;
    private final Map<Integer, Long> map = new HashMap<>();

    private void dfs(TreeNode node, int level, long x) {
        if (node == null) return;
        long min = Math.min(map.getOrDefault(level, x), x);
        map.put(level, min);
        res = Math.max(res, x - min + 1);
        dfs(node.left, level + 1, x * 2);
        dfs(node.right, level + 1, x * 2 + 1);
    }
}
