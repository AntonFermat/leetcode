package leetcode.p0900.p0958;

public class CheckCompletenessOfABinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        height(root, 0);
        return height == 1 || complete(root, 0);
    }

    private int height = 0;
    private boolean complete = false;

    private void height(TreeNode node, int level) {
        if (node == null) {
            height = Math.max(height, level);
            return;
        }
        height(node.left, level + 1);
        height(node.right, level + 1);
    }

    private boolean complete(TreeNode node, int level) {
        if (node == null) return false;
        var left = node.left;
        var right = node.right;
        if (level == height - 2) {
            if (complete) {
                return left == null && right == null;
            } else {
                if (left == null && right != null) return false;
                if (left != null && right != null) return true;
                complete = true;
                return true;
            }
        }
        return complete(left, level + 1) && complete(right, level + 1);
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
