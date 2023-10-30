package leetcode.p1300.p1356;

import java.util.Arrays;

public class Solution {
    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr).boxed()
                .sorted((i1, i2) -> Integer.bitCount(i1) == Integer.bitCount(i2) ? i1 - i2 : Integer.bitCount(i1) - Integer.bitCount(i2))
                .mapToInt(Integer::intValue).toArray();
    }
}
