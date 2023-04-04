package leetcode.p2400.p2405;

import java.util.HashSet;

public class OptimalPartitionOfString {
    public int partitionString(String s) {
        int res = 1;
        var set = new HashSet<Character>();
        for (var c : s.toCharArray()) {
            if (set.contains(c)) {
                set.clear();
                res++;
            }
            set.add(c);
        }
        return res;
    }
}
