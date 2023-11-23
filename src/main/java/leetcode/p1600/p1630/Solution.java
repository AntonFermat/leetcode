package leetcode.p1600.p1630;

import java.util.*;

public class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        var res = new ArrayList<Boolean>();
        for (int i = 0; i < l.length; i++) {
            var sub = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Arrays.sort(sub);
            boolean b = true;
            int diff = sub[0] - sub[1];
            for (int j = 1; j < sub.length - 1; j++) {
                if (diff != sub[j] - sub[j + 1]) {
                    b = false;
                    break;
                }
            }
            res.add(b);
        }
        return res;
    }
}
