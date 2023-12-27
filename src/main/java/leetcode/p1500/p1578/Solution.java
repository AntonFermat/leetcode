package leetcode.p1500.p1578;

public class Solution {
    public int minCost(String colors, int[] neededTime) {
        int res = 0, cur = 0;
        for (int i = 0; i < colors.length(); i++) {
            if (i != 0 && colors.charAt(i) != colors.charAt(i - 1)) cur = 0;
            res += Math.min(cur, neededTime[i]);
            cur = Math.max(cur, neededTime[i]);
        }
        return res;
    }
}
