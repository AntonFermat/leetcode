package leetcode.p1100.p1125;

import java.util.*;

public class SmallestSufficientTeam {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int m = req_skills.length;
        var map = new HashMap<String, Integer>();
        for (int i = 0; i < m; i++) map.put(req_skills[i], i);

        var ppl = new int[people.size()];
        for (int i = 0; i < people.size(); i++) {
            for (String skill : people.get(i)) {
                if (map.containsKey(skill)) ppl[i] |= (1 << map.get(skill));
            }
        }

        var memo = new long[1 << m];
        Arrays.fill(memo, -1);

        long resMask = helper(ppl, (1 << m) - 1, memo);
        var res = new int[Long.bitCount(resMask)];

        for (int i = 0, j = 0; i < ppl.length; i++) {
            if (((resMask >> i) & 1) == 1) res[j++] = i;
        }
        return res;
    }

    private Long helper(int[] ppl, int skills, long[] memo) {
        if (skills == 0) return 0L;
        if (memo[skills] != -1) return memo[skills];
        for (int i = 0; i < ppl.length; i++) {
            int skillsMask = skills & ~ppl[i];
            if (skillsMask != skills) {
                long pplMask = helper(ppl, skillsMask, memo) | (1L << i);
                if (memo[skills] == -1 || Long.bitCount(pplMask) < Long.bitCount(memo[skills])) {
                    memo[skills] = pplMask;
                }
            }
        }
        return memo[skills];
    }
}
