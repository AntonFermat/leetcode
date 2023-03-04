package leetcode.p2000.p2444;

public class CountSubarraysWithFixedBounds {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;
        int len = nums.length;
        int minKPos = -1, maxKPos = -1, leftPos = -1;
        int prev = -1;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (num < minK || num > maxK) leftPos = i;
            if (num == minK) minKPos = i;
            if (num == maxK) maxKPos = i;
            int rightPos = Math.min(minKPos, maxKPos);
            if (rightPos > leftPos) res += (rightPos - leftPos);
        }
        return res;
    }
}
