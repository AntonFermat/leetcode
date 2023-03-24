package leetcode.p0100.p0106;

import java.util.*;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        index = inorder.length - 1;
        return buildTree(postorder, 0, inorder.length - 1, map);
    }

    private int index;

    private TreeNode buildTree(int[] postorder, int l, int r, Map<Integer, Integer> map) {
        if (l > r) return null;

        int val = postorder[index--];
        var node = new TreeNode(val);

        node.right = buildTree(postorder, map.get(val) + 1, r, map);
        node.left = buildTree(postorder, l, map.get(val) - 1, map);

        return node;
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
