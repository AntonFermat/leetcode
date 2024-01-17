package leetcode.p1200.p1207;

import java.util.HashSet;

public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        var count = new int[2001];
        for (int a : arr) count[a + 1000]++;
        var set = new HashSet<Integer>();
        for (int c : count) {
            if (c != 0) {
                if (!set.add(c)) return false;
            }
        }
        return true;
    }
}
