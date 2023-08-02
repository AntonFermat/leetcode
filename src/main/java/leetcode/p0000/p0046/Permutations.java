package leetcode.p0000.p0046;

import java.util.*;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        var res = new ArrayList<List<Integer>>();
        backtrack(nums, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> numsList, List<List<Integer>> res) {
        if (nums.length == numsList.size()) {
            res.add(new ArrayList<>(numsList));
        } else {
            for (int num : nums) {
                if (numsList.contains(num)) continue;
                numsList.add(num);
                backtrack(nums, numsList, res);
                numsList.remove(numsList.size() - 1);
            }
        }
    }
}
