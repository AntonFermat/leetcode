package leetcode.p1100.p1187;

import java.util.*;

public class MakeArrayStrictlyIncreasing {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        int len = arr1.length;
        var set = new TreeSet<Integer>();
        for (int num : arr2) set.add(num);

        int num1 = arr1[0];
        int num2 = set.first();

        int res = helper(arr1, set, num1, 1);
        if (num2 < arr1[0]) {
            res = Math.min(res, 1 + helper(arr1, set, num2, 1));
        }
        return res > len ? -1 : res;
    }

    private final Map<Pair<Integer, Integer>, Integer> memo = new HashMap<>();

    private int helper(int[] arr1, TreeSet<Integer> set, int prev, int index) {
        int len = arr1.length;
        if (len == index) return 0;

        var pair = new Pair<>(prev, index);
        if (memo.containsKey(pair)) return memo.get(pair);

        int res = 2001;

        int num1 = arr1[index];
        if (prev < num1) {
            res = Math.min(res, helper(arr1, set, num1, index + 1));
        }

        var num2 = set.ceiling(prev + 1);
        if (num2 != null) {
            res = Math.min(res, 1 + helper(arr1, set, num2, index + 1));
        }

        memo.put(pair, res);
        return res;
    }

    private record Pair<E, P>(E key, P value) {
    }
}
