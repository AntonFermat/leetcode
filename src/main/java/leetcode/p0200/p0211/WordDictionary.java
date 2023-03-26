package leetcode.p0200.p0211;

public class WordDictionary {

    public WordDictionary() {
    }

    public void addWord(String word) {
        var node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.end = true;
    }

    public boolean search(String word) {
        return search(word, root);
    }

    private boolean search(String word, TrieNode node) {
        if (word.length() == 0) return node.end;

        var cur = node;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                boolean res = false;
                String substr = word.substring(i + 1);
                for (var next : cur.children) {
                    if (next == null) continue;
                    res = res || search(substr, next);
                }
                return res;
            } else if (cur.children[c - 'a'] == null) {
                return false;
            } else {
                cur = cur.children[c - 'a'];
            }
        }
        return cur.end;
    }

    private final TrieNode root = new TrieNode();

    private static class TrieNode {
        boolean end = false;
        TrieNode[] children = new TrieNode[26];
    }
}
