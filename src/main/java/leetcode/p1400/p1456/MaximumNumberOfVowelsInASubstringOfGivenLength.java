package leetcode.p1400.p1456;

import java.util.Set;

public class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public int maxVowels(String s, int k) {
        var set = Set.of('a', 'e', 'i', 'o', 'u');
        int len = s.length();
        int res = 0, cur = 0;
        for (int i = 0, j = 0; i < len; i++) {
            if (set.contains(s.charAt(i))) cur++;
            if (i - j == k) {
                if (set.contains(s.charAt(j))) cur--;
                j++;
            }
            res = Math.max(res, cur);
        }
        return res;
    }
}
