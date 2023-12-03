package leetcode.p1100.p1160;

public class Solution {
    public int countCharacters(String[] words, String chars) {
        int res = 0;
        var count = new int[26];
        for (char c : chars.toCharArray()) count[c - 'a']++;
        for (String w : words) {
            var tres = 0;
            var tcount = new int[26];
            for (char c : w.toCharArray()) {
                tcount[c - 'a']++;
                if (tcount[c - 'a'] > count[c - 'a']) {
                    tres = 0;
                    break;
                } else tres++;
            }
            res += tres;
        }
        return res;
    }
}
