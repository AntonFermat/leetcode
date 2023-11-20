package leetcode.p2300.p2391;

public class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int res = 0;
        int m = 0, p = 0, g = 0;
        for (int i = 0; i < garbage.length; i++) {
            String garb = garbage[i];
            res += garb.length();
            if (i != 0) {
                m += travel[i - 1];
                p += travel[i - 1];
                g += travel[i - 1];
                if (garb.contains("M")) {
                    res += m;
                    m = 0;
                }

                if (garb.contains("P")) {
                    res += p;
                    p = 0;
                }

                if (garb.contains("G")) {
                    res += g;
                    g = 0;
                }
            }
        }

        return res;
    }
}
