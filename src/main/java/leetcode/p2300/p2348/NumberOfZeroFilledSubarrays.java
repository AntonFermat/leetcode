package leetcode.p2300.p2348;

public class NumberOfZeroFilledSubarrays {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0;
        long count = 0;
        for (int num : nums) {
            if (num == 0) {
                count++;
            } else if (num != 0 && count > 0) {
                res += sum(count);
                count = 0;
            }
        }
        if (nums[nums.length - 1] == 0) res += sum(count);
        return res;
    }

    long sum(long n) {
        return n * (1 + n) / 2;
    }
}
