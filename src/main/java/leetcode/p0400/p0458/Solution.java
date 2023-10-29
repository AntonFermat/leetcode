package leetcode.p0400.p0458;

public class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int states = minutesToTest / minutesToDie + 1;
        int res = (int) Math.ceil(Math.log(buckets) / Math.log(states));
        return Math.pow(states, res - 1) == buckets ? res - 1 : res;
    }
}
