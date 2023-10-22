package leetcode.p1700.p1793;

import java.util.*;

public class Solution {
    public int maximumScore(int[] nums, int k) {
        int len = nums.length;

        var right = new int[len];
        Arrays.fill(right, len);
        var stack = new Stack<Integer>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                int pop = stack.pop();
                right[pop] = i;
            }
            stack.push(i);
        }
        var left = new int[len];
        Arrays.fill(left, -1);
        stack.clear();

        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                int pop = stack.pop();
                left[pop] = i;
            }
            stack.push(i);
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            if (left[i] < k && right[i] > k) {
                res = Math.max(res, nums[i] * (right[i] - left[i] - 1));
            }
        }
        return res;
    }
}
