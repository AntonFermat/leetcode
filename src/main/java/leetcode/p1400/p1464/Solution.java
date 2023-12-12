package leetcode.p1400.p1464;

public class Solution {
    public int maxProduct(int[] nums) {
        int max1 = 0, max2 = 0;
        for (int num : nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else max2 = Math.max(num, max2);
        }
        return (max1 - 1) * (max2 - 1);
    }
}
