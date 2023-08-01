package leetcode.p0000.p0077;

import java.util.*;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        var res = new ArrayList<List<Integer>>();
        backtrack(1, n, k, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int index, int n, int k, List<Integer> numList, List<List<Integer>> res) {
        if (index == n + 1) return;
        numList.add(index);
        backtrack(index + 1, n, k, numList, res);
        if (numList.size() == k) res.add(new ArrayList<>(numList));
        numList.remove(numList.size() - 1);
        backtrack(index + 1, n, k, numList, res);
    }
}
