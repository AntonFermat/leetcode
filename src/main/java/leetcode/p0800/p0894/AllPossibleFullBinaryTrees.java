package leetcode.p0800.p0894;

import java.util.*;

public class AllPossibleFullBinaryTrees {
    public List<TreeNode> allPossibleFBT(int n) {
        if (n == 1) {
            return List.of(new TreeNode(0));
        }
        List<TreeNode> res = new ArrayList<>();
        for (int i = 1; i <= n - 2; i += 2) {
            var leftList = allPossibleFBT(i);
            var rightList = allPossibleFBT(n - 1 - i);
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    var root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
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
