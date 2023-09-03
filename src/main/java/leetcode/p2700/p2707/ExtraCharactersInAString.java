package leetcode.p2700.p2707;

import java.util.Arrays;

public class ExtraCharactersInAString {
    public int minExtraChar(String s, String[] dictionary) {
        build(dictionary);
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return helper(s, 0, memo);
    }

    private int helper(String s, int index, int[] memo) {
        int len = s.length();
        if (index >= len) return 0;
        if (memo[index] != -1) return memo[index];
        int res = len - index;

        for (int i = index; i < len; i++) {
            var sub = s.substring(index, i + 1);

            if (find(sub)) {
                res = Math.min(res, helper(s, i + 1, memo));
            } else {
                res = Math.min(res, sub.length() + helper(s, i + 1, memo));
            }
        }

        return memo[index] = res;
    }


    private void build(String[] words) {
        for (var w : words) {
            var node = root;
            for (var c : w.toCharArray()) {
                if (node.children[c - 'a'] == null) node.children[c - 'a'] = new TrieNode();
                node = node.children[c - 'a'];
            }
            node.end = true;
        }
    }

    private boolean find(String word) {
        var node = root;
        for (var c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) return false;
            node = node.children[c - 'a'];
        }
        return node.end;
    }

    private final TrieNode root = new TrieNode();

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean end = false;
    }
}
