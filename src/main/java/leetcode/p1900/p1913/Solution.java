package leetcode.p1900.p1913;

public class Solution {
    public int maxProductDifference(int[] nums) {
        int a = 0, b = 0, c = Integer.MAX_VALUE, d = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > a) {
                b = a;
                a = num;
            } else b = Math.max(b, num);

            if (num < c) {
                d = c;
                c = num;
            } else d = Math.min(d, num);
        }
        return a * b - c * d;
    }
}