package leetcode.p2000.p2009;

import java.util.*;

public class Solution {
    public int minOperations(int[] nums) {
        var set = new HashSet<Integer>();
        for (int num : nums) set.add(num);
        var arr = set.stream().mapToInt(i -> i).toArray();
        Arrays.sort(arr);
        int len = nums.length;
        int res = len;
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i] + len - 1;
            int l = i, r = arr.length - 1;
            while (l < r) {
                int m = r - (r - l) / 2;
                if (arr[m] == val) {
                    r = m;
                    break;
                } else if (arr[m] > val) r = m - 1;
                else l = m + 1;
            }
            res = Math.min(res, len - (r - i + 1));
        }
        return res;
    }
}
