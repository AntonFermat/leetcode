package leetcode.p2100.p2141;

public class MaximumRunningTimeOfNComputers {
    public long maxRunTime(int n, int[] batteries) {
        int len = batteries.length;
        long sum = 0;
        for (var b : batteries) sum += b;
        long l = 0, r = sum / n;

        while (l < r) {
            long m = r - (r - l) / 2;
            if (helper(batteries, n, m)) l = m;
            else r = m - 1;
        }
        return l;
    }

    private boolean helper(int[] bb, int n, long m) {
        long sum = 0;
        for (int b : bb) {
            sum += Math.min(m, b);
        }
        return sum >= m * n;
    }
}
