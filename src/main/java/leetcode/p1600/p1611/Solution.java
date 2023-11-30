package leetcode.p1600.p1611;

public class Solution {
    public int minimumOneBitOperations(int n) {
        return n == 0 ? 0 : n ^ minimumOneBitOperations(n / 2);
    }
}
