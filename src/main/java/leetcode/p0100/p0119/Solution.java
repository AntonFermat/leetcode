package leetcode.p0100.p0119;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        var dp = new int[rowIndex + 1];
        for (int i = 0; i < rowIndex + 1; i++) {
            var ndp = new int[i + 1];
            ndp[0] = 1;
            ndp[i] = 1;
            for (int j = 1; j < i; j++) ndp[j] = dp[j] + dp[j - 1];
            dp = ndp;
        }
        return Arrays.stream(dp).boxed().collect(Collectors.toList());
    }
}
