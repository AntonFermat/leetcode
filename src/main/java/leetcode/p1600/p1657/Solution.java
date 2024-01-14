package leetcode.p1600.p1657;

import java.util.Arrays;

public class Solution {
    public boolean closeStrings(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        if (len1 != len2) return false;
        var count1 = new int[26];
        for (char c : word1.toCharArray()) count1[c - 'a']++;
        var count2 = new int[26];
        for (char c : word2.toCharArray()) count2[c - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (count1[i] == 0 && count2[i] != 0 || count2[i] == 0 && count1[i] != 0) return false;
        }
        Arrays.sort(count1);
        Arrays.sort(count2);
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) return false;
        }
        return true;
    }
}
