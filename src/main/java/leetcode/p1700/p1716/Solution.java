package leetcode.p1700.p1716;

public class Solution {
    public int totalMoney(int n) {
        int res = 0;
        for (int i = 0; i < n; i++) res += i / 7 + i % 7 + 1;
        return res;
    }
}
