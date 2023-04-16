package leetcode.p1600.p1639;

import java.util.*;

public class NumberOfWaysToFormATargetStringGivenADictionary {
    private final Map<Integer, Map<Character, Integer>> map = new HashMap<>();
    private final int mod = 1_000_000_007;
    private String target;
    private int len = 0;
    private int tlen = 0;
    private long[][] dp;

    public int numWays(String[] words, String target) {
        this.target = target;
        tlen = target.length();
        for (String w : words) {
            for (int j = 0; j < w.length(); j++) {
                var c = w.charAt(j);
                var freq = map.computeIfAbsent(j, o -> new HashMap<>());
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }
            len = Math.max(len, w.length());
        }

        dp = new long[tlen][len];
        for (int i = 0; i < tlen; i++) Arrays.fill(dp[i], -1);

        long res = 0;
        for (int i = 0; i < len; i++) {
            res += helper(0, i);
        }
        return (int) (res % mod);
    }

    private long helper(int tindex, int index) {
        long res = 0;
        if (dp[tindex][index] != -1) return dp[tindex][index];

        if (map.containsKey(index)) {
            int freq = map.get(index).getOrDefault(target.charAt(tindex), 0);
            if (tindex == tlen - 1) {
                res = freq;

            } else {
                long sum = 0;
                for (int i = index + 1; i < len; i++) {
                    sum += dp[tindex + 1][i] == -1 ? helper(tindex + 1, i) : dp[tindex + 1][i];
                }
                res = (res + freq * sum) % mod;
            }
        }
        return dp[tindex][index] = res;
    }
}
