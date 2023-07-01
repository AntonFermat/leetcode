package leetcode.p2300.p2305;

public class FairDistributionOfCookies {
    public int distributeCookies(int[] cookies, int k) {
        return helper(cookies, new int[k], 0);
    }

    private int helper(int[] cookies, int[] dist, int index) {
        if (index == cookies.length) {
            int res = 0;
            for (int d : dist) res = Math.max(res, d);
            return res;
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < dist.length; i++) {
            dist[i] += cookies[index];
            res = Math.min(res, helper(cookies, dist, index + 1));
            dist[i] -= cookies[index];
        }
        return res;
    }
}
