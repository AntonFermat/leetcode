package leetcode.p0900.p0905;

import java.util.Arrays;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] % 2 == 1 && nums[r] % 2 == 0) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
            }
            if (nums[l] % 2 == 0) l++;
            if (nums[r] % 2 == 1) r--;
        }
        return nums;
    }

    public int[] sortArrayByParity1(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .sorted((i1, i2) -> {
                    if (i1 % 2 == 0 && i2 % 2 == 1) return -1;
                    else if (i1 % 2 == 1 && i2 % 2 == 0) return 1;
                    else return 0;
                })
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
