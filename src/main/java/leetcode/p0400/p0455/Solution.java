package leetcode.p0400.p0455;

import java.util.Arrays;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int index = 0;
        while (index < s.length && res < g.length) {
            if (s[index] >= g[res]) res++;
            index++;
        }
        return res;
    }
}
