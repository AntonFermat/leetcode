package leetcode.p1600.p1658;

import java.util.Arrays;

public class MinimumOperationsToReduceXToZero {
    public int minOperations(int[] nums, int x) {
        int sum = Arrays.stream(nums).sum();
        int maxLength = -1, currSum = 0;
        for(int r = 0, l = 0; r < nums.length; r++) {
            currSum += nums[r];
            while(l <= r && currSum > sum - x){
                currSum -= nums[l++];
            }
            if(currSum == sum - x) {
                maxLength = Math.max(maxLength, r - l + 1);
            }
        }

        return maxLength == -1 ? - 1 : nums.length - maxLength;
    }
}
