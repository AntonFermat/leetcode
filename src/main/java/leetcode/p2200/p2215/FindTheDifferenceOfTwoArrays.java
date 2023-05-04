package leetcode.p2200.p2215;

import java.util.*;
import java.util.stream.Collectors;

public class FindTheDifferenceOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        var set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        var set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        var list1 = new ArrayList<Integer>();
        var list2 = new ArrayList<Integer>();
        for (int n : set1) if (!set2.contains(n)) list1.add(n);
        for (int n : set2) if (!set1.contains(n)) list2.add(n);
        return List.of(list1, list2);
    }
}
