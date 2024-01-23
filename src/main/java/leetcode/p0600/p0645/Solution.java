package leetcode.p0600.p0645;

public class Solution {
    public int[] findErrorNums(int[] nums) {
        int len = nums.length;
        var count = new int[len];
        var res = new int[2];
        for (int num : nums) count[num - 1]++;
        for (int i = 0; i < len; i++) {
            if (count[i] == 2) res[0] = i + 1;
            else if (count[i] == 0) res[1] = i + 1;
        }
        return res;
    }
}
