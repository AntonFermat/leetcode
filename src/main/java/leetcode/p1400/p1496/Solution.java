package leetcode.p1400.p1496;

import java.util.HashSet;

public class Solution {
    public boolean isPathCrossing(String path) {
        var set = new HashSet<Integer>();
        int x = 0, y = 0;
        set.add(0);
        for (char c : path.toCharArray()) {
            if (c == 'N') y++;
            else if (c == 'S') y--;
            else if (c == 'E') x++;
            else x--;
            int p = 10000 * x + y;
            if (set.contains(p)) return true;
            set.add(p);
        }
        return false;
    }
}
