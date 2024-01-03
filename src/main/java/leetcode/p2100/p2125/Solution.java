package leetcode.p2100.p2125;

public class Solution {
    public int numberOfBeams(String[] bank) {
        int res = 0, prev = 0;
        for (var b : bank) {
            int cur = 0;
            for (var c : b.toCharArray()) {
                if (c == '1') cur++;
            }
            if (cur != 0) {
                res += prev * cur;
                prev = cur;
            }
        }
        return res;
    }
}
