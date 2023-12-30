package leetcode.p1800.p1897;

public class Solution {
    public boolean makeEqual(String[] words) {
        var count = new int[26];
        for (String word : words) {
            for (var c : word.toCharArray()) count[c - 'a']++;
        }
        for (int c : count) {
            if (c % words.length > 0) return false;
        }
        return true;
    }
}
