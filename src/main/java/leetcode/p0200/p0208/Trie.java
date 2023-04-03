package leetcode.p0200.p0208;

public class Trie {

    private final TrieNode root = new TrieNode();

    public Trie() {
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            var tmpNode = node.children[c - 'a'];
            if (tmpNode == null) {
                var newNode = new TrieNode();
                node.children[c - 'a'] = newNode;
                node = newNode;
            } else {
                node = tmpNode;
            }
        }
        node.wordEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            var tmpNode = node.children[c - 'a'];
            if (tmpNode == null) return false;
            node = tmpNode;
        }
        return node.wordEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            var tmpNode = node.children[c - 'a'];
            if (tmpNode == null) return false;
            node = tmpNode;
        }
        return true;
    }

    public static class TrieNode {
        TrieNode() {
        }

        TrieNode(boolean wordEnd) {
            this.wordEnd = wordEnd;
        }

        boolean wordEnd = false;
        TrieNode[] children = new TrieNode[26];
    }
}