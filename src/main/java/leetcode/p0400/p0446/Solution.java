package leetcode.p0400.p0446;

import java.util.*;

public class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        if (len < 3) return 0;
        long res = 0;
        var map = new HashMap<Pair, Long>();
        for (int i = 1; i < len; i++) {
            long num = nums[i];
            for (int j = 0; j < i; j++) {
                long diff = num - nums[j];
                long l = map.getOrDefault(new Pair(j, diff), 0L) + 1;
                if (l > 1) {
                    res += (l - 1);
                }
                map.put(new Pair(i, diff), l + map.getOrDefault(new Pair(i, diff), 0L));
            }
        }
        return (int) res;
    }

    private record Pair(int i, long l) {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return i == pair.i && l == pair.l;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, l);
        }
    }
}
