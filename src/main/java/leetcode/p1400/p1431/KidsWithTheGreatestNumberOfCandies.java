package leetcode.p1400.p1431;

import java.util.*;

public class KidsWithTheGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (var c : candies) max = Math.max(max, c);
        var res = new ArrayList<Boolean>();
        for (var c : candies) {
            res.add(c + extraCandies >= max);
        }
        return res;
    }
}
