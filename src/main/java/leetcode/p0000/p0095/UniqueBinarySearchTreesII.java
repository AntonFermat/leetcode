package leetcode.p0000.p0095;

import leetcode.TreeNode;

import java.util.*;

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        return backtrack(1, n);
    }

    private List<TreeNode> backtrack(int start, int end) {
        var res = new ArrayList<TreeNode>();

        if (start > end) res.add(null);
        else {
            for (int i = start; i <= end; i++) {
                var lefts = backtrack(start, i - 1);
                var rights = backtrack(i + 1, end);
                for (var left : lefts) {
                    for (var right : rights) {
                        var root = new TreeNode(i);
                        res.add(root);
                        root.left = left;
                        root.right = right;
                    }
                }
            }
        }
        return res;
    }
}
