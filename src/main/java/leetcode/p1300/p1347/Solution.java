package leetcode.p1300.p1347;

public class Solution {
    public int minSteps(String s, String t) {
        int len = s.length();
        var counts = new int[26];
        var countt = new int[26];
        for (int i = 0; i < len; i++) {
            counts[s.charAt(i) - 'a']++;
            countt[t.charAt(i) - 'a']++;
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res += Math.abs(counts[i] - countt[i]);
        }
        return res / 2;
    }
}
