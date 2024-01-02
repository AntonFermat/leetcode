package leetcode.p2600.p2610;

import java.util.*;

public class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        var res = new ArrayList<List<Integer>>();
        var count = new int[nums.length + 1];
        for (int num : nums) {
            if (count[num] >= res.size()) res.add(new ArrayList<>());
            res.get(count[num]).add(num);
            count[num]++;
        }
        return res;
    }
}
