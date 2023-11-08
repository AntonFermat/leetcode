package leetcode.p2800.p2849;

public class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if (t == 0) return sx == fx && sy == fy;
        if (sx == fx && sy == fy && t == 1) return false;
        return Math.max(Math.abs(sx - fx), Math.abs(sy - fy)) <= t;
    }
}
