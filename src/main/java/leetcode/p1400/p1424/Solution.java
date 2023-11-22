package leetcode.p1400.p1424;

import java.util.*;

public class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        var map = new TreeMap<Integer, LinkedList<Integer>>();
        int size = 0;
        for (int i = 0; i < nums.size(); i++) {
            var row = nums.get(i);
            for (int j = 0; j < row.size(); j++) {
                map.computeIfAbsent(i + j, o -> new LinkedList<>()).addFirst(row.get(j));
                size++;
            }
        }
        var res = new int[size];
        int index = 0;
        for (var e : map.entrySet()) {
            for (int val : e.getValue()) {
                res[index++] = val;
            }
        }
        return res;
    }
}
