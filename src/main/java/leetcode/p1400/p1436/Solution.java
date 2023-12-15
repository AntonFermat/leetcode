package leetcode.p1400.p1436;

import java.util.*;

public class Solution {
    public String destCity(List<List<String>> paths) {
        var set = new HashSet<String>();
        for (var path : paths) set.add(path.get(0));
        for (var path : paths) {
            if (!set.contains(path.get(1))) return path.get(1);
        }
        return null;
    }
}
