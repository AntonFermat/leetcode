package leetcode.p1200.p1291;

import java.util.*;

public class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        var res = new ArrayList<Integer>();
        String s = "123456789";
        for (int i = String.valueOf(low).length(); i <= String.valueOf(high).length(); i++) {
            for (int j = 0; j < 10 - i; j++) {
                int x = Integer.parseInt(s.substring(j, j + i));
                if (low <= x && x <= high) res.add(x);
            }
        }
        return res;
    }
}
