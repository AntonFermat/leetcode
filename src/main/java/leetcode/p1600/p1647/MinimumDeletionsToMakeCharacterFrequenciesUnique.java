package leetcode.p1600.p1647;

import java.util.Arrays;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {

    public int minDeletions(String s) {
        var count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;
        Arrays.sort(count);
        int res = 0;
        for (int i = 24; i >= 0; i--) {
            while (count[i] >= count[i + 1] && count[i] > 0) {
                res += 1;
                count[i]--;
            }
        }
        return res;
    }
}
