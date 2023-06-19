package leetcode.p1700.p1732;

public class FindTheHighestAltitude {
    public int largestAltitude(int[] gain) {
        int curr = 0, res = 0;
        for (int g : gain) {
            curr += g;
            res = Math.max(res, curr);
        }
        return res;
    }
}