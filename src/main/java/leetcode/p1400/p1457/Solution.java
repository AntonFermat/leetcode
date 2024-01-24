package leetcode.p1400.p1457;

import leetcode.TreeNode;

public class Solution {
    private int res = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        dfs(root, new int[10]);
        return res;
    }

    private boolean isPal(int[] freq) {
        int odd = 0;
        for (int f : freq) {
            if (f % 2 == 1) {
                if (odd++ > 0) return false;
            }
        }
        return true;
    }

    private void dfs(TreeNode node, int[] freq) {
        freq[node.val]++;
        if (node.left == null && node.right == null) {
            if (isPal(freq)) res++;
        } else {
            if (node.left != null) dfs(node.left, freq);
            if (node.right != null) dfs(node.right, freq);
        }
        freq[node.val]--;
    }
}
