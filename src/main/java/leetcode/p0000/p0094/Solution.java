package leetcode.p0000.p0094;

import leetcode.TreeNode;

import java.util.*;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();
        var res = new ArrayList<>(inorderTraversal(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal(root.right));
        return res;
    }
}
