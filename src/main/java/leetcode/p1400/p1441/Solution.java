package leetcode.p1400.p1441;

import java.util.*;

public class Solution {
    public List<String> buildArray(int[] target, int n) {
        var res = new ArrayList<String>();
        for (int i = 1, j = 0; i <= n && j < target.length; i++) {
            res.add("Push");
            if (i != target[j]) res.add("Pop");
            else j++;
        }
        return res;
    }
}
