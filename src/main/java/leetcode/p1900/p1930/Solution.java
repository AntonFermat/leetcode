package leetcode.p1900.p1930;

import java.util.*;

public class Solution {
    public int countPalindromicSubsequence(String s) {
        int len = s.length();
        int[] first = new int[26], last = new int[26];
        Arrays.fill(first, -1);
        for (int i = 0; i < len; i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1) first[c] = i;
            last[c] = i;
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            var set = new HashSet<Character>();
            for (int j = first[i] + 1; j < last[i]; j++) set.add(s.charAt(j));
            res += set.size();
        }
        return res;
    }
}
